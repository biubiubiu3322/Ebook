package com.su.config;

import com.su.mapper.EbookUserMapper;
import com.su.pojo.EbookUser;
import com.su.service.EbookUserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private EbookUserMapper ebookUserMapper;

    //必须重写，自己来实现登陆验证
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
        grantedAuths.add(new SimpleGrantedAuthority("USER"));
        EbookUser ebookUser = ebookUserMapper.loginbyUserName(username);
        if (ebookUser == null) {
            System.out.println("user[" + username + "] is not exist!");
            throw new UsernameNotFoundException(username + " do not exist!");
        }
        System.out.println("Get user info from db: " + ebookUser.toString());
        User user = new User(ebookUser.getUsername(), ebookUser.getPassword(), grantedAuths);
        return user;
    }
}
