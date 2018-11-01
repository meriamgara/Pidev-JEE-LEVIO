package tn.esprit.pidev.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.pidev.entities.Benefice;


@Stateless
@LocalBean
public class BeneficeServices implements BeneficeService {
	@PersistenceContext(unitName="pidev-ejb")
	EntityManager em;
	
	
	@Override
	public int SumBeneficeByProject(Benefice idben) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Benefice> getAllBenefice() {
		List<Benefice> listbenefice = em.createQuery("select e from Benefice e",Benefice.class).getResultList();
		return listbenefice; 
	}

}
