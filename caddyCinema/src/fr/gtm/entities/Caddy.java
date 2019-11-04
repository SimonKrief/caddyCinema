package fr.gtm.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class Caddy implements Serializable{

	private List<Film> films;
	private double total;

	public Caddy() {
		films = new ArrayList<Film>();
		total = 0;
	}
	
	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}
	
	public double getTotal() {
		return total;
	}

	public void addFilm(Film film) {
		films.add(film);
		total += film.getPrixht();
	}
	
	public void removeFilm(int i) {
		total -= films.get(i).getPrixht();
		films.remove(i);
	}
	
}
