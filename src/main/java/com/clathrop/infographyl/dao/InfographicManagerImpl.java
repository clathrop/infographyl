package com.clathrop.infographyl.dao;

import com.clathrop.infographyl.model.Infographic;
import com.clathrop.infographyl.model.JsonJTableInfographicBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clathrop on 4/2/15.
 */
@Service
public class InfographicManagerImpl implements InfographicManager{

    @Autowired
    private InfographicDao infographicDao;

    @Override
    @Transactional
    public void insertInfographic(JsonJTableInfographicBean infographicBean){
        Infographic infographic = new Infographic();
        infographic.setName(infographicBean.getName());
        infographic.setDescription(infographicBean.getDescription());
        infographic.setUrl(infographicBean.getUrl());
        infographic.setCategory(infographicBean.getCategory());
        infographic.setTags(infographicBean.getTags());
        infographicDao.insertInfographic(infographic);
    }

    @Override
    public List<Infographic> findAllInfographics(){
        return infographicDao.findAllInfographics();
    }

    @Override
    public Infographic getRandomInfographic(){
        int rowCount = infographicDao.getRowCount();
        return infographicDao.getRandomInfographic(rowCount);
    }

    @Override
    public Integer getRowCount(){
        return infographicDao.getRowCount();
    }

    @Override
    public List<JsonJTableInfographicBean> listInfographics(Integer startIndex, Integer pageSize){

        List<JsonJTableInfographicBean> jsonIgList = new ArrayList<JsonJTableInfographicBean>();
        List<Infographic> igList = null;
        try{
            igList = infographicDao.listInfographics(startIndex, pageSize);
            for(Infographic ig : igList){
                JsonJTableInfographicBean jsonIg = new JsonJTableInfographicBean();
                jsonIg.setId(Integer.toString(ig.getId()));
                jsonIg.setName(ig.getName());
                jsonIg.setUrl(ig.getUrl());
                jsonIg.setDescription(ig.getDescription());
                jsonIg.setCategory(ig.getCategory());
                jsonIg.setTags(ig.getTags());
                jsonIgList.add(jsonIg);
            }
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }

        return jsonIgList;
    }

    @Override
    @Transactional
    public void updateInfographic(JsonJTableInfographicBean infographicBean){
        infographicDao.updateInfographic(infographicBean);
    }

}
