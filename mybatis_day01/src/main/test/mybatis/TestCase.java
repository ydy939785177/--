package mybatis;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author ydy
 * @create 2019-03-22 22:38
 */
public class TestCase {

    MapperScannerConfigurer msc;
    SqlSessionFactoryBean ssfb;

    @Test
    public void getConnection() throws SQLException {
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");

        BasicDataSource dataSource = ac.getBean("dataSource", BasicDataSource.class);

        Connection conn = dataSource.getConnection();
        System.out.println(conn);

        ac.close();
    }

    @Test
    public void insert() {
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");

        UserMapper userMapper = ac.getBean("userMapper", UserMapper.class);

        User user = new User();
        user.setUsername("root");
        user.setPassword("root");
        user.setAge(18);
        user.setPhone("1308544525");
        user.setEmail("root@qq.cn");
        Integer rows = userMapper.insert(user);
        System.out.println("rows=" + rows);

        ac.close();
    }


}

