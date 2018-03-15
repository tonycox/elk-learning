#!/usr/bin/env bash

if [ "$1" = "docker" ]; then
    docker-compose up
else
    echo 'yet nothing'
fi
