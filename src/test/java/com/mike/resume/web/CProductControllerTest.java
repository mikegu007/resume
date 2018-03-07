package com.mike.resume.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

/**
 * @author Mike
 * @describe
 * @date 2018/3/7
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CProductControllerTest {
    @Autowired
    private MockMvc mvc;
    @Test
    public void getAllProduct() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/getAllProduct"))
                .andExpect(MockMvcResultMatchers.status().isOk())
        //.andExpect(MockMvcResultMatchers.content().string("365"));  //测试接口返回内容
        ;
    }

}