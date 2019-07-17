package com.suyoggaikwad.dao;

import com.suyoggaikwad.model.Employee;

import javax.persistence.*;
import java.util.List;

public class EmployeeDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();

    public List<Employee> getAllEmployees() {
        et.begin();
        Query query = em.createQuery("select e from Employee e");
        List<Employee> list = query.getResultList();
        return list;
    }

    public Employee addEmployee(Employee employee) {
       et.begin();
       if(employee.getName()!=null) {
           em.persist(employee);
           et.commit();
           System.out.println("Employee Added!");
           em.close();
       }
       return employee;
    }

    public Employee updateEmployee(String name, int id) {
        et.begin();
        Employee emp = null;
        emp = em.find(Employee.class, id);
        if(null!=emp) { emp.setName(name); et.commit(); }
        em.close();
        return emp;
    }

    public Employee deleteEmployee(String name) {
        et.begin();
        Query q = em.createQuery("select e from Employee e where e.name = ?1");
        q.setParameter(1, name);
        Employee emp = null;
        try {
            emp = (Employee) q.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("No such employee present in the Database");
        }
        if(emp!=null) {
            em.remove(emp);
            et.commit();
        }
        em.close();
        return emp;
    }
}
