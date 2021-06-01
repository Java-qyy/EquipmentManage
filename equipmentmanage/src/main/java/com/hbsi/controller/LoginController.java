package com.hbsi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hbsi.dao.EmployeeDao;
import com.hbsi.entity.Employee;
import com.hbsi.util.CodeUtils;
import com.hbsi.util.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.TimeUnit;

@RestController
public class LoginController {

    @Autowired
    public EmployeeDao employeeDao;
    @Autowired
    public Email emailutil;
    @Autowired
    public RedisTemplate<String,String> redisTemplate;


    /**
     * 发送验证码
     * @param username
     * @param password
     * @return
     */

    @RequestMapping(value = "/login/code")
    public Map<String,Object> code(String username,String password){
        Map<String,Object> map = new HashMap<>();

        QueryWrapper<Employee> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("username",username).eq("password",password);
        Employee employee = employeeDao.selectOne(queryWrapper1);
        if(employee==null){
            map.put("msg","用户不存在");
            map.put("flag",false);
            return map;
        }
        String code = CodeUtils.code();
        emailutil.email(employee.getEmail(),code);
        redisTemplate.opsForValue().set(employee.getUsername(),code,30, TimeUnit.MINUTES);

        map.put("msg","验证码已发送");
        map.put("flag",true);
        return map;
    }




    @RequestMapping(value = "/login/login")
    public Map<String,Object> login(String username,String code){
        Map<String,Object> map = new HashMap<>();
        String s = redisTemplate.opsForValue().get(username);

        if(!StringUtils.hasText(s) || !s.equals(code)){
            map.put("msg","验证码已失效或错误");
            map.put("flag",false);
            return map;
        }

        String token = UUID.randomUUID().toString()+username;
        redisTemplate.opsForValue().set(username+"token",token);
        redisTemplate.delete(username);
        map.put("msg","登陆成功");
        map.put("flag",true);
        map.put("token",token);
        return map;

    }


}
