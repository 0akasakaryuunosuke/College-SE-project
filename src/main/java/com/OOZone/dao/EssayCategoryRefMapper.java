package com.OOZone.dao;

import com.OOZone.entity.Category;

import java.util.List;

public interface EssayCategoryRefMapper {
    List<Category> listCategoryByEssayId(Integer essayId);
}
