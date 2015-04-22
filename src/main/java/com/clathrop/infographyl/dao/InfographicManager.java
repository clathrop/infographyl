package com.clathrop.infographyl.dao;

import com.clathrop.infographyl.model.Infographic;
import com.clathrop.infographyl.model.JsonJTableInfographicBean;

import java.util.List;

/**
 * Created by clathrop on 4/2/15.
 */
public interface InfographicManager {

    void insertInfographic(JsonJTableInfographicBean infographicBean);
    List<Infographic> findAllInfographics();
    Infographic getRandomInfographic();
    Integer getRowCount();
    List<JsonJTableInfographicBean> listInfographics(Integer startIndex, Integer pageSize);
    void updateInfographic(JsonJTableInfographicBean infographicBean);
    List<Infographic> findInfographicsForCategory(String category);
    Infographic findInfographicForId(Integer id);
}
