package com.ohgiraffers.section01.statement;

import com.ohgiraffers.domain.entity.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.ohgiraffers.common.JDBCTemplate.close;

//a. datebase 접속에 관련된 내용을 적음
public class EmployeeRepository {

    public Employee findEmployeeByEmpId(Connection con, String empId) {

        Statement stmt = null;
        ResultSet rset = null;

        Employee foundEmployee = null;

        try {
            stmt = con.createStatement();
            String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = '" + empId + "'";

            rset = stmt.executeQuery(query);

            if(rset.next()) {
                foundEmployee = new Employee();
                foundEmployee.setEmpId(rset.getString("EMP_ID"));
                foundEmployee.setEmpName(rset.getString("EMP_NAME"));
                foundEmployee.setEmpNo(rset.getString("EMP_NO"));
                foundEmployee.setEmail(rset.getString("EMAIL"));
                foundEmployee.setPhone(rset.getString("PHONE"));
                foundEmployee.setDeptCode(rset.getString("DEPT_CODE"));
                foundEmployee.setJobCode(rset.getString("JOB_CODE"));
                foundEmployee.setSalLevel(rset.getString("SAL_LEVEL"));
                foundEmployee.setSalary(rset.getInt("SALARY"));
                foundEmployee.setBonus(rset.getDouble("BONUS"));
                foundEmployee.setManagerId(rset.getString("MANAGER_ID"));
                foundEmployee.setHireDate(rset.getDate("HIRE_DATE"));
                foundEmployee.setEntDate(rset.getDate("ENT_DATE"));
                foundEmployee.setEntYn(rset.getString("ENT_YN"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(stmt);
            close(rset);
        }

        return foundEmployee;
    }

    public List<Employee> findAllEmployees(Connection con) {

        Statement stmt = null;
        ResultSet rset = null;

        List<Employee> employees = null;    //a. return해줄 result 선언

        try {
            stmt = con.createStatement(); //a. statement를 만들어줌

            String query = "SELECT * FROM EMPLOYEE"; //a. query 작성

            rset = stmt.executeQuery(query); //a. result에 query 담음

            employees = new ArrayList<>();
            while (rset.next()) {
                Employee row = new Employee();
                row.setEmpId(rset.getString("EMP_ID"));
                row.setEmpName(rset.getString("EMP_NAME"));
                row.setEmpNo(rset.getString("EMP_NO"));
                row.setEmail(rset.getString("EMAIL"));
                row.setPhone(rset.getString("PHONE"));
                row.setDeptCode(rset.getString("DEPT_CODE"));
                row.setJobCode(rset.getString("JOB_CODE"));
                row.setSalLevel(rset.getString("SAL_LEVEL"));
                row.setSalary(rset.getInt("SALARY"));
                row.setBonus(rset.getDouble("BONUS"));
                row.setManagerId(rset.getString("MANAGER_ID"));
                row.setHireDate(rset.getDate("HIRE_DATE"));
                row.setEntDate(rset.getDate("ENT_DATE"));
                row.setEntYn(rset.getString("ENT_YN"));

                employees.add(row);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(stmt);
        }

        return employees;
    }

    public List<Employee> findAllEmployees(Connection con, String order) {

        Statement stmt = null;
        ResultSet rset = null;

        List<Employee> employees = null;    //a. return해줄 result 선언

        try {
            stmt = con.createStatement(); //a. statement를 만들어줌

            String query = "SELECT * FROM EMPLOYEE ORDER BY EMP_ID " + order; //a. query 작성

            rset = stmt.executeQuery(query); //a. result에 query 담음

            employees = new ArrayList<>();
            while (rset.next()) {
                Employee row = new Employee();
                row.setEmpId(rset.getString("EMP_ID"));
                row.setEmpName(rset.getString("EMP_NAME"));
                row.setEmpNo(rset.getString("EMP_NO"));
                row.setEmail(rset.getString("EMAIL"));
                row.setPhone(rset.getString("PHONE"));
                row.setDeptCode(rset.getString("DEPT_CODE"));
                row.setJobCode(rset.getString("JOB_CODE"));
                row.setSalLevel(rset.getString("SAL_LEVEL"));
                row.setSalary(rset.getInt("SALARY"));
                row.setBonus(rset.getDouble("BONUS"));
                row.setManagerId(rset.getString("MANAGER_ID"));
                row.setHireDate(rset.getDate("HIRE_DATE"));
                row.setEntDate(rset.getDate("ENT_DATE"));
                row.setEntYn(rset.getString("ENT_YN"));

                employees.add(row);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(stmt);
        }

        return employees;
    }
}
