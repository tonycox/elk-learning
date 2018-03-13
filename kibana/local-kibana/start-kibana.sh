#!/usr/bin/env bash

# only for local debugging

SCRIPT_PATH=$(dirname $0)
KIBANA_VERSION=4.4.2

mkdir ${SCRIPT_PATH}/build
wget -q -O - https://download.elastic.co/kibana/kibana/kibana-${KIBANA_VERSION}-linux-x64.tar.gz | tar -xzf - -C ${SCRIPT_PATH}/build
KIBANA_LOCAL=${SCRIPT_PATH}/build/kibana-${KIBANA_VERSION}-linux-x64

sh ${KIBANA_LOCAL}/
