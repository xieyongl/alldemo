package com.example.alldemo.thread.threadpool;

import com.example.alldemo.thread.threadpool.userDefinedDenialPolicy.RejectionStrategy01;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @description: TODO
 * @author: xieyong
 * @date: 2022/11/17 16:09
 **/
public class ThreadPoolService {


    /**
     * 自定义线程名称,方便的出错的时候溯源
     */
    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("test-pool-%d").build();

    /**
     * corePoolSize    线程池核心池的大小
     * maximumPoolSize 线程池中允许的最大线程数量
     * keepAliveTime   当线程数大于核心时，此为终止前多余的空闲线程等待新任务的最长时间
     * unit            keepAliveTime 的时间单位
     * workQueue       用来储存等待执行任务的队列
     * threadFactory   创建线程的工厂类
     * handler         拒绝策略类,当线程池数量达到上线并且workQueue队列长度达到上限时就需要对到来的任务做拒绝处理
     */
    private static ExecutorService service = new ThreadPoolExecutor(
            2,
            4,
            0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(100),
//            namedThreadFactory,
            new RejectionStrategy01()
    );

    /**
     * 获取线程池
     *
     * @return 线程池
     */
    public static ExecutorService getEs() {
        return service;
    }

    /**
     * 使用线程池创建线程并异步执行任务
     *
     * @param r 任务
     */
    public static void newTask(Runnable r) {
        service.execute(r);
    }


    public static void main(String[] args) {
        final ExecutorService es = getEs();
        for (int i = 0; i < 10000; i++) {
            int finalI = i;
            es.execute(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName() + " hello--" + finalI);
                    }
                });
        }
    }

}