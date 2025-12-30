package com.example.campusitemsharing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 校园物品共享平台主应用类 / Campus Item Sharing Platform Main Application Class
 * 
 * 这是Spring Boot应用程序的入口点，负责启动整个应用。
 * This is the entry point for the Spring Boot application, responsible for starting the entire application.
 * 
 * @SpringBootApplication 注解启用了自动配置、组件扫描和配置属性支持
 * @SpringBootApplication annotation enables auto-configuration, component scanning, and configuration properties support
 * 
 * @author psmarter
 * @version 1.0
 * @since 2025-12-30
 */
@SpringBootApplication
public class CampusItemSharingApplication {

    /**
     * 应用程序主入口方法 / Application main entry method
     * 
     * @param args 命令行参数 / Command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(CampusItemSharingApplication.class, args);
    }

}
