package tn.esprit.pidevLevio.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import tn.esprit.pidevLevio.entities.User;

@Entity
public class Projet implements Serializable {

		/**
	 * 
	 */

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String titre;
	private String description;
	//client ---> user
	@ManyToOne
	private User client;
	
	
	// new
	@ManyToOne
	private User responsable;

	@OneToMany(mappedBy="projet")
	private List<Benefice> benefice;
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public User getClient() {
		return client;
	}


	public void setClient(User client) {
		this.client = client;
	}


	public User getResponsable() {
		return responsable;
	}


	public void setResponsable(User responsable) {
		this.responsable = responsable;
	}
	
	

	public List<Benefice> getBenefice() {
		return benefice;
	}


	public void setBenefice(List<Benefice> benefice) {
		this.benefice = benefice;
	}


	public Projet() {
		
	}

//Resonsable add project without client


//responsable affect client to project


	// modifier
	public Projet(int id, String titre, String description, User client) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.client = client;
	}






	public Projet(String titre, String description) {
		super();
		this.titre = titre;
		this.description = description;
	}


	public Projet(String titre, String description, User responsable) {
		super();
		this.titre = titre;
		this.description = description;
		this.responsable = responsable;
	}


	public Projet(int id, String titre, String description, User client, User responsable) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.client = client;
		this.responsable = responsable;
	}



	
	
	

	
	
	
	
}
