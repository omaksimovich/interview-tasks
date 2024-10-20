package org.interview.task5;

import java.util.concurrent.BlockingQueue;

public class SimpleConsumerAndProducer {

    public record Message(String id, String body) {
    }

    public static class SimpleProducer implements Runnable {

        public SimpleProducer(BlockingQueue<Message> queue) {

        }


        @Override
        public void run() {

        }
    }

    public static class SimpleConsumer implements Runnable {

        public SimpleConsumer(BlockingQueue<Message> queue) {
        }

        @Override
        public void run() {

        }
    }
}
