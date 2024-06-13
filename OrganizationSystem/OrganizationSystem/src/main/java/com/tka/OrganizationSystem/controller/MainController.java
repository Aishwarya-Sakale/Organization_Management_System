package com.tka.OrganizationSystem.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee;
import com.tka.OrganizationSystem.service.MainService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class MainController {

	@Autowired
	MainService service;
	
	//API1
	@PostMapping("/addcountry")
	public String addcountry(@RequestBody Country c) {
		
		String msg = service.addcountry(c);
		return msg;
	}
	
	//API2
	@PutMapping("/updatecountry")
	public String updateCountry(@RequestBody Country c) {
		
		 String msg = service.updatecountry(c);
		 return msg;
	}
	
	//API3
	@DeleteMapping("/deletecountry/{id}")
	public String deletecountry(@PathVariable int id) {
		
		String msg = service.deletecountry(id);
		return msg;
	}
	
	//API4
	@GetMapping("/getAllCountry")
	public List<Country> getAllCountry(){
		
		List<Country> list = service.getAllCountry();
		return list;
	}
	
	//API5
	@GetMapping("/getCountryById/{id}")
	public Country getCountryById(@PathVariable int id) {
		Country c = service.getCountryById(id);
		return c;
	}
	
	//API6
	@PostMapping("/addEmp")
	public String addEmployee(@RequestBody Employee emp) {
		String msg = service.addEmployee(emp);
		return msg;
	}
	
	//API7
	@PutMapping("/updateEmp")
	public String updateEmployee(@RequestBody Employee emp) {
		String msg = service.updateEmployee(emp);
		return msg;
	}
	
	//API8
	@DeleteMapping("/deleteEmp/{id}")
	public String deleteEmployee(@PathVariable int id) {
		String msg = service.deleteEmployee(id);
		return msg;
	}
	
	//API9
	@GetMapping("/getAllEmp")
	public List<Employee> getAllEmployee(){
		List<Employee> list = service.getAllEmployee();
		return list;
	}
	
	//API10
	@GetMapping("/getEmpById/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		Employee emp = service.getEmployeeById(id);
		return emp;
	}
	
	//API11
	@GetMapping("/getEmpByStatus/{status}")
	public List<Employee> getEmpByStatus(@PathVariable String status){
		List<Employee> list = service.getEmpByStatus(status);
		return list;
	}
	
	//API12
	@GetMapping("/getEmpByDep/{department}")
	public List<Employee> getEmpByDep(@PathVariable String department){
		List<Employee> list = service.getEmpByDep(department);
		return list;
	}
	
	//API12
	@GetMapping("/getEmpByCname/{cname}")
	public List<Country> getEmpByCountry(@PathVariable String cname){
		List<Country> list = service.getEmpByCountry(cname);
		return list;
	}
	
	//API13
	@PostMapping("/login")
	public HashMap loginuser(@RequestBody Employee emp) {
		HashMap map = service.loginuser(emp);
		return map;
	}
}
