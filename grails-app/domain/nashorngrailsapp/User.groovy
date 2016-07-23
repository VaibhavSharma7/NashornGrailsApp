package nashorngrailsapp

class User {


    String emailId
    String firstName
    String lastName
    boolean isDeleted
    Long firstAmount
    Long secondAmount
    Long totalAmount

    static constraints = {
        emailId nullable: false
        firstName nullable: true
        lastName nullable: true
        isDeleted nullable: true
        firstAmount nullable: true
        secondAmount nullable: true
        totalAmount nullable: true
    }

    static List<User> getUsers(Map map) {
        User.list(map)
    }

    static User getUser(Map map) {
        User.findWhere(map)
    }


}
