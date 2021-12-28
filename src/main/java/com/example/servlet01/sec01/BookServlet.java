package com.example.servlet01.sec01;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BookServlet", value = "/bookInsert")
public class BookServlet extends HttpServlet {
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

        String bookNo = request.getParameter("bookNo");
        String bookName = request.getParameter("bookName");
        String bookAuthor = request.getParameter("bookAuthor");
        String bookPrice = request.getParameter("bookPrice");
        String bookYear = request.getParameter("bookYear");
        String bookMonth = request.getParameter("bookMonth");
        String bookDate = request.getParameter("bookDate");
        String qtyNo = request.getParameter("qtyNo");
        String pubNo = request.getParameter("pubNo");

        System.out.println("도서 번호: " + bookNo );
        System.out.println("도서 명: " + bookName );
        System.out.println("저자: " + bookAuthor );
        System.out.println("가격: " + bookPrice );
        System.out.println("발행일: " + bookYear+"-"+ bookMonth +"-"+bookMonth);
        System.out.println("재고: " + qtyNo );
        System.out.println("출판사 번호: " + pubNo );
    }
}
