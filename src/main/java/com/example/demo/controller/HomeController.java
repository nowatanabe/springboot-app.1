package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.User;
import com.example.demo.service.HomeService;

@Controller
public class HomeController {

    private HomeService service;

    public HomeController(HomeService homeService) {
        this.service = homeService;
    }

    @RequestMapping(value="/", method=RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index");

        User user = service.getUser();
        String userName = "";
        if (user != null) {
            userName = user.getName();
        }


        mav.addObject("userName", userName);
        return mav;
    }
}
