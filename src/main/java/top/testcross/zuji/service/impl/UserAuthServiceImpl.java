package top.testcross.zuji.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.testcross.zuji.bean.UimUser;
import top.testcross.zuji.bean.UimUserExample;
import top.testcross.zuji.mapper.UimUserMapper;
import top.testcross.zuji.service.IUserAuthService;
import top.testcross.zuji.util.DaoUtil;

import java.util.List;

@Service
public class UserAuthServiceImpl implements IUserAuthService {
    @Autowired
    UimUserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UimUser uimUser=getUserByUserName(username);
        User user=new User(uimUser.getUserName(),uimUser.getUserPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("user"));
        return  user;
    }

    public UimUser getUserByUserName(String username){
        UimUserExample example=new UimUserExample();
        example.createCriteria().andUserNameEqualTo(username);
        List<UimUser> users= (List<UimUser>) DaoUtil.selectByExample(userMapper,example);

        if(users.size()==0)return new UimUser();
        return  users.get(0);
    }


}
