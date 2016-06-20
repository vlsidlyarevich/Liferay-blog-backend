package com.github.solairerove.blog.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.solairerove.blog.Application;
import com.github.solairerove.blog.dto.LoginDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by vlad on 09.06.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@WebAppConfiguration
@SpringApplicationConfiguration(Application.class)
public class AuthControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup() throws Exception {
        this.mvc = webAppContextSetup(context).build();
    }

    @Test
    public void authorizeTest() throws Exception{
        LoginDTO dto = new LoginDTO("login","password");
        ObjectMapper objectMapper = new ObjectMapper();

        mvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST, "/api/")
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotImplemented());
    }
}
