<<<<<<< HEAD
package co.simplo.evalsession3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplo.evalsession3.model.Categorie;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {

}
=======
package co.simplo.evalsession3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.simplo.evalsession3.model.Categorie;

/**
 * Interface DAO pour Categorie
 *
 */

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {

}
>>>>>>> branch 'master' of https://github.com/salva116ario/eval-session3-spring-jpa.git
