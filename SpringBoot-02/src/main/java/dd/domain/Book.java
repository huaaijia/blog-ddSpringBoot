package dd.domain;

import java.io.Serializable;

/**
 * Created by huaaijia on 2016/10/21.
 */
public class Book implements Serializable{
    private static final long serialVersionUID = -1L;

    private String bookName;
    private Integer count;

    public Book() {
    }


    public Book(String bookName, Integer count) {
        this.bookName = bookName;
        this.count = count;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
