package com.chen.realm;

import com.chen.Service.BloggerService;
import com.chen.entity.Blogger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * @author ChenYi
 * @corporation HongYang_software
 * @create 2021-09-26
 */
public class MyRealm extends AuthorizingRealm {

    @Resource
    private BloggerService bloggerService;
    /**
     * 为当前登录用户赋予权限
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 验证当前登录用户
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
       String userName=(String)token.getPrincipal();
       Blogger blogger=bloggerService.getByUserName(userName);
       if(blogger!=null){
           SecurityUtils.getSubject().getSession().setAttribute("currentUser",blogger);
           AuthenticationInfo auth=new SimpleAuthenticationInfo(blogger.getUsername(),blogger.getPassword(),"cyy");
           return  auth;
       }else {
           return null;
       }
    }
}
