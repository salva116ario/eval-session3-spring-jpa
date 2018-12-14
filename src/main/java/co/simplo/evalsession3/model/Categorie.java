<<<<<<< HEAD
package co.simplo.evalsession3.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "categorie")
public class Categorie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ca_id")
	private Integer id;
	
	@Column(name = "ca_intitule")
	private String intitule;
	
	@JsonBackReference
	@OneToMany(mappedBy = "categorie" )
	private Set<Livre> livres = new HashSet<Livre>();

	public Categorie() {
		super();
	}

	public Categorie(Integer id, String intitule, Set<Livre> livres) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.livres = livres;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Set<Livre> getLivres() {
		return livres;
	}

	public void getLivres(Set<Livre> livres) {
		this.livres = livres;
	}
	
	
	

}
=======
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
>>>>>>> branch 'master' of https://github.com/salva116ario/eval-session3-spring-jpa.git
