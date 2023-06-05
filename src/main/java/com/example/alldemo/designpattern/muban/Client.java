package com.example.alldemo.designpattern.muban;

public class Client {
    public static void main(String[] args) {
        //A 病人看病
        Patient_A patient_A = new Patient_A();
        //看病的流程
        patient_A.procedure();
        /**
         * 输出如下：
         * 你的订单号为2
         * 排队中。。。。
         * 你的病为胃病
         * 药单：健胃消食片 ==== 加了钩子程序则不显示
         */
        //B 病人看病，的流程也是一样，只需要实例化B，并调用公共的模板流程即可，提高代码的利用率

        Patient_B patient_B = new Patient_B();
        patient_B.procedure();

    }
}
