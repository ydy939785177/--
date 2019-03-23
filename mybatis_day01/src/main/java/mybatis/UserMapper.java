package mybatis;


import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author ydy
 * @create 2019-03-22 22:35
 */
public interface UserMapper {

    // 插入数据
    Integer insert(User user);

    //查看所有用户
    List<User> findAll();

    //根据用户名查询用户数据
    User findByUsername(String username);

    //将所有的用户的is_delete设置为0或1
    Integer updateIsDelete(Integer isDelete);

    //修改密码
    // update xx set password=? where id=?
    Integer updatePassword(
            @Param("id") Integer id,
            @Param("password") String password);

    //统计用户数量
    Integer countById();

    //批量删除
    Integer deleteByIds(int[] ids);

    //动态查询
    List<User> select(@Param("where") String where);

    //加强版动态
    List<User> select2(
            @Param("where") String where,
            @Param("orderBy") String orderBy,
            @Param("limit") String limit);

    List<UserVO> findAll2();
}
