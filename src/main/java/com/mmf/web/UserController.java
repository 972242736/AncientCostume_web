package com.mmf.web;

import com.mmf.model.User;
import com.mmf.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

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
    private Object list(Model model) {
        List<User> list = userService.getUserList();
        model.addAttribute("list", list);
        // list.jsp + model = ModelAndView
        System.out.println("**********" + list.toString());
        return list;
    }
}
