package myfirstgrailsapp

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class PersonControllerSpec extends Specification implements ControllerUnitTest<PersonController> {

    def setup() {
    }

    def cleanup() {
    }

    void "Test the index API returns correct welcome message"() {
        given: "This is the index API"

        when: "The index API is executed"
        controller.index()

        then: "The Welcome message must returned."
        assert response.getText() == "Hello World from the PersonController"

        and: 'a success response code is returned'
        assert response.status == 200

        and: 'a error message should null'
        assert response.errorMessage == null
    }

    void "Test the list API returns the empty results."() {
        given: "Mock the person Service"
        controller.personService = Mock(PersonService) {
            list(_) >> []
        }

        when: "The list API is executed"
        controller.list()

        then: "The returned json should match"
        assert response.getText() == "{\"count\":0,\"results\":[],\"status\":\"success\"}"

        and: 'a success response code is returned'
        assert response.status == 200

        and: 'a error message should null'
        assert response.errorMessage == null
    }

    void "Test the list API returns the complete list of persons in results."() {
        given: "Mock the person Service"
        List<Person> samplePersons = [new Person(firstName: 'User1', lastName: 'LastName1'),
                                      new Person(firstName: 'User2', lastName: 'LastName2'),
                                      new Person(firstName: 'User3', lastName: 'LastName3')]
        controller.personService = Mock(PersonService) {
            list(_ as Map) >> samplePersons
        }

        when: "The list API is executed"
        controller.list()

        then: "The returned json should match"
        assert response.getText().contains('{"count":3,"results":')

        and: 'a success response code is returned'
        assert response.status == 200

        and: 'a error message should null'
        assert response.errorMessage == null
    }

    void "Test the list API returns only max number of results in list of persons."() {
        given: "Mock the person Service"
        List<Person> samplePersons = [new Person(firstName: 'User1', lastName: 'LastName1'),
                                      new Person(firstName: 'User2', lastName: 'LastName2')]
        controller.personService = Mock(PersonService) {
            list(_ as Map) >> samplePersons
        }

        when: "The list API is executed"
        controller.list(2)

        then: "The returned json should match"
        assert response.getText().startsWith('{"count":2,"results":')

        and: 'a success response code is returned'
        assert response.status == 200

        and: 'a error message should null'
        assert response.errorMessage == null
    }

    void "Test the save API returns newly created Person Object"() {
        given: "Mock the person Service"
        Person person = new Person()
        person.setFirstName("User-")
        person.setLastName("LastName")

        controller.personService = Mock(PersonService) {
            save(_ as Person) >> person
        }

        when: "The save API is executed"
        controller.save()

        then: "It should returned the newly created person object."
        assert response == true

        and: 'a success response code is returned'
        assert response.status == 200

        and: 'a error message should null'
        assert response.errorMessage == null
    }
}
