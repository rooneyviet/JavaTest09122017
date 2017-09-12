package JavaBeans;

import java.awt.print.Book;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Viet Quan on 03/08/2017.
 */
public class BookBean implements Serializable {
    private int book_id;
    private String book_name;
    private String book_publisher;
    private int page;
    private List<CommentBean> commentBeanList;

    public List<CommentBean> getCommentBeanList() {
        return commentBeanList;
    }

    public void setCommentBeanList(List<CommentBean> commentBeanList) {
        this.commentBeanList = commentBeanList;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_publisher() {
        return book_publisher;
    }

    public void setBook_publisher(String book_publisher) {
        this.book_publisher = book_publisher;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public BookBean(){

    }
}
