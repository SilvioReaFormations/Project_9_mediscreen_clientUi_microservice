package com.openclassroom.microservice.clientui.beans;

import javax.validation.constraints.NotEmpty;

public class PatientBean
{
	private Integer patientId;
	@NotEmpty(message = "First Name is mandatory")
	private String firstName;
	@NotEmpty(message = "Last Name is mandatory")
	private String lastName;
	@NotEmpty(message = "Birthdate is mandatory")
	private String birthdate;
	@NotEmpty(message = "Gender is mandatory")
	private String gender;
	@NotEmpty(message = "Address is mandatory")
	private String address;
	@NotEmpty(message = "Phone Number is mandatory")
	private String phoneNumber;

	
	public PatientBean(@NotEmpty(message = "First Name is mandatory") String firstName,
			@NotEmpty(message = "Last Name is mandatory") String lastName,
			@NotEmpty(message = "Birthdate is mandatory") String birthdate,
			@NotEmpty(message = "Gender is mandatory") String gender,
			@NotEmpty(message = "Address is mandatory") String address,
			@NotEmpty(message = "Phone Number is mandatory") String phoneNumber)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.gender = gender;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}


	public PatientBean()
	{
		super();
	}

	
	
	

	public PatientBean(Integer patientId, @NotEmpty(message = "First Name is mandatory") String firstName,
			@NotEmpty(message = "Last Name is mandatory") String lastName,
			@NotEmpty(message = "Birthdate is mandatory") String birthdate,
			@NotEmpty(message = "Gender is mandatory") String gender,
			@NotEmpty(message = "Address is mandatory") String address,
			@NotEmpty(message = "Phone Number is mandatory") String phoneNumber)
	{
		super();
		this.patientId = patientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.gender = gender;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}


	@Override
	public String toString()
	{
		return "PatientBean [patient_id=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", birthdate=" + birthdate + ", gender=" + gender + ", address=" + address + ", phoneNumber="
				+ phoneNumber + "]";
	}
	
	
	
	

	public Integer getPatientId()
	{
		return patientId;
	}


	public void setPatientId(Integer patientId)
	{
		this.patientId = patientId;
	}


	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	public String getBirthdate()
	{
		return birthdate;
	}
	public void setBirthdate(String birthdate)
	{
		this.birthdate = birthdate;
	}
	public String getGender()
	{
		return gender;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	
}
