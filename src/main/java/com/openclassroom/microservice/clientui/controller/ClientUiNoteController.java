package com.openclassroom.microservice.clientui.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.openclassroom.microservice.clientui.beans.NoteBean;
import com.openclassroom.microservice.clientui.beans.PatientBean;
import com.openclassroom.microservice.clientui.proxies.MicroserviceNoteProxy;

@Controller
public class ClientUiNoteController
{
	@Autowired
	MicroserviceNoteProxy proxy;

	static final Logger logger = LogManager.getLogger();
	
	
	// READ//
	

	@GetMapping("/patient/read/{id}/notes")
	public String readNotes(@PathVariable("id") Integer id, Model model)
	{
		List<NoteBean> notes = proxy.getAllNotes(id);
		model.addAttribute("notes", notes);
		return "note/notesList";
	}
	
	
	// CREATE //
	
	
	@GetMapping("/patient/read/{id}/notes/add")
	public String AccessAddNotesForm(@PathVariable("id") Integer id, NoteBean noteBean, Model model)
	{
		model.addAttribute("patientId", id);
//		List<NoteBean> notes = proxy.getAllNotes(id);
//		model.addAttribute("notes", notes);
		return "note/addNote";
	}
	
	
	@PostMapping("/patient/read/{id}/notes/add") 
	public String addNote (@PathVariable("id") Integer id, @Valid NoteBean noteBean, BindingResult result, Model model)
	{
		
		if (result.hasErrors())
		{
			logger.warn("validation error");
			return "note/addNote";
		}
		
		model.addAttribute("noteBean", noteBean);
		noteBean.setPatientId(id);
		proxy.addNote(id,noteBean);
		logger.info("New note added");
		return "redirect:/patient/read/{id}/notes";
	}
	
	
	// UPDATE //
	
	@GetMapping("/patient/read/{patientId}/notes/update/{noteId}")
	public String updatePatient(@PathVariable("noteId") String noteId, @PathVariable("patientId") Integer patientId, Model model)
	{
		model.addAttribute("noteUpdate", proxy.getNote(noteId).get());
		model.addAttribute("patientId", patientId);
		return "note/updateNoteForm";
	}
	
	@PostMapping("/patient/read/{patientId}/notes/update/{noteId}")
	public String updatePatient(@PathVariable("noteId") String noteId, @PathVariable("patientId") Integer patientId, @Valid NoteBean noteUpdate, 
			BindingResult result, Model model)
	{

		if (result.hasErrors())
		{
			logger.warn("Update error");
			return "note/updateNoteForm";
		}
		
		proxy.updateNote(noteId, noteUpdate);
		
		return "redirect:/patient/read/{patientId}/notes";
	}

	
	// DELETE  //
	
	@GetMapping("/patient/read/{patientId}/notes/delete/{noteId}")
	public String deleteNote(@PathVariable("noteId") String noteId, @PathVariable("patientId") Integer patientId)
	{
		proxy.deleteNote(noteId);
		return "redirect:/patient/read/{patientId}/notes";
	}
	
	
}
