package com.restapi.example;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestapiApplicationTests {

    @Test
    public void contextLoads() {
        int p1 = 2;
        int p2 = 50;
        Assert.assertEquals("https://nominatim.openstreetmap.org/reverse?format=json&lat=2&lon=50",
                "https://nominatim.openstreetmap.org/reverse?format=json&lat="+p1+"&lon="+p2+"");
    }

}
