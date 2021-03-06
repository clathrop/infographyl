package com.clathrop.infographyl.controller;


import com.clathrop.infographyl.dao.InfographicDao;
import com.clathrop.infographyl.dao.InfographicManager;
import com.clathrop.infographyl.dao.InfographicManagerImpl;
import com.clathrop.infographyl.model.Infographic;
import org.hibernate.dialect.InformixDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sound.midi.MidiDevice;
import java.util.List;

/**
 * Created by clathrop on 4/2/15.
 */
@Controller
public class InfographicController {

    @Autowired
    InfographicManager infographicManager;

    @RequestMapping("/")
    public String home(Model model){
        try{
            int size = infographicManager.findAllInfographics().size();
            Infographic ig = infographicManager.getRandomInfographic();

            String name = ig.getName();
            String url = ig.getUrl();
            String category = ig.getCategory();

            model.addAttribute("size", size);
            model.addAttribute("url", url);
            model.addAttribute("category", category);
            model.addAttribute("name", name);
            model.addAttribute("description", ig.getDescription());
            model.addAttribute("tags", ig.getTags());

        } catch (Exception e){
            e.printStackTrace();
        }
        return "home";
    }

    @RequestMapping("/view/{igId}")
    public String viewSingle(@PathVariable("igId") String igId, Model model){
        try{
            Infographic ig = infographicManager.findInfographicForId(Integer.parseInt(igId));

            model.addAttribute("url", ig.getUrl());
            model.addAttribute("category", ig.getCategory());
            model.addAttribute("name", ig.getName());
            model.addAttribute("description", ig.getDescription());
            model.addAttribute("tags", ig.getTags());

        } catch (Exception e){
            e.printStackTrace();
        }
        return "singleView";
    }

    @RequestMapping("/category/{categoryId}")
//    public String category(@RequestParam(value = "category", required = false, defaultValue = "technology") String category, Model model){
      public String category(@PathVariable("categoryId") String categoryId, Model model){
        List<Infographic> igList = infographicManager.findInfographicsForCategory(categoryId);

        model.addAttribute("igList", igList);
        model.addAttribute("listSize", igList.size());
        model.addAttribute("categoryId", categoryId);


        return "category";
    }


}
