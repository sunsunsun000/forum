package com.forum.action;

import java.util.HashMap;
import java.util.Map;

import com.forum.util.ActionReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forum.dto.UserDto;
import com.forum.service.UserService;
import com.forum.util.CurrentRequestType;
import com.forum.util.RequestType;

@Controller
@RequestMapping("/user")
public class UserAction {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @RequestMapping(value = "/register")
    public Map<String, Object> register(@RequestBody UserDto userDto) {
        CurrentRequestType.setCurrentRequestType(RequestType.AJAX);
        userService.registerUser(userDto);
        return ActionReturnUtil.returnSuccess();
    }

    public Map<String, Object> updateUser(UserDto userDto) {
        userService.updateUser(userDto);
        return ActionReturnUtil.returnSuccess();
    }

    @ResponseBody
    @RequestMapping(value = "/login")
    public Map<String, Object> login(@RequestBody UserDto userDto) {
        CurrentRequestType.setCurrentRequestType(RequestType.AJAX);
        userService.login(userDto);
        return ActionReturnUtil.returnSuccess();
    }
}
