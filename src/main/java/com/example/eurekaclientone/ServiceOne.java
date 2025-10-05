package com.example.eurekaclientone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/serviceOne")
public class ServiceOne {
    @Autowired
	RestTemplate resttemplate;
    
	@GetMapping("/sendMobileNumber/{mobile}")
	public String sendMobileNumber(@PathVariable("mobile") String mobileNumber) {
		// url to check http://localhost:8041/serviceOne/sendMobileNumber/9573320910
		return resttemplate.getForObject("http://eurekaclienttwo/serviceTwo/getMobileNumber/"+mobileNumber, String.class);
	}
	 
	@GetMapping("/sendCityName")
	public String sendCityname(@RequestParam("city") String cityName) {
		
		return resttemplate.getForObject("http://eurekaclienttwo/serviceTwo/getCityName?city="+cityName, String.class);

	}
}
