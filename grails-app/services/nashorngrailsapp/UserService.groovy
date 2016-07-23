package nashorngrailsapp

import grails.transaction.Transactional

@Transactional
class UserService {

    NashornScriptInvocationService nashornScriptInvocationService

    List<User> getUsers() {
        Map result = nashornScriptInvocationService.invokeScriptContent("getUsers")
        result?.users?.each { User user ->
            user.totalAmount = nashornScriptInvocationService.invokeScriptContent("calculateAmount", user.firstAmount, user.secondAmount)?.amount
        }
        result?.users
    }

    User findUser() {
        Map result = nashornScriptInvocationService.invokeScriptContent("findUser", "email1@gmail.com")
        result?.user
    }

}
