package JavaBeans;

import java.io.Serializable;

/**
 * Created by Viet Quan on 12/09/2017.
 */
public class CommentBean implements Serializable {

    private  int book_review_id;
    private String review;
    private BookBean bookId;

    public int getBook_review_id() {
        return book_review_id;
    }

    public void setBook_review_id(int book_review_id) {
        this.book_review_id = book_review_id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public BookBean getBookId() {
        return bookId;
    }

    public void setBookId(BookBean bookId) {
        this.bookId = bookId;
    }

    public CommentBean(){

    }
}
