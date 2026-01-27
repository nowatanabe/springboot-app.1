package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.HomeService;

import jakarta.servlet.http.HttpSession;


@Controller
public class OGC040010010Controller
{
    private HomeService service;

    public OGC040010010Controller(HttpSession session, HomeService homeService) {
        this.service = homeService;
    }

    @RequestMapping(value="/", method={RequestMethod.GET, RequestMethod.POST})
    public String index() {
        return "forward:/OGC040010010/init";
    }
    
    @RequestMapping(value="/OGC040010010/init", method={RequestMethod.GET, RequestMethod.POST})
    public ModelAndView init(HttpSession session, ModelAndView mav) {
        mav.setViewName("page/OGC040010010");

        session.setAttribute("hoge", "ほげ");

        List<String> sessionInfo = new ArrayList<String>(); 
        session.getAttributeNames().asIterator().forEachRemaining(name -> {
            Object value = session.getAttribute(name);
            sessionInfo.add(String.format("['%s', %s]", name, value.toString()));
        });

        mav.addObject("characters", service.getAllCharacters());
        mav.addObject("sessions", sessionInfo);

        return mav;
    }
 
    @RequestMapping(value="/OGC040010010/search", method={RequestMethod.GET, RequestMethod.POST})
    public ModelAndView search(HttpSession session, ModelAndView mav) {
        mav.setViewName("page/OGC040010010");


        return mav;
    }

    @RequestMapping(value="/OGC040010010/reflect", method={RequestMethod.GET, RequestMethod.POST})
    public ModelAndView reflect(HttpSession session, ModelAndView mav) {
        mav.setViewName("page/OGC040010010");

        return mav;
    }

}
