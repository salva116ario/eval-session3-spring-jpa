package co.simplo.evalsession3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import co.simplo.evalsession3.model.Livre;
import co.simplo.evalsession3.repository.LivreRepository;

@RestController
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class LivreController {

	@Autowired
	private LivreRepository livreRepository;

	public LivreController() {
	}

	/**
	 * requete GET sur /getAll retourne la liste de tous les livres
	 * 
	 * @return
	 */
	@GetMapping(value = "/getAll")
	public Iterable<Livre> listeLivres() {
		Iterable<Livre> livres = livreRepository.findAll();
		return livres;
	}

	/**
	 * Requete GET sur /byId/{XX} retourne le livre avec id=XX
	 * 
	 * @param id
	 * @return
	 */

	@GetMapping(value = "/byId/{id}")
	public Livre livreById(@PathVariable int id) {
		return livreRepository.findById(id);
	}

	/**
	 * Requete GET sur /byIsbn/{XXXX} retourne le livre avec isbn = XXXX
	 * 
	 * @param isbn
	 * @return
	 */
	@GetMapping(value = "/byIsbn/{isbn}")
	public Livre livreById(@PathVariable Long isbn) {
		return livreRepository.findByIsbn(isbn);
	}

	/**
	 * Requete GET sur /byTitre/{ABC} retourne les livres dont le titre contient ABC
	 * 
	 * @param titre
	 * @return
	 */
	@GetMapping(value = "/byTitre/{titre}")
	public Iterable<Livre> livresByTitre(@PathVariable String titre) {
		return livreRepository.findByTitreContainingIgnoreCase(titre);
	}

	/**
	 * Requete GET sur /byInStock/{X} retourne les livres avec un stock > X
	 * 
	 * @param stock
	 * @return
	 */
	@GetMapping(value = "/byInStock/{stock}")
	public Iterable<Livre> livresByStockGreaterThan(@PathVariable int stock) {
		return livreRepository.findByStockGreaterThan(stock);
	}

	/**
	 * Requete GET sur /byAuteur/{XXX} retourne les livres dont le nom de l'auteur
	 * contient XXX
	 * 
	 * @param auteur
	 * @return
	 */
	@GetMapping(value = "/byAuteur/{auteur}")
	public Iterable<Livre> livresByAuteur(@PathVariable String auteur) {
		return livreRepository.findByAuteurContainingIgnoreCase(auteur);
	}
}