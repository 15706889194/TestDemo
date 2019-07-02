package com.zhenxin.test;

import com.zhenxin.pojo.JsonData;
import com.zhenxin.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/test")
public class TestFramework {
    public JsonData findUserById(Integer user_id){
        List<User> list = new ArrayList();

     return new JsonData().buildSuccess(list);
    }

}
