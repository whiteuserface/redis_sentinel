package com.example.redis_sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.test.context.ContextConfiguration;

@SpringBootApplication
public class Redis_sentinelApplication {

	public static void main(String[] args) {
		SpringApplication.run(Redis_sentinelApplication.class, args);
	}

}
