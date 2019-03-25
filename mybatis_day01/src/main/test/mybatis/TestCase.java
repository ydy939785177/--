package mybatis;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


/**
 * @author ydy
 * @create 2019-03-22 22:38
 */
public class TestCase {

    MapperScannerConfigurer msc;
    SqlSessionFactoryBean ssfb;
    AbstractApplicationContext ac;
    UserMapper userMapper;
    BasicDataSource dataSource;
    DepartmentMapper departmentMapper;

    @Before
    public void init() {
        ac = new ClassPathXmlApplicationContext("spring.xml");
        userMapper = ac.getBean("userMapper", UserMapper.class);
        departmentMapper = ac.getBean("departmentMapper", DepartmentMapper.class);
    }

    @After
    public void destroy() {
        ac.close();
    }

    @Test
    public void getConnection() throws SQLException {
        dataSource = ac.getBean("dataSource", BasicDataSource.class);
        Connection conn = dataSource.getConnection();
        System.out.println(conn);

    }

    @Test
    public void insert() {
        User user = new User();
        user.setUsername("root6");
        user.setPassword("root1");
        user.setAge(33);
        user.setPhone("1308544525");
        user.setEmail("root@qq.cn");
        user.setIsDelete(0);
        Integer rows = userMapper.insert(user);
        System.out.println("rows=" + rows);

    }


    @Test
    public void findAll() {
        List<User> list = userMapper.findAll();
        for (User user : list) {
            System.out.println("user = " + user);
        }
    }

    @Test
    public void findByUsername() {
        String username = "root1";
        User user = userMapper.findByUsername(username);
        System.out.println(user);
    }

    @Test
    public void updateIsDelete() {
        Integer isDelete = 1;
        Integer rows = userMapper.updateIsDelete(isDelete);
        System.out.println("rows=" + rows);
    }

    @Test
    public void updatePassword() {
        Integer id = 6;
        String password = "8888";
        Integer rows = userMapper.updatePassword(id, password);
        System.out.println("rows=" + rows);
    }

    @Test
    public void countById() {
        Integer count = userMapper.countById();
        System.out.println("count = " + count);
    }

    @Test
    public void deleteByIds() {
        int[] arr = new int[2];
        arr[0] = 1;
        arr[1] = 2;
        Integer rows = userMapper.deleteByIds(arr);
        System.out.println("rows = " + rows);
    }

    @Test
    public void select() {
        String where = "username='张三'";
        System.out.println("-----------------------");
        List<User> list = userMapper.select(null);
        for (User user : list) {
            System.out.println("user = " + user);
        }
        System.out.println("-----------------------");
        list = userMapper.select(where);
        for (User user : list) {
            System.out.println("user = " + user);
        }
    }

    @Test
    public void findAll2() {
        List<UserVO> list = userMapper.findAll2();
        for (UserVO userVO : list) {
            System.out.println("userVO = " + userVO);
        }
    }

    @Test
    public void select2() {
        String where = "id>1";
        String orderBy = "id DESC";
        String limit = "1,1";
        List<User> list = userMapper.select2(where, orderBy, limit);
        for (User user : list) {
            System.out.println(user);
        }
        System.out.println("-------------------");
        where = null;
        orderBy = null;
        limit = null;
        list = userMapper.select2(where, orderBy, limit);
        for (User user : list) {
            System.out.println("user = " + user);
        }
    }

    @Test
    public void findAllDepartment() {
        List<DepartmentVO> list = departmentMapper.findAll();
        System.out.println("BEGIN:");
        for (DepartmentVO departmentVO : list) {
            System.out.println(departmentVO);
        }
        System.out.println("END.");
    }

    @Test
    public void findDepartmentById() {
        Integer id = 1;
        DepartmentVO departmentVO = departmentMapper.findById(id);
        System.out.println(departmentVO);
    }


}

