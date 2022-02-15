package com.example.alldemo.thread.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @description: TODO
 * @author: xieyong
 * @date: 2022/2/14 16:05
 **/
public class CallablePrintDemo {

    public static void main(String[] args) {

        List<Future> list = new ArrayList<>();

        ExecutorService pool = Executors.newFixedThreadPool(6);
        for (int j = 0; j < 1000; j++) {
            FutureTask<String> future = (FutureTask<String>) pool.submit(new PrintTask(j));
            list.add(future);
        }

        for (Future<String> f : list){
            try {
                while (!f.isDone()) ;//Future返回如果没有完成，则一直循环等待，直到Future返回完成
                System.out.println(f.get());     //打印各个线程（任务）执行的结果
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                //启动一次顺序关闭，执行以前提交的任务，但不接受新任务
                pool.shutdown();
            }
        }
    }

}

class PrintTask implements Callable<String> {

    private int i;

    PrintTask(int i) {
        this.i = i;
    }

    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName() + " call方法被调用！ 任务返回结果为：" + i;
    }
}