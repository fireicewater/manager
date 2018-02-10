package com.sim.manager.mapper;

import com.sim.config.MyMapper;
import com.sim.manager.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper extends MyMapper<Role> {
    List<Role> findRolesByUserid(@Param("userid") Integer id);
}