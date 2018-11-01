package tn.esprit.pidev.presentation.mbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.pidev.entities.Benefice;
import tn.esprit.pidev.services.BeneficeServices;

@ManagedBean
@SessionScoped
public class BeneficesBeans {
	
	private List<Benefice> benefices;
  @EJB
  BeneficeServices beneficeServices;
  
  public List<Benefice> ConsulterBenefices(){
	  benefices= beneficeServices.getAllBenefice();
	  return benefices;
	  
  }
}
