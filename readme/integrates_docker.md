1、打开docker的设置界面，找到General,在里面找到
*Expose daemon on tcp://localhost:2375 without TLS*选项，打上勾，
即可进行本地或远程API调用。

如果第一次打开，必须手动重启一次docker

2、在setting中添加docker，Engine API URL 填写 tcp://localhost:2375
随后idea会自动连接docker。（图片下次一定添加）

在控制台的`Services`标签可以看见

3、添加maven插件
```xml
<!--复制jar包到指定目录-->
<plugin>
    <artifactId>maven-antrun-plugin</artifactId>
    <executions>
        <execution>
            <id>gen-webadmin</id>
            <phase>package</phase>
            <configuration>
                <tasks>
                    <copy todir="docker" file="target/${project.artifactId}-${project.version}.${project.packaging}" />
                </tasks>
            </configuration>
            <goals>
                <goal>run</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

4、在项目根目录下创建一个`docker`文件夹，在里面添加`Dockerfile`文件
```dockerfile
FROM java:8u111

VOLUME /tmp

ADD *.jar app.jar

EXPOSE 80

ENTRYPOINT ["java","-jar","/app.jar"]

# Ubuntu 时区
RUN cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
```

5、点击Edit Configuration，选择dockerfile
![](./images/9264166-d1d2c66b87e8f6c9.webp)

6、在docker执行之前需要把项目打包，所以在最下面的操作栏中加入maven打包相关的命令：

工作目录：
`D:/Desktop/qunar_my/springboot-practice/springboot-docker`

maven命令：（清除上次打包，再重新打包）
`clean package -Dmaven.test.skip=true`




























