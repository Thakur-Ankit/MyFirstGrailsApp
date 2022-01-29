package myfirstgrailsapp

class BootStrap {

    PersonService personService;

    def init = { servletContext ->
        for (int i = 0; i < 5; i++) {
            Person person = new Person();
            person.setFirstName("User-" + Math.random());
            person.setLastName("LastName" + Math.random())
            personService.save(person);
        }
    }
    def destroy = {
        Person.findAll().each { it.delete(flush:true, failOnError:true) }
    }
}
