package nashorngrailsapp

class UserController {

    UserService userService

    def index() {
        render(view: "index", model: [users: userService.getUsers(), user: userService.findUser()])
    }

}
