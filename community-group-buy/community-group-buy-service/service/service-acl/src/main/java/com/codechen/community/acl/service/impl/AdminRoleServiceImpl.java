package com.codechen.community.acl.service.impl;

import com.codechen.community.acl.mapper.AdminRoleMapper;
import com.codechen.community.acl.service.AdminRoleService;
import com.codechen.community.model.acl.AdminRole;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper, AdminRole> implements AdminRoleService {
}
