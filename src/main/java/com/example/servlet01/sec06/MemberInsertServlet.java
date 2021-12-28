package com.example.servlet01.sec06;

import com.example.servlet01.sec04.MemberDAO;
import com.example.servlet01.sec04.MemberVO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "MemberInsertServlet", value = "/MemberInsertServlet")
public class MemberInsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // (1) 요청 받음
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        // MemberVO에 저장
        MemberVO vo = new MemberVO();
        vo.setId(id);
        vo.setPwd(pwd);
        vo.setName(name);
        vo.setEmail(email);

        // 또는 생성자 사용
        //MemberVO vo = new MemberVO(id, pwd, name, email);

        // 회원 정보 등록 : memberInsert() 호출  -> DB에 저장
        MemberDAO dao = new MemberDAO();
        dao.memberInsert(vo);
    }
}
