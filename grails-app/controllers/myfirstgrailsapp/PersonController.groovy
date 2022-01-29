package myfirstgrailsapp

import grails.converters.JSON

class PersonController {

    PersonService personService;

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
