package myfirstgrailsapp

import grails.converters.JSON

class PersonController {

    def index() {
        render "Hello World";
    }

    PersonService personService;

    def list(Integer max) {
        params.max = Math.min(max ?: 25, 100)
        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
        try {
            List<Person> personList = personService.list(params);
            apiResponseDTO.setCount(personList.size());
            apiResponseDTO.setStatus("success");
            apiResponseDTO.setResults(personList);
        } catch(Exception ex) {
            apiResponseDTO.setCount(0);
            apiResponseDTO.setStatus("fail");
            apiResponseDTO.setResults(new ArrayList<Person>());
//            ex.getMessage();
        }
        render apiResponseDTO as JSON;
    }

    def save() {
        Person person = new Person();
        person.setFirstName("User-" + Math.random());
        person.setLastName("LastName" + Math.random())
        personService.save(person);
        render personService.save(person) as JSON;
    }
}
