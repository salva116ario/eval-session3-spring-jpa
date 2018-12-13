package co.simplo.evalsession3.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.simplo.evalsession3.model.Livre;

public interface LivreRepository extends CrudRepository<Livre, Integer>{


	Livre findById(int id);
	Livre findByIsbn(Long isbn); 
	Iterable<Livre> findByTitreContainingIgnoreCase(String titre);
	Iterable<Livre> findByStockGreaterThan(int i);
	Iterable<Livre> findByAuteurContainingIgnoreCase(String auteur);


}
