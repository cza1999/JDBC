package emp;

import javax.xml.transform.sax.TemplatesHandler;
import java.util.List;

public class Emp {
    private int booknum;
    private String bookname;
    private String booktype ;
    private String bookshe ;
    private int money ;
    private int co;

    public int getBooknum() {
        return booknum;
    }

    public void setBooknum(int booknum) {
        this.booknum = booknum;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBooktype() {
        return booktype;
    }

    public void setBooktype(String booktype) {
        this.booktype = booktype;
    }

    public String getBookshe() {
        return bookshe;
    }

    public void setBookshe(String bookshe) {
        this.bookshe = bookshe;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getCo() {
        return co;
    }

    public void setCo(int co) {
        this.co = co;
    }

    @Override
    public String toString() {
        return "{" +
                "booknum=" + booknum +
                ", bookname='" + bookname +
                ", booktype='" + booktype +
                ", bookshe=" + bookshe +
                ", money=" + money +
                ", co=" + co +
                '}'+"\n";
    }
}
