package com.example.alldemo.proxy.staticProxy;

/**
 * @description: TODO
 * @author: xieyong
 * @date: 2022/6/22 16:40
 **/
public class RentHouse {

    public static void main(String[] args) {

        Renter renter =  new Renter();
        RenterProxy renterProxy = new RenterProxy(renter);
        renterProxy.rentHouse();
    }
}