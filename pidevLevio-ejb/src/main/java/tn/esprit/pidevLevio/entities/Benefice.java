package tn.esprit.pidevLevio.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Benefice
 *
 */
@Entity

public class Benefice implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idBenefice;
	private float prix;
	private float budget;
	private float budgetCourant;
	private int mois1;
	private int mois2;
	private int mois3;
	private int mois4;
	private int mois6;
	private int mois7;
	private int mois8;
	private int mois9;
	private int mois10;
	private int mois11;
	private int mois12;
	
	@ManyToOne
	private Projet projet;
	
	private static final long serialVersionUID = 1L;

	public Benefice() {
		super();
	}   
	public int getIdBenefice() {
		return this.idBenefice;
	}

	public void setIdBenefice(int idBenefice) {
		this.idBenefice = idBenefice;
	}   
	public float getPrix() {
		return this.prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}   
	public float getBudget() {
		return this.budget;
	}

	public void setBudget(float budget) {
		this.budget = budget;
	}   
	public float getBudgetCourant() {
		return this.budgetCourant;
	}

	public void setBudgetCourant(float budgetCourant) {
		this.budgetCourant = budgetCourant;
	}   
	public int getMois1() {
		return this.mois1;
	}

	public void setMois1(int mois1) {
		this.mois1 = mois1;
	}   
	public int getMois2() {
		return this.mois2;
	}

	public void setMois2(int mois2) {
		this.mois2 = mois2;
	}
	public int getMois3() {
		return mois3;
	}
	public void setMois3(int mois3) {
		this.mois3 = mois3;
	}
	public int getMois4() {
		return mois4;
	}
	public void setMois4(int mois4) {
		this.mois4 = mois4;
	}
	public int getMois6() {
		return mois6;
	}
	public void setMois6(int mois6) {
		this.mois6 = mois6;
	}
	public int getMois7() {
		return mois7;
	}
	public void setMois7(int mois7) {
		this.mois7 = mois7;
	}
	public int getMois8() {
		return mois8;
	}
	public void setMois8(int mois8) {
		this.mois8 = mois8;
	}
	public int getMois9() {
		return mois9;
	}
	public void setMois9(int mois9) {
		this.mois9 = mois9;
	}
	public int getMois10() {
		return mois10;
	}
	public void setMois10(int mois10) {
		this.mois10 = mois10;
	}
	public int getMois11() {
		return mois11;
	}
	public void setMois11(int mois11) {
		this.mois11 = mois11;
	}
	public int getMois12() {
		return mois12;
	}
	public void setMois12(int mois12) {
		this.mois12 = mois12;
	}
	public Projet getProjet() {
		return projet;
	}
	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Benefice(float prix, float budget, float budgetCourant, int mois1, int mois2, int mois3, int mois4,
			int mois6, int mois7, int mois8, int mois9, int mois10, int mois11, int mois12, Projet projet) {
		super();
		this.prix = prix;
		this.budget = budget;
		this.budgetCourant = budgetCourant;
		this.mois1 = mois1;
		this.mois2 = mois2;
		this.mois3 = mois3;
		this.mois4 = mois4;
		this.mois6 = mois6;
		this.mois7 = mois7;
		this.mois8 = mois8;
		this.mois9 = mois9;
		this.mois10 = mois10;
		this.mois11 = mois11;
		this.mois12 = mois12;
		this.projet = projet;
	}
	public Benefice(int idBenefice, float prix, float budget, float budgetCourant, int mois1, int mois2, int mois3,
			int mois4, int mois6, int mois7, int mois8, int mois9, int mois10, int mois11, int mois12, Projet projet) {
		super();
		this.idBenefice = idBenefice;
		this.prix = prix;
		this.budget = budget;
		this.budgetCourant = budgetCourant;
		this.mois1 = mois1;
		this.mois2 = mois2;
		this.mois3 = mois3;
		this.mois4 = mois4;
		this.mois6 = mois6;
		this.mois7 = mois7;
		this.mois8 = mois8;
		this.mois9 = mois9;
		this.mois10 = mois10;
		this.mois11 = mois11;
		this.mois12 = mois12;
		this.projet = projet;
	}
   
}
