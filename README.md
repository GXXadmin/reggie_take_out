# application.yml

**该文件没有在项目中配置，需要自己创建**

```yaml
server:
  port: 8080
spring:
  application:
    # 应用的名称，可选
    name: reggie_take_out
  datasource:
    druid:
      driver-class-name: com.mysql.cj.jdbc.Driver
      url: jdbc:mysql://localhost:3306/reggie?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&useSSL=false&allowPublicKeyRetrieval=true
      username: root
      password: '123456'
  main:
    banner-mode: off
mybatis-plus:
  configuration:
    #在映射实体或者属性时，将数据库中表名和字段名中的下划线去掉，按照驼峰命名法映射
    map-underscore-to-camel-case: true
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
  global-config:
    db-config:
      id-type: ASSIGN_ID
reggie:
  path: D:\案例\reggie_take_out\img\ #图片存储地址
```

项目介绍：该项目后台采用restful风格开发，项目前后端分离

技术栈：springboot，mybatisplus，mysql8，fastjson，druid（数据库连接池），slf4j

开发工具：idea，maven，git，lombok

# 登陆界面地址

服务端 http://localhost:8080/backend/page/login/login.html

客户端 





# 项目结构

ReggieApplication 项目启动

## common（常规包，比较混乱）

- BaseContext 基于ThreadLocal封装工具类，用户保存和获取当前登录用户id
- GlobalExceptionHandler 自定义全局异常处理
- JacksonObjectMapper 对象映射器:基于jackson将Java对象转为json，或者将json转为Java对象
- MyMetaObjecthandler 公共字段自动填充，更新
- R 服务端返回结果类
- CustomException 自定义异常

## config（配置）

- MybatisPlusConfig MP的分页插件
- WebMvcConfig 资源映射，消息转换器

## controller（控制层）

- AddressBookController 地址簿
- CategoryController 分类管理
- CommonController 文件上传和下载
- DishController 菜品管理
- EmployeeController 员工管理
- OrderController 订单处理
- OrderDetailController 订单明细
- SetmealController 套餐管理
- ShoppingCartController 购物车
- UserController 用户登陆

## dto（实体类扩展）

- DishDto 对实体类Dish的扩展
- SetmealDto 对Setmeal（套餐）的扩展

## entity（实体类）

- AddressBook 地址簿
- Category 分类1 菜品分类 2 套餐分类
- Dish 菜品
- DishFlavor 菜品口味
- Employee 员工
- OrderDetail 订单明细
- Orders 订单
- Setmeal 套餐
- SetmealDish 套餐菜品关系
- ShoppingCart 购物车
- User 用户信息

## filter

- LoginCheckFilter 检查用户用户登陆状态

## mapper

持久层

## service

业务模块

## utils

- SMSUtils 短信发送工具类
- ValidateCodeUtils 随机生成验证码工具类



























