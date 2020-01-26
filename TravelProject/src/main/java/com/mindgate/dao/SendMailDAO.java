package com.mindgate.dao;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Repository;

import com.mindgate.pojo.EmployeeDetails;
import com.mindgate.pojo.TravelRequestDetails;
@Repository
public class SendMailDAO {
	@Autowired
	private JavaMailSender sender;
	@Autowired
	TravelRequestDAOImpl requestDAOImpl;

	
	public String sendMail(int requestId) throws MessagingException {
		int a=4;

		MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED);
        System.out.println("sending mail");
        TravelRequestDetails request=new TravelRequestDetails();
        request=requestDAOImpl.getTravelRequest(requestId);
        EmployeeDetails employee=new EmployeeDetails();
        employee=request.getEmployeeDetails();
        System.out.println(employee.getEmail());

		try {
        helper.addAttachment("logo.gif", new ClassPathResource("journey.gif"));
     // String inlineImage = "<img src=\"cid:logo.gif\"></img><br/>";

        helper.setSubject("Mail From Travel Agent");
        helper.setTo(employee.getEmail());
        //
	helper.setText("Greetings for your travel Ticket Booked Successfully "
      					+ "Happy Journey "+a);
        
		} catch (MessagingException e) {
			e.printStackTrace();
			return "Error while sending mail ..";
		}
	
	sender.send(message);
	return "Sent Success!";

	}   
}
