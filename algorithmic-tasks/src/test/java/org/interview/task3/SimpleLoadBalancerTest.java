package org.interview.task3;


import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

class SimpleLoadBalancerTest {

    @Test
    void getServiceUrl() throws InterruptedException {
        final ExecutorService executorService = Executors.newFixedThreadPool(20);
        final SimpleLoadBalancer simpleLoadBalancer = new SimpleLoadBalancer(List.of("Service 1", "Service 2", "Service 3", "Service 4", "Service 5"));

        final Callable<String> task = simpleLoadBalancer::getServiceUrl;
        final List<Callable<String>> tasks = IntStream.range(0, 30).mapToObj(e -> task).toList();

        final List<Future<String>> futures = executorService.invokeAll(tasks);

        futures.forEach(future -> {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
        executorService.shutdown();
        if (!executorService.awaitTermination(1, TimeUnit.SECONDS)) {
            executorService.shutdownNow();
        }
    }
}
