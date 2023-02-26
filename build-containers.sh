#!/usr/bin/env bash

REPO=ilem0n

pushd modules/api
docker build -t $REPO/udaconnect-api:latest .
docker push $REPO/udaconnect-api:latest
popd

pushd modules/frontend
docker build -t $REPO/udaconnect-app:latest .
docker push $REPO/udaconnect-app:latest
popd

pushd modules/connections-service
./mvnw clean package
docker build -f src/main/docker/Dockerfile.jvm -t $REPO/udaconnect-connections-service:latest .
docker push $REPO/udaconnect-connections-service:latest
popd