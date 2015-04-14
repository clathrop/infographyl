package com.clathrop.infographyl.controller;

import com.clathrop.infographyl.dao.InfographicManager;
import com.clathrop.infographyl.jsonresponse.JsonJtableInfographicResponse;
import com.clathrop.infographyl.model.JsonJTableInfographicBean;
import com.clathrop.infographyl.jsonresponse.JsonJtableInfographicListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by clathrop on 4/4/15.
 */
@Controller
public class JTableController {

    @Autowired
    InfographicManager infographicManager;


    @RequestMapping(value = "/infographicTable", method = RequestMethod.GET)
    public String show(ModelMap model) {
        return "infographicTable";
    }

    @RequestMapping(value = "/infographicTable/listInfographics")
    @ResponseBody
    public JsonJtableInfographicListResponse listInfographics(@RequestParam Integer jtStartIndex, @RequestParam Integer jtPageSize) {

        JsonJtableInfographicListResponse jilr;
        List<JsonJTableInfographicBean> igList;
        try {
            int igCount = infographicManager.getRowCount();
            System.out.println("\n\nTotalRecordCount: " + igCount + "\n\n");

            igList = infographicManager.listInfographics(jtStartIndex, jtPageSize);

            for (JsonJTableInfographicBean ig : igList) {
                System.out.println("\n\n" + ig.toString() + "\n\n");
            }
            jilr = new JsonJtableInfographicListResponse("OK", igList, igCount);
        } catch (Exception e) {
            jilr = new JsonJtableInfographicListResponse("ERROR", e.getMessage());
        }
        return jilr;
    }

    @RequestMapping(value = "/infographicTable/createInfographic", method = RequestMethod.POST)
    @ResponseBody
    public JsonJtableInfographicResponse createInfographic(@ModelAttribute JsonJTableInfographicBean infographicBean, BindingResult result) {

        JsonJtableInfographicResponse jsonJtableInfographicResponse;

        if (result.hasErrors()) {
            jsonJtableInfographicResponse = new JsonJtableInfographicResponse();
        }
        try {
            infographicManager.insertInfographic(infographicBean);
            jsonJtableInfographicResponse = new JsonJtableInfographicResponse("OK", infographicBean);
        } catch (Exception e) {
            jsonJtableInfographicResponse = new JsonJtableInfographicResponse("ERROR", e.getMessage());
        }

        return jsonJtableInfographicResponse;
    }

    @RequestMapping(value = "/infographicTable/updateInfographic", method = RequestMethod.POST)
    @ResponseBody
    public JsonJtableInfographicResponse updateInfographic(@ModelAttribute JsonJTableInfographicBean infographicBean, BindingResult result) {

        JsonJtableInfographicResponse jsonJtableInfographicResponse;
        if (result.hasErrors()) {
            jsonJtableInfographicResponse = new JsonJtableInfographicResponse("ERROR", "Form invalid");
            return jsonJtableInfographicResponse;
        }
        try {
            infographicManager.updateInfographic(infographicBean);
            jsonJtableInfographicResponse = new JsonJtableInfographicResponse("OK", infographicBean);
        } catch (Exception e) {
            jsonJtableInfographicResponse = new JsonJtableInfographicResponse("ERROR", e.getMessage());
        }
        return jsonJtableInfographicResponse;
    }


}
