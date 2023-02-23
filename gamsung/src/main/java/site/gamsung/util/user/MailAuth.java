package site.gamsung.util.user;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MailAuth extends Authenticator {
	
	 PasswordAuthentication pa;
	    
	    public MailAuth() {
	        String mail_id = "email_add";
	        String mail_pw = "password";
	        
	        pa = new PasswordAuthentication(mail_id, mail_pw);
	    }
	    
	    public PasswordAuthentication getPasswordAuthentication() {
	        return pa;
	    }

}
