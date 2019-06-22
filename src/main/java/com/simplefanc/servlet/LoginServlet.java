package com.simplefanc.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //客户端发送的请求数据封装在req中
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        PrintWriter writer = resp.getWriter();
//        ServletOutputStream outputStream = resp.getOutputStream();
        if(name.equals("cf")){
            if(password.equals("123")){
                writer.write("login success");
//                outputStream.write("success".getBytes());
            }else {
                writer.write("error password");
            }
        }else{
            writer.write("error name");
        }

        System.out.println("...");
    }
}
