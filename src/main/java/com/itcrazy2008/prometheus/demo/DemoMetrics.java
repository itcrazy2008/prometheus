package com.itcrazy2008.prometheus.demo;

import java.util.concurrent.atomic.AtomicInteger;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;

public class DemoMetrics implements MeterBinder {
  AtomicInteger count = new AtomicInteger(0);

  @Override
  public void bindTo(MeterRegistry meterRegistry) {
    Gauge.builder("demo.count", count, c -> c.incrementAndGet())
        .tags("datacent", "ds1","region","sh","county","jd")//key value ....
        .description("demo of custom meter binder")
        .register(meterRegistry);
  }
}

