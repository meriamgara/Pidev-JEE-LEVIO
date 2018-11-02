package tn.esprit.pidev.presentation.mbeans;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.URL;

import javax.faces.bean.ViewScoped;

import javax.servlet.ServletContext;

import tn.esprit.pidev.constant.Constants;
import tn.esprit.pidev.entities.Demande;
import tn.esprit.pidev.services.DemandeService;
import tn.esprit.pidev.util.Utils;

@ManagedBean
@SessionScoped
public class DemandeBean {

	private int id;
	private String nomD;
	private String prenomD;
	private String diplome;
	private Integer age;
	private String tel;
	private String email;
	private String nationalite;
	private String comptences;
	private String image;
	private String cv;
	private String poste;
	private Integer userId;
	private List<Demande> demandes;

	private List<Demande> Mesdemandes;
	private Integer demandeIdToBeUpdated;

	private Part imageFile;
	private Part cvFile;
	private String message;
	// private static Logger LOGGER = Logger.getLogger("InfoLogging");
	
	@ManagedProperty(value="#{userBean}")
	UserBean userBean;
	
	
	@EJB
	DemandeService demandeService;

	public String ajouterDemande() throws IOException {
		this.uploadFile();
		demandeService.ajouter(
				new Demande(nomD, prenomD, diplome, age, tel, email, nationalite, comptences, image, cv, poste, userBean.getUser()));
		//FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "DemandePages/ajout?faces-redirect=true";
	}
	// ********************

	public Integer getUserId() {
		return userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getNomD() {
		return nomD;
	}

	public void setNomD(String nomD) {
		this.nomD = nomD;
	}

	public String getPrenomD() {
		return prenomD;
	}

	public void setPrenomD(String prenomD) {
		this.prenomD = prenomD;
	}

	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getComptences() {
		return comptences;
	}

	public void setComptences(String comptences) {
		this.comptences = comptences;
	}

	public DemandeService getDemandeService() {
		return demandeService;
	}

	public void setDemandeService(DemandeService demandeService) {
		this.demandeService = demandeService;
	}

	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public String getImage() throws IOException  {
		return image;
	}

	public String getCv() {
		return cv;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}
	public Part getImageFile() {
		return imageFile;
	}

	public void setImageFile(Part imageFile) {
		this.imageFile = imageFile;
	}

	public Part getCvFile() {
		return cvFile;
	}

	public void setCvFile(Part cvFile) {
		this.cvFile = cvFile;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

	public List<Demande> getMesdemandes() {
		return Mesdemandes;
	}

	public void setMesdemandes(List<Demande> mesdemandes) {
		Mesdemandes = mesdemandes;
	}

	public String uploadFile() throws IOException {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		/*FacesContext context = FacesContext.getCurrentInstance();
		ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
		String path = servletContext.getRealPath("");*/
		boolean imageFileSuccess = false;
		if (imageFile.getSize() > 0) {
			String fileName = Utils.getFileNameFromPart(imageFile);
			System.out.print("image" + fileName);
			this.image = fileName;
			/**
			 * destination where the file will be uploaded
			 */
			File outputFile = new File("E:"+File.separator+"javaEE" + File.separator + "images" + File.separator + fileName);
			inputStream = imageFile.getInputStream();
			outputStream = new FileOutputStream(outputFile);
			byte[] buffer = new byte[Constants.BUFFER_SIZE];
			int bytesRead = 0;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
			if (outputStream != null) {
				outputStream.close();
			}
			if (inputStream != null) {
				inputStream.close();
			}
			imageFileSuccess = true;
		}
		boolean cvFileSuccess = false;
		if (cvFile.getSize() > 0) {
			String fileName = Utils.getFileNameFromPart(cvFile);
			System.out.print("cv" + fileName);
			this.cv = fileName;
			File outputFile = new File("E:"+File.separator+"javaEE" + File.separator + "cv" + File.separator + fileName);
			inputStream = cvFile.getInputStream();
			outputStream = new FileOutputStream(outputFile);
			byte[] buffer = new byte[Constants.BUFFER_SIZE];
			int bytesRead = 0;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
			if (outputStream != null) {
				outputStream.close();
			}
			if (inputStream != null) {
				inputStream.close();
			}
			cvFileSuccess = true;
		}
		/*if (imageFileSuccess || cvFileSuccess) {
			System.out.println("File uploaded to : " + path);

			setMessage("File successfully uploaded to " + path);
		} else {

			setMessage("Error, select atleast one file!");
		}*/

		return null;
	}

	public Integer getDemandeIdToBeUpdated() {
		return demandeIdToBeUpdated;
	}

	public void setDemandeIdToBeUpdated(Integer demandeIdToBeUpdated) {
		this.demandeIdToBeUpdated = demandeIdToBeUpdated;
	}

	public List<Demande> getDemandes() {
		return demandeService.findAll();
	}

	public List<Demande> getMesDemandes() {
		Mesdemandes = demandeService.findbyIDUSer(userBean.getUser());
		return Mesdemandes;
	}

	public void supprimer(Integer demandeID) {
		System.out.println("id: " + demandeID);
		// LOGGER.info("id1:"+demandeID);
		demandeService.supprimer(demandeID);
	}

	public void modifier(Demande demande) {

		this.setNomD(demande.getNomD());
		this.setPrenomD(demande.getPrenomD());
		this.setDiplome(demande.getDiplome());
		this.setAge(demande.getAge());
		this.setTel(demande.getTel());
		this.setEmail(demande.getEmail());
		this.setNationalite(demande.getNationalite());
		this.setComptences(demande.getComptences());
		this.setImage(demande.getImage());
		 this.setCv(demande.getCv());
		this.setPoste(demande.getPoste());
		this.setDemandeIdToBeUpdated(demande.getId());

		
	}



	public void updateDemande() {
		demandeService.update(new Demande(nomD, prenomD, diplome, age, tel, email, nationalite, comptences, image, cv,
				poste, demandeIdToBeUpdated));
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	

}
