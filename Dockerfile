FROM openjdk:8-jdk-alpine
VOLUME /tmp
ENV TZ=Asia/Shanghai
# 将上一步的jar包copy到镜像中的根目录，并重命名为app.jar
COPY target/elastic-job-demo-0.0.1-SNAPSHOT.jar app.jar
COPY /src/main/resources conf
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","-Dspring.config.location=/conf/","/app.jar"]