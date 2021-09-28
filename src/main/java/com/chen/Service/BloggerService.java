package com.chen.Service;

import com.chen.entity.Blogger;

/**
 * @author ChenYi
 * @corporation HongYang_software
 * @create 2021-09-26
 */
public interface BloggerService {

    public Blogger getByUserName(String userName);

}
