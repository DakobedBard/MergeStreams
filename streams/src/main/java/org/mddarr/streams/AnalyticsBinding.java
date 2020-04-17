package org.mddarr.streams;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface AnalyticsBinding {
    String PAGE_VIEWS_OUT = "pvout";
    String PAGE_VIEWS_IN = "pvin";

    // page views
    @Input(PAGE_VIEWS_IN)
    KStream<String,PageViewEvent> pageViewsIn();

    @Output(PAGE_VIEWS_OUT)
    MessageChannel pageViewsOut();
}
