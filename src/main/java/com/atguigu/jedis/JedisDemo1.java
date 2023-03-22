package com.atguigu.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
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
     jedis.set("name","lucy");
     jedis.mset("k1","v1","k2","v2");
     List<String> mget = jedis.mget("k1", "k2");
     System.out.println(mget);

     String name = jedis.get("name");
     System.out.println(name);
     for(String key:keys){
         System.out.println(key);
     }


 }
 @Test
 public void demo2(){
     Jedis jedis=new Jedis("saic01.top",6379);
     jedis.lpush("key1","lucy","mary","jack");
     List<String> values = jedis.lrange("key1", 0, -1);
     System.out.println(values);


 }
 @Test
    public void demo3(){
        Jedis jedis=new Jedis("saic01.top",6379);
        jedis.sadd("name","lucy","jack");
     Set<String> name = jedis.smembers("name");
     System.out.println(name);
 }
}
