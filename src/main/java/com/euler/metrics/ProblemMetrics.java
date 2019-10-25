package com.euler.metrics;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.binder.jvm.JvmGcMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmMemoryMetrics;
import io.micrometer.core.instrument.binder.system.ProcessorMetrics;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.stream.Collectors.joining;

public class ProblemMetrics {
  public static void main(String[] args) {
    measure(() -> {
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
  }

  public static void measure(Runnable r) {
    MeterRegistry registry = new SimpleMeterRegistry();
    new JvmGcMetrics().bindTo(registry);
    new JvmMemoryMetrics().bindTo(registry);
    new ProcessorMetrics().bindTo(registry);

    List<Double> heapUtilization = new ArrayList<>();
    List<Double> cpuUtilization = new ArrayList<>();

    Disposable memoryProcessorMeasurements = Flux.interval(Duration.ofSeconds(1))
      .doOnEach(n -> {
        heapUtilization.add(registry.get("jvm.memory.used")
          .tag("area", "heap")
          .gauges()
          .stream()
          .mapToDouble(Gauge::value)
          .sum());

        cpuUtilization.add(registry.get("process.cpu.usage").gauge().value());
      })
      .subscribe();

    Timer timer = registry.timer("problem");

    try {
      timer.record(r);
    }
    finally {
      memoryProcessorMeasurements.dispose();

      System.out.println("CPU: " + cpuUtilization.stream().map(n -> (int) (n * 100) + "%")
        .collect(joining(", ")));
      System.out.println("Memory: " + heapUtilization.stream().map(n -> humanReadableByteCount(n.longValue()))
        .collect(joining(", ")));
      System.out.println("Execution time: " + timer.max(TimeUnit.SECONDS) + "s");
    }
  }

  private static String humanReadableByteCount(long bytes) {
    if (bytes < 1000) return bytes + "b";
    int exp = (int) (Math.log(bytes) / Math.log(1000));
    String pre = "kmgtpe".charAt(exp-1) + "";
    return String.format("%.1f%sb", bytes / Math.pow(1000, exp), pre);
  }
}
