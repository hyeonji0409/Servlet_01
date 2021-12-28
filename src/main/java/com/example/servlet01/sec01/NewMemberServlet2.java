package com.example.servlet01;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/newMember2")
public class NewMemberServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        String hp1 = request.getParameter("hp1");
        String hp2 = request.getParameter("hp2");
        String hp3 = request.getParameter("hp3");
        String year = request.getParameter("year");
        String[] interest = request.getParameterValues("interest");
        String department = request.getParameter("department");

        System.out.println("이름 : " + name);
        System.out.println("아이디 : " + id);
        System.out.println("비밀번호 : " + pwd);
        System.out.println("휴대폰 번호 : " + hp1+"-" + hp2+"-" + hp3 );
        System.out.println("학년 : " + year + "학년");

        System.out.print("관심분야 : ");
        for (String inter : interest ) {
            System.out.print(inter + " ");
        }
        System.out.println();
        System.out.println("학과 : " + department);

        response.setContentType("text/html;charset=utf-8");

        // 서버에서 클라이언트로 데이터 전송에 자바 IO스트림 이용
        PrintWriter out = response.getWriter();
        // HTML 문서 형식으로 데이터 전송
        out.println("<html><head></head><body>");
        out.println("이름 : " + name + "<br>");
        out.println("아이디 :" + id + "<br>");
        out.println("비밀번호 : " + pwd + "<br>");
        out.println("휴대폰 번호 : " + hp1+"-" + hp2+"-" + hp3 + "<br>");
        out.println("학년 : " + year + "학년" + "<br>");
        out.print("관심분야 : ");
        for (String inter : interest ) {
            out.print(inter + " ");
        }
        out.println("<br>");
        out.println("학과 : " + department);
        out.println("</body></html>");
    }
}