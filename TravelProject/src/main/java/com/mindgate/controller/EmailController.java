package com.mindgate.controller;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.mindgate.service.SendMailService;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/sendMail")
public class EmailController {

	
	@Autowired
	SendMailService sendMailService;
	
	@RequestMapping(value = "/{requestId}", method = RequestMethod.GET)
	public String sendMail(@PathVariable int requestId) throws MessagingException {
		return sendMailService.sendMail(requestId);
	}   
	}
        
        
        
        
