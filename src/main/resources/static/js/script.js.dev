$(document).ready(function() {

	// appelle la méthode pour charger la table livre dans la datatable
	loadDatatable();
	// déclaration d'une variable table;
	var table = $('#livreTable').DataTable();
	// appelle la méthode pour charger la table categorie
	loadCategories();

	/*
	 * Si vous double-cliquez sur une ligne de la datatable vous récupérez la
	 * valeur des attributs de la ligne concernée (row) aux différentes zones de
	 * saisie
	 */
	$('#livreTable tbody').on('dblclick', 'tr', function() {
		let dataRow = table.row(this).data();
		$("#id").val(dataRow.id);
		$("#titre").val(dataRow.titre);
		$("#auteur").val(dataRow.auteur);
		$("#editeur").val(dataRow.editeur);
		$("#imageCouverture").val(dataRow.couverture);
		$("#isbn").val(dataRow.isbn);
		$("#categorie").val(dataRow.categorie.id);
		$("#langue").val(dataRow.langue);
		$("#prix").val(dataRow.prix);
		$("#stock").val(dataRow.stock);
	});

	// si vous cliquez sur le bouton click "btn-post"
	// on appelle la méthode "livre_submit()
	// en lui passant 2 paramètres : la référence du bouton pour le désactiver
	// et la type de méthode, ici POST.
	$("#btn-post").click(function() {
		livre_submit($("#btn-post"), "POST", table);
	});

	// si vous cliquez sur le bouton click "btn-put"
	// on appelle la méthode "livre_submit()
	// en lui passant 2 paramètres : la référence du bouton pour le désactiver
	// et la type de méthode, ici PUT.
	$("#btn-put").click(function() {
		livre_submit($("#btn-put"), "PUT", table);

	});

	// click on RESET
	$("#btn-reset").click(function() {
		resetForm(); // méthode qui met les valeurs des zones de textes du
		// formulaire à blanc
		resetFeedBackLivre();
	});

	// click on GET
	$("#btn-get").click(function() {
		getLivre(); // affiche l'livre(e) sélectionné(e) dans la DataTable
	});

	// click on DELETE
	$("#btn-delete").click(function() {
		deleteLivre(); // efface l'livre en fonction de l'identifiant

	});
});

// charge les données dans la datatable
function loadDatatable() {
	$('#livreTable').DataTable({

		"ajax" : {
			url : '/getAll',
			dataSrc : ''
		},
		"columns" : [ {
			"data" : "id"
		}, {
			"data" : "titre"
		}, {
			"data" : "auteur"
		}, {
			"data" : "editeur"
		}, {
			"data" : "couverture",
			"render" : function(data, type, row, meta) {
				return '<img src="' + data + '" width="50px" />';
			}
		}, {
			"data" : "isbn"
		}, {
			"data" : "categorie.intitule"
		}, {
			"data" : "prix"
		}, {
			"data" : "stock"
		}

		]
	});
}

// Fonction qui traite les PUT et PUST
function livre_submit(button, httpVerb, table) {

	var livre = {};
	// on récupère les valeurs saisies
	livre["id"] = $("#id").val();
	livre["auteur"] = $("#auteur").val();
	livre["titre"] = $("#titre").val();
	livre["editeur"] = $("#editeur").val();
	livre["couverture"] = $("#imageCouverture").val();
	livre["isbn"] = $("#isbn").val();
	var categorie = {
		"id" : $("#categorie").val(),
		"intitule" : ""
	};
	livre["categorie"] = categorie;
	livre["prix"] = $("#prix").val();
	livre["stock"] = $("#stock").val();

	// on initialise l'url du back
	var url = "/addLivre/";

	// si c'est une modification, on passe l'identifiant
	if (httpVerb == "PUT")
		url += "" + livre["id"];

	// on désactive le bouton en cours
	button.prop("disabled", true);

	// on lance la méthode ajax pour faire le lien avec les méthodes back du
	// constructeur
	$
			.ajax({
				type : httpVerb, // méthode POST ou PUT
				contentType : "application/json; charset=utf-8", // type de données
				url : url, // url destinatrice
				dataType : 'json', // on précise le mode de transfert
				data : JSON.stringify(livre), // on transforme les données de
				// la variable Javascript
				// "livre" en format JSON
				cache : false, // pas de cache sollicité
				timeout : 600000, // délai d'attente
				success : function(data) { // si ok

					var json = "<h3>Server Response au format JSON</h3><pre>livre (modifié/ajouté) :<br>"
							+ JSON.stringify(data, null, 4) + "</pre>";

					$('#feedbackLivre').html(json); // renvoie les infos aux
					// format JSON adapté au
					// HTML dans la balise "<DIV
					// id="feedbacklivre">

					console.log("SUCCESS : ", data);
					button.prop("disabled", false);

					resetForm()
				},
				error : function(e) {

					var json = "<h3>Server Response</h3><pre>" + e.responseText
							+ "</pre>";

					$('#feedbackLivre').html(json);

					console.log("ERROR : ", e);
					button.prop("disabled", false);

				}
			});

}
// vide les champs du formulaire
function resetForm() {
	$('#livre-form')[0].reset();
}
// vide la div feedbackLivre
function resetFeedBackLivre() {
	$('#feedbackLivre').html("");
}

// Récupère les infos de la table catégorie
function loadCategories() {
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : '/categories',
		data : {},
		dataType : 'json',
		cache : false,
		timeout : 600000,
		success : function(data) {

			var json = JSON.stringify(data, null, 4);
			var list = '';
			$.each(data, function(key, value) {
				list += '<option value=' + value['id'] + '>'
						+ value['intitule'] + '</option>';
			});
			$("#categorie").append(list);
		},
		error : function(e) {

			var json = "<h3>Server Response</h3><pre>" + e.responseText
					+ "</pre>";

			$('#feedbackLivre').html(json);

			console.log("ERROR : ", e);
		}
	});
}

// Methode qui retourne les infos d'un livre
function getLivre() {
	
	var path;
	var choixRecherche = $("#choixGet").val();
	switch (choixRecherche) {
	case "byId" :
		path = "/byId/" + $("#id").val();
		break;
	case "byTitre" :
		path = "byTitre/" + $("#titre").val();
		break;
	case "byAuteur" :
		path = "byAuteur/" + $("#auteur").val();
		break;
	case "byIsbn" :
		path = "byIsbn/" + $("#isbn").val();
		break;
	case "byStock" :
		path = "byStock/" + $("#stock").val();
		break;
	case "byCategorie" :
		path = "byCategorie/" + $("#categorie").val();
		console.log(path);
		break;
	default :
			$('#feedbackLivre').html(
			"Recherche impossible");
	}
	
//	
//	var idValue = $("#id").val();
//	var titreValue = $("#titre").val();
//	var path;
//	if (idValue.length == 0 && titreValue.length == 0) {
//		$('#feedbackLivre').html(
//				"Merci d'indiquer au moins un id ou une partie du titre");
//	} else {
//		if (idValue.length > 0) {
//			path = "/byId/" + idValue;
//			console.log(path);
//		} else {
//			path = "/byTitre/" + titreValue;
//			console.log(path);
//		}
		$.ajax({
					type : "GET",
					contentType : "application/json",
					url : path,
					data : {},
					dataType : 'json',
					cache : false,
					timeout : 600000,
					success : function(data) {

						var json = "<h3>Server Response format JSON</h3><pre>Livre trouvé :<br>"
								+ JSON.stringify(data, null, 4) + "</pre>";

						$('#feedbackLivre').html(json);

						$("#id").val(data.id);
						$("#titre").val(data.titre);
						$("#auteur").val(data.auteur);
						$("#editeur").val(data.editeur);
						$("#imageCouverture").val(data.couverture);
						$("#isbn").val(data.isbn);
						$("#categorie").val(data.categorie.id);
						$("#prix").val(data.prix);
						$("#stock").val(data.stock);

						console.log("SUCCESS : ");
						
					
						

					},
					error : function(e) {

						var json = "<h3>Server Response</h3><pre>"
								+ e.responseText + "</pre>";

						$('#feedbackLivre').html(json);
					

						console.log("ERROR : ", e);
					}
				});
}

// Méthode pour supprimer un livre
function deleteLivre() {

	var idLivre = $("#id").val();

	$.ajax({
		type : "DELETE",
		contentType : "application/json",
		url : "/deleteLivre/" + idLivre,
		// data : {},
		// dataType : 'json',
		cache : false,
		timeout : 600000,
		success : function(data) {

			var json = "<h3>Server Response</h3><pre>Livre " + idLivre
					+ " deleted.</pre>";
			$('#feedbackLivre').html(json);
			console.log("SUCCESS : ", data);

			resetForm();
		},
		error : function(e) {
			var json = "<h3>Server Response</h3><pre>" + e.responseText
					+ "</pre>";

			$('#feedbackLivre').html(json);
			console.log("ERROR : ", e);
		},
		complete : function() {
			document.location.reload();
		}
	});
	
	
	
	}
