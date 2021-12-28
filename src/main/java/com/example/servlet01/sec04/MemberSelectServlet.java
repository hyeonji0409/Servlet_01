package com.example.servlet01.sec04;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/memberSelect")
public class MemberSelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        MemberDAO dao = new MemberDAO();

        ArrayList<MemberVO> memList = dao.memberSelect();

        out.print("<html><head></head><body>");
        out.print("<table border=1><tr align='center' bgcolor='green'>");
        out.print("<td>아이디</td><td>비밀번호</td><td>이름</td>" +
                "<td>이메일</td><td>가입일</td><td>삭제</td></tr>");

        for(int i=0; i<memList.size(); i++) {
            MemberVO vo = (MemberVO) memList.get(i);
            String id = vo.getId();
            String pwd = vo.getPwd();
            String name = vo.getName();
            String email = vo.getEmail();
            Date joinDate = vo.getJoinDate();

            // 한 행씩 출력
            out.print("<tr><td>" + id + "</td><td>" +
                    pwd + "</td><td>" +
                    name + "</td><td>" +
                    email + "</td><td>" +
                    joinDate + "</td><td>" +
                    "<a href='MemberDeleteServlet?id=" + id + "'>삭제</a></td></tr>");
        }

        out.print("</table></body></html>");
    }
}
