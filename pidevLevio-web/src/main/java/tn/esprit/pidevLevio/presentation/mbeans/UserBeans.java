package tn.esprit.pidev.presentation.mbeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


import tn.esprit.pidev.entities.User;
import tn.esprit.pidev.services.UserService;



@ManagedBean
@SessionScoped
public class UserBeans {
	private String login;
	private String password;
	private User user;
	private boolean loggedIn;
	
	
	
	@EJB
	UserService userService;
	
	public String doLogin(){
		String navigateTo="null";
		user = userService.getUserByEmailsAndPassword(login, password);
		
		if (user != null && user.getRole().equals(tn.esprit.pidev.entities.User.Role.responsable) ){
			navigateTo = "dashboard?faces-redirect=true";
			loggedIn = true;
		}
		else if(user != null && user.getRole().equals(tn.esprit.pidev.entities.User.Role.client) ){
				navigateTo = "testtemplate?faces-redirect=true";
				loggedIn = true;
			}
		/*	
			else if(user != null && user.getRole().equals(tn.esprit.pidev.entities.User.Role.ressource) ){
				navigateTo = "/admin/ressouce?faces-redirect=true";
				loggedIn = true;
			}
			else if(user != null && user.getRole().equals(tn.esprit.pidev.entities.User.Role.demandeur) ){
				navigateTo = "/admin/demandeur?faces-redirect=true";
				loggedIn = true;
			}*/
			
		else{
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Saisir autre fois"));
			
		}
		return navigateTo; 
	}
	
	public String  doLogout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
}
