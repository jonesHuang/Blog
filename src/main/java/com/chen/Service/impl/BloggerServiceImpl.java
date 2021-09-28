package com.chen.Service.impl;

import com.chen.Service.BloggerService;
import com.chen.dao.BloggerDao;
import com.chen.entity.Blogger;
import org.springframework.stereotype.Service;

/**
 * @author ChenYi
 * @corporation HongYang_software
 * @create 2021-09-26
 */
@Service("bloggerService")
public class BloggerServiceImpl implements BloggerService {

    private BloggerDao bloggerDao;

    @Override
    public Blogger getByUserName(String userName) {
        return bloggerDao.getByUserName(userName);
    }
}
