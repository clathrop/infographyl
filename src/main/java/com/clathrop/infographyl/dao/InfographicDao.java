package com.clathrop.infographyl.dao;

import com.clathrop.infographyl.model.Infographic;
import com.clathrop.infographyl.model.JsonJTableInfographicBean;

import java.util.List;

public interface InfographicDao{

    void insertInfographic(Infographic infographic);
    List<Infographic> findAllInfographics();
    Infographic getRandomInfographic(Integer tableSize);
    Integer getRowCount();
    List<Infographic> listInfographics(Integer startIndex, Integer pageSize);
    //void updateInfographic(Infographic infographic);
    void updateInfographic(JsonJTableInfographicBean infographic);
    List<Infographic> findInfographicsForCategory(String category);

}