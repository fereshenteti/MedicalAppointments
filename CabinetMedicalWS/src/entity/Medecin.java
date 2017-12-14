package entity;

import java.io.Serializable;

public class Medecin implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1256609551175042164L;
	private Long idMedecin;
	private String nom;
	private String prenom;
	private String grade;
	private String specialite;
	private boolean actif;
	private String username;
	private String password;
	
	
	public Medecin() {
		super();
	}


	public Medecin(Long idMedecin, String nom, String prenom, String grade, String username, String password,
			String specialite) {
		super();
		this.idMedecin = idMedecin;
		this.nom = nom;
		this.prenom = prenom;
		this.grade = grade;
		this.specialite = specialite;
		this.username = username;
		this.password = password;		
	}


	public Long getIdMedecin() {
		return idMedecin;
	}


	public void setIdMedecin(Long idMedecin) {
		this.idMedecin = idMedecin;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	public String getSpecialite() {
		return specialite;
	}


	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}


	public boolean isActif() {
		return actif;
	}


	public void setActif(boolean actif) {
		this.actif = actif;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
}
