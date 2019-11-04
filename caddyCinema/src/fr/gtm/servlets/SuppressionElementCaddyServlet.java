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
 * Servlet implementation class SuppressionElementCaddyServlet
 */
@WebServlet("/SuppressionElementCaddyServlet")
public class SuppressionElementCaddyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject 
	private Caddy caddy;
	@EJB 
	private Service service; 

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuppressionElementCaddyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titre = request.getParameter("titre");
		List<Film> films = caddy.getFilms();
		int i = 0;
		int indice = 0;
		for(Film film : films) {
			if(film.getTitre().equals(titre)) {
				indice = i;
				break;
			}
			i++;
		}
		caddy.removeFilm(indice);
		request.getSession().setAttribute("filmsCaddy", caddy.getFilms());
		request.getSession().setAttribute("totalCaddy", caddy.getTotal());
		films = service.getAllFilms();
		request.setAttribute("films", films);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/show-films2.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
