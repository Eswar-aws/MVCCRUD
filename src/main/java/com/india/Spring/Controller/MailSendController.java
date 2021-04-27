package com.india.Spring.Controller;

import java.io.IOException;
import java.io.InputStream;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class MailSendController {

@Autowired
private JavaMailSender javaMailSender;

@RequestMapping("/email")
public String emailf()
{
	return "EmailForm";
}

@RequestMapping(value="/mail", method=RequestMethod.POST)
public String sendMail(HttpServletRequest req,final @RequestParam CommonsMultipartFile attachfile) 
{
	String to=req.getParameter("recipient");
	String sub=req.getParameter("subject");
	String mess=req.getParameter("message");
	
		javaMailSender.send(new MimeMessagePreparator() {
				
				@Override
				public void prepare(MimeMessage mimeMessage) throws Exception
				{
					MimeMessageHelper mimeHelper=new MimeMessageHelper(mimeMessage,true,"UTF-8");
					mimeHelper.setTo(to);
					mimeHelper.setSubject(sub);
					mimeHelper.setText(mess);
					
					String attachment=attachfile.getOriginalFilename();
					
					if(!attachment.equals(""))
					{
						mimeHelper.addAttachment(attachment, new InputStreamSource() {
							@Override
							public InputStream getInputStream() throws IOException
							{
								return attachfile.getInputStream();
							}
						});
					}			
				}
		});
		
		return "Result";
}
}
