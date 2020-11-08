package org.springboard.admin

import org.springboard.user.Account
import org.springboard.user.InternalUserPersistence
import org.springframework.stereotype.Component
import java.util.*

interface IAdminPersistence {
    fun getAllAccounts(): List<Account>
    fun getAccount(publicId: UUID): Account?
}

@Component
class AdminPersistence(private val userPersistence: InternalUserPersistence) : IAdminPersistence {
    override fun getAllAccounts(): List<Account> {
        return userPersistence.getUsers()
                .map {
                    it.toAccount()
                }
    }

    override fun getAccount(publicId: UUID): Account? {
        return userPersistence.getUsers(publicId = publicId).firstOrNull()?.toAccount()
    }
}
