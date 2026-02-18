package com.alexjr.activemq.config;

import jakarta.jms.ConnectionFactory;
import org.apache.qpid.jms.JmsConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@Configuration
@EnableJms
public class JmsConfig {

  @Bean
  public ConnectionFactory connectionFactory(
      @Value("${AMQP_URL}") String url,
      @Value("${AMQP_USER}") String user,
      @Value("${AMQP_PASS}") String pass
  ) {
    return new JmsConnectionFactory(user, pass, url);
  }
}