# Assurance Console App

## Contexte
Une société d’assurance souhaite digitaliser ses services. Cette application console facilite la gestion des contrats, des clients et des sinistres.

## Objectifs
- Créer une application console fonctionnelle pour gérer les assurés et leurs sinistres.
- Appliquer des concepts de programmation fonctionnelle en Java :
    - Streams API pour le traitement des collections.
    - Lambda et Method References pour simplifier le code.
    - Optional pour gérer les valeurs nulles.


## Diagram de class 

https://lucid.app/lucidchart/5a2d4306-7d26-4731-99de-65c6ff125b22/edit?page=0_0&invitationId=inv_57ef5155-2e3a-45d5-bb93-8b3dde35838f#

## Planificaton 
https://echchablihamza1-1758017258704.atlassian.net/jira/software/projects/GDCD/boards/34


## Interface Utilisateur

### Gestion des Conseillers
- Ajouter un conseiller (ID généré automatiquement)
- Supprimer un conseiller par ID
- Rechercher un conseiller par ID
- Afficher les clients d’un conseiller par ID

### Gestion des Clients
- Ajouter un client (ID généré automatiquement)
- Supprimer un client par ID
- Rechercher un client par nom et trier par ordre alphabétique (Streams API)
- Rechercher un client par ID (Optional)
- Afficher la liste des clients d’un conseiller (Streams API)

### Gestion des Contrats
- Ajouter un contrat (ID généré automatiquement, rattaché à un client)
- Afficher un contrat par ID (Optional)
- Supprimer un contrat par ID
- Afficher les contrats d’un client donné

### Gestion des Sinistres
- Ajouter un sinistre (ID généré automatiquement, rattaché à un contrat)
- Supprimer un sinistre par ID
- Calculer le coût total des sinistres d’un client (Streams API)
- Rechercher un sinistre par ID (Optional)
- Afficher les sinistres d’un contrat (Streams API)
- Afficher les sinistres triés par montant décroissant (Streams API)
- Afficher les sinistres d’un client (Streams API)
- Afficher les sinistres avant une date donnée (Streams API)
- Afficher les sinistres dont le coût est supérieur à un montant donné (Streams API)

## Structure de l’Application

### Modèle
- `Person` : nom, prénom, email
- `Conseiller` : extends Person
- `Client` : extends Person, rattaché à un conseiller
- `Contrat` : id, typeContrat (ENUM), dateDebut, dateFin, client
- `Sinistre` : id, typeSinistre (ENUM), date, montant, description, contrat

### Enum
- Types de contrats : automobile, maison, maladie
- Types de sinistre : accident voiture, accident maison, maladie

### View
- `ClientView` : menus et sous-menus des clients
- `ContratView` : menus et sous-menus des contrats
- `SinistreView` : menus et sous-menus des sinistres

### Service
- Contient la logique métier (CRUD, filtres, tri)
- `ConseillerService`, `ClientService`, `ContratService`, `SinistreService`

### DAO
- Communication avec la base de données (CRUD)
- `ClientDAO`, `ContratDAO`, `SinistreDAO`

## Spécifications Techniques
- Java 8
- JDBC pour la persistance
- Encapsulation : propriétés privées avec getters/setters
- API Streams pour traitement de collections
- Gestion des valeurs absentes avec Optional
- Java Time API pour les dates
- Lambda et Method References  


