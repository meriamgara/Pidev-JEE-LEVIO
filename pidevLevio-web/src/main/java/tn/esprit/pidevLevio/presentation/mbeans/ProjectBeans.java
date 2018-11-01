package tn.esprit.pidev.presentation.mbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.pidev.entities.*;
import tn.esprit.pidev.entities.User;
import tn.esprit.pidev.services.ProjetService;
import tn.esprit.pidev.services.UserService;

@ManagedBean
@SessionScoped
public class ProjectBeans {

	private String titre;
	private String description;
	private User responsable; 
	 private User client; 
	private Integer selectedIdEmploye;
	private Integer selectedIdupdate;
	private List<User> users,u; 
	private List<Projet> projets,projid; 
	@EJB
	ProjetService projetService;
	@EJB
	UserService userserice;
	@PostConstruct
	public void init(){
		
		users=userserice.getAllUser();
		u=userserice.getALLClient();
		
		
	}
public void init1(){
		
		
		projets=projetService.getListProject();
	}
	public UserService getUserserice() {
		return userserice;
	}
	public void setUserserice(UserService userserice) {
		this.userserice = userserice;
	}
	
	//ajout projet
	public String AddProjet(){
		
		Projet projet = new Projet(titre, description);
		//Resposable static
		User user = new User(2);
		User c = new User();
		
		c.setId(selectedIdEmploye);
		projet.setClient(c);
		projet.setResponsable(user);
		projetService.AddProject(projet);
		return null;
				//"/listprojet?faces-redirect=true";
		
	}
	
	//recupere tous les projets 
	public List<Projet> ConsulterProjet(){
		
		projets = projetService.getListProject();
		return projets; 
	}
	
	//recuperer les user si i
	public List<User> ConsulterUser(){
		users = userserice.getAllUser(); 
		return users; 
	}
	//recuperer les projets par id client
	public List<Projet> ConsulterProjetByID(){
		projid = projetService.getListProjectByID(0);
		return projid;
	}
	
	//supprimer client
	  public void deleteProjet(Integer cl){
		  projetService.DeleteProject(cl);
	  }
	  //modifier projet
	  public String modifierProjet(){
		  User res = new User(2);
		  client.setId(selectedIdEmploye);
		  projetService.UpdateProject(new Projet(selectedIdupdate, titre, description, client,res));
		  return "/listprojet?faces-redirect=true";
	  }

	  
	  //recuperer pour update 
	  public String recupProj(Projet p){
		  //client.setId(selectedIdEmploye);
		  this.setSelectedIdupdate(p.getId());
		  this.setTitre(p.getTitre());
		  this.setDescription(p.getDescription());
		  this.setClient(p.getClient());
		  this.setResponsable(p.getResponsable());
		  return "/updateprojet?faces-redirect=true";
		  
		  
		  
		  
	  }
	public List<Projet> getProjets() {
		return projets;
	}
	public void setProjets(List<Projet> projets) {
		this.projets = projets;
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

	public ProjetService getProjetService() {
		return projetService;
	}

	public void setProjetService(ProjetService projetService) {
		this.projetService = projetService;
	}

	public User getResponsable() {
		return responsable;
	}

	public void setResponsable(User responsable) {
		this.responsable = responsable;
	}

	public Integer getSelectedIdEmploye() {
		return selectedIdEmploye;
	}

	public void setSelectedIdEmploye(Integer selectedIdEmploye) {
		this.selectedIdEmploye = selectedIdEmploye;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	public User getClient() {
		return client;
	}
	public void setClient(User client) {
		this.client = client;
	}
	public Integer getSelectedIdupdate() {
		return selectedIdupdate;
	}
	public void setSelectedIdupdate(Integer selectedIdupdate) {
		this.selectedIdupdate = selectedIdupdate;
	}
	public List<User> getU() {
		return u;
	}
	public void setU(List<User> u) {
		this.u = u;
	}
	
	
	
	
	
	
}
