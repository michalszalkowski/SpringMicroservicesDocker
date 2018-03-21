#!/usr/bin/env bash
docker network create szalek-network
docker-compose build
docker-compose up