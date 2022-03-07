package com.example.alldemo;

import com.example.alldemo.thread.async.AsyncTasks;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CompletableFuture;

/**
 * @description: TODO
 * @author: xieyong
 * @date: 2022/2/16 14:44
 **/

@Slf4j
@SpringBootTest
public class AsyncTest {

    @Autowired
    private AsyncTasks asyncTasks;



    @Test
    public void test() throws Exception {
        long start = System.currentTimeMillis();

        String s = "&";
        System.out.println(s.length());


        CompletableFuture<String> task1 = asyncTasks.doTaskOne();
        CompletableFuture<String> task2 = asyncTasks.doTaskTwo();
        CompletableFuture<String> task3 = asyncTasks.doTaskThree();
        CompletableFuture.allOf(task1, task2, task3).join();
        long end = System.currentTimeMillis();

        log.info("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }
}