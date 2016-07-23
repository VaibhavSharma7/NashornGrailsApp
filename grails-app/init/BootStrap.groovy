import nashorngrailsapp.User

class BootStrap {

    def init = { servletContext ->

        (1..5).each {
            new User(emailId: "email${it}@gmail.com", firstName: "User_first_name_${it}", lastName: "User_last_name_${it + (it - 1)}", isDeleted: false,
                    firstAmount: (100 * (it + 1)), secondAmount: (100 * (it + 1))).save(flush: true)
        }

        (6..10).each {
            new User(emailId: "email${it}@gmail.com", firstName: "User_first_name_${it}", lastName: "User_last_name_${it + (it - 1)}", isDeleted: false,
                    firstAmount: (100 * (it + 1)), secondAmount: (100 * (it + 1))).save(flush: true)
        }
    }
    def destroy = {
    }
}
