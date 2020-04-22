package org.mddarr.stream;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

@EnableBinding(Producer.MySourceBinding.class)
public class Producer {
	private MySourceBinding mySource;
	public Producer(MySourceBinding mySource) {
		super();
		this.mySource = mySource;
	}
	public MySourceBinding getMysource() {
		return mySource;
	}

	public interface MySourceBinding {
		String OUTPUT = "counts";
		@Output(OUTPUT)
		MessageChannel output();
	}




}
