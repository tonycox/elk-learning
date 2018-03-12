#### if network doesn't exist
```
docker network create garage-net
```
#### build dockerized flink
```
docker build -t doc-flink flink-setup/src/main/docker
```
#### start dockerized flink
```
docker run -it --name doc-flink \
--hostname flink \
--net garage-net \
-p 8081:8081 \
-p 6123:6123 \
doc-flink local
```
#### start dockerized official flink:1.4.1-alpine
```
docker run -it --name doc-flink \
--hostname flink \
--net garage-net \
-p 8081:8081 \
-p 6123:6123 \
flink:1.4.1-alpine local
```
