# Projet RMI

 * Auteurs: 
	  * Jérémy Melchor [jeremy.melchor@etu.unice.fr](jeremy.melchor@etu.unice.fr)
	  * Matthieu Perrin [matthieu.perrin@etu.unice.fr](matthieu.perrin@etu.unice.fr)
 * Date: 25 Mai 2016

Le but de ce projet est de pouvoir utiliser des méthodes java à distance, depuis un serveur. Notre projet simule un magasin de voitures. Il y a 2 différents clients : 

 - les vendeurs
 - les acheteurs

## Architecture du projet
![architecture](https://github.com/patchimou/RMI/tree/master/img/architecture.png)
Tout d'abord le package client, on utilise le *ClientLauncher* pour être en tant que client ou le *VendeurLauncher* pour être en tant que gestionnaire du magasin.
Au niveau du package serveur, celui ci contient des *Enum*, une base de données et un launcher pour le serveur. Il est découpé en 2 :

 - Le package *acheteur* offrant une interface de services avec leur implémentation
 - Le package *vendeur* offrant une interface de gestion du stock de voitures, avec leur implémentation ainsi que l'objet *Car* lui-même

### Execution
**A completer quand on aura mis en place l'accès remote**

## Fonctionnalités

Du côté vendeur, comme opérations sur les voitures, on peut :

 - Ajouter
 - Supprimer
 - Modifier
 - Récupérer la liste

Pour les acheteurs, on peut :

 - Trier par
	 - Modèle
	 - Marque
	 - Couleur
	 - Type de carburant
	 - Prix (supérieur ou inférieur à un prix)
	 - Date (supérieur ou inférieur à une date)

Pour simplifier l'utilisation et la cohérence entre vendeur et acheteurs (afin d'éviter qu'un vendeur enregistre une voiture de couleur *"bleu"* et un acheteur en recherche une de couleur *"bleue"*), on utilisera les *Enums* côté client.
![enum](https://github.com/patchimou/RMI/tree/master/img/enum.png)

> **Remarque** : Toute les méthodes renvoient des *String*, pour avoir un affichage du résultat de la méthode que vous avez appelé dans le client, mettez cette méthode dans un `System.out.println()` sinon l'affichage se fera côté serveur et sera donc inutile pour vous en tant que client !

## Difficultés rencontrées
**A completer**
 
 
