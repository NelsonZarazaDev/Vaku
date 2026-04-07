package com.vaku.gateway_server.beans;

import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.netty.http.client.HttpClient;


@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("country", r -> r.path("/core-server/country/**").uri("lb://core-server"))
                .route("department", r -> r.path("/core-server/department/**").uri("lb://core-server"))
                .route("city", r -> r.path("/core-server/city/**").uri("lb://core-server"))
                .route("documentType", r -> r.path("/core-server/documentType/**").uri("lb://core-server"))
                .build();
    }

    @Bean
    public HttpClient httpClient() {
        return HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
    }
}
