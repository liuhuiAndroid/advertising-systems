package com.noc.ad;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SponsorTestApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class SponsorApplicationTests {

    @Test
    public void contextLoads() {
    }

}
