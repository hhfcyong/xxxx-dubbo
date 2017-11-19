package com.xxxx.redis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.BinaryClient;
import redis.clients.jedis.BinaryClient.LIST_POSITION;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class xxxxJedisPool {
	private static final Log log = LogFactory.getLog(xxxxJedisPool.class);
	JedisPool pool=null;
	Jedis jedis =null;
	ClassPathXmlApplicationContext context=null;
	/**
	 * 构造函数，初始化jedis连接池
	 */
    public xxxxJedisPool(){
    	try{
    		context = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");
			context.start();
		     pool = (JedisPool) context.getBean("jedisPool"); 
		     jedis = pool.getResource();

    	}
        catch(Exception e){
        	log.error("==>redisCluster context start error:", e);
        	context.stop();
        	System.exit(0);
        } 	
    } 
    public Jedis getJedis(){
    	return jedis;
    }
    public static void main(String[] args){
    	Jedis jedis=new xxxxJedisPool().getJedis();
    	jedis.set("bigdata1", "bigdata is very good");
    	System.out.println("数据存储完毕，请检查！");
    }
}