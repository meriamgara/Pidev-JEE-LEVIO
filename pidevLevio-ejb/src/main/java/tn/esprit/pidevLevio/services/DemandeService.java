package tn.esprit.pidev.services;

import java.util.List;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.pidev.entities.Demande;
import tn.esprit.pidev.entities.User;



@Stateless
@LocalBean
public class DemandeService implements DemandeServiceLocal,DemandeServiceRemote
{
	@PersistenceContext
	private EntityManager em;

	@Override
	public void ajouter(Demande demande) {
		em.persist(demande);
		
	}

	@Override
	public List<Demande> findAll() 
	{
		//return em.createQuery("select * from  Demande",Demande.class).getResultList();
		return em.createQuery("select c from Demande c",Demande.class).getResultList();
		
	}

	@Override
	public void supprimer(Integer demandeID) {
		Demande d = em.find(Demande.class,demandeID);
		em.remove(d);
	}

	@Override
	public void update(Demande demande) {
		
		em.merge(demande);
		
	}

	@Override
	public List<Demande> findbyIDUSer(User user) 
	{
		return em.createQuery(
				"SELECT u FROM Demande u WHERE u.demandeur= :id ", Demande.class)
		.setParameter("id",user)
		.getResultList();
	}


	
	
}
