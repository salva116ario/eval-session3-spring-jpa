package co.simplo.evalsession3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplo.evalsession3.model.Categorie;
import co.simplo.evalsession3.repository.CategorieRepository;

@RestController
public class CategorieController {
	
	@Autowired
	private CategorieRepository categorieRepository;
	
	/**
	 * requete GET sur /categories retourne la liste de tous les livres
	 * 
	 * @return
	 */
	@GetMapping(value = "/categories")
	public ResponseEntity<?> listeCategories() {
		Iterable<Categorie> categories = null;
		try {
			categories = categorieRepository.findAll();
			System.out.println(categories);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(categories);
	}
	
	}
