package fr.gtm.services;



import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import fr.gtm.entities.Caddy;

public class MailCaddy {
	
	public void sentTo(String email) {
		Email email = new SimpleEmail();
		
		// machine sur laquelle est installée le serveur mail:
		email.setHostName("192.168.1.104");
		email.setSmtpPort(25);
//		email.setAuthenticator(new DefaultAuthenticator("simon", "simonpw"));
//		email.setSSLOnConnect(true);
		email.setFrom("cinema@cinoche.com");
		email.setSubject("Commande Effectuée");
		email.setMsg("vous avez commandé les films suivants"+Caddy.class);

		email.addTo("email");

		email.send();
		System.out.println("Fin de l'envoi");
	}

}
