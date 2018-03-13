#!/usr/bin/env bash

# only for local debugging

SCRIPT_PATH=$(dirname $0)
LOGSTASH_VERSION=2.2.0

mkdir ${SCRIPT_PATH}/build
wget -q -O - https://download.elasticsearch.org/logstash/logstash/logstash-${LOGSTASH_VERSION}.tar.gz | tar -xzf - -C ${SCRIPT_PATH}/build
LOGSTASH_LOCAL=${SCRIPT_PATH}/build/logstash-${LOGSTASH_VERSION}

sh ${LOGSTASH_LOCAL}/
