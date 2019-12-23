package com.hwgif.configure.session;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableRedisHttpSession
public class SessionConfigure {

        @Value("${spring.redis.host}")
        private String redisHost;

        @Value("${spring.redis.port}")
        private int redisPort;

        @Value("${spring.redis.password}")
        private String redisPwd;

        @Bean
        public JedisConnectionFactory connectionFactory() {
            RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
            redisStandaloneConfiguration.setHostName(redisHost);
            redisStandaloneConfiguration.setDatabase(0);
            redisStandaloneConfiguration.setPassword(RedisPassword.of(redisPwd));
            redisStandaloneConfiguration.setPort(redisPort);

            return new JedisConnectionFactory(redisStandaloneConfiguration);
        }

}
