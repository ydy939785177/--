package mybatis;

import java.util.List;

/**
 * @author ydy
 * @create 2019-03-25 9:21
 */
public interface DepartmentMapper {
    List<DepartmentVO> findAll();

    DepartmentVO findById(Integer id);
}
