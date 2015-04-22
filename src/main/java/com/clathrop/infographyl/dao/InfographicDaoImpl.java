package com.clathrop.infographyl.dao;

import com.clathrop.infographyl.model.Infographic;
import com.clathrop.infographyl.model.JsonJTableInfographicBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.sound.midi.MidiDevice;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by clathrop on 4/2/15.
 */
@Repository
public class InfographicDaoImpl implements InfographicDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public void insertInfographic(Infographic infographic) {
        try {
            entityManager.persist(infographic);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

    }

    @Override
    public List<Infographic> findAllInfographics() {
        try {
            Query query = entityManager.createQuery("from Infographic");

            List<Infographic> igList = query.getResultList();
            return igList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Infographic getRandomInfographic(Integer tableSize) {
        Random rand = new Random();
        int randomIndex = rand.nextInt((tableSize - 1) + 1) + 1;

        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Infographic> cq = builder.createQuery(Infographic.class);

            Root<Infographic> root = cq.from(Infographic.class);
            cq.select(root);
            cq.where(builder.equal(root.<Integer>get("id"), randomIndex));
            Infographic randomIg = entityManager.createQuery(cq).getSingleResult();
            return randomIg;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }


    }

    @Override
    public Integer getRowCount() {
        try {
            Number result = (Number) entityManager.createNativeQuery("Select count(id) from infographics").getSingleResult();
            return result.intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Infographic> listInfographics(Integer startIndex, Integer pageSize) {
        List<Infographic> igList;

        String sStartIndex = Integer.toString(startIndex);
        String sPageSize = Integer.toString(pageSize);

        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Infographic> cq = builder.createQuery(Infographic.class);

            Root<Infographic> root = cq.from(Infographic.class);
            cq.select(root);
            igList = entityManager.createQuery(cq).setFirstResult(startIndex).setMaxResults(pageSize).getResultList();
            return igList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }

    @Override
    @Transactional
    public void updateInfographic(JsonJTableInfographicBean infographicBean) {
        try {
            Infographic ig = entityManager.find(Infographic.class, Integer.parseInt(infographicBean.getId()));

            ig.setName(infographicBean.getName());
            ig.setUrl(infographicBean.getUrl());
            ig.setDescription(infographicBean.getDescription());
            ig.setCategory(infographicBean.getCategory());
            ig.setTags(infographicBean.getTags());
            entityManager.merge(ig);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Infographic> findInfographicsForCategory(String category) {
        List<Infographic> igList;

        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Infographic> cq = builder.createQuery(Infographic.class);

            Root<Infographic> root = cq.from(Infographic.class);
            cq.select(root);
            cq.where(builder.like(root.<String>get("category"), category));
            igList = entityManager.createQuery(cq).getResultList();

            return igList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }

    }

    @Override
    public Infographic findInfographicForId(Integer id){
        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Infographic> cq = builder.createQuery(Infographic.class);

            Root<Infographic> root = cq.from(Infographic.class);
            cq.select(root);
            cq.where(builder.equal(root.<Integer>get("id"), id));
            Infographic infographic = entityManager.createQuery(cq).getSingleResult();
            return infographic;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }

    }


}
