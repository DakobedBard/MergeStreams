#!/bin/bash

docker cp db/create.sql usersDB:/create.sql && docker exec usersDB psql -d usersdb -U database1_role -f create.sql