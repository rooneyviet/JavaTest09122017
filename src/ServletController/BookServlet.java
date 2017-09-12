package ServletController;

import JavaBeans.BookBean;
import Services.database;

import javax.servlet.annotation.WebServlet;
import java.awt.print.Book;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Viet Quan on 03/08/2017.
 */

@WebServlet(name = "BookServlet", urlPatterns = "/book")
public class BookServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String bookName = request.getParameter("txtName");
        String bookPublisher = request.getParameter("txtPublisher");
        int bPage = Integer.parseInt(request.getParameter("txtPage"));
        request.setCharacterEncoding("UTF-8");
        try {
            Connection con = database.getConnection();
            //Statement stm = con.createStatement();

            String insert_query = "INSERT INTO book (book_name, book_publisher, page) VALUES (?,?,?)";
            PreparedStatement dbStatement = con.prepareStatement(insert_query);
            dbStatement.setString(1, bookName);
            dbStatement.setString(2, bookPublisher);
            dbStatement.setInt(3, bPage);
            dbStatement.executeUpdate();

            response.sendRedirect("book");
            //request.getRequestDispatcher("book-test").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        try {


            Connection con = database.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from book");

            List<BookBean> bookList = new ArrayList<BookBean>();
            while(rs.next()){
                BookBean b = new BookBean();
                b.setBook_name(rs.getString("book_name"));
                b.setBook_publisher(rs.getString("book_publisher"));
                b.setPage(rs.getInt("page"));
                b.setBook_id(rs.getInt("book_id"));

                bookList.add(b);
            }
            request.setAttribute("dsbook", bookList);
            request.getRequestDispatcher("book.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(BookServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
