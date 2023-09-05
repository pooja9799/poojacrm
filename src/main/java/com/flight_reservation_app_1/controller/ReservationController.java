package com.flight_reservation_app_1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flight_reservation_app_1.dto.ReservationRequest;
import com.flight_reservation_app_1.entity.Reservation;
import com.flight_reservation_app_1.service.ReservationService;

@Controller
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService; // giving reference variable type as interface name

	@RequestMapping("/confirmReservation")
	public String confirmReservation(ReservationRequest request, ModelMap modelMap) {
		Reservation reservationId = reservationService.bookFlight(request);
		modelMap.addAttribute("reservationId", reservationId.getId());
		return "confirmReservation";
	}
}
