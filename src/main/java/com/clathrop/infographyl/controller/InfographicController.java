package com.clathrop.infographyl.controller;


import com.clathrop.infographyl.dao.InfographicManager;
import com.clathrop.infographyl.dao.InfographicManagerImpl;
import com.clathrop.infographyl.model.Infographic;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by clathrop on 4/2/15.
 */
@Controller
public class InfographicController {

    @RequestMapping("/hello")
    public String hello(@RequestParam(value="name", required = false, defaultValue = "World") String name, Model model){

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        InfographicManager igManager = (InfographicManager) ctx.getBean("infographicManagerImpl");

        
        List<Infographic> list = igManager.findAllInfographics();

        int size = list.size();

        model.addAttribute("size", size);

        model.addAttribute("name", name);
        //returns the view name
        return "helloworld";
    }


}
