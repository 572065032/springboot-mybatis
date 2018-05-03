package org.spring.springboot.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import redis.clients.jedis.*;
@Service
public class jedisTest {

        @Autowired
        public JedisPool jedisPool;//非切片连接池

        private static jedisTest instance;

    public jedisTest() {
    }

    public void test(){
        Jedis j=jedisPool.getResource();
            j.set("aaaaa","11111");
            System.out.println(j.get("aaaaa"));
            j.close();
    }


    public static jedisTest getInstance(){
        if(instance==null){
            instance=new jedisTest();
        }
        return instance;
    }

    public static void setInstance(jedisTest instance) {
        jedisTest.instance = instance;
    }
}

