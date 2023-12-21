package com.lqjai;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringbootApplicationTests {

    @Test
    void contextLoads() {
        Map<String, Object> map = new HashMap<>();
        map.put("k1", "ddddd");
        map.put("k2", false);
        System.out.println(map.get("k1"));
        System.out.println((boolean) map.get("k2") == true);
    }

}
