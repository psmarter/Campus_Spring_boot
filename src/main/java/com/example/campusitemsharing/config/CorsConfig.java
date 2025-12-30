package com.example.campusitemsharing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * CORS 跨域配置类 / CORS Configuration Class
 * 
 * 配置跨域资源共享，允许 Android 应用和其他客户端访问 API。
 * Configure Cross-Origin Resource Sharing to allow Android app and other clients to access the API.
 * 
 * CORS 是一种安全机制，允许来自不同域的资源请求。
 * CORS is a security mechanism that allows resource requests from different domains.
 * 
 * @author psmarter
 * @version 1.0
 * @since 2025-12-30
 */
@Configuration
public class CorsConfig {

    /**
     * 配置 CORS 过滤器 / Configure CORS Filter
     * 
     * 此方法创建并配置一个 CORS 过滤器，定义了允许的来源、方法和头部。
     * This method creates and configures a CORS filter, defining allowed origins, methods, and headers.
     * 
     * @return 配置好的 CORS 过滤器 / Configured CORS filter
     */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        
        // 允许所有来源（开发环境）/ Allow all origins (development environment)
        // ⚠️ 生产环境应该指定具体的域名以提高安全性
        // ⚠️ In production, specify exact domains for better security
        // 例如 / Example: config.addAllowedOrigin("https://your-frontend-domain.com");
        config.addAllowedOriginPattern("*");
        
        // 允许所有 HTTP 方法 / Allow all HTTP methods
        // GET, POST, PUT, DELETE, PATCH, OPTIONS
        config.addAllowedMethod("*");
        
        // 允许所有请求头 / Allow all request headers
        // Content-Type, Authorization, X-Requested-With, etc.
        config.addAllowedHeader("*");
        
        // 允许携带认证信息（cookies, HTTP authentication）
        // Allow credentials (cookies, HTTP authentication)
        config.setAllowCredentials(true);
        
        // 预检请求的缓存时间（秒）/ Preflight request cache time (seconds)
        // 减少预检请求的频率，提高性能 / Reduce preflight request frequency, improve performance
        config.setMaxAge(3600L);
        
        // 暴露的响应头（允许客户端访问）/ Exposed response headers (accessible by clients)
        config.addExposedHeader("Authorization");
        config.addExposedHeader("Content-Type");
        
        // 对所有路径应用此配置 / Apply this configuration to all paths
        source.registerCorsConfiguration("/**", config);
        
        return new CorsFilter(source);
    }
}
