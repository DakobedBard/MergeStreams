CREATE TABLE customers(
	user_id INTEGER PRIMARY KEY,
	store_id INTEGER NOT NULL,
	first_name VARCHAR(30) NOT NULL,
	last_name VARCHAR(30) NOT NULL,
	email VARCHAR(40) NOT NULL,
	address_id INTEGER NOT NULL
	active BOOLEAN NOT NULL, 
	
	created_on DATE NOT NULL,
	last_update TIMESTAMP NOT NULL,
	isactive BOOLEAN NOT NULL
);

CREATE TABLE address(
	address_id INTEGER PRIMARY KEY,
	address VARCHAR(150) NOT NULL,
	address2 VARCHAR 


); 

