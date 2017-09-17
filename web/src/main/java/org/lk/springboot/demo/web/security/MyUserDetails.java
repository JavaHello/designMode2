package org.lk.springboot.demo.web.security;

import org.lk.springboot.demo.domain.model.user.Permissions;
import org.lk.springboot.demo.domain.model.user.Role;
import org.lk.springboot.demo.domain.model.user.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetails implements UserDetails {
    private static final long serialVersionUID = 3453282262016772362L;
    private UserInfo userInfo;
    private List<Permissions> permissions;

    public MyUserDetails(UserInfo userInfo) {
        this.userInfo = userInfo;
        this.permissions = userInfo.getPermissions();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> arrayList = new ArrayList<>();
        for (Role role : userInfo.getRoles()) {
            arrayList.add(new SimpleGrantedAuthority(role.getReCode()));
        }
        return arrayList;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<Permissions> getPermissions(){
        return this.permissions;
    }

    @Override
    public String getPassword() {
        return this.userInfo.getUpassword();
    }

    @Override
    public String getUsername() {
        return this.userInfo.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
