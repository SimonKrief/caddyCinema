package fr.gtm.dao;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.gtm.entities.Film;

@Singleton
public class FilmDAO {

	@PersistenceContext(name="cinema")
	private EntityManager em;
	
	public List<Film> getAllFilms(){
		return em.createNamedQuery("Film.getAll", Film.class)
				                  .getResultList();
	}
	
	public Film getFilmByID(String id){
					
		return em.find(Film.class, Long.parseLong(id));
	}

}