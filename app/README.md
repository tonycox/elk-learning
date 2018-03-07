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
