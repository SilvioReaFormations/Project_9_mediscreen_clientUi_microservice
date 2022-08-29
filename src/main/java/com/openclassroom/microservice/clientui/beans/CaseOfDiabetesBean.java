package com.openclassroom.microservice.clientui.beans;

import java.util.ArrayList;
import java.util.List;

public class CaseOfDiabetesBean
{

	private List<String> patientNote = new ArrayList<>();
	private String patientBirthdate;
	private String patientGender;
	
	public CaseOfDiabetesBean()
	{
		super();
	}

	public CaseOfDiabetesBean(List<String> patientNote, String patientBirthdate, String patientGender)
	{
		super();
		this.patientNote = patientNote;
		this.patientBirthdate = patientBirthdate;
		this.patientGender = patientGender;
	}
	
	

	public List<String> getPatientNote()
	{
		return patientNote;
	}

	public void setPatientNote(List<String> patientNote)
	{
		this.patientNote = patientNote;
	}

	public String getPatientBirthdate()
	{
		return patientBirthdate;
	}

	public void setPatientBirthdate(String patientBirthdate)
	{
		this.patientBirthdate = patientBirthdate;
	}

	public String getPatientGender()
	{
		return patientGender;
	}

	public void setPatientGender(String patientGender)
	{
		this.patientGender = patientGender;
	}
}
