package com.clathrop.infographyl.dao;

import com.clathrop.infographyl.model.Infographic;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by clathrop on 4/2/15.
 */
@Repository
public class InfographicDaoImpl implements InfographicDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertInfographic(Infographic infographic){
        entityManager.persist(infographic);
    }

    @Override
    public List<Infographic> findAllInfographics(){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Infographic> cq = builder.createQuery(Infographic.class);

        Root<Infographic> root = cq.from(Infographic.class);
        cq.select(root);
        return entityManager.createQuery(cq).getResultList();

    }
}
