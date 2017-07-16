#!/bin/bash
PWD=`pwd`
docker ps -a | grep nextreview-db | awk '{print $1;}' | xargs docker rm
docker images | grep nextreview-db | awk '{print $1;}' | xargs docker rmi -f
docker build -t resourcepool/nextreview-db .
