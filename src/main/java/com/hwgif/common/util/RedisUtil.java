package com.hwgif.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Collections;


/**
 * redis工具类
 *
 */
@Component
public class RedisUtil {

    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";
    private static final Long RELEASE_SUCCESS = 1L;

    private static final Long EXPIRE_TIME = 1000L; //毫秒

    private static JedisPool jedisPool;

//    使用init方法进行初始化
    @Autowired
    public void init(JedisPool jedisPool){
        RedisUtil.jedisPool = jedisPool;
    }

    /**
     * 释放jedis资源
     *
     * @param jedis
     */
    @SuppressWarnings("deprecation")
    public static void returnResource(final Jedis jedis) {
        if (jedis != null && jedisPool != null) {
            jedisPool.returnResource(jedis);
        }
    }


    /**
     * 设置值
     *
     * @param key
     * @param value
     * @return -5：Jedis实例获取失败<br/>OK：操作成功<br/>null：操作失败
     * @author jqlin
     */
    public static String set(String key, String value) {

        Jedis jedis = RedisUtil.jedisPool.getResource();

        String result = null;
        try {
            result = jedis.set(key, value);
        } catch (Exception e) {

        } finally {
        }

        return result;
    }


    /**
     * 获取值
     *
     * @param key
     * @return
     * @author jqlin
     */
    public static String get(String key) {

        Jedis jedis = jedisPool.getResource();
        String result = "";
        try {
            result = jedis.get(key);
        } catch (Exception e) {
//            log.error("获取值失败：" + e.getMessage(), e);
//            returnBrokenResource(jedis);
        } finally {
            returnResource(jedis);
        }

        return result;
    }


    /**
     * 分布式锁  获取锁
     * 单机redis模式
     *
     */
     public static boolean getLock( String lockKey, String requestId, int expireTime) {
         Jedis jedis = jedisPool.getResource();
         try{
             String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);

             if (LOCK_SUCCESS.equals(result)) {
                 return true;
             }
         }catch (Exception e){

         }finally {

             returnResource(jedis);
         }

         return false;
     }

    /**
     * 释放锁
     * @param key
     * @return
     */
     public boolean releaseLock(String key,String value){
         Jedis jedis = jedisPool.getResource();
         String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
         Object result = jedis.eval(script, Collections.singletonList(key), Collections.singletonList(value));

         if (RELEASE_SUCCESS.equals(result)) {
             return true;
         }
         return false;
     }

}
