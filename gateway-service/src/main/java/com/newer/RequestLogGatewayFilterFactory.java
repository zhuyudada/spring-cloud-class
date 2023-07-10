package com.newer;

/**
 * @author Administrator
 * @CopyRight(C), 2009-2023,牛耳教育有限公司
 * @FileName: RequestLogGatewayFilterFactory
 * @projectName test-shop-cloud-0608
 * @description: TODO
 * @date 2023/6/2010:17
 */
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.support.GatewayToStringStyler;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.URI;
import java.util.Arrays;
import java.util.List;


@Slf4j
@Component
public class RequestLogGatewayFilterFactory
        extends AbstractGatewayFilterFactory<AbstractGatewayFilterFactory.NameConfig>{
    public RequestLogGatewayFilterFactory() {
        super(NameConfig.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("name");
    }

    @Override
    public GatewayFilter apply(NameConfig config) {
        return new GatewayFilter() {
            //public void doFilter(HttpServletRequest,HttpServletResponse,FilterChain)
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                // 获取请求路径
                //ServerWebExchange.getRequest返回HttpServletRequest
                //.getRespnose返回HttpServerletResponse
                URI uri = exchange.getRequest().getURI();


                ServerHttpRequest myRequest =  exchange.getRequest();
                HttpServletRequest my = (HttpServletRequest) myRequest;
                HttpSession session = my.getSession();
                log.info("获取到请求路径：{}", uri.toString());
                //
                log.info("配置属性：{}", config.getName());
                return chain.filter(exchange);//FilerChain.doFilter(request,response)
            }

            @Override
            public String toString() {
                return GatewayToStringStyler
                        .filterToStringCreator(RequestLogGatewayFilterFactory.this).toString();
            }
        };
    }

}

