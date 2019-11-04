package fr.gtm.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.entities.Caddy;
import fr.gtm.entities.Film;
import fr.gtm.services.Service;

/**
 * Servlet implementation class ShowFilmServlet
 */
@WebServlet("/ShowFilmServlet")
public class ShowFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject 
	private Caddy caddy;
	@EJB 
	private Service service; 

    public ShowFilmServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Film> films = service.getAllFilms();
		request.setAttribute("films", films);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/show-films.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
