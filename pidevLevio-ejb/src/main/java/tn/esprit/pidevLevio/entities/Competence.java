package tn.esprit.pidevLevio.entities;

import java.io.Serializable;
import java.util.List;



import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;


@Entity
public class Competence implements Serializable {
	
	private static final long serialVersionUID = -1396669830860400871L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String libelle;
	
	@Enumerated(EnumType.STRING)
	private typeCategorie categorie; 
    

	@OneToMany(mappedBy="competence",fetch=FetchType.EAGER)
	private List<Evaluation> evaluations;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public List<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

    public typeCategorie getCategorie() {
		return categorie;
	}

	public void setCategorie(typeCategorie categorie) {
		this.categorie = categorie;
	}
	
	public Competence(int id, String libelle, typeCategorie categorie, List<Evaluation> evaluations) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.categorie = categorie;
		this.evaluations = evaluations;
	}
	

	public Competence(int id, String libelle, typeCategorie categorie) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.categorie=categorie; 
	}

	public Competence() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public String toString() {
		return "Competence [id=" + id + ", libelle=" + libelle + ", categorie=" + categorie + ", evaluations="
				+ evaluations + "]";
	}

	public Competence(String libelle,typeCategorie categorie) {
		super();
		this.libelle = libelle;
		this.categorie=categorie;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categorie == null) ? 0 : categorie.hashCode());
		result = prime * result + ((evaluations == null) ? 0 : evaluations.hashCode());
		result = prime * result + id;
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Competence other = (Competence) obj;
		if (categorie != other.categorie)
			return false;
		if (evaluations == null) {
			if (other.evaluations != null)
				return false;
		} else if (!evaluations.equals(other.evaluations))
			return false;
		if (id != other.id)
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		return true;
	}
	
	
	
	

}
