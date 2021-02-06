package emp;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
    public class empMain {
        public static void main(String[] args) throws Exception {
       List<Emp> list =new empMain().findAll();
            System.out.println(list);
            System.out.println(list.size());
        }

        public List<Emp> findAll() {
            Connection conn = null;
            Statement stat = null;
            ResultSet rs = null;
            Emp emp = null;
            List<Emp> list = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost/book", "root", "zxcvbnm1999");
                String sql = "select * from book";
                stat = conn.createStatement();
                rs = stat.executeQuery(sql);
//            让光标向下移动一行
                list = new ArrayList<Emp>();
                while (rs.next()) {
                    int booknum = rs.getInt(1);
                    String bookname = rs.getString("bookname");
                    String booktype = rs.getString("booktype");
                    String bookshe = rs.getString("bookshe");
                    int money = rs.getInt(5);
                    int cou = rs.getInt("cou");
                    emp = new Emp();
                    emp.setBooknum(booknum);
                    emp.setBookname(bookname);
                    emp.setBooktype(booktype);
                    emp.setBookshe(bookshe);
                    emp.setMoney(money);
                    emp.setCo(cou);
                    list.add(emp);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                if (stat != null) {
                    try {
                        stat.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
            return list;
        }
    }

