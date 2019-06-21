package cn.edu.bjtu.preeticket.service;

import cn.edu.bjtu.preeticket.model.UserNormal;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface UserService {

    String register(JSONObject registerInfo);

    String  login(JSONObject loginInfo);

    String getUserByUsername(String username);
}
