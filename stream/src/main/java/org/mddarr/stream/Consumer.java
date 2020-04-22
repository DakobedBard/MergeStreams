package org.mddarr.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.handler.annotation.SendTo;

@Slf4j
@EnableBinding(Consumer.MYSink.class)
public class Consumer {

	@StreamListener(target = MYSink.INPUT)
	@SendTo(MYSink.OUTPUT)
	public String consume(String message) {

		log.info("recieved a string message : " + message +" dumbass");
		return message + " dumbass";
	}

	public interface MYSink {
		String INPUT = "words";
		String OUTPUT = "output";

		@Input(INPUT)
		SubscribableChannel input();
		@Output(OUTPUT)
		MessageChannel output();
	}

}
