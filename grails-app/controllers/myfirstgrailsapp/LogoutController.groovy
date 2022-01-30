package myfirstgrailsapp

class LogoutController {

    def index() {
        request.logout() // Logout current user
        session.invalidate()
        render "Logout user";
    }
}
