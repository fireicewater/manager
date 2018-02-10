package com.sim.manager.mapper;

import com.sim.config.MyMapper;
import com.sim.manager.model.User;
import com.sim.manager.service.UserService;
import com.sim.manager.view.UserSearchView;
import com.sim.manager.view.UserView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends MyMapper<User> {

    List<UserView> findUserBySearch(UserSearchView searchView);

    UserView findUserViewById(@Param("userid") Integer userid);
}