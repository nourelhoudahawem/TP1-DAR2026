# TP1-DAR2026 — Les sockets en mode connecté TCP

## 1. Vérification de l’environnement
Cette capture d’écran montre la vérification des versions de Git et de Java avec les commandes `git --version` et 
`java --version`.

![Vérification de l’environnement](screenshots/1-verification.png)
## 2. Création du projet Java
Cette capture d’écran présente la structure du projet `TP1-DAR2026`, contenant les packages `serverPackage` et `clientPackage`, avec les classes `Server.java` et `Client.java`.

![Structure du projet Java](screenshots/2-structure-projet.png)
## 3. Démarrage du serveur
Cette capture d’écran montre le serveur TCP démarré sur le port 5000. Le serveur attend la connexion d’un client grâce à la méthode `accept()`.

![Serveur en attente de connexion](screenshots/3-serveur-attente.png)
## 4. Connexion du client au serveur
Cette capture d’écran montre l’exécution du client TCP et l’établissement de la connexion avec le serveur sur le port 5000.

![Client connecté au serveur](screenshots/4-client-connecte.png)
## 5. Vérification de la connexion côté serveur
Cette capture d’écran montre que le serveur a accepté la connexion du client grâce à la méthode `accept()`.

![Serveur connecté au client](screenshots/5-serveur-client-connecte.png)
## 6. Test de connexion avec une adresse IP

Cette capture d’écran montre la modification de l’adresse utilisée par le client. Le nom `localhost` est remplacé par l’adresse IPv4 de la machine afin de tester la connexion TCP.

![Test avec une adresse IP](screenshots/6-test-adresse-ip.png)
## 7. Résultat du test avec une adresse IP

Le test de connexion a réussi. Le client a pu établir une connexion TCP avec le serveur en utilisant l’adresse IPv4 de la machine sur le port 5000.

![Résultat de la connexion avec une adresse IP](screenshots/7-connexion-ip.png)