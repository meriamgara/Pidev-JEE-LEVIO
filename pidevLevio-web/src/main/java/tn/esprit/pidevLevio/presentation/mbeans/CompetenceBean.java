package tn.esprit.pidevLevio.presentation.mbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import tn.esprit.pidevLevio.entities.Competence;
import tn.esprit.pidevLevio.entities.typeCategorie;
import tn.esprit.pidevLevio.services.CompetenceService;

@ManagedBean
@SessionScoped
public class CompetenceBean {

	private String libelle;

	@Enumerated(EnumType.STRING)
	private typeCategorie categorie;

	private List<Competence> competences;

	private List<Competence> Filtredcompetence;

	private String rechercher;

	@EJB
	CompetenceService competenceService;

	public CompetenceBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void ajouterCompetence() {
		competenceService.ajouterCompetence(new Competence(libelle, categorie));
		System.out.println("ajouterrrrrrrrr");
	}

	// public List<Competence> getCompetence() {
	// competences = (List<Competence>) competenceService.getAllCompetence();
	// return competences;
	//
	// }
	@PostConstruct
	public void init() {
		Filtredcompetence = competenceService.getAllCompetence();
	}

	public void filtres(typeCategorie c) {
		Filtredcompetence = competenceService.getCompetenceByCategorie(c);
	}

	// public String competenceByCatego(){
	//
	// competences =competenceService.getCompetenceByCategorie(categorie);
	// System.out.println("rechercher"+rechercher);
	// System.out.println(competences);
	// return "rechercher Par Categorie";
	// }

	public typeCategorie getCategorie() {
		return categorie;
	}

	public void setCategorie(typeCategorie categorie) {
		this.categorie = categorie;
	}

	public List<Competence> getCompetences() {
		return competences;
	}

	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}

	public String getRechercher() {
		return rechercher;
	}

	public void setRechercher(String rechercher) {
		this.rechercher = rechercher;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Competence> getFiltredcompetence() {
		return Filtredcompetence;
	}

	public void setFiltredcompetence(List<Competence> filtredcompetence) {
		Filtredcompetence = filtredcompetence;
	}

}
