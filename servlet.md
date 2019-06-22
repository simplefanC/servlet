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



### HttpServletRequest

- getParameter获得单个请求数据

- getParameterValues
- getHeader
- getHeaderNames获取所有HeaderName可根据HeaderName获取Header信息

- getRequestURI相对容器路径
- getRequestURL完整路径
- getQueryString获取?后面所有内容（如正则判断QueryString，处理不同请求）

- getContextPath上下文路径，项目部署时定义的工程上下文路径，URI=ContextPath+urlPattern



解决请求中文乱码，设置编码，tomcat容器默认ISO-8859-1

```java
req.setCharacterEncoding("UTF-8");
```

### HttpServletResponse

解决响应中文乱码

```java
resp.setContentType("text/html; charset=UTF-8");
```

响应对象不能同时使用字节流和字符流，会出现状态异常

```
java.lang.IllegalStateException: getWriter() has already been called for this response
```

```java
PrintWriter writer = resp.getWriter();
ServletOutputStream outputStream = resp.getOutputStream();
writer.write("login success");
outputStream.write("success".getBytes());
```



## 转发

属于容器的一种行为

当前servlet将请求交给另一个servlet处理，而无需通知浏览器

客户端请求一次，容器内部多少次客户端不知道，转发是容器的一种传播行为

从url地址来看，不会改变

```java
req.getRequestDispatcher("/f2").forward(req,resp);
```

当前所处上下文为容器内部，上下文路径已经包含了ContextPath

## 重定向

是客户端重新请求的一种行为，服务器通知客户端再次发起请求

url地址会改变

服务器会有额外的开销

由于是重新请求，所以无法继续共享之前请求里的req,resp对象，共享数据可通过

- url重写
- cookie
- session

```java
resp.sendRedirect("/servlet/f4?name="+name);
```