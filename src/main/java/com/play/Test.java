package com.play;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author: guoyongkui
 * @date: 2020/12/12 20:06
 * @projectName: holdon
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        //数据队列，容量20
        ArrayBlockingQueue<Integer> dataQueue = new ArrayBlockingQueue<>(20);
        //线程池
        ExecutorService threadPool = Executors.newCachedThreadPool();

        //生产者线程启动
        for(int i=0; i<7; i++){
            threadPool.submit(new Producer(dataQueue));
        }

        //消费者线程启动
        for(int i=0; i<3; i++){
            threadPool.submit(new Consumer(dataQueue));
        }

        threadPool.shutdown();
    }


    /**
     * 生产者线程
     */
    static class Producer implements Callable<Integer> {
        //数据队列
        private ArrayBlockingQueue<Integer> dataQueue;
        private static Random random= new Random();
        public Producer(ArrayBlockingQueue<Integer> dataQueue) {
            this.dataQueue = dataQueue;
        }

        @Override
        public Integer call() throws Exception {
            //生产数据
            int data = random.nextInt(10);
            dataQueue.put(data);
            return data;
        }
    }


    /**
     * 消费者线程
     */
    static class Consumer implements Callable<Integer> {
        ArrayBlockingQueue<Integer> dataQueue;

        public Consumer(ArrayBlockingQueue<Integer> dataQueue) {
            this.dataQueue = dataQueue;
        }

        @Override
        public Integer call() throws Exception {
            //循环消费处理数据
            while(true){
                //从数据队列中取数据
                int data = dataQueue.take();
                try{
                    int result = dealData(data);
                    System.out.println("消费线程-" + Thread.currentThread().getName() + "处理数据" + data + "的结果为:" +result);
                }catch (Exception e){
                    System.out.println("消费线程-"+Thread.currentThread().getName()+"处理数据"+data +"出错,原因为:"+e); //异常处理
                }
            }
        }


        /**
         * 处理数据
         * @param data
         * @return
         * @throws Exception
         */
        Integer dealData(Integer data) throws InterruptedException, ExecutionException {
            //生成处理线程线池（5个线程）
            ExecutorService es = Executors.newFixedThreadPool(5);
            List<Callable<Integer>> cdCallList = new ArrayList<>();
            for (int i = 0; i < 5; i++){
                cdCallList.add(new CustomerDispose(data));
            }
            //获取结果
            List<Future<Integer>> resultFutures = es.invokeAll(cdCallList);
            int result = 0;
            for(Future<Integer> t : resultFutures){
                result = result + t.get();
            }
            es.shutdown();
            return result;
        }
    }

    static class CustomerDispose implements Callable<Integer> {

        /**
         * 待处理的数据
         */
        private Integer data;

        public CustomerDispose(Integer data) {
            this.data = data;
        }

        @Override
        public Integer call() throws Exception {
            return data + 1;
        }

    }
}
