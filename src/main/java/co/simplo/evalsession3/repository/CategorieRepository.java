package co.simplo.evalsession3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplo.evalsession3.model.Categorie;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {

}
