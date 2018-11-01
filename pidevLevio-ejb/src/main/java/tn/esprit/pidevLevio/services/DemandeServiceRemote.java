package tn.esprit.pidev.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.pidev.entities.Demande;
import tn.esprit.pidev.entities.User;





@Remote
public interface DemandeServiceRemote 
{
	void ajouter(Demande demande);
	void supprimer(Integer demandeID);
	void update(Demande demande);
	List<Demande> findAll();
	List<Demande> findbyIDUSer(User user) ;
}