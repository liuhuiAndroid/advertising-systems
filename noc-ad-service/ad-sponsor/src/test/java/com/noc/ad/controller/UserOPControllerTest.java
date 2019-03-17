package com.noc.ad.controller;

import com.noc.ad.SponsorApplicationTests;
import com.noc.ad.exception.AdException;
import com.noc.ad.vo.CreateUserRequest;
import com.noc.ad.vo.CreateUserResponse;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserOPControllerTest extends SponsorApplicationTests {

    @Autowired
    UserOPController userOPController;

    @Test
    public void createUser() throws AdException {
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setUsername("second kill");
        CreateUserResponse createUserResponse = userOPController.createUser(createUserRequest);
        Assert.assertTrue(createUserResponse != null);
    }
}