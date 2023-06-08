package com.example.alldemo.designpattern.zerenlian;

public class Client {

    public static Handler getClient(){
        /**
         * 1、小于3天，需要组长审批
         * 2、3-5天，需要组长、部门领导审批
         * 3、大于5天，需要组长、部门领导、VP审批
         */
        Handler groupLeader = new GroupLeaderHandler(1);//组长审批
        Handler departmentLeader = new DeptLeaderHandler(3);//部门领导审批
        Handler boss = new VPHandler(6);//Vp审批

        groupLeader.setNextHandler(departmentLeader);
        departmentLeader.setNextHandler(boss);

        return groupLeader;
    }
    public static void main(String[] args) {

        Handler client = getClient();

        for(int i=1;i<=10;i++){
            client.leaveHandler(i,"请"+i+"天假",1);
            System.out.println("----------------");
        }
    }
}