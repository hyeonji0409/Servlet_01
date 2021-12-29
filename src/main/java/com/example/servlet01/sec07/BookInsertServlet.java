package com.example.servlet01.sec07;

import com.example.servlet01.sec04.MemberDAO;
import com.example.servlet01.sec04.MemberVO;
import com.example.servlet01.sec05.BookVO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "BookInsertServlet", value = "/BookInsertServlet")
public class BookInsertServlet extends HttpServlet {
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
        String bookNo = request.getParameter("bookNo");
        String bookName = request.getParameter("bookName");
        String bookAuthor = request.getParameter("bookAuthor");
        Integer  bookPrice = request.getParameter("bookPrice");
        Date bookDate = request.getParameter("bookDate");
        String pubNo = request.getParameter("pubNo");

        // MemberVO에 저장
        BookVO vo = new BookVO();
        vo.setBookNo(bookNo);
        vo.setBookName(bookName);
        vo.setBookAuthor(bookAuthor);
        vo.setBookPrice(bookPrice);
        vo.setBookDate(bookDate);
        vo.setPubNo(pubNo);

        // 또는 생성자 사용
        //MemberVO vo = new MemberVO(id, pwd, name, email);

        // 회원 정보 등록 : memberInsert() 호출  -> DB에 저장
        MemberDAO dao = new MemberDAO();
        dao.memberInsert(vo);
    }
}
