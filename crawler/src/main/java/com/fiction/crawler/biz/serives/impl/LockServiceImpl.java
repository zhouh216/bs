package com.fiction.crawler.biz.serives.impl;

import com.fiction.crawler.biz.serives.LockService;
import com.fiction.crawler.biz.utils.MyStringUtils;
import com.fiction.crawler.biz.utils.RedisLock;
import com.fiction.crawler.web.config.RedisPoolUtil;
import com.fiction.crawler.web.exception.CongestionException;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreMutex;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @program: crawler
 * @description:
 * @author: zh
 * @create: 2019-12-26 15:18
 **/
@Service("lockService")
public class LockServiceImpl implements LockService {

    @Autowired
    private CuratorFramework curatorFramework;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private RedisLock redisLock;
    @Autowired
    RedisPoolUtil redisPoolUtil;
    @Resource
    private Redisson redisson;

    public static final String PATH="/zookeeperLock/lock";
    //商品详情
    private static HashMap<String, Integer> product = new HashMap();
    //订单表
    private static HashMap<String, String> orders = new HashMap();
    //库存表
    private static HashMap<String, Integer> stock = new HashMap();
    static {
        product.put("123", 10000);
        stock.put("123", 10000);
    }
    /**
     * 高并发有问题
     *没有进行加锁操作 高并发出现问题  方法名改为order可进行测试
     * @param product_id
     * @return
     */
    public String order1(String product_id) {
        if (stock.get(product_id) == 0) {
            return "活动已经结束了";
            //已近买完了
        } else {
            //还没有卖完
            try {
                //模拟操作数据库
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            orders.put(MyStringUtils.getuuid(), product_id);
            stock.put(product_id, stock.get(product_id) - 1);
        }
        return select_info(product_id);
    }

    ////基于zookeeper进行分布式加锁
    @Override
    public String order(String productiD) throws CongestionException {
        InterProcessSemaphoreMutex balanceLock=new  InterProcessSemaphoreMutex(curatorFramework,PATH);
        try {
            //进行加锁操作
            //绝对阻塞
            if(balanceLock.acquire(100,TimeUnit.MILLISECONDS)){
                throw new CongestionException();
            }
            if (stock.get(productiD) == 0) {
                return "活动已经结束了";
                //已近买完了
            } else {
                //还没有卖完
                try {
                    //模拟操作数据库
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                orders.put(UUID.randomUUID().toString(), productiD);
                stock.put(productiD, stock.get(productiD) - 1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                balanceLock.release();
            }catch (Exception e){

            }
        }
        return select_info(productiD);
    }

    /**
     * 高并发没问题，效率还行
     *
//     * @param product_id
     * @return
     */
//    @Override
//    public String order(String product_id) throws CongestionException{
//        Jedis jedis = redisPoolUtil.getJedis();
//        /**
//         * redis加锁
//         */
//        try {
//            String value = System.currentTimeMillis() + 10000 + "";
//
//            if (!redisLock.lock5(jedis,product_id, value)) {
//                throw new CongestionException();
//            }
//            if (stock.get(product_id) == 0) {
//                return "活动已经结束了";
//                //已近买完了
//            } else {
//                //还没有卖完
//                try {
//                    //模拟操作数据库
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                orders.put(MyStringUtils.getuuid(), product_id);
//                stock.put(product_id, stock.get(product_id) - 1);
//            }
//            /**
//             * redis解锁
//             */
////        redisLock.unlock(jedis,product_id, value);
//            redisLock.unlock5(jedis,product_id, value);
//        }finally {
//            if(jedis!=null){
//                jedis.close();
//            }
//        }
//        return select_info(product_id);
//    }
//    @Override
//    public String order(String product_id) throws CongestionException{
//        /**
//         * redisson加锁
//         */
//        RLock lock = redisson.getLock(product_id);
//        try {
//           if(!lock.tryLock(50, TimeUnit.MILLISECONDS)){
//               throw new CongestionException();
//           }
//            if (stock.get(product_id) == 0) {
//                return "活动已经结束了";
//                //已近买完了
//            } else {
//                //还没有卖完
//                try {
//                    //模拟操作数据库
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                orders.put(MyStringUtils.getuuid(), product_id);
//                stock.put(product_id, stock.get(product_id) - 1);
//            }
//            /**
//             * redis解锁
//             */
////        redisLock.unlock(jedis,product_id, value);
//        }catch (InterruptedException e){
//
//        }finally {
//            if(lock!=null){
//                lock.unlock();
//            }
//        }
//        return select_info(product_id);
//    }




//    @Override
//    public String order(String productId) throws CongestionException{
//        InterProcessSemaphoreMutex balanceLock=new  InterProcessSemaphoreMutex(curatorFramework,PATH);
//        try {
//            //进行加锁操作
//            if(!balanceLock.acquire(10, TimeUnit.MILLISECONDS)){
//                throw new CongestionException();
//            };
//            if (stock.get(productId) == 0) {
//                return "活动已经结束了";
//                //已近买完了
//            } else {
//                //还没有卖完
//                try {
//                    //模拟操作数据库
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                orders.put(UUID.randomUUID().toString(), productId);
//                stock.put(productId, stock.get(productId) - 1);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            try {
//                balanceLock.release();
//            }catch (Exception e){
//
//            }
//        }
//        return select_info(productId);
//    }

    public String select_info(String product_id) {
        return "限量抢购商品XXX共" + product.get(product_id) + ",现在成功下单" + orders.size()
                + ",剩余库存" + stock.get(product_id) + "件";
    }
}
