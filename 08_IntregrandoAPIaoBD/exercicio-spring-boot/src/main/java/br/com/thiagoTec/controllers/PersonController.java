package br.com.thiagoTec.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.thiagoTec.model.Person;
import br.com.thiagoTec.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired // com essa anotação o spring ele entende que você quer a injeção dessa classe
				// que está anotada com @service
	private PersonServices service;
//	private PersonServices service = new PersonServices();

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) // informando que ele produz json

	public List<Person> findAll() {

		return service.findAll();
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, //-> ele consumiu o json que digitamos no body
			produces = MediaType.APPLICATION_JSON_VALUE) //-> e ele produziu/retornou json através das informamoçoes que
															// enviamos no body
	public Person create(@RequestBody Person person) {
		return service.create(person);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Person update(@RequestBody Person person) {
		return service.update(person);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build(); //colocando o noContent().build() ele faz voltar o status 204 
	}

}
