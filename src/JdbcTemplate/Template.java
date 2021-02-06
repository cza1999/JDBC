package JdbcTemplate;
import druid.JdbcUtil2;
import emp.Emp;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Template {
//     1.获取JDBCTemplate对象
    JdbcTemplate te=new JdbcTemplate(JdbcUtil2.getDataSource());

//    Junit单元测试，可以让方法单独运行
//    @Test
    public void tese1(){
//        2.定义SQL
        String sql="update account set balance= 10 where id=2";
//        3.执行SQL
        int count =te.update(sql);
        System.out.println(count);
    }
//    @Test
    public void test2(){
        String sql="insert into account(balance,aa,ab) values (?,?,?)";
        int count =te.update(sql,52,444,"sss");
        System.out.println(count);
    }
//    @Test
    public void test3(){
        String sql="delete from account where id= ?";
        int count =te.update(sql,4);
        System.out.println(count);
    }
//    @Test
    /*4..查询id为1001的记录,将其封装为Map集合
    注意:这个方法查询的结果集长度只能是1*/

    public void test4(){
        String sql="select * from account where id= ? ";
        Map<String,Object> map=te.queryForMap(sql,5);
        System.out.println(map);
    }
//    @Test
//    查询所有记录，将其封装为List
    public void test5(){
        String sql="select * from account ";
        List<Map<String,Object>> list=te.queryForList(sql);
        for(Map<String,Object> stringObjectMap :list){
            System.out.println(stringObjectMap);
        }
    }
    //        6．查询所有记录，将其封装为Emp对象的List集合
//    @Test
    public void test6(){
        String sql="select * from book";
        List<Emp> list =te.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int i) throws SQLException {
                Emp emp = new Emp();
                int booknum = rs.getInt(1);
                String bookname = rs.getString("bookname");
                String booktype = rs.getString("booktype");
                String bookshe = rs.getString("bookshe");
                int money = rs.getInt(5);
                int cou = rs.getInt("cou");

                emp.setBooknum(booknum);
                emp.setBookname(bookname);
                emp.setBooktype(booktype);
                emp.setBookshe(bookshe);
                emp.setMoney(money);
                emp.setCo(cou);

                return emp;
            }
        });
        for(Emp emp:list){
            System.out.println(list);
        }
    }
//    @Test
    public void test7() {
        String sql = "select * from book";
        List<Emp> list = te.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : list) {
            System.out.println(list);
        }
    }
        @Test
        public void test8(){
            String sql = "select count(booknum) from book";
            long total =te.queryForObject(sql,long.class);
            System.out.println(total);
        }
    }

