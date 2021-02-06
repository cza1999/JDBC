package JdbcTemplate;

import druid.JdbcUtil2;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.xml.transform.Templates;

public class demo1 {
    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(JdbcUtil2.getDataSource());

//    3.调用方法
        String sql = "update account set balance =1012 where id=? ";
        int count = template.update(sql,2);
        System.out.println(count);
    }
}
