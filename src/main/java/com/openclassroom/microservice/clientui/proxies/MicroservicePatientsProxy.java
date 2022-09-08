package com.openclassroom.microservice.clientui.proxies;


import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.openclassroom.microservice.clientui.beans.PatientBean;


@FeignClient(name="mediscreen-patient", url="host.docker.internal:8081")
public interface MicroservicePatientsProxy
{
	
	@GetMapping(value = "/patient/readAll")
	public List<PatientBean> getAllPatient();
	
	@GetMapping(value = "/patient/read/{id}")
	public Optional<PatientBean> getPatient(@PathVariable("id")Integer id);
	
	@PostMapping(value="/patient/add")
	public PatientBean addPatient(@RequestBody PatientBean patientBean);
	
	@PostMapping(value="/patient/update/{id}")
	public PatientBean updatePatient(@PathVariable("id")Integer id, @RequestBody PatientBean patientBean);
	
	@GetMapping(value="/patient/delete/{id}")
	public void deletePatient(@PathVariable("id")Integer id);
	
}
