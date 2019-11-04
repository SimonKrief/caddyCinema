package fr.gtm.services;

import java.util.List;

import javax.ejb.Singleton;
import javax.inject.Inject;

import fr.gtm.dao.FilmDAO;
import fr.gtm.entities.Film;

@Singleton
public class Service {
	
	@Inject
	private FilmDAO dao;
	
	public List<Film> getAllFilms(){
		return dao.getAllFilms();
	}
	
	public Film getFilm(String id){
		return dao.getFilmByID(id);
	}
}