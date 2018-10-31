package tn.esprit.pidevLevio.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ressource implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String firstName; 
	private String lastName;
	private String addresse ;
	private Long tel;
    private String email;
    @Enumerated(EnumType.STRING)
    private typeContrat TypeContrat;
    private typeDisponibilite TypeDisponibilite;
    
    private String photo;
    private String CV;
    
    private String Description;
    
    @OneToMany(mappedBy="ressource")
    private List<Evaluation> evaluations;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}

	public Long getTel() {
		return tel;
	}

	public void setTel(Long tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public typeContrat getTypeContrat() {
		return TypeContrat;
	}

	public void setTypeContrat(typeContrat typeContrat) {
		TypeContrat = typeContrat;
	}

	public typeDisponibilite getTypeDisponibilite() {
		return TypeDisponibilite;
	}

	public void setTypeDisponibilite(typeDisponibilite typeDisponibilite) {
		TypeDisponibilite = typeDisponibilite;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getCV() {
		return CV;
	}

	public void setCV(String cV) {
		CV = cV;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	
	public List<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CV == null) ? 0 : CV.hashCode());
		result = prime * result + ((Description == null) ? 0 : Description.hashCode());
		result = prime * result + ((TypeContrat == null) ? 0 : TypeContrat.hashCode());
		result = prime * result + ((TypeDisponibilite == null) ? 0 : TypeDisponibilite.hashCode());
		result = prime * result + ((addresse == null) ? 0 : addresse.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((evaluations == null) ? 0 : evaluations.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
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
		Ressource other = (Ressource) obj;
		if (CV == null) {
			if (other.CV != null)
				return false;
		} else if (!CV.equals(other.CV))
			return false;
		if (Description == null) {
			if (other.Description != null)
				return false;
		} else if (!Description.equals(other.Description))
			return false;
		if (TypeContrat != other.TypeContrat)
			return false;
		if (TypeDisponibilite != other.TypeDisponibilite)
			return false;
		if (addresse == null) {
			if (other.addresse != null)
				return false;
		} else if (!addresse.equals(other.addresse))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (evaluations == null) {
			if (other.evaluations != null)
				return false;
		} else if (!evaluations.equals(other.evaluations))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (photo == null) {
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ressource [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", addresse=" + addresse
				+ ", tel=" + tel + ", email=" + email + ", TypeContrat=" + TypeContrat + ", TypeDisponibilite="
				+ TypeDisponibilite + ", photo=" + photo + ", CV=" + CV + ", Description=" + Description + "]";
	}

	public Ressource(int id, String firstName, String lastName, String addresse, Long tel, String email,
			typeContrat typeContrat, typeDisponibilite typeDisponibilite, String photo, String cV, String description) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.addresse = addresse;
		this.tel = tel;
		this.email = email;
		TypeContrat = typeContrat;
		TypeDisponibilite = typeDisponibilite;
		this.photo = photo;
		CV = cV;
		Description = description;
	}

	public Ressource() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
	
	
}
