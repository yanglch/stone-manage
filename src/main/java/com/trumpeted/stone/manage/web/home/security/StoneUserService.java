/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.trumpeted.stone.manage.web.home.security;

import com.trumpeted.stone.manage.biz.shared.service.RoleService;
import com.trumpeted.stone.manage.biz.shared.service.UserService;
import com.trumpeted.stone.manage.biz.shared.vo.RoleVo;
import com.trumpeted.stone.manage.biz.shared.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author ylc
 * @version $Id: UserDetailsService.java, v 0.1 2019年03月05日 21:01 ylc Exp $
 */
@Component
public class StoneUserService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
        UserVo userVo = userService.getUser(loginName);
        if (userVo == null) {
            throw new UsernameNotFoundException("login name:" + loginName + ", not exist");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        addAuthorties(authorities, userVo.getPermissionId());

        if (StringUtils.hasText(userVo.getRoleId())) {
            Arrays.stream(userVo.getRoleId().split(",")).collect(Collectors.toList())
                    .forEach((roleId) -> {
                        RoleVo role = roleService.getRole(Long.parseLong(roleId));
                        if(role != null){
                            authorities.add(new SimpleGrantedAuthority(role.getName()));
                            addAuthorties(authorities, role.getPermissionId());
                        }
                    });
        }

        return new User(userVo.getLoginName(), userVo.getPassWord(), authorities);
    }

    private void addAuthorties(List<GrantedAuthority> authorities, String authorties) {
        if (StringUtils.hasText(authorties)) {
            Arrays.stream(authorties.split(",")).collect(Collectors.toList())
                    .forEach((permission) -> authorities.add(new SimpleGrantedAuthority(permission)));
        }
    }

}