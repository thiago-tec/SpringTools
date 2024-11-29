package br.com.thiagoTec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.thiagoTec.model.Person;

//@Repository  informando que essa classe é o repositorio, porém no spring boot 3.0.1 não precisa mais colocar essa
//anotação, extends JpaRepository já faz o papel.

public interface PersonRepository extends JpaRepository<Person, Long> {
}// extends Jparepository faz essa classe ser responsavel por fazer o CRUD, onde
	// o tipo é a classe entidade e o id é o tipo do atributo ID
