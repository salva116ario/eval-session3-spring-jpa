package co.simplo.evalsession3.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "livre")
public class Livre implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "li_id")
	private Integer id;
	@Column(name = "li_titre")
	private String titre;	
	@Column(name = "li_auteur")
	private String auteur;
	@Column(name = "li_editeur")
	private String editeur;
	@Column(name = "li_isbn")
	private Long isbn;
	@Column(name = "li_couverture")
	private String couverture;
	@Column(name = "li_prix")
	private Double prix;
	@Column(name = "li_stock")
	Integer stock;
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "categorie")
	private Categorie categorie;
	
	
	
	
	public Livre() {
		super();
	}

	public Livre(Integer id, String titre, String auteur, String editeur, Long isbn, String couverture, Double prix,
			Integer stock, Categorie categorie) {
		super();
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
		this.editeur = editeur;
		this.isbn = isbn;
		this.couverture = couverture;
		this.prix = prix;
		this.stock = stock;
		this.categorie = categorie;
	}

	
	public Categorie getCategorie() {
		return categorie;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getEditeur() {
		return editeur;
	}

	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}

	public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

	public String getCouverture() {
		return couverture;
	}

	public void setCouverture(String couverture) {
		this.couverture = couverture;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", auteur=" + auteur + ", editeur=" + editeur + ", isbn=" + isbn
				+ ", couverture=" + couverture + ", prix=" + prix + ", stock=" + stock + ", categorie=" + categorie
				+ "]";
	}
	
	

	
	
	
}
