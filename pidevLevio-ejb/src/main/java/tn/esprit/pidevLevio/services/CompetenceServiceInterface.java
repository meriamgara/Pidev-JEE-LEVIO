package tn.esprit.pidevLevio.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.pidevLevio.entities.Competence;
import tn.esprit.pidevLevio.entities.typeCategorie;


@Remote
public interface CompetenceServiceInterface {

	public int ajouterCompetence(Competence competence);

	public void ajouterEvaluation(int idCompetence, int idRessource, int idEvaluation, int niveau);
	
	public List<Competence> getAllCompetence();

	List<Competence> getCompetenceByCategorie(typeCategorie categorie);
	
	

}
