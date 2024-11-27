package br.com.thiagoTec.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.thiagoTec.data.vo.v1.PersonVO;
import br.com.thiagoTec.data.vo.v2.PersonVOV2;
import br.com.thiagoTec.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired // com essa anotação o spring ele entende que você quer a injeção dessa classe
				// que está anotada com @service
	private PersonServices service;
//	private PersonServices service = new PersonServices();

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) // informando que ele produz json

	public List<PersonVO> findAll() {

		return service.findAll();
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, //-> ele consumiu o json que digitamos no body
			produces = MediaType.APPLICATION_JSON_VALUE) //-> e ele produziu/retornou json através das informamoçoes que
															// enviamos no body
	public PersonVO create(@RequestBody PersonVO person) {
		return service.create(person);
	}
	
	@PostMapping(value = "/v2", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVOV2 createV2(@RequestBody PersonVOV2 person) {
		return service.create(person);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO update(@RequestBody PersonVO person) {
		return service.update(person);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build(); //colocando o noContent().build() ele faz voltar o status 204 
	}

}
