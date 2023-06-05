package com.example.alldemo.thread.pageQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class ThredQuery  implements Callable<List<Map<String, Object>>> {
    private Object myService;//需要通过够早方法把对应的业务service传进来 实际用的时候把类型变为对应的类型
    private String sex;//查询条件 根据条件来定义该类的属性

    private int bindex;//分页index
    private int num;//数量

    /**
     * 重新构造方法
     * @param myService
     * @param sex
     * @param bindex
     * @param num
     */
    public ThredQuery(Object myService,String sex,int bindex,int num){
        this.myService=myService;
        this.sex=sex;
        this.bindex=bindex;
        this.num=num;
    }

    @Override
    public List<Map<String, Object>> call() throws Exception {
        //通过service查询得到对应结果
        List<Map<String, Object>>  list  =new ArrayList<>(); //myService.queryBySex(sex,bindex,num);

        return list;
    }
}