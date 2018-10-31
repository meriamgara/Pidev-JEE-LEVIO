package tn.esprit.pidevLevio.presentation.mbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.pidevLevio.entities.typeCategorie;

@ManagedBean
@ApplicationScoped
public class Data {

	
	
	public typeCategorie[] getTypeCategories() {
        return typeCategorie.values();
    }
	

	@PostConstruct
	public void init()
	{
		 categorie = typeCategorie.AGILE; 
	}
	
	 private typeCategorie categorie ;

	public typeCategorie getCategorie() {
		return categorie;
	}

	public void setCategorie(typeCategorie categorie) {
		this.categorie = categorie;
	} 
	 
	 
	 
	 
	
}
