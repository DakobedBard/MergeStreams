package org.mddarr.listener.orders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@EnableBinding(Sink.class)
public class Consumer {

    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @StreamListener(target = Sink.INPUT)
    public void consume(String message) {

        logger.info("recieved a string message : " + message);
    }
}
