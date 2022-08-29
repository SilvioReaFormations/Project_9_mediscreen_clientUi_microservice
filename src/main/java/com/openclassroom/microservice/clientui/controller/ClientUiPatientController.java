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
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openclassroom.microservice.clientui.beans.PatientBean;
import com.openclassroom.microservice.clientui.proxies.MicroservicePatientsProxy;

@Controller
public class ClientUiPatientController
{
	@Autowired
	MicroservicePatientsProxy proxy;
	
	static final Logger logger = LogManager.getLogger();
	
	
	////// READ A PATIENT //////
	
	@RequestMapping("/")
	public String index(Model model)
	{
		List<PatientBean> patients = proxy.getAllPatient();
		model.addAttribute("patients", patients);
		return "patient/index";
	}
	
	
	////// CREATE A PATIENT //////
	
	@GetMapping("/patient/add")
	public String addPatient(PatientBean patientBean, Model model)
	{
		return "patient/addPatientForm";
	}
	
	
	@PostMapping("/patient/add") 
	public String addPatient(@Valid PatientBean patientBean, BindingResult result, Model model)
	{
		
		if (result.hasErrors())
		{
			logger.warn("validation error");
			return "patient/addPatientForm";
		}
		model.addAttribute("patientBean", patientBean);
		proxy.addPatient(patientBean);
		logger.info("New Patient added : " + patientBean.getFirstName()+ " "+ patientBean.getLastName());
		
		return "redirect:/";
	}
	
	
	////// UPDATE A PATIENT //////
	
	@GetMapping("/patient/update/{id}")
	public String updatePatient(@PathVariable("id") Integer id, Model model)
	{
		model.addAttribute("patientUpdate", proxy.getPatient(id).get());
		return "patient/updatePatientForm";
	}
	
	
	@PostMapping("/patient/update/{id}")
	public String updatePatient(@PathVariable("id") Integer id, @ModelAttribute @Valid PatientBean patientUpdate, 
			BindingResult result, Model model)
	{
		
		if (result.hasErrors())
		{
			logger.warn("Update error");
			return "patient/updatePatientForm";
		}

		proxy.updatePatient(id, patientUpdate);
		logger.info(patientUpdate.getFirstName() +" "+ patientUpdate.getLastName()+ " updated");
		
		return "redirect:/";
	}
	
	
	////// DELETE A PATIENT //////
	
	@GetMapping("/patient/delete/{id}")
	public String deletePatient(@PathVariable("id") Integer id)
	{
		proxy.deletePatient(id);
		return "redirect:/";
	}
}
