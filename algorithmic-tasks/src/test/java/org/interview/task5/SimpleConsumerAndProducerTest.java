package org.interview.task5;

import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

class SimpleConsumerAndProducerTest {

    @Test
    void test() {
        final BlockingQueue<SimpleConsumerAndProducer.Message> queue = new LinkedBlockingQueue<>(10);

        final SimpleConsumerAndProducer.SimpleProducer simpleProducer = new SimpleConsumerAndProducer.SimpleProducer(queue);
        final SimpleConsumerAndProducer.SimpleConsumer simpleConsumer = new SimpleConsumerAndProducer.SimpleConsumer(queue);

        final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        executorService.submit(simpleConsumer);
        executorService.submit(simpleConsumer);
        executorService.submit(simpleConsumer);
        executorService.submit(simpleConsumer);
        executorService.submit(simpleProducer);
        executorService.submit(simpleProducer);
        executorService.submit(simpleProducer);
        executorService.submit(simpleProducer);
    }

}
