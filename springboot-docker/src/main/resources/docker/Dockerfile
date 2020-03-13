FROM java:8u111
# 创建/tmp目录并挂载到Docker数据文件夹，应为Springboot使用内嵌tomcat容器，默认视同/tmp作为工作目录
VOLUME /tmp

ADD *.jar app.jar

EXPOSE 80 8080

ENTRYPOINT ["java","-jar","/app.jar"]

# Ubuntu 时区
# RUN cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime