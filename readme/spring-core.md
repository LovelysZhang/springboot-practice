# Spring核心原理
## Spring
### IOC/DI

### AOP

### beanFactory 和 factoryBean


## SpringMVC

### 过滤器

### 拦截器

### 监听器

### mvc源码

## Spring Validation
参数校验

### 简单实用
`Java API`规范(`JSR303`)定义了`Bean`校验的标准`validation-api`，但没有提供实现。`hibernate validation`是对这个规范的实现，并增加了校验注解如`@Email`、`@Length`等。`Spring Validation`是对`hibernate validation`的二次封装，用于支持`spring mvc`参数自动校验。接下来，我们以`spring-boot`项目为例，介绍`Spring Validation`的使用。

### 引入依赖
如果`spring-boot`版本小于`2.3.x`，`spring-boot-starter-web`会自动传入`hibernate-validator`依赖。如果`spring-boot`版本大于`2.3.x`，则需要手动引入依赖：

### 参考
https://mp.weixin.qq.com/s/jwJtTl5A_TL6jBmwlQNqCQ

----
[Spring boot web app项目](https://www.javatt.com/p/28742)

[Spring Boot 中的静态资源到底要放在哪里](https://juejin.im/post/5ca55b6be51d4574cd19f52a)
