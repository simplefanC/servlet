# servlet

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



### service

每当有请求到达匹配之后就执行一次



### destroy

当容器进行销毁的时候执行

前提是必须已经初始化过



## loadOnStartup

定义servlet是否跟随容器的启动而启动

如果某个servlet里面负责的工作很重要，属于准备性工作，让它随容器启动而启动

结论：

- 数字越小，执行优先级越高

适用工作有严格先后顺序



## genericServlet



## HttpServlet

实际开发一般会使用这个来开发，如果我们某个servlet需要特殊处理生命周期的另外两个方法时，重写init、destroy方法即可可。











