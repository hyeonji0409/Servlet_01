package com.example.servlet01;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet2", value = "/login2")
public class LoginServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 클라이언트 요청 처리
        // 클라이언트 -> 서버 인코딩
        request.setCharacterEncoding("utf-8");

        String id =  request.getParameter("user_id");
        String pw =  request.getParameter("user_pw");
        System.out.println("아이디 : " + id);
        System.out.println("비밀번호 : " + pw);
        // 응답처리
        // 서버 - > 클라이언트로 setContentType
        response.setContentType("text/html;charset=utf-8");

        // 서버에서 클라이언트로 데이터 전송에 자바 IO스트림 이용
        PrintWriter out = response.getWriter();
        // HTML 문서 형식으로 데이터 전송
        out.println("<html><head></head><body>");
        out.println("아이디 :" + id + "<br>" +  "비밀번호 : " + pw);
        out.println("</body></html>");
    }
}
