#!/bin/bash
 docker exec -it db psql 'dbname=postgres user=postgres options=--search_path=inventory'
