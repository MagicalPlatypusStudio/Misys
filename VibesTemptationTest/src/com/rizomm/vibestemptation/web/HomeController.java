package com.rizomm.vibestemptation.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rizomm.vibestemptation.service.BacklogService;

@Controller
public class HomeController {
	@Autowired
	private BacklogService backlogService;

	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mNv = new ModelAndView("index");
		return mNv;
	}
}
