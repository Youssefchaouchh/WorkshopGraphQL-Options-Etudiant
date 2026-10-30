WorkshopGraphQL - Gestion Options & Etudiants
Année Universitaire: 2026-2027 - Architecture Orientée Services (AOS)
Étudiant: Youssef Chaouch

Objectif
Mise en place d'une API GraphQL en Java (graphql-java-tools) pour la gestion des options pédagogiques et des étudiants. Remplacement de REST par GraphQL pour permettre au client de choisir les champs retournés.

Structure du projet
WorkshopGraphQL-Options/
├── src/main/java/
│   ├── entities/
│   │   ├── Option.java
│   │   └── Etudiant.java
│   ├── repository/
│   │   ├── OptionBusiness.java
│   │   └── EtudiantBusiness.java
│   └── graphql/
│       ├── Query.java
│       ├── Mutations.java
│       └── GraphQLEndPoint.java
├── src/main/resources/
│   └── schema.graphql
├── pom.xml
└── README.md
Dépendances (pom.xml)
graphql-java 3.0.0
graphql-java-tools 3.2.0
graphql-java-servlet 4.0.0
javax.servlet-api 3.0.1 (provided)
Fonctionnalités Implémentées
A. Options (6)
getAllOptions: [Option!]!
getOptionByCode(codeOption: Int!): Option
getOptionsByDomaine(domaine: String!): [Option!]!
addOption(...): Boolean
updateOption(...): Boolean
deleteOption(codeOption: Int!): Boolean
B. Etudiants (5)
getAllEtudiants: [Etudiant!]!
getEtudiantByIdentifiant(identifiant: String!): Etudiant
getEtudiantsByOption(codeOption: Int!): [Etudiant!]!
addEtudiant(...): Boolean
updateEtudiant(...): Boolean
deleteEtudiant(identifiant: String!): Boolean
Test avec Postman
URL unique: POST http://localhost:8080/WorkshopGraphQL_war/graphql

Exemple Multi-Query (Question 3 TP)
query MultiTest {
  allOpts: getAllOptions { codeOption libelle }
  infoOpts: getOptionsByDomaine(domaine: "Informatique") { codeOption libelle capacite }
  allEtuds: getAllEtudiants { identifiant nom option { libelle } }
}
Observation: Une seule requête HTTP retourne 3 jeux de données différents, contrairement à REST qui nécessiterait 3 appels. Pas de sur-fetching.

Prérequis
JDK 8
Tomcat 8.5 / 9
IntelliJ IDEA + Plugin GraphQL JetBrains
Lancement
mvn clean package
Déployer target/WorkshopGraphQL.war sur Tomcat
Tester via Postman: http://localhost:8080/WorkshopGraphQL_war/graphql
Collection Postman
Voir fichier WorkshopGraphQL_FINAL_Tests.postman_collection.json inclus.

Auteur
Youssef Chaouch - ESPRIT
