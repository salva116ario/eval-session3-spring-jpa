# Evaluation session 3
## Mini application SpringBoot avec JPA, Hibernate et Javascript. 
### (Sam J. / Salva)

## Présentation de l'application
Il s'agit d'une interface graphique permettant de manipuler les données d'une table de BDD contenant des livres.  
L'idée est de pouvoir consulter et éditer ce catalogue en réalisant toutes les opération de CRUD.  

### MLD
![mld](/mld.png)  
La BDD est très simple ! Une table *livre* contenant les infos de chaque ouvrage, liée à une table *categorie*, partant du principe qu'un livre ne peut avoir qu'une seule catégorie.

### Architecture de l'appli
Nous avons d'abord généré un projet Maven / Spring Boot / Hibernate.  
Dans le package model, nous avons d'abord créé les deux classes "entités" *Livre* et *Catalogue* qui nous ont permis de générer les tables SQL.  
Le package repository contient les classes LivreRepository et CatalogueRepository (extends JpaRepository).  
Le package controller contient une classe LivreController avec les méthodes de CRUD qui permettent de :  
  REQUETES GET
  lister tous les livres 
  trouver un livre par son id 
  trouver un livre par ISBN
  trouver les livres dont le titre contient xxx
  trouver les livres dont le nom de l'auteur contient xxx 
  trouver les livres avec plus de n exemplaires en stock
  REQUETE POST
  ajouter un livre 
  REQUETE PUT
  modifier un livre
  REQUETE DELETE
  supprimer un livre par id 

Pour la partie front, nous avons utilisé le plugin javascript DataTables pour l'affichage de la liste des livres.
Un formulaire permet d'afficher / modifier les infos d'un livre sélectionné.
Les appels aux méthodes de CRUD se font depuis le fichier script.js, lorsqu'on clique sur les boutons dédiés affichés dans la page index.html 
