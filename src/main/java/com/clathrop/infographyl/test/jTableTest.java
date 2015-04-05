package com.clathrop.infographyl.test;

import com.clathrop.infographyl.dao.InfographicManager;
import com.clathrop.infographyl.dao.InfographicManagerImpl;
import com.clathrop.infographyl.model.Infographic;
import com.clathrop.infographyl.model.JsonJTableInfographicBean;

import java.util.List;

/**
 * Created by clathrop on 4/4/15.
 */
public class jTableTest {



    public static void main(String[] args){

        testListInfographics();


    }


    private static void testListInfographics(){
        InfographicManager igManager = new InfographicManagerImpl();

        List<JsonJTableInfographicBean> igList = igManager.listInfographics(0, 3);

        for(JsonJTableInfographicBean jsonIg : igList){
            System.out.println(jsonIg.toString());
        }

    }

}
