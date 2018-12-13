package co.simplo.evalsession3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonRawValue;

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
	public ResponseEntity<?> listeLivres() {
		Iterable<Livre> livres = null;
		try {
		 livres = livreRepository.findAll();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(livres);
	}


	/**
	 * Requete GET sur /byId/{XX} retourne le livre avec id=XX
	 * 
	 * @param id
	 * @return
	 */

	@GetMapping(value = "/byId/{id}")
	public ResponseEntity<?> livreById(@PathVariable int id) {
		Livre livre = null;
		try {
			livre = livreRepository.findById(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(livre);
	}

	/**
	 * Requete GET sur /byIsbn/{XXXX} retourne le livre avec isbn = XXXX
	 * 
	 * @param isbn
	 * @return
	 */
	@GetMapping(value = "/byIsbn/{isbn}")
	public  ResponseEntity<?>  livreById(@PathVariable Long isbn) {
		Livre livre = null;
		try {
			livre = livreRepository.findByIsbn(isbn);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(livre);
	}
	

	/**
	 * Requete GET sur /byTitre/{ABC} retourne les livres dont le titre contient ABC
	 * 
	 * @param titre
	 * @return
	 */
	@GetMapping(value = "/byTitre/{titre}")
	public ResponseEntity<?> livresByTitre(@PathVariable String titre) {
		Iterable<Livre> livres = null;
		try {
		 livres = livreRepository.findByTitreContainingIgnoreCase(titre);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(livres);
	}
	
	/**
	 * Requete GET sur /byStock/{n} retourne les livres avec un stock > n
	 * 
	 * @param stock
	 * @return
	 */
	@GetMapping(value = "/byStock/{stock}")
	public ResponseEntity<?> livresByStockGreaterThan(@PathVariable int stock) {
		Iterable<Livre> livres = null;
		try {
		 livres = livreRepository.findByStockGreaterThan(stock);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(livres);
		}

	/**
	 * Requete GET sur /byAuteur/{XXX} retourne les livres dont le nom de l'auteur
	 * contient XXX
	 * 
	 * @param auteur
	 * @return
	 */
	@GetMapping(value = "/byAuteur/{auteur}")
	public ResponseEntity<?> livresByAuteur(@PathVariable String auteur) {
		
		Iterable<Livre> livres = null;
		try {
		 livres = livreRepository.findByAuteurContainingIgnoreCase(auteur);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(livres);
	}
	
	/**
	 * Requete POST sur /addLivre pour ajouter un livre a la BDD
	 * @param livre
	 * @return
	 */
	@PostMapping(value = "/addLivre", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> addLivre(@RequestBody Livre livre){
		Livre resultLivre = null;
		System.out.println(livre);
		String titre = livre.getTitre();
		if((titre == null) || (titre.isEmpty()))
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Il manque le titre !");
		
		String auteur = livre.getAuteur();
		if((auteur == null) || (auteur.isEmpty()))
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Il manque l'auteur !");
		
		try {
			resultLivre = livreRepository.saveAndFlush(livre);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(resultLivre);
	}
	
	/**
	 * Requete PUT sur /addLivre/{X} met a jour la fiche du livre avec id = X
	 * @param livre
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PutMapping(value = "/addLivre/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	
	public ResponseEntity<?> updateLivre(@RequestBody Livre livre,@PathVariable Integer id) throws Exception {
		Livre resultLivre = null;
		String titre = livre.getTitre();
		System.out.println(titre);
		if((titre == null) || (titre.isEmpty()))
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Il manque le titre !");
		
		String auteur = livre.getAuteur();
		if((auteur == null) || (auteur.isEmpty()))
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Il manque l'auteur !");
		
		try {
			System.out.println(livre);
			resultLivre = livreRepository.save(livre);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(resultLivre);
	}
	
	/**
	 * Requete DELETE sur /deleteLivre/{x} pour supprimer le livre avec id = X de la BDD
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/deleteLivre/{id}")
	public ResponseEntity<?> deleteLivre(@PathVariable Integer id){
		try {
		livreRepository.deleteById(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
}