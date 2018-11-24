package cn.happy.day05annotationdi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * author：  刘涛
 *
 * @create 2018-11-20 15:37
 */
@Component
public class Book {
    @Value("${book.bookname}")
    private String bookname;
    @Value("${book.bookprice}")
    private Integer bookprice;

    @Resource
    /*@Autowired
    @Qualifier(value = "publisher")*/
    private Publisher publisher;

    @Override
    public String toString() {
        return "Book{" +
                "bookname='" + bookname + '\'' +
                ", bookprice=" + bookprice +
                ", publisher=" + publisher +
                '}';
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Integer getBookprice() {
        return bookprice;
    }

    public void setBookprice(Integer bookprice) {
        this.bookprice = bookprice;
    }

}
