package myfirstgrailsapp

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class LogoutControllerSpec extends Specification implements ControllerUnitTest<LogoutController> {

    def setup() {
    }

    def cleanup() {
    }

    void "Test the index API which logout the current user"() {
        given: "This is the index API"

        when: "The index API is executed"
        controller.index()

        then: "The Welcome message must returned."
        assert response.getText() == "Logout user"

        and: 'a success response code is returned'
        assert response.status == 200

        and: 'a error message should null'
        assert response.errorMessage == null
    }
}
