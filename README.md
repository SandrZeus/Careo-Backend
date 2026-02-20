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

## Prerequisites
- JDK 21
- Docker + Docker Compose

## Running Locally

### 1. Clone the repository
```bash
git clone https://github.com/SandrZeus/Careo-Backend.git
cd CareoBackend
```

### 2. Create your `.env` file
Create a `.env` file in the project root with the following variables:
```env
POSTGRES_DB=database
POSTGRES_USER=user
POSTGRES_PASSWORD=password

MINIO_ROOT_USER=user
MINIO_ROOT_PASSWORD=password
MINIO_BUCKET_NAME=bucket-name
```

### 3. Start infrastructure
```bash
docker-compose up -d
```

This starts the following services:
- PostgreSQL on port `5433`
- Redis on port `6379`
- Kafka on port `9092`
- MinIO on ports `9000` (API) and `9001` (web console)

### 4. Run the app
```bash
./run.sh
```

The app will start on `http://localhost:8080`. Flyway will automatically apply
database migrations on startup.

## Useful URLs
- API: `http://localhost:8080`
- Actuator: `http://localhost:8080/actuator`
- MinIO Console: `http://localhost:9001`

## Stopping
```bash
# Stop the app: Ctrl+C

# Stop infrastructure (preserves data)
docker-compose down

# Stop infrastructure and wipe all data
docker-compose down -v
```