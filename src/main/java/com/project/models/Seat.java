package com.project.models;

import java.security.spec.PSSParameterSpec;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.utils.HibernateUtil;

@Entity
@Table(name="seats")
public class Seat {
	
		@Id
		@Column(name="seat_id")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
	
	
	//Many seats belong to many flight id's
		@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
		@JoinColumn(name="flight_id", nullable=true)
		private int flight_id;
		
		@Column(name="seat_available", nullable=false)
		private Boolean seatAvailable;
		
		
	public Seat() {
		this.seatAvailable = false;
	}
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getFlight_id() {
		return flight_id;
	}



	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
	}



	public Boolean getSeatAvailable() {
		return seatAvailable;
	}



	public void setSeatAvailable(Boolean seatAvailable) {
		this.seatAvailable = seatAvailable;
	}



	@Override
	public String toString() {
		return "Seat [id=" + id + ", flight_id=" + flight_id + ", seatAvailable=" + seatAvailable + "]";
	}



	public void makeSeats() {
		
		for(int i = 0; i<21; i++)
		{
			 Seat seat = new Seat();
				
				Session ses = HibernateUtil.getSession();
				
				Transaction tran = ses.beginTransaction();
				
				//Use the .save() method on the session object to save the user to database, then commit the transaction
				ses.save(seat);
				tran.commit();
		}
	}
	
	
}



