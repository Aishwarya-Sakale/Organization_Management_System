package com.tka.OrganizationSystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee;

@Repository
public class MainDao {

	@Autowired
	SessionFactory factory;
	
	public String addcountry(Country c) {
		
		Session session = null;
		Transaction tx = null;
		String msg = null;
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			session.persist(c);
			tx.commit();
			msg = "Country Added Successfully...";
		
		}catch (Exception e) {
			
			if(tx != null) {
				tx.rollback();
			}
			
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		
		return msg;
	}

	public String updatecountry(Country c) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			Country country = session.get(Country.class, c.getCid());
			
			country.setCname(c.getCname());
			session.merge(country);
			tx.commit();
			msg = "Country is updated successfully...";
		}catch (Exception e) {
			
			if(tx != null) {
				tx.rollback();
			}
			
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		
		return msg;
	}

	public String deletecountry(int id) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			Country country = session.get(Country.class,id);
			
			session.remove(country);
			
			tx.commit();
			msg = "Country is Deleted Successfully...";
		}catch (Exception e) {
			
			if(tx != null) {
				tx.rollback();
			}
			
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return msg;
	}

	public List<Country> getAllCountry() {
		Session session = null;
		Transaction tx = null;
		List<Country> list = null;
		String hqlQuery = "from Country";
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			Query<Country> query = session.createQuery(hqlQuery,Country.class);
			
			list = query.list();
			tx.commit();
		}catch (Exception e) {
			
			if(tx != null) {
				tx.rollback();
			}
			
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return list;
	}

	public Country getCountryById(int id) {
		Session session = null;
		Transaction tx = null;
		Country c = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			c =  session.get(Country.class, id);
			tx.commit();
		}catch (Exception e) {
			
			if(tx != null) {
				tx.rollback();
			}
			
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return c;
	}

	public String addEmployee(Employee emp) {
		
		Session session = null;
		Transaction tx = null;
		String msg = null;
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			session.persist(emp);
			
			tx.commit();
			msg = "Employee Added Successfully...";
		}catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return msg;
	}

	public String updateEmployee(Employee emp) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			Employee empData = session.get(Employee.class, emp.getId());
			empData.setName(emp.getName());
			empData.setPhoneno(emp.getPhoneno());
			empData.setDepartment(emp.getDepartment());
			empData.setStatus(emp.getStatus());
			empData.setCreatedby(emp.getCreatedby());
			empData.setCreateddtm(emp.getCreateddtm());
			empData.setUpdatedby(emp.getUpdatedby());
			empData.setUpdateddtm(emp.getUpdateddtm());
			empData.setCountry(emp.getCountry());
			
			session.merge(empData);
			
			tx.commit();
			msg = "Employee Updated Successfully...";
		}catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return msg;
	}

	public String deleteEmployee(int id) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			Employee e = session.get(Employee.class,id);
			session.remove(e);
			
			tx.commit();
			msg = "Employee Deleted Successfully...";
		}catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return msg;
	}

	public List<Employee> getAllEmployee() {
		Session session = null;
		Transaction tx = null;
		List<Employee> list = null;
		String hqlQuery = "from Employee";
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			Query<Employee> query = session.createQuery(hqlQuery,Employee.class);
			list = query.list();
			
			tx.commit();
		}catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		
		return list;
	}

	public Employee getEmployeeById(int id) {
		Session session = null;
		Transaction tx = null;
		Employee emp =null;
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			emp = session.get(Employee.class, id);
			
			tx.commit();
		}catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return emp;
	}

	public List<Employee> getEmpByStatus(String status) {
		Session session = null;
		Transaction tx = null;
		List<Employee> list = null;
		String hqlQuery = "from Employee where status =: status";
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			Query<Employee> query = session.createQuery(hqlQuery,Employee.class);
			query.setParameter("status", status);
			
			list = query.list();
		} catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return list;
	}

	public List<Employee> getEmpByDep(String department) {
		Session session = null;
		Transaction tx = null;
		List<Employee> list = null;
		String hqlQuery = "from Employee where department =: department";
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			Query<Employee> query = session.createQuery(hqlQuery,Employee.class);
			query.setParameter("department", department);
			
			list = query.list();
		} catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return list;
	}

	

	public List<Country> getEmpByCountry(String cname) {
		Session session = null;
		Transaction tx = null;
		List<Country> list = null;
		String hqlQuery = "from Country where cname =: cname";
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			Query<Country> query = session.createQuery(hqlQuery,Country.class);
			query.setParameter("cname", cname);
			
			list = query.list();
		} catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return list;
	}
	
	public Employee loginuser(Employee emp) {
		Session session = null;
		Transaction tx = null;
		String hqlQuery = "from Employee where name =: name and phoneno =:phoneno";
		Employee employee = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Query<Employee> query = session.createQuery(hqlQuery,Employee.class);
			query.setParameter("name", emp.getName());
			query.setParameter("phoneno", emp.getPhoneno());
			
			employee = query.uniqueResult();
			
			tx.commit();
		} catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return employee;
	}


}
