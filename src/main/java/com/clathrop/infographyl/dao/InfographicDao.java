package com.clathrop.infographyl.dao;

import com.clathrop.infographyl.model.Infographic;

import java.util.List;

public interface InfographicDao{

    void insertInfographic(Infographic infographic);
    List<Infographic> findAllInfographics();
}