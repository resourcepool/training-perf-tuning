#!/bin/bash
rm -rf db/log
mkdir db/log
PWD=`pwd`
cd db
./build.sh
cd ..
docker run -p 3306:3306 -v $PWD/db/log:/var/log -v $PWD/db/dump-dev:/docker-entrypoint-initdb.d resourcepool/nextreview-db
