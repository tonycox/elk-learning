#!/usr/bin/env bash

# only for local debugging

SCRIPT_PATH=$(dirname $0)
KIBANA_VERSION=6.0.0
if [ "$1" = "mac" ]; then
  KIBANA_LOCAL=${SCRIPT_PATH}/build/kibana-${KIBANA_VERSION}-darwin-x86_64
else
  KIBANA_LOCAL=${SCRIPT_PATH}/build/kibana-${KIBANA_VERSION}-linux-x86_64
fi

if [ ! -d "${SCRIPT_PATH}/build" ]; then
  mkdir ${SCRIPT_PATH}/build
fi

if [ ! -d "${KIBANA_LOCAL}" ]; then
  echo [INFO] loading kibana-${KIBANA_VERSION}
  if [ "$1" = "mac" ]; then
    wget -q -O - https://artifacts.elastic.co/downloads/kibana/kibana-${KIBANA_VERSION}-darwin-x86_64.tar.gz | \
      tar -xzf - -C ${SCRIPT_PATH}/build
  else
    wget -q -O - https://artifacts.elastic.co/downloads/kibana/kibana-${KIBANA_VERSION}-linux-x86_64.tar.gz | \
      tar -xzf - -C ${SCRIPT_PATH}/build
  fi
fi

echo [INFO] starting kibana
sh ${KIBANA_LOCAL}/bin/kibana
