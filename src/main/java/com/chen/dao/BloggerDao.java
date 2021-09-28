package com.chen.dao;

import com.chen.entity.Blogger;

/**
 * @author ChenYi
 * @corporation HongYang_software
 *
 * 博主Dao接口
 * @create 2021-09-26
 */
public interface BloggerDao {

        public Blogger getByUserName(String userName);
}
