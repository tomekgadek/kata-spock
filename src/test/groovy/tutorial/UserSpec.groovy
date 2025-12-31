package tutorial

import io.github.tomekgadek.tutorial.UserEntity
import io.github.tomekgadek.tutorial.UserRepository
import io.github.tomekgadek.tutorial.UserService
import io.github.tomekgadek.tutorial.UserState
import spock.lang.Specification

class UserSpec extends Specification {

    def "shouldFindUserWhenUserExists"() {

        given:
        def userRepository = Stub(UserRepository)
        def userService = Spy(new UserService(userRepository))

        def johnDoe = new UserEntity(1, "John Doe", 25, UserState.NEW)
        def mikeJordan = new UserEntity(2, "Mike Jordan", 33, UserState.NEW)

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

        def johnDoe = new UserEntity(1, "John Doe", 25, UserState.NEW)
        def mikeJordan = new UserEntity(2, "Mike Jordan", 33, UserState.NEW)

        userRepository.findUserById(1) >> johnDoe
        userRepository.findUserById(2) >> mikeJordan
        userRepository.findUserById(3) >> null

        when:
        def userInfo = userService.getUserInfo(3)

        then:
        userInfo.name == ""
        userInfo.age == 0
        userInfo.state == UserState.UNKNOWN
    }

    def "shouldReturnTrueWhenUserIsVerified"() {

        given: "prepare data"
        def userRepository = Stub(UserRepository)
        def userService = new UserService(userRepository)

        def verifiedUser = new UserEntity(1, "John Doe", 25, UserState.VERIFIED)
        def unknownUser = null

        userRepository.findUserById(1) >> verifiedUser
        userRepository.findUserById(2) >> unknownUser

        expect: "user verified => return true"
        userService.isUserVerified(1)

        and: "unknown user => return false"
        !userService.isUserVerified(2)
    }
}
