package co.simplo.evalsession3.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Bean Categorie
 *
 */
@Entity
@Table(name = "categorie")
public class Categorie implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ca_id")
	private String id;

	@Column(name = "ca_intitule")
	private String intitule;

	@JsonBackReference
	@OneToMany(mappedBy = "categorie")
	private List<Livre> livres = new ArrayList<Livre>();

	public Categorie() {
		super();
	}

	public Categorie(String id, String intitule, List<Livre> livres) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.livres = livres;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public List<Livre> getLivres() {
		return livres;
	}

	public void getLivres(List<Livre> livres) {
		this.livres = livres;
	}


}
