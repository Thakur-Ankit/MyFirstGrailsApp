package myfirstgrailsapp

class Person {

    static constraints = {
        firstName blank: false, nullable: false, maxSize: 255
        lastName blank: true, nullable: true , maxSize: 255
    }

    String firstName;
    String lastName;

    static mapping = {
        firstName index: true
    }


}
