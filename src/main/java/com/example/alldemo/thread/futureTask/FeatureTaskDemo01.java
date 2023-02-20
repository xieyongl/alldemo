package com.example.alldemo.thread.futureTask;

import java.util.concurrent.*;

/**
 * @description: TODO 可用于异步获取执行结果或取消执行任务的场景。通过传入Runnable或者Callable的任务给FutureTask，
 * 直接调用其run方法或者放入线程池执行，之后可以在外部通过FutureTask的get方法异步获取执行结果，因此，FutureTask非常适合用于耗时的计算，
 * 主线程可以在完成自己的任务后，再去获取结果。另外，FutureTask还可以确保即使调用了多次run方法，它都只会执行一次Runnable或者Callable任务，
 * 或者通过cancel取消FutureTask的执行等
 * @author: xieyong
 * @date: 2022/11/11 17:18
 **/
public class FeatureTaskDemo01 {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        Task task = new Task();
        FutureTask<Integer> futureTask = new FutureTask<>(task);
        service.submit(futureTask);
        service.shutdown();
        System.out.println("主线程正在执行任务。。。");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            //阻塞直至任务完成
            System.out.println("-------------------------------------");
            System.out.println("执行结果为：" + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("任务执行完成。。。");
    }

    static class Task implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            try {
                System.out.println("从线程正在执行任务。。。");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int num = 0;
            for (int i = 0; i <= 100; i++) {
                num += i;
            }
            return num;
        }
    }
}