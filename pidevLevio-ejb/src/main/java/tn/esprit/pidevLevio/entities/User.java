package tn.esprit.pidevLevio.entities;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class User implements Serializable {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String login;
	private String pwd;
	private String roles;
	
}
