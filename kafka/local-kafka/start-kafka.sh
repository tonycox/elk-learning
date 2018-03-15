#!/usr/bin/env bash

# only for local debugging

SCRIPT_PATH=$(dirname $0)
KAFKA_VERSION=1.0.0
METRICBEAT_VERSION=6.0.0
KAFKA_LOCAL=${SCRIPT_PATH}/build/kafka_2.11-${KAFKA_VERSION}
if [ "$1" = "mac" ]; then
  METRICBEAT_LOCAL=${SCRIPT_PATH}/build/metricbeat-${METRICBEAT_VERSION}-darwin-x86_64
else
  METRICBEAT_LOCAL=${SCRIPT_PATH}/build/metricbeat-${METRICBEAT_VERSION}-linux-x86_64
fi

if [ ! -d "${SCRIPT_PATH}/build" ]; then
  mkdir ${SCRIPT_PATH}/build
fi

if [ ! -d "${KAFKA_LOCAL}" ]; then
  echo [INFO] loading kafka-${KAFKA_VERSION}
  wget -q -O - http://apache-mirror.rbc.ru/pub/apache/kafka/${KAFKA_VERSION}/kafka_2.11-${KAFKA_VERSION}.tgz | \
    tar -xzf - -C ${SCRIPT_PATH}/build
fi
if [ ! -d "${METRICBEAT_LOCAL}" ]; then
  echo [INFO] loading metricbeat-${METRICBEAT_VERSION}
  if [ "$1" = "mac" ]; then
    wget -q -O - https://artifacts.elastic.co/downloads/beats/metricbeat/metricbeat-${METRICBEAT_VERSION}-darwin-x86_64.tar.gz | \
      tar -xzf - -C ${SCRIPT_PATH}/build
  else
    wget -q -O - https://artifacts.elastic.co/downloads/beats/metricbeat/metricbeat-${METRICBEAT_VERSION}-linux-x86_64.tar.gz | \
      tar -xzf - -C ${SCRIPT_PATH}/build
  fi
fi

echo [INFO] starting kafka
sh ${KAFKA_LOCAL}/bin/zookeeper-server-start.sh ${KAFKA_LOCAL}/config/zookeeper.properties &
sh ${KAFKA_LOCAL}/bin/kafka-server-start.sh ${KAFKA_LOCAL}/config/server.properties &

sleep 5 #sec
echo [INFO] starting metricbeat

#sudo chown `whoami` ${SCRIPT_PATH}/metricbeat.yml
#sudo chown `whoami` ${METRICBEAT_LOCAL}/modules.d/system.yml

if [ "$1" = "mac" ]; then
  ${METRICBEAT_LOCAL}/metricbeat -e -v -c ${SCRIPT_PATH}/metricbeat.yml -d "publish"
else
  ${METRICBEAT_LOCAL}/metricbeat -e -v -c ${SCRIPT_PATH}/metricbeat.yml -d "publish"
fi
