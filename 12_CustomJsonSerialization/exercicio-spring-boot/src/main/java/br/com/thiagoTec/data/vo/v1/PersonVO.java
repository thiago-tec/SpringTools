package br.com.thiagoTec.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "first_name", "lastName", "adress", "gender" }) // alterando a ordem que o json trás os
																			// dados, caso personalize o nome de um
																			// atributo, você tem que colocar ele aqui
																			// tbm.
public class PersonVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@JsonProperty("first_name") // personalizando como vai ser o nome quando o json retornar
	private String firstName;

	private String lastName;

	private String address;

//	@JsonIgnore ele deixa ele diz que o json não que ele serialize
	private String gender;

	public PersonVO() {
	}

	public int hashCode() {
		return Objects.hash(address, firstName, gender, id, lastName);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonVO other = (PersonVO) obj;
		return Objects.equals(address, other.address) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(gender, other.gender) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
