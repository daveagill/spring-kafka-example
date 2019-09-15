# Spring-Kafka Producer and Consumer Example

This is a minimal example of a Spring-Kafka producer and consumer micro-service applications.

This project is comprised of two spring-boot apps, one for the producer and one for the consumer.

Be sure to create a Kafka topic first:

```
bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic mytopic
```

The name of the topic, group-id and bootstrap-server can be configured in the `application.properties` files for the producer and consumer.

The producer will send simple messages given via the browser URL request param, e.g.

```
http://localhost:8080/send?msg=hello-world
```

And the consumer will simply log anything that it receives:

```
2019-09-16 00:15:48.775  INFO 74969 --- [ntainer#0-0-C-1] acme.app.Consumer                        : Message received: hello-world
```