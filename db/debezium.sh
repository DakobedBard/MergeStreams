#!/bin/bash
# Pull docker image
docker pull debezium/example-postgres

# Run docker container
docker run -it --rm --name postgres -p 5432:5432 \
-e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres \
debezium/example-postgres

## In a separate terminal, launch psql to run SQL queries:
docker run -it --rm --name psql_client \
-e PGOPTIONS="--search_path=inventory" \
-e PGPASSWORD=postgres --link postgres:postgres debezium/example-postgres \
psql -h postgres -U postgres

