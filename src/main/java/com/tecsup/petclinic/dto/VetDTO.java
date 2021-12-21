package com.tecsup.petclinic.dto;




public class VetDTO {

	private long id;
	
	private String firstName;
	
	private String lastName;

	

	public VetDTO(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
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


	@Override
	public String toString() {
		return "Vet [id=" + id + ", firstname=" + firstName + ", lastname=" + lastName + "]";
	}

}

