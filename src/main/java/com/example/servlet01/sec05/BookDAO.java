package com.example.servlet01.sec05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class BookDAO {
    private Connection connDB() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/servletdb?serverTimezone=UTC";
            String user = "root";
            String pwd = "1234";

            con = DriverManager.getConnection(url, user, pwd);
            if(con != null) {
                System.out.println("연결 성공");
            }
        } catch(Exception e) {
            System.out.println("연결 오류 발생!");
            e.printStackTrace();
        }
        return con;
    }
    // 회원 정보 조회 (전체 회원 정보 SELECT 해서 반환 : BookVO 반환)
    // BookVO 여러 행 반환 : ArrayList<BookVO>
    public ArrayList<BookVO> bookSelect() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        ArrayList<BookVO> bookList = new ArrayList<BookVO>();

        try {
            con = connDB();

            String query = "select * from book";
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) { // 결과 세트에서 한 행씩 처리
                // 한 행(회원 1명당) 처리
                String bookNo = rs.getString("bookNo");
                String bookName = rs.getString("bookName");
                String bookAuthor = rs.getString("bookAuthor");
                Integer bookPrice = rs.getInt("bookPrice");
                Date bookDate = rs.getDate("bookDate");
                String pubNo = rs.getString("pubNo");

                // 한 행 정보 가져와서 MemberVO에 저장 : setter 메소드 사용
                BookVO vo = new BookVO();
                vo.setBookNo(bookNo);
                vo.setBookName(bookName);
                vo.setBookAuthor(bookAuthor);
                vo.setBookPrice(bookPrice);
                vo.setBookDate(bookDate);
                vo.setPubNo(pubNo);

                // 각 MemberVO를 ArrayList에 추가(저장)
                bookList.add(vo);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

            try {
                rs.close();
                pstmt.close();
                con.close();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return bookList;
    }
}
