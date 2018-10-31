package tn.esprit.pidevLevio.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Client implements Serializable {
	 
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
	private int tel;
    private String email; 
  
    
    private Categorie categories ;
    private typeClient type;
    //private String photo;

	@OneToMany(mappedBy="client")
	private List<Projet>projets;

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

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Categorie getCategories() {
		return categories;
	}

	public void setCategories(Categorie categories) {
		this.categories = categories;
	}

	public typeClient getType() {
		return type;
	}

	public void setType(typeClient type) {
		this.type = type;
	}

	public List<Projet> getProjets() {
		return projets;
	}

	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addresse == null) ? 0 : addresse.hashCode());
		result = prime * result + ((categories == null) ? 0 : categories.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((projets == null) ? 0 : projets.hashCode());
		result = prime * result + tel;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Client other = (Client) obj;
		if (addresse == null) {
			if (other.addresse != null)
				return false;
		} else if (!addresse.equals(other.addresse))
			return false;
		if (categories != other.categories)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
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
		if (projets == null) {
			if (other.projets != null)
				return false;
		} else if (!projets.equals(other.projets))
			return false;
		if (tel != other.tel)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", addresse=" + addresse
				+ ", tel=" + tel + ", email=" + email + ", categories=" + categories + ", type=" + type + ", projets="
				+ projets + "]";
	}

	public Client(int id, String firstName, String lastName, String addresse, int tel, String email,
			Categorie categories, typeClient type, List<Projet> projets) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.addresse = addresse;
		this.tel = tel;
		this.email = email;
		this.categories = categories;
		this.type = type;
		this.projets = projets;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    
    
    
  
}
