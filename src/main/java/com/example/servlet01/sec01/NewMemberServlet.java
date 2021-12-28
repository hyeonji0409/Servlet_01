package com.example.servlet01.sec01;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/newMember")
public class NewMemberServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void init(ServletConfig config) throws ServletException {
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
    }
}