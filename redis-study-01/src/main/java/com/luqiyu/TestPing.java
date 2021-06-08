package com.luqiyu;

import redis.clients.jedis.Jedis;

/**
 * 测试连接redis
 *
 * @author: 启誉
 * @create: 2021-05-11
 **/
public class TestPing {
    public static void main(String[] args) {
        //不能使用127.0.0.1 报错
        Jedis jedis = new Jedis("192.168.89.128",6379);
        System.out.println(jedis.ping());
        jedis.set("testKey","testValue");
        System.out.println(jedis.get("testKey"));
    }
}
