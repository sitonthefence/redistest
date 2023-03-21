package com.atguigu.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

public class JedisDemo1 {
    public static void main(String[] args) {
        Jedis jedis=new Jedis("saic01.top",6379);
        String value =jedis.ping() ;
        System.out.println(value);

    }

 @Test
    public void demo1(){
     Jedis jedis=new Jedis("saic01.top",6379);
     Set<String> keys = jedis.keys("*");
     for(String key:keys){
         System.out.println(key);
     }


 }

}
