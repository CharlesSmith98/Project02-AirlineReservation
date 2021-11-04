package com.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.models.Flight;
import com.project.repos.FlightRepo;
import com.project.repos.FlightRepoDao;

@Controller
@RequestMapping(path = "/flight")
@CrossOrigin(origins = "*")
public class FlightController {
	
	@Autowired
	private FlightRepoDao fDao;

	
	public FlightController(FlightRepoDao fDao) {
		this.fDao = fDao;
	}

	@RequestMapping(value = "")
	public @ResponseBody List<Flight> getAllFlights() {
		System.out.println("From get all flights");
		return fDao.selectAll();
	}

	@PostMapping(value = "")
	public @ResponseBody String createFlight(Flight f) {
		fDao.create(f);
		return "Flight created successfuly";
	}

}
