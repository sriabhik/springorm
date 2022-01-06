package com.spring.orm.dao;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.entities.Student;

public class StudentDao {
	
	//HibernateTemplate  have all method that makes possible to fire query
	
	private HibernateTemplate hibernateTemplate;
	
	//save student
	@Transactional
	public int insert(Student student) {
		Integer i = (Integer)this.hibernateTemplate.save(student);
		return i;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	

}
