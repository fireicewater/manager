package com.sim.manager.service;

import com.github.pagehelper.PageInfo;
import com.sim.manager.view.UserSearchView;
import com.sim.manager.view.UserView;

import java.util.List;

public interface UserService {
    /**
     * 用户注册
     *
     * @param userView
     * @return
     */
    Boolean register(UserView userView);

    /**
     * 校验用户名唯一
     *
     * @param username
     * @return
     */
    Boolean validtaeUser(String username);

    /**
     * 修改用户
     *
     * @param userView
     * @return
     */
    Boolean updateUser(UserView userView);
    /**
     *  逻辑删除用户
     *
     * @param userids
     * @return
     */
    Boolean deleteUsers(List<Integer> userids);

    PageInfo<UserView> findUsersBySerch(UserSearchView userSearchView);
}
