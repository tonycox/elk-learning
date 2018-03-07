#!/usr/bin/env bash

SCRIPTPATH=$(dirname $0)

mkdir ${SCRIPTPATH}/build
wget -q -O - http://apache-mirror.rbc.ru/pub/apache/kafka/1.0.0/kafka_2.11-1.0.0.tgz | tar -xzf - -C ${SCRIPTPATH}/build

sh ${SCRIPTPATH}/build/kafka_2.11-1.0.0/bin/zookeeper-server-start.sh ${SCRIPTPATH}/build/kafka_2.11-1.0.0/config/zookeeper.properties &
sh ${SCRIPTPATH}/build/kafka_2.11-1.0.0/bin/kafka-server-start.sh ${SCRIPTPATH}/build/kafka_2.11-1.0.0/config/server.properties &
