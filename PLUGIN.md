# UUIA Java SDK 插件开发指南
### 概述  
每一个Java SDK的插件都对应一个用户请求中的group字段.UUIA标准功能在base组中实现.但基础功能是由中心结点访问的，而插件功能是由用户的小程序直接发起的. 
### 开发  
Java SDK会自动的将用户发来的JSON字符串中group字段的内容映射到service包对应的类中.如您要开发一个插件对应的group为community,您只要在service包内编写Community类即可。  
对于您编写的对应的service类，您需要满足以下要求:
* 类名符合Java命名规范，首字母大写.
* 实现Group接口
* 存在一个构造函数，接受一个UuiaController的实例。SDK将通过这个方法实例化您编写的类.

####使用JPA
如果您只是进行基础的CRUD，推荐使用JPA。您可以在dao.entity编写对应的数据表，在dao包内编写对应的Repository。接着您便可以按照如下方法使用JPA：  
1. 在UuiaController中加入对应的Repository，以及其setter和getter，在setter上加入`@Autowired`进行注入。
2. 在您编写的service类中，您可以通过您编写的构造函数来获得在controller中注入的Repository，来操控数据库。

