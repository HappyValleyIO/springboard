package org.springboard.auth

import org.springframework.security.core.authority.SimpleGrantedAuthority

enum class AuthAuthority(val ref: String) {
    ADMIN("ADMIN"),
    USER("USER");

    val grantedAuthority: SimpleGrantedAuthority = SimpleGrantedAuthority(ref)

    companion object {
        fun fromRef(ref: String): AuthAuthority {
            return values().first {
                it.ref == ref
            }
        }
    }
}