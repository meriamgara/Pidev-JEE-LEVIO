package tn.esprit.pidevLevio.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.pidevLevio.entities.Benefice;


@Stateless
@LocalBean
public class BeneficeServices implements BeneficeService {
	@PersistenceContext(unitName="pidevLevio-ejb")
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
