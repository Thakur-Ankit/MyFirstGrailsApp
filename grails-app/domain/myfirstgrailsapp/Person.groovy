package myfirstgrailsapp

class Person {

    static constraints = {
    }

    String firstName;
    String lastName;

    static mapping = {
        firstName index: true
    }


}
