
package fr.gtm.services;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import org.apache.commons.mail.HtmlEmail;

import fr.gtm.entities.Caddy;

public class ValidationCaddy {

	private static final Logger LOG = Logger.getLogger("commande");
	private String message;

	public ValidationCaddy() {
		LOG.info("validation en cours");
	}

	public String creationMessage(Caddy caddy) {
		LOG.info("creation message: " + caddy.toString());

		message = "";
		try {
//			BufferedReader reader = new BufferedReader(
//					new InputStreamReader(new FileInputStream("WebContent/template.html"), "utf-8"));
//			BufferedReader reader = new BufferedReader(
//					new InputStreamReader(new FileInputStream("C:\templates\template.html"), "utf-8"));
			BufferedReader reader = new BufferedReader(
			new InputStreamReader(new FileInputStream("C:/templates/template.html"), "utf-8"));
			String line = reader.readLine();
			while (line != null) {
				line = line.replace("{{nom}}", "Simon");
				line = line.replace("{{commande}}", caddy.toString());
				message += line;
				LOG.info(line);
				line = reader.readLine();

			}

		} catch (FileNotFoundException ex) {
			System.out.println("fichier non trouvé");

		} catch (UnsupportedEncodingException ex) {
			System.out.println("encodage foiré");

		} catch (IOException ex) {
			System.out.println("problème de sortie, sans doutes");

		}

		LOG.info("Le message créé est: " + message);

		return message;
	}

	public void sentTo(String email, String message) throws EmailException {

		LOG.info("envoi de mail");

		HtmlEmail m = new HtmlEmail();

		m.setHostName("192.168.1.104");
		m.setSmtpPort(25);
		m.setFrom("cinema@cinoche.com");
		m.setSubject("Commande Effectuée");

		LOG.info("Le message envoyé: " + message);
		m.setHtmlMsg(message);// "vous avez commandé les films suivants"+caddy.toString()+" pour la somme de
								// "+ caddy.getTotal()

		m.addTo(email);

		m.send();
		System.out.println("Fin de l'envoi");
	}

}
