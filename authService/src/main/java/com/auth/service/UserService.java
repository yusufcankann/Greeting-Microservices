package com.auth.service;



import com.auth.domain.SystemUser;
import com.auth.domain.Role;

import java.util.List;

public interface UserService {
    SystemUser saveUser(SystemUser systemUser);
    Role saveRole(Role role);
    void addRoleToUser(String username,String roleName);
    SystemUser getUser(String username);
    List<SystemUser> getUsers();


}
