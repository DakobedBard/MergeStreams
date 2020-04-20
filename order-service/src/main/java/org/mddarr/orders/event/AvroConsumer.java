package org.mddarr.orders.event;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.mddarr.orders.Constants;
import org.mddarr.orders.event.dto.Event1;
import org.mddarr.orders.event.dto.Event3;
import org.mddarr.orders.event.dto.Event4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AvroConsumer {

    private static final Logger logger = LoggerFactory.getLogger(AvroConsumer.class);

    @KafkaListener(topics = Constants.EVENT_1_TOPIC, groupId = "group_id")
    public void consume(ConsumerRecord<String, Event1> record) {
        logger.info(String.format("Consumed message -> %s", record.value()));
    }
}
