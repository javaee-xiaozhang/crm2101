package com.soft191.zhangjunwen.mapper;

import com.soft191.zhangjunwen.domain.SysUser;

import java.util.List;

public interface SysUserMapper {

    public List<SysUser> findUserAndRole();
}
