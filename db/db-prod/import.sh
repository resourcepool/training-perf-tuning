cat import_0_schema.sql | docker exec -i nextreview-db /usr/bin/mysql -u root --password=toor nextreview
cat import_1_person.sql | docker exec -i nextreview-db /usr/bin/mysql -u root --password=toor nextreview
cat import_2_team.sql | docker exec -i nextreview-db /usr/bin/mysql -u root --password=toor nextreview
cat import_3_person_team.sql | docker exec -i nextreview-db /usr/bin/mysql -u root --password=toor nextreview
cat import_4_review.sql | docker exec -i nextreview-db /usr/bin/mysql -u root --password=toor nextreview
