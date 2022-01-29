package myfirstgrailsapp

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class PersonSpec extends Specification implements DomainUnitTest<Person> {

    def setup() {
    }

    def cleanup() {
    }

    void 'test firstName cannot be null'() {
        when: 'firstName is null'
        domain.firstName = null

        then: 'firstName validation should fail.'
        !domain.validate(['firstName'])
        domain.errors['firstName'].code == 'nullable'
    }

    void 'test lastName cannot be null'() {
        when: 'lastName is null'
        domain.lastName = null

        then: 'lastName validation should pass.'
        domain.validate(['lastName'])
    }

    void 'test firstName cannot be blank'() {
        when: 'firstName is blank'
        domain.firstName = ''

        then: 'firstName validation should fail.'
        !domain.validate(['firstName'])
        domain.errors['firstName'].code == 'blank'
    }

    void 'test lastName can be blank'() {
        when: 'lastName is blank'
        domain.lastName = ''

        then: 'lastName validation should pass.'
        domain.validate(['lastName'])
    }

    void 'test firstName can have a maximum of 255 characters'() {
        when: 'for a string of 256 characters'
        String str = 'a' * 256
        domain.firstName = str

        then: 'firstName validation should fail'
        !domain.validate(['firstName'])
        domain.errors['firstName'].code == 'maxSize.exceeded'

        when: 'for a string of 256 characters'
        str = 'a' * 255
        domain.firstName = str

        then: 'firstName validation should pass'
        domain.validate(['firstName'])
    }

    void 'test lastName can have a maximum of 255 characters'() {
        when: 'for a string of 256 characters'
        String str = 'a' * 256
        domain.lastName = str

        then: 'lastName validation should fail'
        !domain.validate(['lastName'])
        domain.errors['lastName'].code == 'maxSize.exceeded'

        when: 'for a string of 256 characters'
        str = 'a' * 255
        domain.lastName = str

        then: 'lastName validation should pass'
        domain.validate(['lastName'])
    }
}
