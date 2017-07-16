cat import_0_schema.sql | docker exec -i nextreview-db /usr/bin/mysql -u root --password=toor nextreview
cat import_1_entries.sql | docker exec -i nextreview-db /usr/bin/mysql -u root --password=toor nextreview
