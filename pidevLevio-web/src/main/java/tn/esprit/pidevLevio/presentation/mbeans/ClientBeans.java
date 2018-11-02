package tn.esprit.pidev.presentation.mbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

import tn.esprit.pidev.entities.User;
import tn.esprit.pidev.entities.User.Role;
import tn.esprit.pidev.entities.User.categorie;
import tn.esprit.pidev.entities.User.typeclient;
import tn.esprit.pidev.services.UserService;

@ManagedBean
@SessionScoped
public class ClientBeans {
	
	private String login;
	private String password;
	private Role role;
	private String nom;
	private String prenom;
	private String addresse ;
	private int tel;
    private String adresseMail; 
    private boolean isActif;
    private categorie categories;
    private typeclient type;
    private List<User> users; 
    private Integer selectIdEmp;
   
	

	@EJB
	UserService userService;
	@ManagedProperty(value="#{UserBeans}")
	UserBeans beans;
	
	public void AddClient(){
	/*	if(beans == null || !beans.isLoggedIn()){
			return "/login?faces-redirect=true";
	}*/
		userService.AddClient(new User(nom, prenom, addresse, tel, adresseMail, login, password, isActif, role, categories, type));
		
		//return "/ListClient?faces-redirect=true";
	}
	
	//recupere tous les clients 
	public List<User> ConsulterClient(){
		
		users = userService.getAllUser();
		return users; 
	}
	
	//recuperer user pour update 
	
	public void recupererUser(User u){
		this.setNom(u.getNom());
		this.setPrenom(u.getPrenom());
		this.setAddresse(u.getAddresse());
		this.setTel(u.getTel());
		this.setPassword(u.getPassword());
		this.setAdresseMail(u.getAdresseMail());
		this.setActif(u.isActif());
		this.setRole(u.getRole());
		this.setCategories(u.getCategories());
		this.setType(u.getType());
	}
	
	//update
	
    public String modifierClient(){
    	userService.UpdateClient(new User(selectIdEmp,nom, prenom, addresse, tel, adresseMail, password, isActif, role, categories, type));
    	return null;
    	//return "/ListClient?faces-redirect=true";
    }
    
    
	//redirection pour update
    public String recupupdateclient(User u){
    	this.setSelectIdEmp(u.getId());
    	this.setNom(u.getNom());
		this.setPrenom(u.getPrenom());
		this.setAddresse(u.getAddresse());
		this.setTel(u.getTel());
		this.setPassword(u.getPassword());
		this.setAdresseMail(u.getAdresseMail());
		this.setActif(u.isActif());
		this.setRole(u.getRole());
		this.setCategories(u.getCategories());
		this.setType(u.getType());
		
    	//userService.UpdateClient(u);

		return "/updateClient?faces-redirect=true";
    }
    
	
	//supprimer client
	  public void deleteClient(Integer cl){
		  userService.DeleteClient(cl);
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

	public boolean isActif() {
		return isActif;
	}

	public void setActif(boolean isActif) {
		this.isActif = isActif;
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

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserBeans getBeans() {
		return beans;
	}

	public void setBeans(UserBeans beans) {
		this.beans = beans;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Integer getSelectIdEmp() {
		return selectIdEmp;
	}

	public void setSelectIdEmp(Integer selectIdEmp) {
		this.selectIdEmp = selectIdEmp;
	}



}
