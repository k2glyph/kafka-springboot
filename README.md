# kafka-springboot
Demo project for integrating Apache Kafka with Spring Boot

__Kafka commands:__  
Starting zookeeper: ./bin/zookeeper-server-start.sh config/zookeeper.properties  
Starting kafka cluster: ./bin/kafka-server-start.sh config/server.properties  
Creating kafka topic: ./kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic topic1  
Describe kafka topic: ./kafka-topics.sh --describe --zookeeper localhost:2181 --topic topic1  
Starting kafka producer: ./kafka-console-producer.sh --broker-list localhost:9092 --topic topic1  
Starting kafka consumer: ./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic topic1 --from-beginning  

__API:__  
http://localhost:8080/kafka/topic1/helloWorld
