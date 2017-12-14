# Création d'un puissance 4 en Web avec SpringBoot en mode server-side-templating

## La marche à suivre
- _Création du projet_
Allez sur https://start.spring.io/, il s'agit d'un outil permettant d'initialiser une application spring boot.
Dans l'écran remplir les champs:
  - group : com.igs.ipi
  - artifact : tp-springboot-"votre nom" 
  
  Spring boot étant très modulaire vous devez sélectionner ceux qui vous intéresse. 
Dans notre cas nous allons prendre (en cochant les cases en mode "full"):
  - web (pour faire du web)
  - JPA (=Java Persistance API : pour faire de l'hibernate)
  - HSQLDB (base de données SQL intégré
  - DEVTOOLS (pour faciliter le développement)
  - MUSTACHE (pour la création de page web dynamique)
  
  Cela permet de générer un zip contenant le squelette d'un projet à intégrer directement dans eclipse ou Intellij (choisir le mode import project maven).
  Vous devez pouvoir executer la classe com.igs.ipi.tpspringbootpetrillo.TpSpringBootPetrilloApplication#main.
  Pour le moment l'application doit démarrer mais ne rien faire 

- COMMIT first commit

- Ajout d'une première page
  - Ajout d'un controlleur (le C de MVC) : GameController dans le package com.igs.ipi.tpspringbootpetrillo.controller
Il s'agit d'un bean spring, il faut donc lui rajouter l'annotation correspondante.
  - Ajout d'une url : dans une application web spring, a chaque url est associée une méthode d'un controller
On ajoute donc la méthode newGame, elle sera déclenchée sur l'url /game/new (http://localhost:8080/game/new) https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-ann-requestmapping
Le controller ne fera pour l'instant aucun traitement, il indiquera simple quelle vue utilisée. en retournant un objet ModelAndView
  - Ajout d'une vue (le V de MVC). Nous allons utilisé des templates mustache pour générer nos pages web.
    1. créer un fichier game.html dans le répertoire src/main/resources/template. Ecrire le code html pour afficher une page web 
    2. modifier le controller pour indiquer le template (la page html) à utiliser. https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-view-script

- COMMIT ajout controller et page

- Ajout d'un Model (le M de MVC) le template game pour afficher des informations relatives à une partie de Puissance 4 a besoin de données qui seront contenues dans un objet GameModel, à créer dans le sous package model
Ce Model contiendra pour le moment les noms des 2 adversaires : nom1 et nom2 (pensez au getter/setter vous pouvez les générer automatiquement par votre IDE)
  - Créer le service GameService dans le sous-package service, là aussi, c'est un bean spring.
  Ajouter la méthode newGame, cette méthode retournera une nouvelle instance de GameModel
  Pour commencer vous pouvez initialiser cette objet avec des noms d'adversaires codés en dur
  - Puis modifier le template game pour afficher les noms des adversaires. 
	Pour cela votre controller va avoir besoin d'appeler le service, il va donc falloir lui injecter, puis dans la méthode newGame appeler la méthode du service et stocker fournir au template l'objet GameModel.

- COMMIT affichage des noms des adversaires

- Modifier la View et le Model pour afficher le tableau de jeu (largeur=7, hauteur=6). https://mustache.github.io/mustache.5.html 

- COMMIT affichage du tableau de jeu

- Enregistrement de la partie en session. Dans un premier temps, une partie ne sera pas enregistrée en base de données mais sera mémorisée sur le serveur dans la session Web (Attention une session web = 2 adversaires qui jouent sur un même navigateur web). 
  - Il va donc falloir créer un bean ayant pour scope session : PartieEnCours.
  Il s'agit d'un bean de type @Component et de scope Session.
  Ce bean contient une propriété de type GameModel https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-factory-scopes
  - Modifier le controller, à la création d'une nouvelle partie, le gameModel correspondant devra être stocké dans le bean PartieEnCours. 
  Il faut donc injecter le bean PartieEnCours dans le controller.
  Attention : pour injecter un bean Scope Session dans un bean scope Singleton, il faut que le bean scope Session soit annotée avec :  @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS. Si vous le faite pas l'application ne devrait pas démarrer (configuration des beans spring incohérent)
  - Puis ajouter une nouvelle méthode dans le controller pour gérer l'url /game (sans le new), le traitement ressemblera au premier, à la différence que le GameModel ne sera pas créée mais récupérée depuis le bean PartieEnCours
  
  Et donc, si vous tentez d'accéder à l'url http://localhost:8080/game, vous devriez avoir une erreur, pour fonctionner il faut au préalable avoir déclenché l'url http://localhost:8080/game/new pour avoir initialisé une partie en cours.
  Vérifier en utilisateur 2 navigateurs web (et donc 2 sessions) que vous ne récupérez pas la partie d'une autre session.
  Vous pouvez par exemple faire le même test avec ou sans le scope session

- COMMIT partie en session

- Ajout d'un jeton dans le tableau.
  - Modifier le template HTML pour pouvoir cliquer dans une colonne du tableau pour ajouter un jeton. 
  Pour faire simple, vous pouvez par exemple ajouter un lien <a>...</a> sur chaque case du tableau. 
  Mais attention ce qui compte c'est la colonne sur laquelle on clique (le jeton va glisser de haut en bas pour atteindre la place libre la plus basse).
  Ce lien va déclencher l'url /game/drop/in i étant le numero de la colonne choisie. C'est donc un paramètre passé par l'url
  cf @PathVariable dans la doc https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-ann-requestmapping
  - Ajouter donc une méthode dans le controleur pour répondre à cette nouvelle url
  A cette étape on peut simplifier en ajoutant systématiquement un pion d'une couleur codé en dur.

- COMMIT ajouter jeton

 - Définir qui doit jouer.
Ajouter dans le gameModel une proprieté indiquant le joueur qui doit jouer. En fonction de cette information les jetons ajoutés correspondront au bon joueur. 
Ajouter une information dans la page HMTL permettant d'identifier a qui c'est le tour de jouer.

- COMMIT identifier le tour du joueur

- A chaque coup joué vérifier si le joueur a gagné. si c'est le cas afficher l'information et stopper le jeu, aucune action ne sera alors autorisée

## Pour aller plus loin
- Utiliser JPA (hibernate) pour stocker l'état de la partie en base de données
- Pour voir modifier les noms des advsersaires, calculer leurs statistiques
- Utilisez AJAX pour l'action "ajouter un jeton"
- Pouvoir jouer avec un advsersaire à distance
- Créer des comptes utilisateurs avec authentification et sécurité
- Faire le même exercice en mode client-side-templating avec une techno type Angular...
