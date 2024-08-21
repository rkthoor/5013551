package com.example.bookstoreapi.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Counter;
import org.springframework.stereotype.Component;

@Component
public class CustomMetrics {

    private final Counter bookAddedCounter;

    public CustomMetrics(MeterRegistry meterRegistry) {
        this.bookAddedCounter = meterRegistry.counter("books.added");
    }

    public void incrementBookAdded() {
        bookAddedCounter.increment();
    }
}
