package com.spring.orm.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.entities.Student;

public class StudentDao {
	
	//HibernateTemplate  have all method that makes possible to fire query
	
	private HibernateTemplate hibernateTemplate;
	
	//this enable wirte operation to db
	@Transactional
	//save student
	public int insert(Student student) {
		Integer i = (Integer)this.hibernateTemplate.save(student);
		return i;
	}
	//get the single data(Object);
	public Student getStudent(int id) {
		Student student =  this.hibernateTemplate.get(Student.class, id);
		return student;
	}
	
	//get Multiple data
	
	public List<Student> getAllStudent() {
		List<Student> list = this.hibernateTemplate.loadAll(Student.class);
		return list;
	}
	
	//Delete Data
	@Transactional
	public void deleteStudent(int id) {
		Student student = this.hibernateTemplate.get(Student.class, id);
		this.hibernateTemplate.delete(student);
	}
	
	//update
	@Transactional
	public void updateStudent(Student student) {
		this.hibernateTemplate.update(student);
		
	}
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	

}
