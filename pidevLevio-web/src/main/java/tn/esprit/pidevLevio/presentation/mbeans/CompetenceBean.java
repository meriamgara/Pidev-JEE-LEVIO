package tn.esprit.pidevLevio.presentation.mbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import tn.esprit.pidevLevio.entities.Competence;
import tn.esprit.pidevLevio.entities.typeCategorie;
import tn.esprit.pidevLevio.services.CompetenceService;



@ManagedBean
@SessionScoped
public class CompetenceBean {

	private String libelle;

	@Enumerated(EnumType.STRING)
	private typeCategorie categorie;

	private List<Competence> competences;

	private List<Competence> Filtredcompetence;
	
	private List<Competence> filters;
	
	private Competence competence;

	private String rechercher;
	
	private UploadedFile image;
		
	private String picture;

	@EJB
	CompetenceService competenceService;

	public CompetenceBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String ajouterCompetence() {
		competenceService.ajouterCompetence(new Competence(libelle, categorie, picture));
		System.out.println("ajouterrrrrrrrr");
		return "/CompetencePages/Afficher?faces-redirect=true"; 
	}

	

	@PostConstruct
	public void init() {
		Filtredcompetence = competenceService.getAllCompetence();
	}

	public void filtres(typeCategorie c) {
		Filtredcompetence = competenceService.getCompetenceByCategorie(c);
	}

	public void filter() {
		filters = competenceService.getListCompetenceByCategorie(competence.getCategorie());
	}
	

	public void imageFileUpload(FileUploadEvent e1) throws Exception{

		this.image=e1.getFile();
		image.write("C:\\Users\\Meriem Gara\\workspaceJEE\\pidev\\pidev-web\\src\\main\\webapp\\resources\\demo\\images\\imagesCompetence\\"+image.getFileName());
		//image.write("C:\\images\\"+image.getFileName());
		
		picture = image.getFileName();
		System.out.println(picture);

		}
	
//	public StreamedContent getImageFromDB(int Id) throws IOException {
//		FacesContext context = FacesContext.getCurrentInstance();
// 
//		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
//			return new DefaultStreamedContent();
//		} else {
// 
//			ByteArrayOutputStream bos = new ByteArrayOutputStream();
// 
//			// Reading image from database assuming that product image (bytes)
//			// of product id I1 which is already stored in the database.
// 
//			byte[] image = null;
//			try {
//				//image = new ProductImageDAO().getProductImage("I1");
//				image = competenceService.getCompetenceImage(Id);
//			} catch (SQLException e) { // TODO Auto-generated catch block
//										// e.printStackTrace();
//			}
// 
//			return new DefaultStreamedContent(new ByteArrayInputStream(image),
//					"image/png");
// 
//		}
//	}
//	
	

	private static final long serialVersionUID = 1L;

	

	// public String competenceByCatego(){
	//
	// competences =competenceService.getCompetenceByCategorie(categorie);
	// System.out.println("rechercher"+rechercher);
	// System.out.println(competences);
	// return "rechercher Par Categorie";
	// }
	
	
	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public UploadedFile getImage() {
		return image;
	}

	public void setImage(UploadedFile image) {
		this.image = image;
	}

	public typeCategorie getCategorie() {
		return categorie;
	}

	public void setCategorie(typeCategorie categorie) {
		this.categorie = categorie;
	}

	public List<Competence> getCompetences() {
		return competences;
	}

	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}

	public String getRechercher() {
		return rechercher;
	}

	public void setRechercher(String rechercher) {
		this.rechercher = rechercher;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Competence> getFiltredcompetence() {
		return Filtredcompetence;
	}

	public void setFiltredcompetence(List<Competence> filtredcompetence) {
		Filtredcompetence = filtredcompetence;
	}

}
