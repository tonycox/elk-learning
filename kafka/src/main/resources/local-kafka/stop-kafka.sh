#!/usr/bin/env bash

# only for local debugging

SCRIPTPATH=$(dirname $0)

sh ${SCRIPTPATH}/build/kafka_2.11-1.0.0/bin/kafka-server-stop.sh
sh ${SCRIPTPATH}/build/kafka_2.11-1.0.0/bin/zookeeper-server-stop.sh &
