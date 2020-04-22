kafka-avro-console-producer 
         --broker-list localhost:9092 --topic input \
         --property value.schema='{"type":"int"}'
         
kafka-topics --create --topic streams-wordcount-output \
                     --zookeeper localhost:2181 --partitions 1 --replication-factor 1
                     
kafka-topics --create --topic streams-plaintext-input \
                     --zookeeper localhost:2181 --partitions 1 --replication-factor 1          
                               --property print.key=true \
                              --property value.deserializer=org.apache.kafka.common.serialization.LongDeserializer
                              
                              
                              
                               kafka-console-consumer --topic streams-wordcount-output --from-beginning \
                                                             --bootstrap-server localhost:9092 \
                                                             --property print.key=true \
                                                             --property value.deserializer=org.apache.kafka.common.serialization.LongDeserializer
                              
                              
confluent local consume $1 -- --from-beginning --property print.key=true --property value.deserializer=org.apache.kafka.common.serialization.LongDeserializer