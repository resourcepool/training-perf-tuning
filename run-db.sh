#!/bin/bash
rm -rf db/log
mkdir db/log
PWD=`pwd`
docker run -e MYSQL_ROOT_PASSWORD=toor -e MYSQL_DATABASE=nextreview -p 3306:3306 -v $PWD/db/log:/var/log mysql:5.7

