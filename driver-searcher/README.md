#### build dockerized flink
```
./gradlew build:driver-searcher

```
#### submit job to dockerized flink with parameters
```
--input-topic logs --output-topic mirror --bootstrap-server PLAINTEXT://doc-kafka:9092
```
#### watch result 
```
docker exec -it doc-kafka \
/usr/local/kafka_2.11-1.0.0/bin/kafka-console-consumer.sh \
--bootstrap-server kafka:9092 \
--topic mirror \
--from-beginning
```
