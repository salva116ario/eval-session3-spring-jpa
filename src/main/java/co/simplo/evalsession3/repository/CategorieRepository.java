package co.simplo.evalsession3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.simplo.evalsession3.model.Categorie;

/**
 * Interface DAO pour Categorie
 *
 */

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {

}
