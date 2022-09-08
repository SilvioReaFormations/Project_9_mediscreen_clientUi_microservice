package com.openclassroom.microservice.clientui.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.openclassroom.microservice.clientui.beans.CaseOfDiabetesBean;
import com.openclassroom.microservice.clientui.beans.NoteBean;
import com.openclassroom.microservice.clientui.beans.PatientBean;
import com.openclassroom.microservice.clientui.proxies.MicroserviceDiabetesProxy;
import com.openclassroom.microservice.clientui.proxies.MicroserviceNoteProxy;
import com.openclassroom.microservice.clientui.proxies.MicroservicePatientsProxy;

@Controller
public class ClientUiDiabetesController
{
	@Autowired
	MicroserviceDiabetesProxy diabetesProxy;
	
	@Autowired
	MicroservicePatientsProxy patientProxy;
	
	@Autowired
	MicroserviceNoteProxy noteProxy;
	
	
	@GetMapping("/patient/read/{id}/case/getCase")
	public String getCase(@PathVariable("id") Integer patientId, Model model)
	{
		CaseOfDiabetesBean diabetes = new CaseOfDiabetesBean();
		
		PatientBean patient = patientProxy.getPatient(patientId).get();
		
		List<NoteBean> noteList = noteProxy.getAllNotes(patientId);
		
		List<String> newList = new ArrayList<>();
		
		for (NoteBean noteBean : noteList)
		{
			newList.add(noteBean.getPatientNote());
		}
	
		
		diabetes.setPatientBirthdate(patient.getBirthdate());
		diabetes.setPatientGender(patient.getGender());
		diabetes.getPatientNote().addAll(newList);
		
		String result = diabetesProxy.getCase(patientId, diabetes);
		
		model.addAttribute("result", result);
		
		return "diabetes/diabetesCases";
	}
	
}
