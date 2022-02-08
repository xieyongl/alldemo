package com.example.alldemo.thread.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @description: TODO
 * @author: xieyong
 * @date: 2022/1/18 14:56
 **/
public class CallableResult {

    static volatile Integer count = 0;

    public static void main(String[] args) {

//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtConfig.class);


//        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newFixedThreadPool(1000); //开启线程池

        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(20); //阻塞队列 这里意思是超过20个任务等待,就会执行拒绝策略（默认抛出异常？）
        ExecutorService executorService1 = new ThreadPoolExecutor(1, 2,
                1, TimeUnit.SECONDS, workQueue, new ThreadPoolExecutor.AbortPolicy());
        List<Future<String>> resultList = new ArrayList<Future<String>>();

        //创建10个任务并执行
        for (int i = 0; i < 100000; i++){
            //使用ExecutorService执行Callable类型的任务，并将结果保存在future变量中
            Future<String> future = executorService1.submit(new TaskWithResult(i));
            //将任务执行结果存储到List中
            resultList.add(future);
        }

        //遍历任务的结果
        for (Future<String> fs : resultList){
            try{
                while(!fs.isDone());//Future返回如果没有完成，则一直循环等待，直到Future返回完成
                System.out.println(fs.get());     //打印各个线程（任务）执行的结果
            }catch(InterruptedException e){
                e.printStackTrace();
            }catch(ExecutionException e){
                e.printStackTrace();
            }finally{
                //启动一次顺序关闭，执行以前提交的任务，但不接受新任务
                executorService.shutdown();
            }
        }
    }

}


class TaskWithResult implements Callable<String>{
    private int id;

    public TaskWithResult(int id){
        this.id = id;
    }

    /**
     * 任务的具体过程，一旦任务传给ExecutorService的submit方法，
     * 则该方法自动在一个线程上执行
     */
    public String call() throws Exception {
        System.out.println("call()方法被自动调用！！！    " + Thread.currentThread().getName());
        //该返回结果将被Future的get方法得到
        return "call()方法被自动调用，任务返回的结果是：" + id + "    " + Thread.currentThread().getName();
    }
}