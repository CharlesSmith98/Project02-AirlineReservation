package com.project.repos;

import java.util.List;

import com.project.models.Flight;

public interface FlightRepo {
	void create(Flight f);
	Flight selectById(int id);
	List<Flight> selectAll();
	Flight selectByName(String name);
}
