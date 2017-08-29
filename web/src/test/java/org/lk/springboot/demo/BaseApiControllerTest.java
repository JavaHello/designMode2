package org.lk.springboot.demo;

import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.lk.springboot.demo.web.util.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
public class BaseApiControllerTest {
    private Logger logger = LoggerFactory.getLogger(getClass());
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wx;

    @Before
    public void testUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wx).build();
    }

    protected ResponseMessage get(String url, Object param) throws Exception {
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get(url);
        String content = null;
        if (param != null) {
            content = JSONObject.toJSONString(param);
            req.content(content);
        }
        MvcResult mvcResult = this.mockMvc.perform(req).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        logger.info("请求方式:GET\n请求地址:{},\n请求参数:{},\n返回数据:{}", url , content, contentAsString);
        ResponseMessage responseMessage = JSONObject.parseObject(contentAsString).toJavaObject(ResponseMessage.Build.class).build();
        Assert.assertTrue("请求有错误", ResponseMessage.SUCCESS_CODE.equals(responseMessage.getCode()));
        return responseMessage;
    }
    protected ResponseMessage post(String url, Object param) throws Exception {
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post(url);
        String content = null;
        if (param != null) {
            content = JSONObject.toJSONString(param);
            req.content(content);
        }
        MvcResult mvcResult = this.mockMvc.perform(req).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        logger.info("请求方式:POST\n请求地址:{},\n请求参数:{},\n返回数据:{}", url , content, contentAsString);
        ResponseMessage responseMessage = JSONObject.parseObject(contentAsString).toJavaObject(ResponseMessage.Build.class).build();
        Assert.assertTrue("请求有错误", ResponseMessage.SUCCESS_CODE.equals(responseMessage.getCode()));
        return responseMessage;
    }
}
