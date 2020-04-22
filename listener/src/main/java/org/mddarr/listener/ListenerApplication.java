package org.mddarr.listener;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.streams.kstream.KStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.binder.kafka.streams.annotations.KafkaStreamsProcessor;
import org.springframework.cloud.stream.messaging.Processor;

import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.SendTo;


import java.util.Date;

@SpringBootApplication
@EnableBinding(ListenerApplication.Binding.class)
public class ListenerApplication {
	private final Log log = LogFactory.getLog(getClass());
	@StreamListener(Source.OUTPUT)
	public String process(String s) {
		log.info("I see a message " + s);
		return s.toUpperCase();
	}
	public static void main(String[] args) {
		SpringApplication.run(ListenerApplication.class, args);
	}
	public interface Binding {
		String WORDS = "words";
		@Output("words")
		MessageChannel words();
	}

	public interface Source {
		String OUTPUT = "output";

		@Output("output")
		MessageChannel output();
	}
//	static interface MYBinding{
//		String WORDS = "words";
//		// page views
//		@Input(WORDS)
//		MessageChannel words();
//	}

	static class WordCount {

		private String word;
		private long count;
		private Date start;
		private Date end;
		@Override
		public String toString() {
			final StringBuffer sb = new StringBuffer("WordCount{");
			sb.append("word='").append(word).append('\'');
			sb.append(", count=").append(count);
			sb.append(", start=").append(start);
			sb.append(", end=").append(end);
			sb.append('}');
			return sb.toString();
		}
		WordCount() {}
		WordCount(String word, long count) {
			this.word = word;
			this.count = count; }

		public String getWord() {
			return word;
		}
		public void setWord(String word) {
			this.word = word;
		}
		public long getCount() {
			return count;
		}
		public void setCount(long count) {
			this.count = count;
		}
		public Date getStart() {
			return start;
		}
		public void setStart(Date start) {
			this.start = start;
		}
		public Date getEnd() {
			return end;
		}
		public void setEnd(Date end) {
			this.end = end;
		}
	}
}



