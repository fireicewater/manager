package com.sim.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sim.manager.mapper.RoleMapper;
import com.sim.manager.mapper.UserDetailMapper;
import com.sim.manager.mapper.UserMapper;
import com.sim.manager.mapper.UserRoleMapper;
import com.sim.manager.model.Role;
import com.sim.manager.model.User;
import com.sim.manager.model.UserDetail;
import com.sim.manager.model.UserRole;
import com.sim.manager.service.UserService;
import com.sim.manager.view.SysUser;
import com.sim.manager.view.UserSearchView;
import com.sim.manager.view.UserView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public Boolean register(UserView userView) {
        User user = new User();
        UserDetail userDetail = new UserDetail();
        Date date = new Date();
        BeanUtils.copyProperties(userView, user);
        user.setCreatetime(date);
        String password = user.getPassword();
        password = bCryptPasswordEncoder.encode(password);
        user.setPassword(password);
        int userid = userMapper.insertUseGeneratedKeys(user);
        BeanUtils.copyProperties(userView, userDetail);
        userDetail.setUserid(user.getId());
        userDetail.setCreatetime(date);
        int userdetailid = userDetailMapper.insertUseGeneratedKeys(userDetail);
        UserRole userRole = new UserRole();
        userRole.setUserid(user.getId());
        //都是用户啊,管理员去数据库改
        userRole.setRoleid(2);
        userRoleMapper.insert(userRole);
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
        Example example = new Example(UserDetail.class);
        example.createCriteria().andEqualTo("userid", userid);
        List<UserDetail> userDetails = userDetailMapper.selectByExample(example);
        if (!userDetails.isEmpty() && userDetails.size() == 1) {
            UserDetail userDetail = userDetails.get(0);
            BeanUtils.copyProperties(userView, userDetail, "id");
            int i = userDetailMapper.updateByPrimaryKeySelective(userDetail);
            return i != 0;
        }
        return false;
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
        List<UserView> userlist = userMapper.findUserBySearch(userSearchView);
        if (!userlist.isEmpty()) {
            return new PageInfo<>(userlist);
        }
        return null;
    }

    @Override
    public Boolean changpassword(int userid, String password) {
        User user = userMapper.selectByPrimaryKey(userid);
        String newpassword = bCryptPasswordEncoder.encode(password);
        user.setPassword(newpassword);
        int i = userMapper.updateByPrimaryKeySelective(user);
        return i != 0;
    }

    @Override
    public Boolean validaePassword(Integer userid, String password) {
        User user = userMapper.selectByPrimaryKey(userid);
        String password1 = user.getPassword();
        return bCryptPasswordEncoder.matches(password, password1);
    }

    @Override
    public UserView findUserByid(Integer userid) {
        return userMapper.findUserViewById(userid);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("username", s);
        List<User> users = userMapper.selectByExample(example);
        if (!users.isEmpty() && users.size() == 1) {
            User user = users.get(0);
            List<Role> roles = roleMapper.findRolesByUserid(user.getId());
            SysUser sysUser = new SysUser(roles);
            BeanUtils.copyProperties(user, sysUser);
            return sysUser;
        }
        return null;
    }
}
