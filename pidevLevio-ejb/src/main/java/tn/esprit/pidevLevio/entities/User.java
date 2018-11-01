package tn.esprit.pidevLevio.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import tn.esprit.pidevLevio.entities.Projet;


@Entity
public class User implements Serializable {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	
	
	private String nom;
	private String prenom;
	private String addresse ;
	private int tel;
    private String adresseMail; 
    private String login;
	private String password;
    private boolean isActif;
    private Role role;
    private categorie categories ;
    private typeclient type;
    public boolean isActif() {
		return isActif;
	}

	public void setActif(boolean isActif) {
		this.isActif = isActif;
	}

	
   
    public enum categorie{
    	publique,privee
    }
    public enum typeclient {
    	actuel,client,fincontrat 
    }
    
    // new    numerutation de role dans la base     client  0  ,   responsable   1   demandeur 2    ressource   3
    public enum Role {
    	client,responsable,demandeur,ressource 
    }
    
    @OneToMany(mappedBy="responsable")
    private List<Projet> Rprojets;
   
    @OneToMany(mappedBy="client")
    private List<Projet> Cprojets;
    
   
    
    

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
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

	public String getAdresseMail() {
		return adresseMail;
	}

	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}

	public categorie getCategories() {
		return categories;
	}

	public void setCategories(categorie categories) {
		this.categories = categories;
	}

	public typeclient getType() {
		return type;
	}

	public void setType(typeclient type) {
		this.type = type;
	}

	public List<Projet> getRprojets() {
		return Rprojets;
	}

	public void setRprojets(List<Projet> rprojets) {
		Rprojets = rprojets;
	}

	public List<Projet> getCprojets() {
		return Cprojets;
	}

	public void setCprojets(List<Projet> cprojets) {
		Cprojets = cprojets;
	}
	

	public User() {
		super();
	}



	public User(String nom, String prenom, String addresse, int tel, String adresseMail, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.addresse = addresse;
		this.tel = tel;
		this.adresseMail = adresseMail;
		this.password = password;
	}

	public User(String nom, String prenom, String addresse, int tel, String adresseMail, String login, String password,
			boolean isActif) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.addresse = addresse;
		this.tel = tel;
		this.adresseMail = adresseMail;
		this.login = login;
		this.password = password;
		this.isActif = isActif;
	}

	public User(String nom, String prenom, String addresse, int tel, String adresseMail, String login, String password,
			boolean isActif, Role role) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.addresse = addresse;
		this.tel = tel;
		this.adresseMail = adresseMail;
		this.login = login;
		this.password = password;
		this.isActif = isActif;
		this.role = role;
	}

	public User(String nom, String prenom, String addresse, int tel, String adresseMail, String login, String password,
			boolean isActif, Role role, categorie categories) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.addresse = addresse;
		this.tel = tel;
		this.adresseMail = adresseMail;
		this.login = login;
		this.password = password;
		this.isActif = isActif;
		this.role = role;
		this.categories = categories;
	}

	public User(String nom, String prenom, String addresse, int tel, String adresseMail, String login, String password,
			boolean isActif, Role role, categorie categories, typeclient type) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.addresse = addresse;
		this.tel = tel;
		this.adresseMail = adresseMail;
		this.login = login;
		this.password = password;
		this.isActif = isActif;
		this.role = role;
		this.categories = categories;
		this.type = type;
	}

	public User(int id, String nom, String prenom, String addresse, int tel, String adresseMail, String login,
			String password, boolean isActif, Role role, categorie categories, typeclient type) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.addresse = addresse;
		this.tel = tel;
		this.adresseMail = adresseMail;
		this.login = login;
		this.password = password;
		this.isActif = isActif;
		this.role = role;
		this.categories = categories;
		this.type = type;
	}

	public User(int id, String nom, String prenom, String addresse, int tel, String adresseMail, String password,
			boolean isActif, Role role, categorie categories, typeclient type) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.addresse = addresse;
		this.tel = tel;
		this.adresseMail = adresseMail;
		this.password = password;
		this.isActif = isActif;
		this.role = role;
		this.categories = categories;
		this.type = type;
	}

	public User(int id) {
		super();
		this.id = id;
	}

	

	// Resposable add client :



    
    
    
    
    
    
    
    
}
