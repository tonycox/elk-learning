#!/usr/bin/env bash

# only for local debugging

SCRIPT_PATH=$(dirname $0)
LOGSTASH_VERSION=6.0.0
LOGSTASH_LOCAL=${SCRIPT_PATH}/build/logstash-${LOGSTASH_VERSION}

if [ ! -d "${SCRIPT_PATH}/build" ]; then
  mkdir ${SCRIPT_PATH}/build
fi
if [ ! -d "${LOGSTASH_LOCAL}" ]; then
  echo [INFO] loading logstash-${LOGSTASH_VERSION}
  wget -q -O - https://artifacts.elastic.co/downloads/logstash/logstash-${LOGSTASH_VERSION}.tar.gz | \
    tar -xzf - -C ${SCRIPT_PATH}/build
fi

sh ${LOGSTASH_LOCAL}/bin/logstash.lib.sh
echo [INFO] starting logstash
sh ${LOGSTASH_LOCAL}/bin/logstash -f ${SCRIPT_PATH}/logstash.conf
