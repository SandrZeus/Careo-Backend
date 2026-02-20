# Careo Backend

Backend service for the Careo medical records management application.

## Tech Stack
- Kotlin + Spring Boot 3
- PostgreSQL + Flyway
- Redis
- Kafka
- AWS S3 / MinIO
- Spring AI
- Firebase Auth

## Architecture
Modular Monolith with Clean Architecture. Each module (user, records, subscription, ai, sync) is self-contained with its own domain, application, infrastructure, and API layers.

## Modules
- **app** — entry point, wires all modules
- **shared/domain** — common value objects and base classes
- **shared/infrastructure** — shared infrastructure configuration
- **shared/api** — shared response wrappers and exception handling
- **modules/user** — authentication and user profiles
- **modules/records** — medical record storage and file management
- **modules/subscription** — subscription plans and feature gating
- **modules/ai** — PDF analysis and profile autofill
- **modules/sync** — offline sync and conflict resolution

## Running Locally
> Docker and docker-compose instructions coming soon