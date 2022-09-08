package com.openclassroom.microservice.clientui.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.openclassroom.microservice.clientui.beans.CaseOfDiabetesBean;


@FeignClient(name="mediscreen-diabetes", url="host.docker.internal:8083")
public interface MicroserviceDiabetesProxy
{
	
	@PostMapping("/patient/read/{id}/case/getCase")
	public String getCase(@PathVariable("id") Integer id, @RequestBody CaseOfDiabetesBean caseOfDiabetesBean);

}
