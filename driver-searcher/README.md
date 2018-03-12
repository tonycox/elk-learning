#### build dockerized flink
```
./gradlew build:driver-searcher

```
#### submit with parameters
```
--input-topic logs --output-topic mirror --bootstrap-server PLAINTEXT://doc-kafka:9092
```
