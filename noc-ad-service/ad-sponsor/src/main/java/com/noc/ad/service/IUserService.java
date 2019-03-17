package com.noc.ad.service;

import com.noc.ad.exception.AdException;
import com.noc.ad.vo.CreateUserRequest;
import com.noc.ad.vo.CreateUserResponse;

public interface IUserService {

    /**
     * 创建用户
     */
    CreateUserResponse createUser(CreateUserRequest request)
            throws AdException;
}

