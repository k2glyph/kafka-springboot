# kafka-springboot
Demo project for integrating Apache Kafka with Spring Boot  

Implementation of sending Email using Kafka Cluster in Spring Boot  

__Application Setup__  
Install the Kafka in your local machine from : [download: apache kafka](https://www.apache.org/dyn/closer.cgi?path=/kafka/2.0.0/kafka_2.11-2.0.0.tgz)  

Unzip the file and from root of the directory,  
start Zookeeper, Kafka Cluster  


__Kafka commands:__  
```` 
Starting zookeeper: ./bin/zookeeper-server-start.sh config/zookeeper.properties  
Starting kafka cluster: ./bin/kafka-server-start.sh config/server.properties  
Creating kafka topic: ./bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic emailTopic  
Describe kafka topic: ./bin/kafka-topics.sh --describe --zookeeper localhost:2181 --topic topic1  
Starting kafka producer: ./bin/kafka-console-producer.sh --broker-list localhost:9092 --topic topic1  
Starting kafka consumer: ./bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic topic1 --from-beginning  
````
and then Run the application

__API Request:__  
````
http://localhost:8080/sendEmail
{
    "toEmail": "pra4mesh@gmail.com",
    "from": "pra4mesh@gmail.com",
    "subject": "Test Message from Kafka cluster",
    "message": "This message is sent from Kafka cluster"
}
````
