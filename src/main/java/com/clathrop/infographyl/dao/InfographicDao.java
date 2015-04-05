package com.clathrop.infographyl.dao;

import com.clathrop.infographyl.model.Infographic;

import java.util.List;

public interface InfographicDao{

    void insertInfographic(Infographic infographic);
    List<Infographic> findAllInfographics();
    Infographic getRandomInfographic(Integer tableSize);
    Integer getRowCount();
    List<Infographic> listInfographics(Integer startIndex, Integer pageSize);

}