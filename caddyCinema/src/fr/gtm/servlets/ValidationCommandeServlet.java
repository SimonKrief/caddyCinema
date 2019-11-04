package fr.gtm.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.EmailException;

import fr.gtm.entities.Caddy;
import fr.gtm.services.Service;
import fr.gtm.services.ValidationCaddy;

/**
 * Servlet implementation class ValidationCommandeServlet
 */
@WebServlet("/ValidationCommandeServlet")
public class ValidationCommandeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject 
	private Caddy caddy;
	@EJB 
	private Service service; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidationCommandeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ValidationCaddy validationCaddy = new ValidationCaddy();
		
		
		try {
			validationCaddy.sentTo("simon@bovoyages.net", validationCaddy.creationMessage(caddy));
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
