package org.mddarr.streams;

import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.TimeWindows;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
@CommonsLog
@EnableBinding(AnalyticsBinding.class)
public class StreamsApplication {

	@Component
	public static class EventSource implements ApplicationRunner{
		private final Log log = LogFactory.getLog(getClass());
		@Override
		public void run(ApplicationArguments args) throws Exception {

		}
	}

	@StreamListener("input")
	@SendTo("output")
	public KStream<?, WordCount> process(KStream<?, String> input) {
		return input
				.flatMapValues(value -> Arrays.asList(value.toLowerCase().split("\\W+")))
				.groupBy((key, value) -> value)
				.windowedBy(TimeWindows.of(1000))
				.count(Materialized.as("WordCounts-multi"))
				.toStream()
				.map((key, value) -> new KeyValue<>(null, new WordCount(key.key(), value, new Date(key.window().start()), new Date(key.window().end()))));
	}
	public static void main(String[] args) {
		SpringApplication.run(StreamsApplication.class, args);
	}

}


class WordCount{

	String word;
	Long count;

	Date start;
	Date end;
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {return end;}
	public void setEnd(Date end) {this.end = end;}
	public String getWord() {return word;}
	public void setWord(String word) {this.word = word;}

	public WordCount(String word, Long count, Date start, Date end) {
		this.word = word;
		this.count = count;
		this.start = start;
		this.end = end;
	}

}