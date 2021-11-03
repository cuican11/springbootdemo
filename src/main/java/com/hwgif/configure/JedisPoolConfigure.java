package com.hwgif.configure;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.concurrent.atomic.AtomicInteger;

@SpringBootConfiguration
public class JedisPoolConfigure {
    @Value("${jedis.pool.host}")
    private String host ="127.0.0.1";
    @Value("${jedis.pool.port}")
    private Integer port = 6379;
    @Value("${jedis.pool.password}")
    private String password ="";
    @Value("${jedis.pool.max-active}")
    private Integer maxActive = 1;
    @Value("${jedis.pool.host}")
    private String database ="127.0.0.1";
    private Integer connectTimeOut = 0;

    public JedisPoolConfig jedisPoolConfig(){    //这个是修改redis性能的时候需要的对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxActive);
        return jedisPoolConfig;
    }


      //这个注解注入工厂的名称是方法名
    @Bean(name = "jedisPool")
    @Primary
    public JedisPool jedisPool(){
        JedisPoolConfig jedisPoolConfig = jedisPoolConfig();
//        return new JedisPool(jedisPoolConfig,host,port, connectTimeOut,password);
        return new JedisPool(jedisPoolConfig,host,port);
    }


}
