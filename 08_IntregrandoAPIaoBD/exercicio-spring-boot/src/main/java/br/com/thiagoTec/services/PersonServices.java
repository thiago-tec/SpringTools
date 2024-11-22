package br.com.thiagoTec.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.thiagoTec.exceptions.ResourceNotFoundException;
import br.com.thiagoTec.model.Person;
import br.com.thiagoTec.repositories.PersonRepository;

@Service // informando para o spring que essa classe que vai ser a injetada em outras
			// classes da aplicação
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired // aqui injetamos a classe no qual vai fazer o crud, sim ela está com a anotação
				// @repository e não @service... mas é a mesma coisa e isso apenas torna o codigo mais legivel 
	PersonRepository repository;

	public List<Person> findAll() {
		logger.info("encontrei uma pessoa");

		return repository.findAll();
	}

	public Person findById(Long id) {

		logger.info("encontrei uma pessoa");

		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("no records found for this id"));
	}

	public Person create(Person person) {
		logger.info("criando uma pessoa");

		return repository.save(person);
	}

	public Person update(Person person) {
		logger.info("atualizando uma pessoa");

		var entity = repository.findById(person.getId()) //pegamos a pessoa por id
				.orElseThrow(() -> new ResourceNotFoundException("no records found for this id"));//se não encontrar lance string tal

		
		//atualizando as informações da pessoa
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		
		//persistindo no banco
		return repository.save(person);
	}

	public void delete(Long id) {
		logger.info("deltando uma pessoa");

		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("no records found for this id"));
		repository.delete(entity);
	}

}
