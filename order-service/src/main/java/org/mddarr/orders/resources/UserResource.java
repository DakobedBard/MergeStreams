package org.mddarr.orders.resources;

import org.mddarr.orders.event.AvroProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/user")
public class UserResource {

    private final AvroProducer producer;

    @Autowired
    UserResource(AvroProducer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public String sendMessageToKafkaTopic(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        this.producer.sendEvent1();
        return "hey";
//        this.producer.sendEvent1();
    }
}