package com.OOZone.dao;

import com.OOZone.entity.Tag;

import java.util.List;

public interface EssayTagRefMapper {
    List<Tag> listTagByEssayId(Integer essayId);
}
