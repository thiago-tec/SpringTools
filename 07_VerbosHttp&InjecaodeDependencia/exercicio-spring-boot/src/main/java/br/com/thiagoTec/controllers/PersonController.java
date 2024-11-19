package br.com.thiagoTec.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.thiagoTec.model.Person;
import br.com.thiagoTec.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired // com essa anotação o spring ele entende que você quer a injeção dessa classe
				// que está anotada com @service
	private PersonServices service;
//	private PersonServices service = new PersonServices();

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) // informando que ele
																								// produz json
	public List<Person> findAll() {
		return service.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable(value = "id") String id) {
		return service.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE , //ele consumiu o json que digitamos no body
			produces = MediaType.APPLICATION_JSON_VALUE) //e ele produziu/retornou json através das informamoçoes que enviamos no body
	public Person create(@RequestBody Person person) {
		return service.create(person);
	}
	
	@RequestMapping(method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE ,
			produces = MediaType.APPLICATION_JSON_VALUE) 
	public Person update(@RequestBody Person person) {
		return service.update(person);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") String id) {
		service.delete(id);
	}

}
