package mybatis;

import java.util.List;

/**
 * @author ydy
 * @create 2019-03-25 9:15
 */
public class DepartmentVO {
    /*
    *部门名字
    */
    private String name ;
    /*
     *部门编号
     */
    private Integer id;
    /*
    *部门人的信息集合
    */
    private List<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "DepartmentVO{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", users=" + users +
                '}';
    }
}
