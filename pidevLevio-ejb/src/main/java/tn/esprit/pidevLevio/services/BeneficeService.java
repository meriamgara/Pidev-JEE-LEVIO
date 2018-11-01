package tn.esprit.pidev.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.pidev.entities.Benefice;
@Remote
public interface BeneficeService {
	public int 	SumBeneficeByProject(Benefice idben); 
	public List<Benefice> getAllBenefice(); 
}
