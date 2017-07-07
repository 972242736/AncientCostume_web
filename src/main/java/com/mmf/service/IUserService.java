package com.mmf.service;

import com.mmf.model.User;

import java.util.List;

/**
 * Created by MMF on 2017/6/14.
 */
public interface IUserService {
    /**
     * 获取全部账户数据
     *
     * @return
     */
    List<User> getUserList(String name);
}
