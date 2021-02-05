package com.model;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * @author HuangCJ
 */
public class Emp {
    private Integer empno;

    private String ename;

    private Double salary;

    private Integer deptno;

    public Emp() {
        System.out.println("[INFO] Emp() called");
    }

    public Emp(Integer empno, String ename) {
        this.empno = empno;
        this.ename = ename;
    }

    public Emp(Integer empno, String ename, Double salary, Integer deptno) {
        this.empno = empno;
        this.ename = ename;
        this.salary = salary;
        this.deptno = deptno;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", salary=" + salary +
                ", deptno=" + deptno +
                '}';
    }

}
