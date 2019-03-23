package mybatis;

/**
 * @author ydy
 * @create 2019-03-23 20:04
 */
public class Department {
    /*
    *部门编号啊
    */
    private Integer id ;
    private int  aaaa;
    /*
    *部门名啊
    */
    private String name ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
