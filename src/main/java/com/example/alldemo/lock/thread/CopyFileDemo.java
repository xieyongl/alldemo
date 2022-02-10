package com.example.alldemo.lock.thread;

import java.io.*;
import java.text.DecimalFormat;

/**
 * @description: TODO 多线程复制多个文件，并显示进度百分比
 * @author: xieyong
 * @date: 2022/2/10 18:25
 **/
public class CopyFileDemo {

    public static void main(String[] args) {
        Test t1=new Test(new File("C:\\Users\\EDY\\Desktop\\work\\txt\\a.txt"),new File("C:\\Users\\EDY\\Desktop\\work\\1.txt"),1);
        Test t2=new Test(new File("C:\\Users\\EDY\\Desktop\\work\\txt\\b.txt"),new File("C:\\Users\\EDY\\Desktop\\work\\2.txt"),1);
        Test t3=new Test(new File("C:\\Users\\EDY\\Desktop\\work\\txt\\c.txt"),new File("C:\\Users\\EDY\\Desktop\\work\\3.txt"),1);
        t1.start();
        t2.start();
        t3.start();

    }
}

class Test extends Thread {
    private File file;
    private File target;
    private int len;//每次读取的长度

    public Test(File file, File target,int len) {
        this.file = file;
        this.target = target;
        this.len=len;
    }

    @Override
    public void run() {
        FileInputStream fis=null;
        FileOutputStream fos=null;
        try {
            fis=new FileInputStream(file);
            fos=new FileOutputStream(target);
            byte[] b=new byte[len];

            int tmp;
            int total=fis.available();
            double loaded=0;
            while ((tmp=fis.read(b))!=-1){
                fos.write(tmp);
                loaded+=tmp;
                double per=loaded/total;
//                double percent=(int)(per*10000)/100.0;
//                System.out.println(file.getName()+"已读取"+percent+"%");
                DecimalFormat df=new DecimalFormat("##.##%");
                System.out.println(file.getName()+"已读取"+df.format(per));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
