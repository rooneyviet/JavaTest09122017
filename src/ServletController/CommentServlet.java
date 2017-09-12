package ServletController;

import JavaBeans.BookBean;
import JavaBeans.CommentBean;
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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Viet Quan on 12/09/2017.
 */
@WebServlet(name = "CommentServlet",urlPatterns = "/Comment")
public class CommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {


            Connection con = database.getConnection();
            PreparedStatement statement = con.prepareStatement("select * from book_review where book_id = ?");
            //SELECT * FROM book_review AS rv JOIN book AS b ON rv.book_id = b.book_id where book_review_id = ?
            statement.setInt(1, Integer.parseInt(request.getParameter("txtBookId")));
            ResultSet rs = statement.executeQuery();
            //ResultSet rs = stm.executeQuery("select * from book WHERE book_id = ?");
            PreparedStatement stm = con.prepareStatement("select * from book where book_id = ?");

            stm.setInt(1, Integer.parseInt(request.getParameter("txtBookId")));
            ResultSet resultSet = stm.executeQuery();
            List<CommentBean> bookCommentList = new ArrayList<CommentBean>();

            BookBean b = new BookBean();
            if(resultSet.next()){
                request.setAttribute("NameBook", resultSet.getString("book_name"));
                b.setBook_name(resultSet.getString("book_name"));
                b.setBook_id(resultSet.getInt("book_id"));
            }
            while(rs.next()){

                //b.setBook_id(Integer.parseInt(request.getParameter("txtBookId")));



                CommentBean cm = new CommentBean();
                cm.setReview(rs.getString("review"));
                cm.setBook_review_id(rs.getInt("book_review_id"));
                cm.setBookId(b);



                bookCommentList.add(cm);
            }
            request.setAttribute("dsComment", bookCommentList);
            request.setAttribute("bookIDGet", request.getParameter("txtBookId"));

            request.getRequestDispatcher("book-comments.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(BookServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
