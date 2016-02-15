FROM mysql:latest
ENV MYSQL_ALLOW_EMPTY_PASSWORD true
ADD ./database.schema /docker-entrypoint-initdb.d/db.sql
