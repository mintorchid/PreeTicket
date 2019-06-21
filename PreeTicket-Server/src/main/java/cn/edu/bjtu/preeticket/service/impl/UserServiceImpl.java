package cn.edu.bjtu.preeticket.service.impl;

import cn.edu.bjtu.preeticket.mapper.UserMapper;
import cn.edu.bjtu.preeticket.model.UserNormal;
import cn.edu.bjtu.preeticket.model.UserOrganizer;
import cn.edu.bjtu.preeticket.service.UserService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public String login(JSONObject loginInfo) {
        JSONObject result = new JSONObject();
        String loginPwd = loginInfo.getString("password");
        String loginUsername = loginInfo.getString("username");

        if (userMapper.getNormalUser(loginUsername) != null) {
            UserNormal userNormal = userMapper.getNormalUser(loginUsername);
            JSONObject data = (JSONObject) JSON.toJSON(userNormal);
            String realPwd = userNormal.getPassword();
            if (realPwd.equals(loginPwd)) {
                result.put("code", "200");
                result.put("msg", "普通用户登录成功");
                data.put("type", "1");
                result.put("data", data);
            } else {
                result.put("code", "400");
                result.put("msg", "普通用户密码错误");
            }
        } else if (userMapper.getOrgUser(loginUsername) != null) {
            UserOrganizer userOrganizer = userMapper.getOrgUser(loginUsername);
            String realPwd = userOrganizer.getPassword();
            JSONObject data = (JSONObject) JSON.toJSON(userOrganizer);
            if (realPwd.equals(loginPwd)) {
                result.put("code", "200");
                result.put("msg", "组织者用户登录成功");
                data.put("type", "2");
                result.put("data", data);
            } else {
                result.put("code", "400");
                result.put("msg", "组织者用户密码错误");
            }
        } else {
            result.put("code", "400");
            result.put("msg", "用户不存在");
        }
        return result.toJSONString();
    }

    @Override
    public String register(JSONObject registerInfo) {
        JSONObject result = new JSONObject();
        UserNormal userNormal = JSON.toJavaObject(registerInfo, UserNormal.class);
        userMapper.addNormalUser(userNormal);
        result.put("code", 200);
        result.put("msg", "注册成功");
        JSONObject data = (JSONObject) JSON.toJSON(registerInfo);
        result.put("data", data);
        return result.toJSONString();
    }

    @Override
    public String getUserByUsername(String username) {
        JSONObject result = new JSONObject();
        UserNormal userNormal = userMapper.getNormalUser(username);
        String data = JSON.toJSONString(userNormal);
        result.put("code", "200");
        result.put("msg", "组织者用户登录成功");
        result.put("data", data);
        return result.toJSONString();
    }
}
