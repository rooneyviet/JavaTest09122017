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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Viet Quan on 12/09/2017.
 */
@WebServlet(name = "UpdateCommentServlet", urlPatterns = "/UpdateComment")
public class UpdateCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String act = request.getParameter("comment-update");
        if (act != null) {
            //no button has been selected
            //delete button was pressed
            request.setCharacterEncoding("UTF-8");
            String review=request.getParameter("txtReview");


            try {
                Connection con = database.getConnection();
                //Statement stm = con.createStatement();

                String insert_query = "UPDATE book_review SET review = ? WHERE book_review_id = ?";
                PreparedStatement dbStatement = con.prepareStatement(insert_query);

                dbStatement.setString(1, review);
                dbStatement.setInt(2, Integer.parseInt(request.getParameter("txtReviewId")));
                dbStatement.executeUpdate();

                request.setAttribute("add_comment_true", true);
//            response.sendRedirect("book");
                //response.sendRedirect(request.getHeader("referer"));
                request.getRequestDispatcher("update-comment.jsp").forward(request, response);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else{
            //delete button was pressed

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {


            Connection con = database.getConnection();
            //PreparedStatement statement = con.prepareStatement("select * from book_review where book_review_id = ?");
            //
            PreparedStatement statement = con.prepareStatement("SELECT * FROM book_review AS rv JOIN book AS b ON rv.book_id = b.book_id where book_review_id = ?");


            statement.setInt(1, Integer.parseInt(request.getParameter("txtCommentId")));
            ResultSet rs = statement.executeQuery();
            //ResultSet rs = stm.executeQuery("select * from book WHERE book_id = ?");

            //List<BookBean> bookList = new ArrayList<BookBean>();
            while(rs.next()){
                CommentBean cm = new CommentBean();
                    BookBean b = new BookBean();



                    b.setBook_name(rs.getString("book_name"));
                    b.setBook_id(rs.getInt("book_id"));
                    b.setBook_publisher(rs.getString("book_publisher"));
                cm.setReview(rs.getString("review"));
                cm.setBook_review_id(rs.getInt("book_review_id"));
                cm.setBookId(b);

                request.setAttribute("commentbookResult", cm);
                //bookList.add(b);
            }


            request.getRequestDispatcher("update-comment.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(BookServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
