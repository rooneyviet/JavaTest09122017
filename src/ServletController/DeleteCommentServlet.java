package ServletController;

import Services.database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Viet Quan on 12/09/2017.
 */
@WebServlet(name = "DeleteCommentServlet", urlPatterns = "/DeleteComment")
public class DeleteCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connection con = database.getConnection();
            PreparedStatement statement = con.prepareStatement("DELETE FROM book_review WHERE book_review_id = ?");
            statement.setInt(1, Integer.parseInt(request.getParameter("txtCommentId")));
            statement.executeUpdate();
            //ResultSet rs = stm.executeQuery("select * from book WHERE book_id = ?");

            //List<BookBean> bookList = new ArrayList<BookBean>();
            //response.sendRedirect("book");
            response.sendRedirect(request.getHeader("referer"));
        } catch (SQLException ex) {
            Logger.getLogger(BookServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
