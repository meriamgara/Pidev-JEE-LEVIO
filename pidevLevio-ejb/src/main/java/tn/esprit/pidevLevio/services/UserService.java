package tn.esprit.pidev.services;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.pidev.entities.User;


@Stateless 
@LocalBean
public class UserService implements UserServiceRemote {
	@PersistenceContext(unitName="pidev-ejb")
    EntityManager em;
	@Override
	public void AddResponsable(User Responsable) {
		// TODO Auto-generated method stub
		em.persist(Responsable);
		
	}

	@Override
	public int AddClient(User Client) {
		em.persist(Client);
		return Client.getId();
	}

	@Override
	public void UpdateClient(User Client) {
	em.merge(Client);
		
	}

	@Override
	public void DeleteClient(int id) {
		User u = new User();
		u = em.find(User.class, id);
		em.remove(u);
	}

	@Override
	public User getListClient() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByEmailsAndPassword(String adresseMail, String password) {
		TypedQuery<User> query= em.createQuery("select e from User e "
				+ "where e.adresseMail=:adresseMail and "
				+ "e.password=:password",User.class);
		query.setParameter("adresseMail", adresseMail);
		query.setParameter("password", password);
		User employe= null;
		try {
			employe=query.getSingleResult();
		} catch (NoResultException e) {
			// TODO: handle exception
			Logger.getAnonymousLogger().info("Aucun Employe trouve avec email :");
		}
		return employe;
	}
	//recuperer tous les users 
	@Override
	public List<User> getAllUser() {
		
		List<User> listeuser = em.createQuery("select e from User e",User.class).getResultList();
		return listeuser; 
	}

	@Override
	public List<User> getALLClient() {
		List<User> listeuser = em.createQuery("select e from User e where role=0",User.class).getResultList();
		return listeuser; 
	}

}



