package tn.esprit.pidevLevio.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.pidevLevio.entities.*;


@Remote
public interface ProjetServiceRemote {

	
	public int AddProject(Projet p);
	public int UpdateProject(Projet p);
	public void DeleteProject(int id);
	public List<Projet> getListProject();
	public void affectationProjetClient(int idP,int idC);
	public List<Projet> getListProjectByID(int idproj);
}
