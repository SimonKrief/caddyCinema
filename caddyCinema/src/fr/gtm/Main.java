package fr.gtm;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

import javax.validation.Validation;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail.HtmlEmail;


import fr.gtm.entities.Caddy;
import fr.gtm.services.ValidationCaddy;

public class Main {
	private static final Logger LOG = Logger.getLogger("cinema");
	
	
	public static void main(String[] args) throws EmailException {
		
		String message = "";
		ValidationCaddy validationCaddy;

		
        LOG.info("start");

	    try {
//	        BufferedReader reader = new BufferedReader (new InputStreamReader (new FileInputStream("src/fr/gtm/template.html"), "utf-8"));
//	        BufferedReader reader = new BufferedReader (new InputStreamReader (new FileInputStream("WebContent/template.html"), "utf-8"));
	        BufferedReader reader = new BufferedReader (new InputStreamReader (new FileInputStream("WebContent/template.html"), "utf-8"));


	        String line = reader.readLine();
//	        StringBuffer text = new StringBuffer();

	     while(line != null) {
	         LOG.info(line);
	         line = line.replace("{{nom}}", "name");
	         
	         message+=line;
	         
	         LOG.info(line);
	         line = reader.readLine();

	         }
	     

	     
			HtmlEmail m = new HtmlEmail();
			m.setHostName("192.168.1.104");
			m.setSmtpPort(25);
//			email.setAuthenticator(new DefaultAuthenticator("simon", "simonpw"));
//			email.setSSLOnConnect(true);
			m.setFrom("cinema@cinoche.com");
			m.setSubject("Commande Effectuée");
			m.setHtmlMsg(message);

			m.addTo("simon@bovoyages.net");

			m.send();
			System.out.println("Fin de l'envoi");
		
	     

	     LOG.info(reader.toString()); 
	     LOG.info(reader.lines().toString()); 

	     
	     reader.close();


	     } catch(FileNotFoundException ex) {

	     } catch(UnsupportedEncodingException ex) {

	     } catch(IOException ex ) {}
		
		
		
	}

}
