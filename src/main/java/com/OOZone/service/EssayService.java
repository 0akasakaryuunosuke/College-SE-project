package com.OOZone.service;

import com.OOZone.entity.Essay;
import com.github.pagehelper.PageInfo;
import java.util.HashMap;
import java.util.List;

/**
 * 业务接口：站在"使用者"角度设计接口 三个方面：方法定义粒度，参数，返回类型（return 类型/异常）
 * 在这里写方法接口
 */
public interface EssayService {
    /**
     * 文章详情页面显示
     *
     * @param status 状态
     * @param id     文章ID
     * @return 文章
     */
    public Essay getEssayByStatusAndId(Integer status, Integer id);
}

