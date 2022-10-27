#基础镜像
FROM openjdk:11
#镜像作者
MAINTAINER yangshuai
#将项目 springboot-docker.jar 加入并且重命名
ADD springboot-docker.jar app.jar
EXPOSE 8888
#启动工程
ENTRYPOINT ["java","-jar","/app.jar"]