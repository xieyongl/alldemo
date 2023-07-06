package com.example.alldemo.frame.spi.demo;

/**
 * 消息接口实现
 */
public class EmailServiceImpl implements MessageService{
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending email: " + message);
    }
}