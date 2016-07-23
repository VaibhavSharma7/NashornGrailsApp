print(" *** Script executed *** ");
var user = Java.type('nashorngrailsapp.User');

var getUsers = function () {
    var map = {sort: "lastName", order: "desc", max: 10};
    var result = user.getUsers(map);
    print("Invoking getter of User class :: " + result);
    return {
        users: result
    }
};

function findUser(emailId) {
    return {
        user: user.getUser({emailId: emailId/*, isDeleted: true*/})
    }
}

function calculateAmount(first_amount, second_amount) {
    return {amount: (first_amount + second_amount) * 2}
}
