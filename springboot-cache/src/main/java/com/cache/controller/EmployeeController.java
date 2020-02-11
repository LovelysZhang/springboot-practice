package com.cache.controller;

import com.cache.bean.Employee;
import com.cache.dao.EmployeeDao;
import com.cache.service.EmployeeService;
import com.cache.util.RedisUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 员工信息操作
 *
 * @author non human
 * on 2020/2/9
 */
@RestController
public class EmployeeController {


    @Resource
    EmployeeService employeeService;

    @Resource
    private EmployeeDao employeeDao;

    @Resource
    private RedisUtils redisUtils;

    @GetMapping("/emp/{id}")
    @ResponseBody
    public Employee getEmp(@PathVariable Integer id) {
        return employeeService.getEmp(id);
    }


    @GetMapping("/key/{id}")
    @Cacheable(cacheNames = "key", keyGenerator = "myKeyGenerator", condition = "#a0>1")
    public Employee getEmpByCustomKeyGenerator(@PathVariable Integer id) {
        return employeeDao.getEmpById(id);
    }

    @GetMapping("/redis/{id}")
    public Employee getEmpSave2Redis(@PathVariable Integer id) {
        Employee employee = employeeDao.getEmpById(id);
        redisUtils.set("emp", employee);
        return employee;
    }
}
