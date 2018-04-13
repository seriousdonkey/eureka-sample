docker build --tag=mysql/eureka-sample .
docker rm eureka-sample-mysql
docker run -p 3306:3306 --name eureka-sample-mysql mysql/eureka-sample

