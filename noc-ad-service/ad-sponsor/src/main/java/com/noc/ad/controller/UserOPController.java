package com.noc.ad.controller;

import com.alibaba.fastjson.JSON;
import com.noc.ad.exception.AdException;
import com.noc.ad.service.IUserService;
import com.noc.ad.vo.CreateUserRequest;
import com.noc.ad.vo.CreateUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserOPController {

    private final IUserService userService;

    @Autowired
    public UserOPController(IUserService userService) {
        this.userService = userService;
    }

    /**
     * 创建用户
     *
     * @param request
     * @return
     * @throws AdException
     */
    @PostMapping("/create/user")
    public CreateUserResponse createUser(@RequestBody CreateUserRequest request)
            throws AdException {
        log.info("ad-sponsor: createUser -> {}", JSON.toJSONString(request));
        return userService.createUser(request);
    }
}
