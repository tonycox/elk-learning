#! /bin/bash -e

if [ -z "$ADVERTISED_HOST_NAME" ] ; then
  echo [INFO] ADVERTISED_HOST_NAME is blank or not set. Finding IP address
  export ADVERTISED_HOST_NAME=$(ip addr | grep 'BROADCAST' -A2 | tail -n1 | awk '{print $2}' | cut -f1  -d'/')
fi

echo HOSTNAME=`hostname`
echo ADVERTISED_HOST_NAME=${ADVERTISED_HOST_NAME}

sed -i "s/ADVERTISED_HOST_NAME/${ADVERTISED_HOST_NAME?}/" /usr/local/kafka-config/server.properties

export ZOO_PORT=2181

if [ -z "$ZOOKEEPER_SERVERS" ] ; then
  export ZOOKEEPER_SERVERS=`hostname`":${ZOO_PORT}"
fi

echo ZOOKEEPER_SERVERS=${ZOOKEEPER_SERVERS}

sed -i "s/ZOOKEEPER_SERVERS/${ZOOKEEPER_SERVERS?}/" /usr/local/kafka-config/server.properties

if [ ! -z "$ZOOKEEPER_SERVERS" ] ; then
  bin/zookeeper-server-start.sh /usr/local/kafka-config/zookeeper.properties &
  sleep 10
fi

bin/kafka-server-start.sh /usr/local/kafka-config/server.properties &

while sleep 60; do
  ps aux
done
