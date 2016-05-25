# Projet RMI

 * Auteurs: 
	  * Jérémy Melchor [jeremy.melchor@etu.unice.fr](jeremy.melchor@etu.unice.fr)
	  * Matthieu Perrin [matthieu.perrin@etu.unice.fr](matthieu.perrin@etu.unice.fr)
 * Date: 25 Mai 2016

Le but de ce projet est de pouvoir utiliser des méthodes java à distance, depuis un serveur, ainsi qu'inscrire des objets dans le registre directement. Notre projet simule un magasin de voitures. Il y a 2 différents clients : 

 - les vendeurs
 - les acheteurs

## Architecture du projet

Le projet est divisé en 5 parties afin de ne pas tout mélanger :

 - Le registre universel qui contient le code de notre propre registre avec un main qui crée un registre RMI, et y inscrit le code de notre registre.
 - Le serveur de classe qui s'occupe juste de télécharger les classes manquantes pour le client
 - Le serveur contenant tout le code métier caché au client avec un main récupérant le code de notre registre universel pour y inscrire nos classes métier
 - Le client, contenant seulement les interfaces et les enums ainsi que l'objet manipulé. En revanche il ne connait pas la sous-classe de l'objet. Deux main y sont présent : un main pour le vendeur, récupérant seulement l'interface de gestion du magasin et un main pour le client récupérant l'interface d'accès à la base de données. Ce découpage a été fait afin qu'un client ne modifie pas la base de données et la questionne seulement.
 - Le Sender et Receiver pour la partie JMS


### Execution RMI
Pour exécuter le projet, il faut :

 1.Démarrer le serveur de classe. Dans la console la ligne suivante va s'afficher : 
  > To use this ClassFileServer set the property -Djava.rmi.server.codebase=http://Nom_du_PC:2001/
  
Garder de coté "Nom_du_Pc" pour l'étape 2

Puis inscrire comme arguments de programme : 

> *2001 C:\Path\to\.class\files*  

> 2001 étant le port sur lequel s'exécute le serveur de classe et l'URL étant le dossier qui contient les fichiers *.class* que le client récupérera lorsqu'il ne connait pas les classes.  
> Sous *IntelliJ* faire Run -> Edit Configurations.. -> inscrire cette ligne dans *Program Arguments*

 2.Avant de lancer le launcher du registre universel, entrer dans les options de VM : 

> -Djava.rmi.server.codebase=http://Nom_du_PC:2001/  
> -Djava.security.policy="src/security.policy"  
> -Djava.rmi.server.useCodeBaseOnly=false  
> Sur *IntelliJ* faire Run -> Edit Configurations.. -> inscrire ces lignes dans *VM Options*  
> **Si problèmes d'accès refusé, mettre le chemin absolu du security.policy**

 3.Ecrire comme options de VM les lignes suivantes et lancer le launcher du **serveur**
> -Djava.rmi.server.codebase=http://Nom_du_PC:2001/  
> -Djava.security.policy="../RMI-RegistreUniversel/src/security.policy"  
> -Djava.rmi.server.useCodeBaseOnly=false  
> **Attention** ici l'URL du *security.policy* pointe sur le *security.policy* du projet RMI-RegistreUniversel

 4.Ecrire les même lignes qu'a l'étape 3 pour le client, et les écrire pour les **2 classes main** et exécuter soit *VendeurLauncher* pour être en tant que vendeur, soit *ClientLauncher* pour être en tant que client.

### Execution JMS

Pour JMS il suffit simplement de lancer le serveur ActiveMQ, puis de lancer la classe MySender et MyReceiver. Le consommateur de message MyReceiver tournera en boucle infinie (écouter avec le listener). En revanche le producteur MySender se termine après avoir envoyé son message.

## Fonctionnalités

La base de donnée est une HashTable, avec comme clé les voitures, et comme valeur le nombre de celle-ci présentent dans le magasin.

Au niveau du Registre Universel, on y a ajouté 3 méthodes :
- ```getLastXResults(int nbKeys)``` qui renvoi le nombre les nbKeys résultats
- ```getLastXKeys(int nbKeys)``` qui renvoi les nbKeys utilisés
- ```getPopularKeys()``` qui renvoi une Hashtable avec les clés utilisés en Key et le nombre de fois où on a fait un lookup comme Valeur de la HashTable

Du côté vendeur, comme opérations sur les voitures, on peut :

 - Ajouter
 - Supprimer
 - Modifier (marque, carburant, couleur, année, prix)
 - Récupérer la liste des voitures, une en particulier, ou le String de la base de donnée.

Pour les acheteurs, on peut :

 - Trier par
	 - Marque
	 - Couleur
	 - Type de carburant
	 - Prix (supérieur ou inférieur à un prix)
	 - Date (supérieur ou inférieur à une date)

Pour simplifier l'utilisation et la cohérence entre vendeur et acheteurs (afin d'éviter qu'un vendeur enregistre une voiture de couleur *"bleu"* et un acheteur en recherche une de couleur *"bleue"*), on utilise des *enums*.
![enum](https://github.com/patchimou/RMI/raw/master/img/enum.png)

De plus on a le registre universel nous permettant de bind directement un objet *Car* dans le registre et d'y accéder.

## Difficultés rencontrées
Les principales difficultés sont le verrou technique et la compréhension du fonctionnement d'un registre RMI. De plus, les exceptions n'étant pas toujours explicite, on reste facilement bloqué si l'on a pas une compréhension globale du rouage RMI. 


 
 


