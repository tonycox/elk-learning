#!/usr/bin/env bash

# only for local debugging

SCRIPTPATH=$(dirname $0)
KAFKA_LOCAL=${SCRIPTPATH}/build/kafka_2.11-1.0.0

sh ${KAFKA_LOCAL}/bin/kafka-server-stop.sh
sh ${KAFKA_LOCAL}/bin/zookeeper-server-stop.sh &
