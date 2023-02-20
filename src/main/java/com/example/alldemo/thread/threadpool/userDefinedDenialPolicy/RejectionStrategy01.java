package com.example.alldemo.thread.threadpool.userDefinedDenialPolicy;

import com.example.alldemo.thread.threadpool.ThreadReader;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @description: 自定义线程池拒绝策略
 * @author: xieyong
 * @date: 2022/11/17 16:44
 **/
@Slf4j
public class RejectionStrategy01 implements RejectedExecutionHandler {

    static ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(10);


    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

        if (r != null) {
            threadPoolExecutor.execute(r);
            log.info("被拒绝线程再次执行！");
        }

    }
}