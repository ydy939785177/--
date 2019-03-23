package mybatis;


import java.util.List;

/**
 * @author ydy
 * @create 2019-03-22 22:35
 */
public interface UserMapper {
    //添加字段
    Integer insert(User user);

    //查看所有用户
    List<User> findAll();


}
