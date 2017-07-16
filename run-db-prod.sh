#!/bin/bash
rm -rf db/log
mkdir db/log
PWD=`pwd`
cd db
./build.sh
cd ..
docker run -p 3306:3306 -v $PWD/db/log:/var/log -v $PWD/db/dump-prod:/docker-entrypoint-initdb.d --name nextreview-db resourcepool/nextreview-db:prod
