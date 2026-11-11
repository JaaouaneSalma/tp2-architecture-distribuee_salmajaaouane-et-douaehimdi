# TP2 : API REST distribuée avec Spring Boot

Deux microservices Spring Boot indépendants, conteneurisés avec Docker.

- **ServiceEtudiants** (port 8081) : CRUD des étudiants
- **ServiceCours** (port 8082) : CRUD des cours, avec `/cours/enrichis` qui appelle ServiceEtudiants

## Lancement

1. `mvnw clean package -DskipTests` dans chaque service
2. `docker compose up --build` à la racine

## Tests

Collection Postman : dossier `postman/` (importer le fichier .json).
Captures de résultats : dossier `captures/`.