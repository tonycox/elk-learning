#### if doesn't exist
```
docker network create garage-net
```
#### build local kafka
```
docker build -t local-kafka kafka/src/main/docker

docker run -it --name local-kafka \
--hostname kafka \
--net garage-net \
-p 9092:9092 -p 2181:2181 \
local-kafka
```


