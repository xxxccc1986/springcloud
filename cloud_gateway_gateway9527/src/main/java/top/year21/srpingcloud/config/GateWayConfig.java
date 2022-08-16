package top.year21.srpingcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: 网关路由配置硬编码方式
 * @date 2022/8/9 16:03
 */
@Configuration
public class GateWayConfig {
    /**
     * Description : 配置了一个id为customer的路由规则
     * 当访问http://localhost:9527/guonei时会转发到http://news.baidu.com/guonei
     * @date 2022/8/9
     * @param routeLocatorBuilder builder
     * @return org.springframework.cloud.gateway.route.RouteLocator
     **/
    @Bean
    public RouteLocator customerRouters(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("customer",
                r -> r.path("/guonei").uri("http://news.baidu.com"))
                .build();
        return routes.build();
    }
}
