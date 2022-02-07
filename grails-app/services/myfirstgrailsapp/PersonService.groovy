package myfirstgrailsapp

import grails.gorm.services.Service

@Service(Person)
interface PersonService {

    List<Person> list(Map args)

    Person save(Person person)

    Long count()

    void delete(long id);

    Person findById(long id)

}
