package com.example.servlet01.sec07;

import com.example.servlet01.sec05.BookVO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class BookDAO2 {
    private Connection con = null;
    DataSource dataSource = null;

    public BookDAO2() {
        try {
            Context init = new InitialContext();
            dataSource = (DataSource) init.lookup("java:comp/env/jdbc/mysql");
            System.out.println("DB 연결 성공");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<BookVO> bookSelect() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        ArrayList<BookVO> bookList = new ArrayList<BookVO>();

        try {
            con = dataSource.getConnection();

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

    public void bookInsert(BookVO vo) {
        PreparedStatement pstmt = null;
        try {
            con = dataSource.getConnection();

            String sql = "insert into book values(?, ?, ?, ?, ?, ?, ?)";
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, vo.getBookNo());
            pstmt.setString(2, vo.getBookName());
            pstmt.setString(3, vo.getBookName());
            pstmt.setString(4, vo.getBookAuthor());
            pstmt.setInt(5, vo.getBookPrice());
            pstmt.setDate(6, (java.sql.Date) vo.getBookDate());
            pstmt.setString(7,  vo.getPubNo());

            // 쿼리문 실행 : 영향을 받은 행의 수 반환
            //select : executeQuery - 결과 행 resultSet 반환.
            //insert / update / delete : executeUpdate() - 영향을 받은 행의 수 반환
            int result = pstmt.executeUpdate();

            if(result > 0) {
                System.out.println("데이터 입력 성공!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void bookDelete(String bookNo) {
        try {
            con = dataSource.getConnection();

            String sql = "delete from book where memId=?";
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1, bookNo);

            // 쿼리문 실행 : 영향을 받은 행의 수 반환
            //select : executeQuery - 결과 행 resultSet 반환.
            //insert / update / delete : executeUpdate() - 영향을 받은 행의 수 반환
            int result = pstmt.executeUpdate();

            if(result > 0) {
                System.out.println("회원정보 삭제 성공!");
            }

            // 모든 객체 close() : 리소스 반납
            pstmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println("오류 발생!");
            e.printStackTrace();
        }
    }
}
