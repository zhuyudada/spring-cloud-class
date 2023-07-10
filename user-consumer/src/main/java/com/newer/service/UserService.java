package com.newer.service;

import com.newer.LogConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
@FeignClient(name = "user-provider",configuration = LogConfiguration.class)
public interface UserService extends ProductService{
}
