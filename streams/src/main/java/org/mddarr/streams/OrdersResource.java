package org.mddarr.streams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class OrdersResource {

    @GetMapping(value = "/publish")
    public String sendMessageToKafkaTopic() {
        return "hey";
    }
}