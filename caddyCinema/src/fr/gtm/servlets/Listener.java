package fr.gtm.servlets;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class Listener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public Listener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	HttpSession session = se.getSession();
//		try {
//    	InitialContext ctx = new InitialContext();
//    	Compteur compteur = (Compteur) ctx.lookup("java:app/jboss-compteur/Compteur");
//		session.setAttribute("compteur", compteur);
//		}
//		catch (NamingException e) {
//		e.printStackTrace();
//		}
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	HttpSession session = se.getSession();
//    	Compteur compteur = (Compteur) session.getAttribute("compteur");
//    	if(compteur != null) {
//    		compteur.remove();
//    	}
    }
	
}
