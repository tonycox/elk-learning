#### if network doesn't exist
```
docker network create garage-net
```
#### build the app
```
./gradlew build:user-api

docker build -t user-app user-api/src/main/docker
```
### run app
```
docker run -it --name user-app \
--hostname user-app \
--net garage-net \
-p 8080:8080 \
user-app
```
#### how to see application's logs
```
docker exec -it doc-kafka \
/usr/local/kafka_2.11-1.0.0/bin/kafka-console-consumer.sh \
--bootstrap-server kafka:9092 \
--topic logs \
--from-beginning
```
#### local app
if you want to debug application locally -> 
start scripts from kafka module before.
[see README.md](https://github.com/tonycox/garage/blob/master/kafka/README.md)

and start script from flink-setup module.
[see README.md](https://github.com/tonycox/garage/blob/master/flink-setup/README.md)
