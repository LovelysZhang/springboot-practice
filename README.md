# springboot in action
Springboot练习

## 一、springboot-mybatis-h2

### 1、springboot 整合mybatis，使用嵌入式H2数据库，内存模式，MySQL MODE

#### 1.1、Springboot初始化执行SQL

```yaml
spring:
  datasource:
    schema:
          - classpath:init/schema.sql
          - classpath:init/data.sql
```
#### 1.2、拦截器分页（pageHelper）

- http://www.imooc.com/article/263101

#### 1.3、拦截器简单实现权限验证

- https://github.com/hawkingfoo/springboot-interceptor
- https://blog.csdn.net/f59130/article/details/79059227

#### 1.4、h2数据库配置

- https://blog.csdn.net/c4jem/article/details/80455502

### 2、AOP。。。。

## 二、springboot-qmq-*
qmq练习，搭建工程没成功


## 三、springboot-protocol-buffer
主要在maven中添加protobuf 插件，在maven中运行`.proto`文件，生成类文件

protobuf 的语法参考 官网


## 笔记补充

autowire 和 resource 的实现和区别