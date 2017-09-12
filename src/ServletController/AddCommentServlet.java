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

/**
 * Created by Viet Quan on 12/09/2017.
 */
@WebServlet(name = "AddCommentServlet", urlPatterns = "/AddComment")
public class AddCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String review=request.getParameter("txtReview");


        request.setCharacterEncoding("UTF-8");
        try {
            Connection con = database.getConnection();
            //Statement stm = con.createStatement();

            String insert_query = "INSERT INTO book_review (review,book_id) VALUES(?,?)";
            PreparedStatement dbStatement = con.prepareStatement(insert_query);

            dbStatement.setString(1, review);
            dbStatement.setInt(2, Integer.parseInt(request.getParameter("txtBookID")));
            dbStatement.executeUpdate();


            response.sendRedirect("book");
            //request.getRequestDispatcher("book-test").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("GetbookID", request.getParameter("txtBookId"));
        request.getRequestDispatcher("add-comment.jsp").forward(request, response);
    }
}
