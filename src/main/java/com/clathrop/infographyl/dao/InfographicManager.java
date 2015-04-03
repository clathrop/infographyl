package com.clathrop.infographyl.dao;

import com.clathrop.infographyl.model.Infographic;

import java.util.List;

/**
 * Created by clathrop on 4/2/15.
 */
public interface InfographicManager {

    void insertInfographic(Infographic infographic);
    List<Infographic> findAllInfographics();

}
