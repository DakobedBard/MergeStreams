https://docs.spring.io/spring-cloud-stream/docs/Brooklyn.RELEASE/reference/html/_introducing_spring_cloud_stream.html

Spring Cloud Stream includes a binder implementation designed explicitly for Apache Kafka Streams binding. With this native integration, a Spring Cloud Stream "processor" application can directly use the Apache Kafka Streams APIs in the core business logic.

Kafka Streams binder implementation builds on the foundations provided by the Spring for Apache Kafka project.

Kafka Streams binder provides binding capabilities for the three major types in Kafka Streams - KStream, KTable and GlobalKTable.

Kafka Streams applications typically follow a model in which the records are read from an inbound topic, apply business logic, and then write the transformed records to an outbound topic. Alternatively, a Processor application with no outbound destination can be defined as well.

In the following sections, we are going to look at the details of Spring Cloud Stream’s integration with Kafka Streams.


@EnableBinding takes one or more interfaces as parameters.  An interface declares input and or output channels
@Input through which messages enter the application
@Output annotation identifies an output channel, through which published messages leave the application


Spring Cloud Stream provides a number of abstractions and primitives that simply the writing of message driven microservee applications
    - Binder abstraction
    - Spring cloud streams application model
    - persistent publish-subscribe support
    - consumer group support
    - partitioning support 
    - a pluggable binder API
    
A Spring Cloud Stream application consists of a middleware-neutral core. The application communicates with the outside world through input and output channels injected into it by Spring Cloud Stream. Channels are connected to external brokers through middleware-specific Binder implementations.