package alone;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
public class select {
    public static void main(String[] args) throws  Exception {

        Connection conn=null;
        Statement stat = null;
        ResultSet rs=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/book","root","zxcvbnm1999");
            String sql="select * from book";
            stat =conn.createStatement();
            rs=stat.executeQuery(sql);
//            让光标向下移动一行
            while(rs.next()) {
                int booknum = rs.getInt(1);
                String bookname = rs.getString("bookname");
                String booktype = rs.getString("booktype");
                String bookshe = rs.getString("bookshe");
                int money = rs.getInt(5);
                String cou = rs.getString("cou");

                System.out.println(booknum + " " + bookname + " " + booktype +
                        " " + bookshe + " " + money + " " + cou);
            }
           /* if(count>0){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }*/
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException ex){
            ex.printStackTrace();
        }finally{
            if(stat!=null){
                try{
                    stat.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(conn!=null){
                try{
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(rs!=null){
                try{
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }
    }
}
