package com.openclassroom.microservice.clientui.proxies;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.openclassroom.microservice.clientui.beans.NoteBean;

@FeignClient(name="mediscreen-note", url="localhost:8082")
public interface MicroserviceNoteProxy
{
	
	@GetMapping(value = "/patient/read/{id}/notes")
	List<NoteBean> getAllNotes(@PathVariable("id") Integer id);
	
	
	@PostMapping(value="/patient/read/{id}/notes/add")
	NoteBean addNote(@PathVariable("id") Integer id, NoteBean noteBean);
	
	
	@GetMapping(value = "update/{noteId}")
	Optional<NoteBean> getNote(@PathVariable("noteId") String id);
	
	
	
	@PostMapping(value="update/{noteId}")
	NoteBean updateNote(@PathVariable("noteId")String id, NoteBean noteBean);
	
	@GetMapping(value="delete/{noteId}")
	void deleteNote(@PathVariable("noteId")String id);
	
	
	
	
}
