package com.luqiyu;

import com.luqiyu.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisStudy02ApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("key","value");
        System.out.println(redisTemplate.opsForValue().get("key"));
        //需序列化
        User luqiyu = new User(1, "luqiyu");
        redisTemplate.opsForValue().set("luqiyu",luqiyu);
        System.out.println(redisTemplate.opsForValue().get("luqiyu"));

    }

}
