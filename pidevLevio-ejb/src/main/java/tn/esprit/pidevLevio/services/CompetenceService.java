package tn.esprit.pidevLevio.services;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.pidevLevio.entities.Competence;
import tn.esprit.pidevLevio.entities.Evaluation;
import tn.esprit.pidevLevio.entities.EvaluationPK;
import tn.esprit.pidevLevio.entities.typeCategorie;




@Stateless
@LocalBean
public class CompetenceService implements CompetenceServiceInterface {

	
	@PersistenceContext(unitName = "pidev-ejb")
	EntityManager em;

	
	@Override
	public int ajouterCompetence(Competence competence) {
		em.persist(competence);
		return competence.getId(); 
	
	}
	
	@Override
	public void ajouterEvaluation(int idCompetence, int idRessource,int idEvaluation, int niveau) {
		EvaluationPK evaluationPK = new EvaluationPK();
		evaluationPK.setIdCompetence(idCompetence);
		evaluationPK.setIdEvaluation(idEvaluation);
		evaluationPK.setIdRessource(idRessource);
		
		Evaluation evaluation = new Evaluation();
		evaluation.setEvaluationPK(evaluationPK);
		evaluation.setNiveau(niveau); //par defaut non valide
		em.persist(evaluation);
	}

	
	@Override
	public List<Competence> getAllCompetence() {
		
		TypedQuery<Competence> query = em.createQuery("Select c from  Competence c ", Competence.class);
		List<Competence> competences = query.getResultList();

		return competences;
		}
	@Override
	public List<Competence> getCompetenceByCategorie (typeCategorie categorie){
		
		System.out.println("Sa Categorie : "+categorie);
		TypedQuery<Competence> query = em.createQuery("Select c from Competence c where c.categorie= :categorie",Competence.class);
				query.setParameter("categorie",categorie);
				
				List <Competence> competences = null;
				try 
				{competences = query.getResultList();
				}catch(NoResultException e)
				{
					//Logger.info("aucun utilisateur trouve avec role : " + role);
					System.out.println("acces refus");
					}
				System.out.println(competences);
				
				return competences;
	}
	
	
	
}
