package org.mddarr.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.SubscribableChannel;

@Slf4j
@EnableBinding(Consumer.MYSink.class)
public class Consumer {

	@StreamListener(target = MYSink.INPUT)
	public void consume(String message) {

		log.info("recieved a string message : " + message);
	}

	public interface MYSink {
		String INPUT = "words";

		@Input(INPUT)
		SubscribableChannel input();
	}

}
