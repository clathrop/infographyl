package com.clathrop.infographyl.controller;

import com.clathrop.infographyl.dao.InfographicManager;
import com.clathrop.infographyl.dao.InfographicManagerImpl;
import com.clathrop.infographyl.model.JsonJTableInfographicBean;
import com.clathrop.infographyl.model.JsonJtableInfographicListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by clathrop on 4/4/15.
 */
@Controller
public class JTableController {

//    @Autowired
//    InfographicManager infographicManager;


    @RequestMapping(value="/infographicTable", method = RequestMethod.GET)
    public String show(ModelMap model){
        return "infographicTable";
    }

    @RequestMapping(value="/infographicTable/listInfographics")
    @ResponseBody
    public JsonJtableInfographicListResponse listInfographics(@RequestParam Integer jtStartIndex, @RequestParam Integer jtPageSize) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        InfographicManager igManager = (InfographicManager) ctx.getBean("infographicManagerImpl");

        JsonJtableInfographicListResponse jilr;
        List<JsonJTableInfographicBean> igList;
        try{
            int igCount = igManager.getRowCount();
            igList = igManager.listInfographics(jtStartIndex, jtPageSize);
            jilr = new JsonJtableInfographicListResponse("OK", igList, igCount);
        } catch(Exception e){
            jilr = new JsonJtableInfographicListResponse("ERROR", e.getMessage());
        }
        return jilr;
    }


}
