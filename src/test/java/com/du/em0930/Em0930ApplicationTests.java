package com.du.em0930;

import com.du.em0930.entity.MyUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Em0930ApplicationTests {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Test
    void contextLoads() {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        MyUser user = MyUser.builder()
                .name("test2")
                .email("test3@text.com")
                .password("9879616")
                .build();

        em.persist(user); //영속성

        user.setName("test3");

        em.flush();
        tx.commit();
        em.close();

    }


    @Test
    void testTemplate() {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();


        em.flush();
        tx.commit();
        em.close();

    }

    @Test
    void testFind() {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        MyUser user = em.find(MyUser.class, 2L);
        System.out.println(user);

        //user.setPassword("8178418");

        em.flush();
        tx.commit();
        em.close();

    }

    @Test
    void testMerge() {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();


        MyUser user = MyUser.builder()
                .id(1L)
                .name("admin")
                .email("admin@gmail.com")
                .password("149819")
                .build();

        em.merge(user); //영속성

        em.flush();
        tx.commit();
        em.close();

    }


    @Test
    void testRemove() {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        MyUser user = em.find(MyUser.class, 3L);

        em.remove(user);

        em.flush();
        tx.commit();
        em.close();

    }

    @Test
    void testSelectAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        List<MyUser> list = em.createQuery("select e from MyUser e", MyUser.class).getResultList();
        for (MyUser user : list) {
            System.out.println(user);
            //user.setName("test");
        }

        em.flush();
        tx.commit();
        em.close();

    }
}
