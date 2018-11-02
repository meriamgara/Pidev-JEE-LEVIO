package tn.esprit.pidevLevio.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.pidevLevio.Projet;
import tn.esprit.pidevLevio.entities.User;
@Stateless
@LocalBean
public class ProjetService implements ProjetServiceRemote {
	@PersistenceContext(unitName="pidevLevio-ejb")
	EntityManager em;
	

	@Override
	public int UpdateProject(Projet p) {
		em.merge(p);
		return p.getId();
		
	}

	@Override
	public void DeleteProject(int id) {
		Projet pr = new Projet();
		pr = em.find(Projet.class, id);
		em.remove(pr);
		
	}

	@Override
	public List<Projet> getListProject() {
		List<Projet> listeuser = em.createQuery("select e from Projet e",Projet.class).getResultList();
		return listeuser; 
	}

	@Override
	public void affectationProjetClient(int idP, int idC) {
		// TODO Auto-generated method stub
		Projet ProjetmanagedEntity = em.find(Projet.class, idP);
		User ClientmanagedEntity = em.find(User.class, idC);
		
		ClientmanagedEntity.getCprojets().add(ProjetmanagedEntity);
		
	}

	@Override
	public int AddProject(Projet p) {
		// TODO Auto-generated method stub
		em.persist(p);
		return p.getId(); 
	}

	@Override
	public List<Projet> getListProjectByID(int idproj) {
		//TypedQuery<Projet> pro =em.createQuery("SELECT * FROM projet WHERE client_id=3",Projet.class);
		return  em.createQuery("select a  from Projet a where idproj=:v1 ",Projet.class).setParameter("v1", idproj).getResultList();
	}



}
