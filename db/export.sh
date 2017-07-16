#!/bin/bash
echo "Will export db of running container in local dump.sql file"
docker exec -i nextreview-db /usr/bin/mysqldump -u root --password=toor nextreview > dump.sql
echo "Done. Don't forget to move the dump to the right directory"

