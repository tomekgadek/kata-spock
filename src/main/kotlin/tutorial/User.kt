package io.github.tomekgadek.tutorial

enum class UserState {
    VERIFIED, NEW, UNKNOWN
}

interface UserRepository {
    fun findUserById(userId: Int): UserEntity?
}

open class UserInfo(var name: String?, var age: Int, var state: UserState)

open class UserEntity(var id: Int, var name: String?, var age: Int, var state: UserState)

open class UserService(val userRepository: UserRepository) {

    fun getUserInfo(userId: Int): UserInfo {

        val user = this.userRepository.findUserById(userId)
        val userInfo = user?.let { UserInfo(it.name, it.age, it.state) }

        return userInfo ?: UserInfo("", 0, UserState.UNKNOWN)
    }

    fun isUserVerified(userId: Int): Boolean {
        return getUserInfo(userId).state == UserState.VERIFIED
    }
}
