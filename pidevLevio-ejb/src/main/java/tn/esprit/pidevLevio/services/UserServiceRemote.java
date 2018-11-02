package tn.esprit.pidevLevio.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.pidevLevio.entities.*;


@Remote
public interface UserServiceRemote {

	public void AddResponsable(User Responsable);
	public int AddClient(User Client);
	public void UpdateClient(User Client);
	public void DeleteClient(int id);
	public User getListClient();
	public User getUserByEmailsAndPassword(String adresseMail,String password);
	public List<User> getAllUser();
	public List<User> getALLClient();
}
