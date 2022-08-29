package com.openclassroom.microservice.clientui.beans;

import javax.validation.constraints.NotEmpty;

public class NoteBean
{
	private String id;
	@NotEmpty(message = "Note is mandatory")
	private String patientNote;
	private Integer patientId;

	
	
	



	public NoteBean()
	{
		super();
	}



	public NoteBean(@NotEmpty(message = "Note is mandatory") String patientNote, Integer patientId)
	{
		super();
		this.patientNote = patientNote;
		this.patientId = patientId;
	}



	public NoteBean(String id, @NotEmpty(message = "Note is mandatory") String patientNote, Integer patientId)
	{
		super();
		this.id = id;
		this.patientNote = patientNote;
		this.patientId = patientId;
	}



	
	
	
	
	
	public Integer getPatientId()
	{
		return patientId;
	}



	public void setPatientId(Integer patientId)
	{
		this.patientId = patientId;
	}



	public String getId()
	{
		return id;
	}



	public void setId(String id)
	{
		this.id = id;
	}



	public String getPatientNote()
	{
		return patientNote;
	}



	public void setPatientNote(String patientNote)
	{
		this.patientNote = patientNote;
	}
	
	
	
	
	
	
	
	
}
