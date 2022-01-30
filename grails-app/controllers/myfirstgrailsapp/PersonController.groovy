package myfirstgrailsapp

import grails.converters.JSON
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.userdetails.GrailsUser

@Secured('isAuthenticated()')
class PersonController {

    PersonService personService;
    SpringSecurityService springSecurityService;

    def loggedInUsername() {
       render loggedUsername();
    }

    String loggedUsername() {
        if ( springSecurityService.principal == null ) {
            return null
        }
        if ( springSecurityService.principal instanceof String ) {
            return springSecurityService.principal
        }
        if ( springSecurityService.principal instanceof GrailsUser ) {
            return ((GrailsUser) springSecurityService.principal).username
        }
        null
    }

    def index() {
        render "Hello World from the PersonController";
    }

    def list(Integer max) {
        try {
            params.max = Math.min(max ?: 25, 100)
            List<Person> personList = personService.list(params);
            ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
            apiResponseDTO.setCount(personList.size());
            apiResponseDTO.setStatus("success");
            apiResponseDTO.setResults(personList);

            render apiResponseDTO as JSON;
        } catch(Exception ex) {
//            ex.getMessage();
            return ex;
        }
    }

    def save() {
        Person person = new Person();
        person.setFirstName("User-" + Math.random());
        person.setLastName("LastName" + Math.random())
        render personService.save(person) as JSON;
    }
}
