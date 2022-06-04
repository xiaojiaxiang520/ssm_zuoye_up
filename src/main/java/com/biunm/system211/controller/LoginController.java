package com.biunm.system211.controller;

import com.alibaba.fastjson.JSONObject;
import com.biunm.system211.pojo.Result;
import com.biunm.system211.pojo.User;
import com.biunm.system211.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class LoginController {

    @Resource//按照接口实现类名字来注入(name = "UserServiceImpl"),当有两个的时候，这个就是根据后面的这个来指定的
    UserService userService;

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    //登录
    @RequestMapping("/zz/admin/login")
    public Result Login(User user, HttpServletRequest httpServletRequest) {

        Result result = new Result<>();
        User fuser = userService.findUser(user);
        //用户登录成功
        if(fuser!=null)
        {
            System.out.println("登录成功：");
            String uuid = UUID.randomUUID()+"";
            System.out.println("存入新的token："+uuid);
            System.out.println("登录后的token:"+uuid);
            //将查询的结果Json化
            String userJson = JSONObject.toJSONString(fuser);
//              存入redis
            try {
                redisTemplate.opsForValue().set(uuid, userJson,30L, TimeUnit.MINUTES);

            }catch (Exception e)
            {
                e.printStackTrace();
            }
            //
            result.setMsg("登录成功");
            result.setCode(200);
            fuser.setPassword("");//密码为空
            HashMap<String, Object> map = new HashMap<>();
            map.put("token",uuid);
            map.put("user",fuser);
            result.setData(map);

            return result;
        }else{
            result.setCode(201);
            result.setMsg("登录失败");
            result.setData(null);
            return result;
        }



    }

}
