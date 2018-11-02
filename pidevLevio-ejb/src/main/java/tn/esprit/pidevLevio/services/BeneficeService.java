package tn.esprit.pidevLevio.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.pidevLevio.entities.Benefice;
@Remote
public interface BeneficeService {
	public int 	SumBeneficeByProject(Benefice idben); 
	public List<Benefice> getAllBenefice(); 
}
