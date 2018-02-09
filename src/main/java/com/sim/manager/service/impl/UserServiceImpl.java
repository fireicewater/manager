package com.sim.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sim.manager.mapper.UserDetailMapper;
import com.sim.manager.mapper.UserMapper;
import com.sim.manager.model.User;
import com.sim.manager.model.UserDetail;
import com.sim.manager.service.UserService;
import com.sim.manager.view.UserSearchView;
import com.sim.manager.view.UserView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDetailMapper userDetailMapper;


    @Override
    public Boolean register(UserView userView) {
        User user = new User();
        UserDetail userDetail = new UserDetail();
        Date date = new Date();
        BeanUtils.copyProperties(userView, user);
        user.setCreattime(date);
        int userid = userMapper.insertUseGeneratedKeys(user);
        BeanUtils.copyProperties(userView, userDetail);
        userDetail.setUserid(userid);
        userDetail.setCreattime(date);
        int userdetailid = userDetailMapper.insertUseGeneratedKeys(userDetail);
        return userid != 0 || userdetailid != 0;
    }

    @Override
    public Boolean validtaeUser(String username) {
        User userforselect = new User();
        userforselect.setUsername(username);
        User user = userMapper.selectOne(userforselect);
        return Optional.ofNullable(user).isPresent();
    }

    @Override
    public Boolean updateUser(UserView userView) {
        Integer userid = userView.getId();
        UserDetail forselect = new UserDetail();
        forselect.setUserid(userid);
        UserDetail userDetail = userDetailMapper.selectOne(forselect);
        BeanUtils.copyProperties(userView, userDetail, "id");
        int i = userDetailMapper.updateByPrimaryKeySelective(userDetail);
        return i != 0;
    }

    @Override
    public Boolean deleteUsers(List<Integer> userids) {
        Example example = new Example(User.class);
        example.createCriteria().andIn("id", userids);
        User user = new User();
        user.setStatus(false);
        int i = userMapper.updateByExampleSelective(user, example);
        return i != 0;
    }

    @Override
    public PageInfo<UserView> findUsersBySerch(UserSearchView userSearchView) {
        PageHelper.startPage(userSearchView.getPage(), 15);

//        PageInfo page = new PageInfo(list);
        return null;
    }
}
