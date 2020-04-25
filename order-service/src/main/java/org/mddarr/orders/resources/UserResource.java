package org.mddarr.orders.resources;

import org.mddarr.orders.event.dto.Event1;
import org.mddarr.orders.event.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.Response;


@RestController
@RequestMapping(value = "/user")
public class UserResource {

    private final AvroProducer producer;

    @Autowired
    UserResource(AvroProducer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public String sendMessageToKafkaTopic(@RequestParam("name") String name, @RequestParam("value") String value) {
        this.producer.sendEvent1(new Event1(name, value));
        return "hey";
//        this.producer.sendEvent1();
    }


    @PostMapping("/orders/")
    public String product(@RequestParam(value="products") List<Long> products, @RequestParam(value="quantities") List<Long> quantities,
                          @RequestParam(value="cid")  Long cid, @RequestParam(value="price") Long price)
    {

        UUID uuid =  UUID.randomUUID();
        Order order = new Order(uuid.toString(),1L,products,quantities);
        this.producer.sendOrder(order);
        return "order";
    }

}