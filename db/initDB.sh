#!/bin/bash
docker cp db/customers.csv usersDB:/customers.csv
docker cp db/address.csv usersDB:/address.csv
docker cp db/populate.sql.sql usersDB:/populate.sql
docker exec usersDB psql -d usersdb -U database1_role -f populate.sql