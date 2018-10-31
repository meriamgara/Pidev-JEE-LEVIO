package tn.esprit.pidevLevio.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Evaluation implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EvaluationPK evaluationPK;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="idCompetence", referencedColumnName="id",insertable=false,updatable=false)
	private Competence competence;
	@ManyToOne
	@JoinColumn(name="idRessource", referencedColumnName="id",insertable=false,updatable=false)
	private Ressource ressource;
	
	
	private int niveau;
	
	
	public Competence getCompetence() {
		return competence;
	}
	public void setCompetence(Competence competence) {
		this.competence = competence;
	}
	
	public Ressource getRessource() {
		return ressource;
	}
	public void setRessource(Ressource ressource) {
		this.ressource = ressource;
	}
	

	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	
	
	
	public Evaluation(Competence competence, Ressource ressource, int niveau) {
		super();
		this.competence = competence;
		this.ressource = ressource;
		this.niveau = niveau;
	}
	
	
	public EvaluationPK getEvaluationPK() {
		return evaluationPK;
	}
	public void setEvaluationPK(EvaluationPK evaluationPK) {
		this.evaluationPK = evaluationPK;
	}
	
	
	
	public Evaluation(EvaluationPK evaluationPK, Competence competence, Ressource ressource, int niveau) {
		super();
		this.evaluationPK = evaluationPK;
		this.competence = competence;
		this.ressource = ressource;
		this.niveau = niveau;
	}
	@Override
	public String toString() {
		return "Evaluation [evaluationPK=" + evaluationPK + ", competence=" + competence + ", ressource=" + ressource
				+ ", niveau=" + niveau + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((competence == null) ? 0 : competence.hashCode());
		result = prime * result + ((evaluationPK == null) ? 0 : evaluationPK.hashCode());
		result = prime * result + niveau;
		result = prime * result + ((ressource == null) ? 0 : ressource.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evaluation other = (Evaluation) obj;
		if (competence == null) {
			if (other.competence != null)
				return false;
		} else if (!competence.equals(other.competence))
			return false;
		if (evaluationPK == null) {
			if (other.evaluationPK != null)
				return false;
		} else if (!evaluationPK.equals(other.evaluationPK))
			return false;
		if (niveau != other.niveau)
			return false;
		if (ressource == null) {
			if (other.ressource != null)
				return false;
		} else if (!ressource.equals(other.ressource))
			return false;
		return true;
	}
	public Evaluation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
