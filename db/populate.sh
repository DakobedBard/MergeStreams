#!/bin/bash

docker cp db/customers.csv usersDB:/customers.csv
docker cp db/address.csv usersDB:/address.csv
docker cp db/populate_from_csv.sql usersDB:/populate_from_csv.sql
docker exec usersDB psql -d usersdb -U database1_role -f populate_from_csv.sql
