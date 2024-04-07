package com.OOZone.service.impl;

import com.OOZone.dao.EssayCategoryRefMapper;
import com.OOZone.dao.EssayMapper;
import com.OOZone.dao.EssayTagRefMapper;
import com.OOZone.entity.Category;
import com.OOZone.entity.Essay;
import com.OOZone.entity.Tag;
import com.OOZone.service.EssayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/*
* 根据具体dao层和entity层实现接口*/

@Service
@Slf4j
public class EssayServiceimpl implements EssayService {
    @Autowired
    private EssayCategoryRefMapper essayCategoryRefMapper;
    @Autowired
    private EssayMapper essayMapper;
    @Autowired
    private EssayTagRefMapper essayTagRefMapper;
    @Override
    public Essay getEssayByStatusAndId(Integer status, Integer id) {
        Essay essay = essayMapper.getEssayByStatusAndId(status, id);
        if (essay != null) {
            List<Category> categoryList =essayCategoryRefMapper.listCategoryByEssayId(essay.getEssayId());
            List<Tag> tagList = essayTagRefMapper.listTagByEssayId(essay.getEssayId());
            essay.setCategoryList(categoryList);
            essay.setTagList(tagList);
        }
        return essay;
    }
}
