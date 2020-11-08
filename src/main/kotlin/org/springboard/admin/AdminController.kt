package org.springboard.admin

import org.springboard.user.Account
import org.springboard.user.EnrichedUserDetails
import org.springframework.http.HttpStatus
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.server.ResponseStatusException
import org.springframework.web.servlet.ModelAndView
import java.util.*

data class AdminIndexViewModel(val userName: String, val accounts: List<Account>)
data class AdminIndividualAccountViewModel(val account: Account)

sealed class AdminViews<T>(private val template: String) {

    fun render(model: T): ModelAndView {
        return ModelAndView(template, mapOf("model" to model))
    }

    object AdminHomeView : AdminViews<AdminIndexViewModel>("pages/admin/index")
    object IndividualAccountView : AdminViews<AdminIndividualAccountViewModel>("pages/admin/individual-account")
}

@Controller
@RequestMapping("/admin")
class AdminController(private val adminService: IAdminService) {

    @GetMapping
    fun adminHome(@AuthenticationPrincipal user: EnrichedUserDetails): ModelAndView {
        val accounts = adminService.getAccounts(user.accountId)
        val model = AdminIndexViewModel(user.handle, accounts)

        return AdminViews.AdminHomeView.render(model)
    }

    @GetMapping("/user/{userId}")
    fun individualUser(@AuthenticationPrincipal user: EnrichedUserDetails, @PathVariable("userId") userId: UUID): ModelAndView {
        val account = adminService.getAccount(user.accountId, userId)
                ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
        val model = AdminIndividualAccountViewModel(account)

        return AdminViews.IndividualAccountView.render(model)
    }
}
