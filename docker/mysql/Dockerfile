FROM mysql/mysql-server

EXPOSE 3306:3306

ADD eureka-sample.cnf /etc/

RUN cat /etc/my.cnf > /etc/eureka-sample.cnf

ENV MYSQL_ROOT_PASSWORD=bgjapo
ENV MYSQL_DATABASE=eureka-sample
ENV MYSQL_USER=eureka-sample
ENV MYSQL_PASSWORD=eureka-sample


ADD initial-script.sql /docker-entrypoint-initdb.d/
