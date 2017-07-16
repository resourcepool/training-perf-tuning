FROM mysql:latest

ENV MYSQL_ROOT_PASSWORD toor
ENV MYSQL_DATABASE nextreview

# Entrypoint overload to catch the ctrl+c and stop signals
ENTRYPOINT ["/bin/bash", "/run.sh"]
CMD ["mysqld"]
COPY run.sh /run.sh
