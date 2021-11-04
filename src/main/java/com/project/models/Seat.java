package com.project.models;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="seats")
public class Seat {
	
	@Id
	@Column(name="seat_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	//Many seats belong to one flight id's
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="flight_id", nullable=false)
	private Flight flight;
	
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



	public Flight getFlight() {
		return flight;
	}



	public void setFlight_id(Flight flight) {
		this.flight = flight;
	}



	public Boolean getSeatAvailable() {
		return seatAvailable;
	}



	public void setSeatAvailable(Boolean seatAvailable) {
		this.seatAvailable = seatAvailable;
	}



	@Override
	public String toString() {
		return "Seat [id=" + id + ", flight=" + flight.getId() + ", seatAvailable=" + seatAvailable + "]";
	}



	public void makeSeats() {
		
		for(int i = 0; i<21; i++)
		{
			// Remove later maybe?
/*			Seat seat = new Seat();
 *			
 *			Session ses = HibernateUtil.getSession();
 *			
 *			Transaction tran = ses.beginTransaction();
 *			
 *			//Use the .save() method on the session object to save the user to database, then commit the transaction
 *			ses.save(seat);
 *			tran.commit();*/
		}
	}
	
	
}



