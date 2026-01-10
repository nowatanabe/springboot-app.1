package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.HomeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController
{
    private HomeService service;

    public HomeController(HttpSession session, HomeService homeService) {
        this.service = homeService;
    }

    @RequestMapping(value="/", method=RequestMethod.GET)
    public ModelAndView index(HttpSession session, ModelAndView mav) {
        session.setAttribute("hoge", "ほげ");

        List<String> sessionInfo = new ArrayList<String>(); 
        session.getAttributeNames().asIterator().forEachRemaining(name -> {
            Object value = session.getAttribute(name);
            sessionInfo.add(String.format("['%s', %s]", name, value.toString()));
        });

        mav.addObject("characters", service.getAllCharacters());
        mav.addObject("sessions", sessionInfo);

        mav.setViewName("index");
        return mav;
    }
}
