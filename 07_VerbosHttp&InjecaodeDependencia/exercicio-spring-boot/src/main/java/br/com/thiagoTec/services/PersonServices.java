package br.com.thiagoTec.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.thiagoTec.model.Person;

@Service // informando para o spring que essa classe que vai ser a injetada em outras
			// classes da aplicação
public class PersonServices {

	private static final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	public List<Person> findAll() {
		logger.info("encontrei uma pessoa");
		List<Person> persons = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}

		return persons;
	}

	public Person findById(String id) {

		logger.info("encontrei uma pessoa");

		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Thiago");
		person.setLastName("Cordeiro");
		person.setAddress("Diadema");
		person.setGender("masculino");
		return person;
	}

	public Person create(Person person) {
		logger.info("criando uma pessoa");

		return person;
	}

	public Person update(Person person) {
		logger.info("atualizando uma pessoa");

		return person;
	}
	
	public void delete(String id) {
		logger.info("deltando uma pessoa");
		
	}
	
	

	private Person mockPerson(int i) { // mock serve para sustentar o codigo por um breve momento e ser substituido
										// conforme for crescendo o codigo, trate ele com algo temporario.

		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name " + i);
		person.setLastName("Last name " + i);
		person.setAddress("Adress " + i);
		person.setGender("masculino");
		return person;
	}

}
