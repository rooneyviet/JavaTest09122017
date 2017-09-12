package ServletController;

import JavaBeans.BookBean;
import Services.database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Viet Quan on 12/09/2017.
 */
@WebServlet(name = "DeleteBookServlet", urlPatterns = "/DeleteBook")
public class DeleteBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connection con = database.getConnection();
            PreparedStatement statement = con.prepareStatement("DELETE FROM book WHERE book_id = ?");
            statement.setInt(1, Integer.parseInt(request.getParameter("txtBookId")));
            statement.executeUpdate();
            //ResultSet rs = stm.executeQuery("select * from book WHERE book_id = ?");

            //List<BookBean> bookList = new ArrayList<BookBean>();
            response.sendRedirect("book");
        } catch (SQLException ex) {
            Logger.getLogger(BookServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
