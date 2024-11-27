package br.com.thiagoTec.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.thiagoTec.data.vo.v2.PersonVOV2;
import br.com.thiagoTec.model.Person;

@Service
public class PersonMapper {
	
	public PersonVOV2 convertEntityToVo(Person person) {
		PersonVOV2 vo = new PersonVOV2();
		vo.setId(person.getId());		
		vo.setAddress(person.getAddress());
		vo.setBirthday(new Date());
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setGender(person.getGender());
		return vo;
	}
	
	
	public Person converVoToEntity(PersonVOV2 person) {
		Person vo = new Person();
		vo.setId(person.getId());		
		vo.setAddress(person.getAddress());
		//vo.setBirthday(new Date());
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setGender(person.getGender());
		return vo;
	}
	

}
