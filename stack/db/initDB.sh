#!/bin/bash
docker cp db/customers.csv db:/customers.csv
docker cp db/address.csv db:/address.csv
docker cp db/populate.sql db:/populate.sql
docker exec db psql -d customersDB -U postgres -f populate.sql