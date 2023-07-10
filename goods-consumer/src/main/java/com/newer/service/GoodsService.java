package com.newer.service;

import com.newer.LogConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "goods-provider",configuration = LogConfiguration.class)
public interface GoodsService extends ConsumerService{
}