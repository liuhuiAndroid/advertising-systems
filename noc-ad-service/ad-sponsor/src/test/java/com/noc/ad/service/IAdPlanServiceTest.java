package com.noc.ad.service;

import com.noc.ad.SponsorApplicationTests;
import com.noc.ad.exception.AdException;
import com.noc.ad.vo.AdPlanGetRequest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

public class IAdPlanServiceTest extends SponsorApplicationTests {

    @Autowired
    private IAdPlanService planService;

    @Test
    public void createAdPlan() {
    }

    @Test
    public void getAdPlanByIds() throws AdException {
        System.out.println(
                planService.getAdPlanByIds(
                        new AdPlanGetRequest(15L, Collections.singletonList(10L))
                )
        );
    }

    @Test
    public void updateAdPlan() {
    }

    @Test
    public void deleteAdPlan() {
    }
}