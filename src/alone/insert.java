package alone;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class insert {
    public static void main(String[] args) throws  Exception {
        
        Connection conn=null;
        Statement stat = null;
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql:///book","root","zxcvbnm1999");
        String sql="insert into book values(21,'数据库','库','清华出版社',44,56)";
        stat =conn.createStatement();
        int count=stat.executeUpdate(sql);
        System.out.println(count);
        
        if(count>0){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
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

        }
    }
}
