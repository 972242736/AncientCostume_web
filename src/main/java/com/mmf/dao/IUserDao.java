package com.mmf.dao;

import com.mmf.model.User;

import java.util.List;

/**
 * Created by MMF on 2017/6/14.
 */
public interface IUserDao {
    List<User> queryAll(String name);
}
