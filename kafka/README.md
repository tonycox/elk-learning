#### if network doesn't exist
```
docker network create garage-net
```
#### build dockerized kafka
```
docker build -t doc-kafka kafka/src/main/docker

docker run -it --name doc-kafka \
--hostname kafka \
--net garage-net \
-p 9092:9092 -p 2181:2181 \
doc-kafka
```
#### start/stop local kafka
```
sh ./kafka/src/main/resources/local-kafka/start-kafka.sh

sh ./kafka/src/main/resources/local-kafka/stop-kafka.sh
```
