#!/usr/bin/env bash

# only for local debugging

SCRIPT_PATH=$(dirname $0)
ELASTIC_VERSION=6.0.0
ELASTIC_LOCAL=${SCRIPT_PATH}/build/elasticsearch-${ELASTIC_VERSION}

if [ ! -d "${SCRIPT_PATH}/build" ]; then
  mkdir ${SCRIPT_PATH}/build
fi
if [ ! -d "${ELASTIC_LOCAL}" ]; then
  echo [INFO] loading elasticsearch-${ELASTIC_VERSION}
  wget -q -O - https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-${ELASTIC_VERSION}.tar.gz | \
    tar -xzf - -C ${SCRIPT_PATH}/build
fi
echo [INFO] starting elasticsearch
sh ${ELASTIC_LOCAL}/bin/elasticsearch
