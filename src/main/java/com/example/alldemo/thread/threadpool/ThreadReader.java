package com.example.alldemo.thread.threadpool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.concurrent.*;

/**
 * @description: TODO
 * @author: xieyong
 * @date: 2022/11/17 16:47
 **/
@Component
@Slf4j
public class ThreadReader {


    private static final BlockingQueue<Runnable> BLOCKING_QUEUE = new LinkedBlockingQueue<>();

    static ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(10);

    @Qualifier("thread-pool")
    @Autowired

    public static void put(Runnable runnable) {

        BlockingQueue<Runnable> blockingQueue = getBlockingQueue();
        try {
            //这里可以是将拒绝策略拒绝的线程再起线程执行
            threadPoolExecutor.execute(runnable);
            blockingQueue.put(runnable);
            log.info("被拒绝的线程已重新执行", runnable);
        } catch (InterruptedException e) {
            //再起线程执行失败的话就可以自定义处理，比如日志、数据库存储或者其他
        }
    }

    public void take() {
        BlockingQueue<Runnable> blockingQueue = getBlockingQueue();
        if (CollectionUtils.isEmpty(blockingQueue)) {
            return;
        }
        try {
            Runnable runnable = blockingQueue.take();
            log.info("取出当前线程池没来得及执行的任务, runnable=<{0}>", runnable);
            threadPoolExecutor.execute(runnable);
        } catch (InterruptedException e) {
            //
        }

    }

    public static BlockingQueue<Runnable> getBlockingQueue() {
        return BLOCKING_QUEUE;
    }
}