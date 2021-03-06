package com.itcrazy2008.prometheus;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.itcrazy2008.prometheus.demo.DemoMetrics;

import io.micrometer.core.instrument.MeterRegistry;

@SpringBootApplication
public class PrometheusApplication {

	public static void main(String[] args) {
        SpringApplication.run(PrometheusApplication.class, args);
	}

    @Bean
    public MeterRegistryCustomizer<MeterRegistry> configurer(@Value("${spring.application.name}") String applicationName) {
      //采集各种指标
	    return (registry) -> registry.config().commonTags("application", applicationName);
    }

  @Bean
  public DemoMetrics demoMetrics(){
	  //自定义指标
    //启动后访问 curl -i http://localhost:8080/actuator/metrics/demo.count
    return new DemoMetrics();
  }

}
