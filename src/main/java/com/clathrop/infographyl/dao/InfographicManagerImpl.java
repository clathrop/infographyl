package com.clathrop.infographyl.dao;

import com.clathrop.infographyl.model.Infographic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void insertInfographic(Infographic infographic){
        infographicDao.insertInfographic(infographic);
    }

    @Override
    public List<Infographic> findAllInfographics(){
        return infographicDao.findAllInfographics();
    }

}
