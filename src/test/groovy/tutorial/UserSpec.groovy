package tutorial

import io.github.tomekgadek.tutorial.UserEntity
import io.github.tomekgadek.tutorial.UserRepository
import io.github.tomekgadek.tutorial.UserService
import spock.lang.Specification

class UserSpec extends Specification {

    def "shouldFindUserWhenUserExists"() {

        given:
        def userRepository = Stub(UserRepository)
        def userService = Spy(new UserService(userRepository))

        def johnDoe = new UserEntity(1, "John Doe", 25)
        def mikeJordan = new UserEntity(2, "Mike Jordan", 33)

        userRepository.findUserById(1) >> johnDoe
        userRepository.findUserById(2) >> mikeJordan

        when:
        def userInfo = userService.getUserInfo(2)

        then:
        userInfo.getName() == mikeJordan.getName()
        userInfo.getAge() == mikeJordan.getAge()
    }

    def "shouldFindUserWhenUserNotExists"() {

        given:
        def userRepository = Stub(UserRepository)
        def userService = Spy(new UserService(userRepository))

        def johnDoe = new UserEntity(1, "John Doe", 25)
        def mikeJordan = new UserEntity(2, "Mike Jordan", 33)

        userRepository.findUserById(1) >> johnDoe
        userRepository.findUserById(2) >> mikeJordan
        userRepository.findUserById(3) >> null

        when:
        def userInfo = userService.getUserInfo(3)

        then:
        userInfo.name == ""
        userInfo.age == 0
    }
}
