package com.zhenxin.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class RedusTest {
    @Test
    public void test(){
        Jedis jedis=new Jedis("120.78.185.109",6379);
        jedis.set("name","tomcat");
        System.out.println(jedis.get("name"));
    }


}