package cn.edu.bjtu.preeticket.service;

import com.alibaba.fastjson.JSONObject;

public interface UserService {

    String register(JSONObject registerInfo);

    String  login(JSONObject loginInfo);

    String getUserByUsername(String username);
}
