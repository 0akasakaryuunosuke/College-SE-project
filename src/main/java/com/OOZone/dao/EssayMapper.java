package com.OOZone.dao;

import com.OOZone.entity.Essay;

/*
 * 数据库文章方法---增删改查，*/
public interface EssayMapper {
    Essay getEssayByStatusAndId(Integer status, Integer id);
}
