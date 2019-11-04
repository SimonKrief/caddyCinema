package fr.gtm.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="films")
@NamedQuery(name = "Film.getAll",query = "SELECT f FROM Film f")
public class Film implements Serializable{
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "pk_film")
private long id;

private String titre;

private String realisateur;

@Column(name ="date_sortie")
private LocalDate dateSortie;

private int duree;//durée du film en minutes

@Column(name ="prixht")
private double prixht;

public String getTitre() {
	return titre;
}

public void setTitre(String titre) {
	this.titre = titre;
}

public String getRealisateur() {
	return realisateur;
}

public void setRealisateur(String realisateur) {
	this.realisateur = realisateur;
}

public LocalDate getDateSortie() {
	return dateSortie;
}

public void setDateSortie(LocalDate dateSortie) {
	this.dateSortie = dateSortie;
}

public int getDuree() {
	return duree;
}

public void setDuree(int duree) {
	this.duree = duree;
}


public long getId() {
	return id;
}


public void setId(long id) {
	this.id = id;
}


@Override
public String toString() {
	return "Film [id=" + id + ", titre=" + titre + ", realisateur=" + realisateur + ", dateSortie=" + dateSortie
			+ ", duree=" + duree +"]";
}

public double getPrixht() {
	return prixht;
}

public void setPrixht(double prixht) {
	this.prixht = prixht;
}



}
