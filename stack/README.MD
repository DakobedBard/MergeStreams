.env
export.sh

curl -i -X POST -H "Accept:application/json" -H  "Content-Type:application/json" http://localhost:8083/connectors/ -d @connectors/cdc.json

curl -X DELETE localhost:8083/connectors/customers-connector

confluent-hub install debezium/debezium-connector-postgresql:0.9.4

  curl -X POST -H "Content-Type: application/json" --data '{"name": "local-debezium-source", "config": {"connector.class":"FileStreamSinkConnector", "tasks.max":"1", "file":"connectors/cdcc.json", "topics":"connect-test" }}' http://localhost:8083/connectors
# Or, to use a file containing the JSON-formatted configuration
# curl -X POST -H "Content-Type: application/json" --data @config.json http://localhost:8083/connectors



confluent local consume dbserver1.customerDB.customer -- --from-beginning

    "database.hostname": "postgres",
    "database.port": "5432",
    "database.user": "postgres",
    "database.password": "postgres",
    "database.dbname" : "customersDB",
    "database.server.name": "dbserver1",
    "schema.whitelist": "customer"