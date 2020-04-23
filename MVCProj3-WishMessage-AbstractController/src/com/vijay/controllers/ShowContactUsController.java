package com.vijay.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class ShowContactUsController extends AbstractController {

	@Override
	public  ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {

		return new ModelAndView("show_contact_us");
	}

}
