package com.luqiyu;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * 测试redis的事务
 *
 * @author: 启誉
 * @create: 2021-05-11
 **/
public class TestTX {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.89.128",6379);
        System.out.println(jedis.get("testKey"));
        //清空数据库的所有键,方便不变user1测试
        jedis.flushDB();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello", "redis");
        jsonObject.put("name", "luqiyu");

        Transaction multi = jedis.multi();
        String result = jsonObject.toJSONString();
        try {
            multi.set("user1", result);
            multi.set("user2", result);
            int i = 1 / 0;
            multi.exec();
        } catch (Exception e) {
            multi.discard();
            e.printStackTrace();
        }finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            jedis.close();
        }
    }
}