package com.mindgate.service;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.dao.SendMailDAO;

@Service
public class SendMailService {
	@Autowired 
	SendMailDAO sendMailDAO;
	public String sendMail(int requestId) throws MessagingException{
		return sendMailDAO.sendMail(requestId);
	}
}
