package com.example.servlet01.sec05;

import com.example.servlet01.sec04.MemberDAO;
import com.example.servlet01.sec04.MemberVO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "BookSelectServlet", value = "/BookSelectServlet")
public class BookSelectServlet extends HttpServlet {
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

        BookDAO dao = new BookDAO();

        ArrayList<BookVO> bookList = dao.bookSelect();

        out.print("<html><head></head><body>");
        out.print("<table border=1><tr align='center' bgcolor='black' color='white'>");
        out.print("<td>도서번호</td><td>도서명</td><td>저자</td>" +
                "<td>가격</td><td>발행일</td><td>출판사번호</td>");

        for(int i=0; i<bookList.size(); i++) {
            BookVO vo = (BookVO) bookList.get(i);
            String bookNo = vo.getBookNo();
            String bookName = vo.getBookName();
            String bookAuthor = vo.getBookAuthor();
            Integer bookPrice = vo.getBookPrice();
            Date bookDate = vo.getBookDate();
            String pubNo = vo.getPubNo();

            // 한 행씩 출력
            out.print("<tr><td>" +
                    bookNo + "</td><td>" +
                    bookName + "</td><td>" +
                    bookAuthor + "</td><td>" +
                    bookPrice + "</td><td>" +
                    bookDate + "</td><td>" +
                    pubNo + "</td></tr>");
        }

        out.print("</table></body></html>");
    }
}
