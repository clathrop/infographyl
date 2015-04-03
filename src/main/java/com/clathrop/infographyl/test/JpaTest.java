//package com.clathrop.infographyl.test;
//
//import com.clathrop.infographyl.model.Infographic;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//import java.util.List;
//
///**
// * Created by clathrop on 4/1/15.
// */
//public class JpaTest {
//
//    private EntityManager manager;
//
//    public JpaTest(EntityManager manager){
//        this.manager = manager;
//    }
//
//    public static void main(String[] args){
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");
//        EntityManager manager = factory.createEntityManager();
//        JpaTest test = new JpaTest(manager);
//
//        EntityTransaction tx = manager.getTransaction();
//        tx.begin();
//
//        try{
//            test.createInfographics();
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        tx.commit();
//
//        test.listInfographics();
//
//        System.out.println("... done");
//
//    }
//
//    private void createInfographics(){
//        int numOfIGs = manager.createQuery("from Infographic", Infographic.class).getResultList().size();
//        if(numOfIGs == 0){
//            Infographic ig1 = new Infographic("info1", "www.ingr.com/1");
//            Infographic ig2 = new Infographic("info2", "www.ingr.com/2");
//
//            manager.persist(ig1);
//            manager.persist(ig2);
//        }
//    }
//
//    private void listInfographics(){
//        List<Infographic> resultList = manager.createQuery("from Infographic", Infographic.class).getResultList();
//        System.out.println("num of infographics: " + resultList.size());
//        for(Infographic i : resultList){
//            System.out.println("ID: " + i.getId() + " Name: " + i.getName() + " URL: " + i.getUrl());
//        }
//    }
//
//
//}
