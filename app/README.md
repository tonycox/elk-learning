#### if doesn't exist
```
docker network create garage-net
```
#### build the app
```
./gradlew build

docker build -t app app/src/main/docker

docker run -it --name app \
--hostname app \
--net garage-net \
-p 8080:8080 \
app
```
#### how to see logs
```
docker exec -it local-kafka \
/usr/local/kafka_2.11-1.0.0/bin/kafka-console-consumer.sh \
--bootstrap-server kafka:9092 \
--topic logs \
--from-beginning
```
