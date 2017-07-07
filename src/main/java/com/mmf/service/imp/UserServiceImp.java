package com.mmf.service.imp;

import com.mmf.dao.IUserDao;
import com.mmf.model.User;
import com.mmf.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by MMF on 2017/6/14.
 */
@Service("userService")
public class UserServiceImp implements IUserService {
    @Resource
    private IUserDao userDao;

    public List<User> getUserList(String name) {
        return userDao.queryAll(name);
    }
}
