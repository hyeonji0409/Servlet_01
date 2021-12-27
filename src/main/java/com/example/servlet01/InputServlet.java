package com.example.servlet01;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "InputServlet", value = "/input")
public class InputServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String id = request.getParameter("user_id");
        String pw = request.getParameter("user_pw");
        String emailRcv = request.getParameter("emailRcv");
        String[] subject = request.getParameterValues("subject");

        System.out.println("아이디 : " + id);
        System.out.println("비밀번호 : " + pw);
        System.out.println("이메일 수신 여부 : " + emailRcv);

        System.out.print("관심분야 : ");
        for (String sub : subject) {
            System.out.print(sub + " ");
        }
        System.out.println();
    }
}
