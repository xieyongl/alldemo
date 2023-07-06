package com.example.alldemo.frame.spi.demo;

import java.util.ServiceLoader;

/**
 * src/main/resources目录下创建一个META-INF/services 目录
 * 并创建一个名为：com.example.alldemo.frame.spi.demo.MessageService 的文件 （接口的全路径）
 * 内容为：com.example.alldemo.frame.spi.demo.EmailServiceImpl (实现类的全路径)
 */
public class Clent {

    public static void main(String[] args) {
        ServiceLoader<MessageService> serviceLoader = ServiceLoader.load(MessageService.class);
        for (MessageService service : serviceLoader) {
            service.sendMessage("Hello, SPI!");
        }
    }

    /** Java SPI（Service Provider Interface）机制是一种用于实现组件扩展的机制。它允许在应用程序中定义接口，并通过配置文件的方式，
     * 允许第三方供应商提供接口的具体实现。
     * 在Java SPI机制中，核心组件定义一个接口，然后提供一个或多个默认的实现。第三方供应商可以通过创建并提供实现来扩展这个接口，
     * 而无需修改核心组件的代码。这种方式使得组件的扩展更加灵活，并支持松耦合的架构。

     SPI机制的实现过程包括以下几个步骤：
     1、定义接口：核心组件首先定义一个接口，该接口定义了一组需要被扩展的功能。
     2、创建实现：第三方供应商根据接口创建实现类，并在实现类中提供具体的功能实现。
     3、配置文件：第三方供应商将实现类的全限定名添加到一个特定的配置文件中。这个配置文件通常被命名为META-INF/services/接口全限定名，其中接口全限定名是核心组件定义的接口的全限定名。
     4、加载实现：核心组件使用Java SPI机制来加载配置文件中列出的所有实现类。这可以通过java.util.ServiceLoader类实现。ServiceLoader会在类路径上搜索所有的配置文件，并实例化其中列出的实现类。
     5、通过上述步骤，核心组件就可以动态地加载和使用第三方供应商提供的实现类，而无需显式地依赖于特定的实现。
     **/
}