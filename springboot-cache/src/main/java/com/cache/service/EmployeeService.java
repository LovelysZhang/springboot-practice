package com.cache.service;

import com.cache.bean.Employee;
import com.cache.dao.EmployeeDao;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author non human
 * on 2020/2/9
 */
@Service
public class EmployeeService {

    @Resource
    private EmployeeDao employeeDao;

    @Cacheable(value = {"employee"})
    public Employee getEmp(Integer id) {
        System.out.println("查询员工" + id);
        return employeeDao.getEmpById(id);
    }
}
