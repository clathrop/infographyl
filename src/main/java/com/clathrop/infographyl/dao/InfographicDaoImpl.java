package com.clathrop.infographyl.dao;

import com.clathrop.infographyl.model.Infographic;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by clathrop on 4/2/15.
 */
@Repository
public class InfographicDaoImpl implements InfographicDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void insertInfographic(Infographic infographic){
        try{
            entityManager.persist(infographic);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

    }

    @Override
    public List<Infographic> findAllInfographics(){
        try{
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Infographic> cq = builder.createQuery(Infographic.class);

            Root<Infographic> root = cq.from(Infographic.class);
            cq.select(root);
            List<Infographic> igList = entityManager.createQuery(cq).getResultList();
            return igList;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Infographic getRandomInfographic(Integer tableSize){
        Random rand = new Random();
        int randomIndex = rand.nextInt((tableSize-1)+1) + 1;

        try{
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Infographic> cq = builder.createQuery(Infographic.class);

            Root<Infographic> root = cq.from(Infographic.class);
            cq.select(root);
            cq.where(builder.equal(root.<Integer>get("id"), randomIndex));
            Infographic randomIg = entityManager.createQuery(cq).getSingleResult();
            return randomIg;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }


    }

    @Override
    public Integer getRowCount(){
        try{
            Number result = (Number) entityManager.createNativeQuery("Select count(id) from infographics").getSingleResult();
            return result.intValue();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Infographic> listInfographics(Integer startIndex, Integer pageSize){
        List<Infographic> igList = new ArrayList<Infographic>();

        String sStartIndex = Integer.toString(startIndex);
        String sPageSize = Integer.toString(pageSize);

        try{
            List list = entityManager.createNativeQuery("Select * from infographics limit " + sStartIndex + ", " + sPageSize).getResultList();
            for(Object ig : list){
                igList.add((Infographic) ig);
            }
            return igList;
        } catch(Exception e){
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }


    }


}
