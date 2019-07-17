package com.suyoggaikwad.service;

import com.suyoggaikwad.dao.EmployeeDao;
import com.suyoggaikwad.model.Employee;

import java.util.List;

public class EmployeeService {

    EmployeeDao employeeDao = new EmployeeDao();

    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    public Employee addEmployee(Employee employee) {
        return employeeDao.addEmployee(employee);
    }

    public Employee updateEmployee(String name, int id) {
        return employeeDao.updateEmployee(name, id);
    }

    public Employee deleteEmployee(String name)  {
        return employeeDao.deleteEmployee(name);
    }
}
