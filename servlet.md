## servlet

必须要有服务器的支持

- tomcat(servlet容器)
- jetty



WEB-INF是一个受保护的目录，只允许服务器自身进行访问，客户端无法直接访问

web.xml web部署描述符（配置文件，指导应用程序如何工作）



## 写servlet

三种方式

- 实现servlet接口
- 继承genericServlet
- 继承httpServlet



<http://localhost:8080/servlet/hate>



## servlet中方法

- init
- getServletConfig
- service
- getServletInfo
- destroy



### init

servlet组件初始化的一项工作，它在第一次创建 Servlet 时被调用，在后续每次用户请求时不再调用。整个生命周期只有0次或1次。

不会追随容器的初始化而初始化（默认状态下）

第一次访问的时候完成初始化

初始化的工作紧随servlet对象创建而完成

工作的servlet从头到尾都是一个servlet（只构造一次，单例多线程工作模式）





