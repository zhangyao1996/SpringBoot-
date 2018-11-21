package com.imooc.sm.service;
/**
* @author zhangyao:
* @date 创建时间：Aug 28, 2018 1:45:14 PM
*/
import com.imooc.sm.entity.Department;
import java.util.List;
public interface DepartmentService {
    void add(Department department);
    void remove(Integer id);
    void edit(Department department);
    Department get(Integer id);
    List<Department> getAll();
}

