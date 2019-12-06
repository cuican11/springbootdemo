package com.hwgif.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

/**
 * Created by lc.huang on 2019/11/20.
 * Description
 */
@Configuration
public class RedisCacheConfig {
        // 使用Redis缓存采用Jackson进行序列化与反序列化是实体类不需要实现java.io.Serializable接口
        // 不使用springboot默认采用JDK进行序列化的操作，通过以下配置修改为基于Jackson的序列化操作
    @Bean
    public RedisCacheConfiguration redisCacheConfiguration(){
        //加载redis缓存的默认配置
        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig();
        configuration = configuration.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
        return configuration;
    }
}
