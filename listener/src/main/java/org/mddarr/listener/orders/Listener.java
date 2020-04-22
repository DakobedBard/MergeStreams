package org.mddarr.listener.orders;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.stereotype.Service;


@Service
@EnableBinding(Processor.class)
public class Listener {

    private static final Logger logger = LoggerFactory.getLogger(Listener.class);

}
