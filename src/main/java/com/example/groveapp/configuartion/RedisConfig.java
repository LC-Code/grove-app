package com.example.groveapp.configuartion;

        import com.fasterxml.jackson.databind.ObjectMapper;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.data.redis.connection.RedisConnectionFactory;
        import org.springframework.data.redis.core.RedisTemplate;
        import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
        import org.springframework.data.redis.serializer.RedisSerializer;
        import org.springframework.data.redis.serializer.SerializationException;
        import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
    @Bean("redisTemplate")
    public RedisTemplate<String,Object> getRedisTemplate(RedisConnectionFactory connectionFactory, ObjectMapper mapper){
        RedisTemplate<String,Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
//        template.setValueSerializer(new Jackson2JsonRedisSerializer(Object.class));

        template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer(mapper));
        return template;
    }
}
