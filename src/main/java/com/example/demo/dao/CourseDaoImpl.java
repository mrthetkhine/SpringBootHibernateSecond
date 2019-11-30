package com.example.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Course;

import org.hibernate.Criteria;
import org.hibernate.Query;
@Repository
@Transactional
public class CourseDaoImpl implements CourseDao{
	
	@Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> getAllCourse() {
		
		return this.getSession()
				.createQuery("from Course")
				.list();
	}

	@Override
	public List<Course> findByName(String name) {
		// TODO Auto-generated method stub
		String queryStr = "from Course where name like CONCAT('%',:name,'%')";
		Query query = this.getSession().createQuery(queryStr);
		query.setParameter("name", name);
		return query.list();
	}

	@Override
	public List<Course> findByNameWithCriteria(String name) {
		Criteria c = this.getSession()
						.createCriteria(Course.class)
						.add(Restrictions.like("name", name,MatchMode.ANYWHERE));
						
		return c.list();
	}
	

}
