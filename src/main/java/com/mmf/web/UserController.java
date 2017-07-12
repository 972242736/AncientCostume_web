package com.mmf.web;

import com.mmf.dto.ResponseModel;
import com.mmf.model.User;
import com.mmf.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by MMF on 2017/6/14.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    private Object list(String name) {
        List<User> list = userService.getUserList(name);
//        model.addAttribute("list", list);
        // list.jsp + model = ModelAndView
        ResponseModel model = new ResponseModel<List<User>>(0, "获取数据成功");
        model.setData(list);
        System.out.println("**********" + list.toString());
        return model;
    }

    @RequestMapping(value = "/list1", method = RequestMethod.GET)
    @ResponseBody
    private Object list(@RequestParam Map<String, Object> params) {
        List<User> list = userService.getUserList(params.get("mao").toString());
        ResponseModel model = new ResponseModel<List<User>>(0, "获取数据成功");
        model.setData(list);
        return model;
    }
}
