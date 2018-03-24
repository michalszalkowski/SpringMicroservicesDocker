#!/usr/bin/env bash
docker network create szalek-network
docker network create szalek-network-storage
docker-compose build
docker-compose up