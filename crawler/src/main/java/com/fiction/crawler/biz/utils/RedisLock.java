package com.fiction.crawler.biz.utils;

import com.fiction.crawler.web.config.RedisPoolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.Collections;

/**
 * @program: crawler
 * @description:
 * @author: zh
 * @create: 2019-12-26 16:51
 **/
@Component
public class RedisLock {
    //    @Autowired
//    private StringRedisTemplate redisTemplate;

    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";
    private static final Long RELEASE_SUCCESS = 1L;


    /**
     * 加锁--但是出现死锁情况下是没办法的。。。
     * 死锁：加锁之后，但是在解锁之前，业务中抛出了异常，从而没有走解锁这个步骤，从而导致锁永远没法解
     */
//    public boolean lock1(String key, String value) {
//        //setIfAbsent相当于jedis中的setnx，如果能赋值就返回true，如果已经有值了，就返回false
//        //即：在判断这个key是不是第一次进入这个方法
//        if (redisTemplate.opsForValue().setIfAbsent(key, value)) {
//            //第一次，即：这个key还没有被赋值的时候
//            return true;
//        }
//        return false;
//    }


    /**
     * 加锁---解决死锁情况：即判断是否超时
     * key：表示商品id
     * value：表示当前毫秒数+设定的超时毫秒数，即什么时候过期
     * 虽然解决了死锁问题，但是如果两个线程同时进入这个方法还是有问题的
     */
//    public boolean lock2(String key, String value) {
//        //setIfAbsent相当于jedis中的setnx，如果能赋值就返回true，如果已经有值了，就返回false
//        //即：在判断这个key是不是第一次进入这个方法
//        if (redisTemplate.opsForValue().setIfAbsent(key, value)) {
//            //第一次，即：这个key还没有被赋值的时候
//            return true;
//        }
//        String current_value = redisTemplate.opsForValue().get(key);
//        if (!MyStringUtils.Object2String(current_value).equals("")
//                //超时了
//                && Long.parseLong(current_value) < System.currentTimeMillis()) {
//            //返回true就能解决死锁
//            return true;
//        }
//        return false;
//    }


    /**
     * 加锁
     */
//    public boolean lock3(String key, String value) {
//        //setIfAbsent相当于jedis中的setnx，如果能赋值就返回true，如果已经有值了，就返回false
//        //即：在判断这个key是不是第一次进入这个方法
//        if (redisTemplate.opsForValue().setIfAbsent(key, value)) {
//            //第一次，即：这个key还没有被赋值的时候
//            return true;
//        }
//        String current_value = redisTemplate.opsForValue().get(key);
//        if (!MyStringUtils.Object2String(current_value).equals("")
//                //超时了
//                && Long.parseLong(current_value) < System.currentTimeMillis()) {//①
//            String old_value = redisTemplate.opsForValue().getAndSet(key, value);//②
//            if (!MyStringUtils.Object2String(old_value).equals("")
//                    //如果两个线程同时调用这个方法，当同时走到①的时候，
//                    // 无论怎么样都有一个线程会先执行②这一行，
//                    //假设线程1先执行②这行代码，那redis中key对应的value就变成了value
//                    //然后线程2再执行②这行代码的时候，获取到的old_value就是value，
//                    //那么value显然和他上面获取的current_value是不一样的，则线程2是没法获取锁的
//                    && old_value.equals(current_value)) {
//                return true;
//            }
//        }
//        return false;
//    }
    public boolean lock4(Jedis jedis,String key, String value) {
        //使用jedis的方式
        //setIfAbsent相当于jedis中的setnx，如果能赋值就返回true，如果已经有值了，就返回false
        //即：在判断这个key是不是第一次进入这个方法redisTemplate.opsForValue().setIfAbsent(key, value)
        if(jedis.setnx(key,value)>0){
            return true;
        }
        String current_value = jedis.get(key);
        if (!MyStringUtils.Object2String(current_value).equals("")
                //超时了
                && Long.parseLong(current_value) < System.currentTimeMillis()) {//①
            String old_value = jedis.getSet(key, value);
            if (!MyStringUtils.Object2String(old_value).equals("")
                    //如果两个线程同时调用这个方法，当同时走到①的时候，
                    // 无论怎么样都有一个线程会先执行②这一行，
                    //假设线程1先执行②这行代码，那redis中key对应的value就变成了value
                    //然后线程2再执行②这行代码的时候，获取到的old_value就是value，
                    //那么value显然和他上面获取的current_value是不一样的，则线程2是没法获取锁的
                    && old_value.equals(current_value)) {
                return true;
            }
        }

        return false;
    }
    public boolean lock5(Jedis jedis,String key,String value){
        String result = jedis.set(key, value, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, 1000);
        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }

    public boolean unlock5(Jedis jedis,String lockKey, String requestId){
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }



    public void unlock4(Jedis jedis,String key, String value){
        try {
            if(MyStringUtils.Object2String(jedis.get(key)).equals(value)){
                jedis.del(key);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


//    public void unlock(String key, String value) {
//        try {
//            if (MyStringUtils.Object2String(redisTemplate.opsForValue().get(key)).equals(value)) {
//                redisTemplate.opsForValue().getOperations().delete(key);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
