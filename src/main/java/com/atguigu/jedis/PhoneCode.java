package com.atguigu.jedis;

import redis.clients.jedis.Jedis;

import java.util.Random;

public class PhoneCode {
    public static void main(String[] args) {
 String code=getCode();
        System.out.println(code);
    }
  public static java.lang.String getCode(){

      Random random=new Random();
      String code="";
      for(int i=0;i<6;i++){
          int rand=random.nextInt(10);
          code+=rand;
      }
      return code;
  }

 public static void veritifyCode(String phone,String code){
     Jedis jedis=new Jedis("saic01.top",6379);
     String countKey="VerifyCode"+phone+":count";
     String codeKey="VerifyCode"+phone+":code";
     String count = jedis.get(countKey);
     if(count==null){
         jedis.setex(countKey,24*60*60,"1");
     }else if(Integer.parseInt(count)<=2){
          jedis.incr(codeKey);
     }else if (Integer.parseInt(count)>2){
         System.out.println("今天发送超过三次");
         jedis.close();
     }
   String vcode=getCode();
     jedis.setex(codeKey,120,vcode);
     jedis.close();


 }

}
