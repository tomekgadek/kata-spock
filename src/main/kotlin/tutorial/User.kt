package io.github.tomekgadek.tutorial

open class UserInfo(var name: String?, var age: Int)

open class UserEntity(var id: Int, var name: String?, var age: Int)

interface UserRepository {
    fun findUserById(userId: Int): UserEntity?
}

open class UserService(val userRepository: UserRepository) {

    fun getUserInfo(userId: Int): UserInfo {

        val user = this.userRepository.findUserById(userId)
        val userInfo = user?.let { UserInfo(it.name, it.age) }

        return userInfo ?: UserInfo("", 0)
    }
}
