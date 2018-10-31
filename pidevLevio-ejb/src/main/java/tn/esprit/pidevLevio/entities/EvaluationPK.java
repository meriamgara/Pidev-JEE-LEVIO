package tn.esprit.pidevLevio.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class EvaluationPK implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idCompetence;
	private int idRessource;
	private int idEvaluation;
	public int getIdCompetence() {
		return idCompetence;
	}
	public void setIdCompetence(int idCompetence) {
		this.idCompetence = idCompetence;
	}
	public int getIdRessource() {
		return idRessource;
	}
	public void setIdRessource(int idRessource) {
		this.idRessource = idRessource;
	}
	public int getIdEvaluation() {
		return idEvaluation;
	}
	public void setIdEvaluation(int idEvaluation) {
		this.idEvaluation = idEvaluation;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCompetence;
		result = prime * result + idEvaluation;
		result = prime * result + idRessource;
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
		EvaluationPK other = (EvaluationPK) obj;
		if (idCompetence != other.idCompetence)
			return false;
		if (idEvaluation != other.idEvaluation)
			return false;
		if (idRessource != other.idRessource)
			return false;
		return true;
	}
	public EvaluationPK(int idCompetence, int idRessource, int idEvaluation) {
		super();
		this.idCompetence = idCompetence;
		this.idRessource = idRessource;
		this.idEvaluation = idEvaluation;
	}
	public EvaluationPK() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
