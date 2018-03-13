#!/usr/bin/env bash

# only for local debugging

SCRIPT_PATH=$(dirname $0)
KAFKA_VERSION=1.0.0

mkdir ${SCRIPT_PATH}/build
wget -q -O - http://apache-mirror.rbc.ru/pub/apache/kafka/${KAFKA_VERSION}/kafka_2.11-${KAFKA_VERSION}.tgz | tar -xzf - -C ${SCRIPT_PATH}/build
KAFKA_LOCAL=${SCRIPT_PATH}/build/kafka_2.11-${KAFKA_VERSION}

sh ${KAFKA_LOCAL}/bin/zookeeper-server-start.sh ${KAFKA_LOCAL}/config/zookeeper.properties &
sh ${KAFKA_LOCAL}/bin/kafka-server-start.sh ${KAFKA_LOCAL}/config/server.properties &
