FROM openjdk:8u151-jdk
MAINTAINER Anton Solovev "tonycoxbk@gmail.com"
RUN wget -q -O - http://apache-mirror.rbc.ru/pub/apache/kafka/1.0.0/kafka_2.11-1.0.0.tgz | tar -xzf - -C /usr/local
WORKDIR /usr/local/kafka_2.11-1.0.0
VOLUME /usr/local/kafka-config
ADD ./config/server.properties /usr/local/kafka-config/server.properties
ADD ./config/zookeeper.properties /usr/local/kafka-config/zookeeper.properties
ADD run-kafka.sh /usr/local/kafka_2.11-1.0.0/run-kafka.sh
ENTRYPOINT ["sh", "run-kafka.sh"]
EXPOSE 9092 2181
