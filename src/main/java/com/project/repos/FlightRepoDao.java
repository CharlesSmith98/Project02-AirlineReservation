package com.project.repos;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.models.Flight;


@Repository
public class FlightRepoDao {

	@Autowired
	private SessionFactory sf;	
	
	public FlightRepoDao(SessionFactory sf) {
		this.sf = sf;
	}

	
	public void create(Flight f) {
		sf.getCurrentSession().save(f);		
	}

	
	public Flight selectById(int id) {
		return sf.getCurrentSession().get(Flight.class, id);
	}

	@Transactional
	public List<Flight> selectAll() {
		
		return sf.getCurrentSession().createQuery("from Flight", Flight.class).list();
	}

	
	public Flight selectByName(String name) {
		return sf.getCurrentSession().createQuery("from flight where name=:name", Flight.class).setParameter("name", name).uniqueResult();
	}
	
	
}
