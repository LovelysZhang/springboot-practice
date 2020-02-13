Springboot 整个Dubbo

## 前提

1、安装一个zk

2、

## 1、创建公共API
创建一个项目，只定义接口

其他项目引用定义的接口
```xml
<dependency>
    <groupId>com.albatross</groupId>
    <artifactId>springboot-dubbo-api</artifactId>
    <version>${project.version}</version>
</dependency>
```
## 2、创建Provider

**坑**

1、如果是 properties 配置文件
包扫描配置
```properties
dubbo.scan.basePackages
```
而不是base-packages

2、Consumer启动报错：No provider available for the service

最快的方法:启动dubbo-admin，检查provider是否真的没有暴露接口

如果没有暴露，在回过来检查生产者项目。

3、暴露接口的@service注解

注意不要倒错包 `org.apache.dubbo.config.annotation.Service;`
## 3、创建Consumer

@Reference，引用dubbo接口的实例

略，看代码



## 4、安装Apache dubbo admin
现在是前后端分离

[项目地址](https://github.com/apache/dubbo-admin):
https://github.com/apache/dubbo-admin

[中文官方文档](https://dubbo.apache.org/zh-cn/blog/dubbo-admin.html):
https://dubbo.apache.org/zh-cn/blog/dubbo-admin.html

### 启动后端
后端项目是springboot，可以直接启动 spring application
```properties
admin.registry.address=zookeeper://127.0.0.1:2181
admin.config-center=zookeeper://127.0.0.1:2181
admin.metadata-report.address=zookeeper://127.0.0.1:2181
```

### 启动前端
需要安装nodejs
> 使用包管理工具nvm安装node
> 安装nvm 、nvm安装node（自行搜索）

在项目的dubbo-admin-ui目录下
```shell script
# install dependencies
npm install

# serve with hot reload at localhost:8081
npm run dev

# build for production with minification
npm run build

# build for production and view the bundle analyzer report
npm run build --report
```
