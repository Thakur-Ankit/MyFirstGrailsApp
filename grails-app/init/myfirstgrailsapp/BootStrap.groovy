package myfirstgrailsapp

class BootStrap {

    PersonService personService;
    UserDataService userDataService;

    def init = { servletContext ->
        for (int i = 0; i < 5; i++) {
            Person person = new Person();
            person.setFirstName("User-" + Math.random());
            person.setLastName("LastName" + Math.random())
            personService.save(person);
        }

//        Creating a test user
        userDataService.save("test", "pass", true, false, false, false)
    }
    def destroy = {
//        Person.findAll().each { it.delete(flush:true, failOnError:true) }
//        User.findAll().each { it.delete(flush:true, failOnError:true) }
//        Role.findAll().each { it.delete(flush:true, failOnError:true) }
//        UserRole.findAll().each { it.delete(flush:true, failOnError:true) }

        Person.DB.drop()
    }
}
