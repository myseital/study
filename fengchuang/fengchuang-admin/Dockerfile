FROM openjdk:8
MAINTAINER myseital24@gmail.com
#FROM java8-with-skywalking-agent:1.0.0
VOLUME /tmp
VOLUME /logs
ARG JAR_FILE=target/fengchuang-admin.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
#ENTRYPOINT [ "java", "-Duser.timezone=Asia/Shanghai", "-Xmx2g", "-Xms2g", "-jar", "/app.jar" ]
ENTRYPOINT [ "java", "-jar", "/app.jar" ]