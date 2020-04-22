# 
curl -i -X POST -H  http://localhost:8083/connectors/ -d @connectors/inventory.json

Delete a connector
curl -X DELETE localhost:8083/connectors/customers-connector/product

# Console consumer
confluent local consume dbserver.inventory.customer -- --value-format avro --from-beginning --property print.key=true

# List the topics 
kafka-topics --list --zookeeper localhost:2181




INSERT INTO customers (id, first_name,last_name, email) VALUES (1005,'Dan','Pass', 'dpass@gmail.com');