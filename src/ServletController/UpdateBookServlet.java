package ServletController;

import JavaBeans.BookBean;
import Services.database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Viet Quan on 03/08/2017.
 */
@WebServlet(name = "UpdateBookServlet", urlPatterns = "/UpdateBook")
public class UpdateBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookName=request.getParameter("txtName");
        String bookPublisher=request.getParameter("txtPublisher");
        int bPage=Integer.parseInt(request.getParameter("txtPage"));



        request.setCharacterEncoding("UTF-8");
        try {
            Connection con = database.getConnection();
            //Statement stm = con.createStatement();

            String insert_query = "UPDATE book SET book_name = ?, book_publisher = ? , page=? WHERE book_id = ?";
            PreparedStatement dbStatement = con.prepareStatement(insert_query);

            dbStatement.setString(1, bookName);
            dbStatement.setString(2, bookPublisher);
            dbStatement.setInt(3, bPage);
            dbStatement.setInt(4, Integer.parseInt(request.getParameter("txtBookId")));
            dbStatement.executeUpdate();


            response.sendRedirect("book");
            //request.getRequestDispatcher("book-test").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {


            Connection con = database.getConnection();
            PreparedStatement statement = con.prepareStatement("select * from book where book_id = ?");
            statement.setInt(1, Integer.parseInt(request.getParameter("txtBookId")));
            ResultSet rs = statement.executeQuery();
            //ResultSet rs = stm.executeQuery("select * from book WHERE book_id = ?");

            //List<BookBean> bookList = new ArrayList<BookBean>();
            while(rs.next()){
                BookBean b = new BookBean();
                b.setBook_name(rs.getString("book_name"));
                b.setBook_publisher(rs.getString("book_publisher"));
                b.setPage(rs.getInt("page"));
                b.setBook_id(rs.getInt("book_id"));
                request.setAttribute("bookResult", b);
                //bookList.add(b);
            }


            request.getRequestDispatcher("update-book.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(BookServlet.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}
