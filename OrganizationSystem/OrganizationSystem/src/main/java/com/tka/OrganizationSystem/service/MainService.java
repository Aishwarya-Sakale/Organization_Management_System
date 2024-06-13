package com.tka.OrganizationSystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.OrganizationSystem.dao.MainDao;
import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee;

@Service
public class MainService {

	@Autowired
	MainDao dao;
	
	public String addcountry(Country c) {
		String msg = dao.addcountry(c);
		if(Objects.isNull(msg)) {
			msg = "Country is not Added...";
		}
		return msg;
	}

	public String updatecountry(Country c) {
		String msg = dao.updatecountry(c);
		if(Objects.isNull(msg)) {
			msg = "Country is not updated...";
		}
		return msg;
	}

	public String deletecountry(int id) {
		String msg = dao.deletecountry(id);
		if(Objects.isNull(msg)) {
			msg = "Country is not deleted...";
		}
		return msg;
	}

	public List<Country> getAllCountry() {
		List<Country> list = dao.getAllCountry();
		if(Objects.isNull(list)) {
			list = null;
		}
		return list;
	}

	public Country getCountryById(int id) {
		Country c = dao.getCountryById(id);
		if(Objects.isNull(c)) {
			c = null;
		}
		return c;
	}

	public String addEmployee(Employee emp) {
		String msg = dao.addEmployee(emp);
		if(Objects.isNull(msg)) {
			msg = "Employee is not Added...";
		}
		return msg;
	}

	public String updateEmployee(Employee emp) {
		String msg = dao.updateEmployee(emp);
		if(Objects.isNull(msg)) {
			msg = "Employee is not Updated...";
		}
		return msg;
	}

	public String deleteEmployee(int id) {
		String msg = dao.deleteEmployee(id);
		if(Objects.isNull(msg)) {
			msg = "Employee is not Deleted...";
		}
		return msg;
	}

	public List<Employee> getAllEmployee() {
		List<Employee> list = dao.getAllEmployee();
		if(Objects.isNull(list)) {
			list = null;
		}
		return list;
	}

	public Employee getEmployeeById(int id) {
		Employee emp = dao.getEmployeeById(id);
		if(Objects.isNull(emp)) {
			emp = null;
		}
		return emp;
	}

	public List<Employee> getEmpByStatus(String status) {
		List<Employee> list = dao.getEmpByStatus(status);
		if(Objects.isNull(list)) {
			list = null;
		}
		return list;
	}

	public List<Employee> getEmpByDep(String department) {
		List<Employee> list = dao.getEmpByDep(department);
		if(Objects.isNull(list)) {
			list = null;
		}
		return list;
	}

	

	public List<Country> getEmpByCountry(String cname) {
		List<Country> list = dao.getEmpByCountry(cname);
		if(Objects.isNull(list)) {
			list = null;
		}
		return list;
	}
	
	public HashMap loginuser(Employee emp) {
		Employee e =  dao.loginuser(emp);
		
		HashMap map = new HashMap();
		
		if(Objects.isNull(e)) {
			//invalid user
			map.put("msg", "Invalid User...");
			map.put("user", e);
		}else {
			//valid user
			map.put("msg", "Valid user...");
			map.put("user", e);
		}
		return map;
	}
}
