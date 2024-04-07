package com.OOZone.controller;
import com.OOZone.dto.EssayParam;
import com.OOZone.entity.Category;
import com.OOZone.entity.Essay;
import  com.OOZone.entity.Tag;
import  com.OOZone.entity.User;

import com.OOZone.enums.UserRole;
import com.OOZone.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*请参照UserController构建*/
@Controller
@RequestMapping("/article")
public class EssayController {
    @Autowired
    private EssayService essayService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TagService tagService;
    @RequestMapping(value = "/edit/{id}")
    public String editEssayView(@PathVariable("id") Integer id, Model model, HttpSession session){
        Essay article = EssayService.getEssayByStatusAndId(null, id);
        if (article == null) {
            return null;
        }
        User user = (User) session.getAttribute("user");
        // 如果不是管理员，访问其他用户的数据，则跳转403
    /*    if (!Objects.equals(essay.getEssayUserId(), user.getUserId()) && !Objects.equals(user.getUserRole(), UserRole.ADMIN.getValue())) {
            return "redirect:/403";
        }*/

        model.addAttribute("article", article);

        List<Category> categoryList = categoryService.listCategory();
        model.addAttribute("categoryList", categoryList);

        List<Tag> tagList = tagService.listTag();
        model.addAttribute("tagList", tagList);

        return null;
    }
    @RequestMapping(value = "/editSubmit", method = RequestMethod.POST)
    public String editArticleSubmit(EssayParam essayParam, HttpSession session) {
        Essay dbEssay = EssayService.getEssayByStatusAndId(null, essayParam.getEssayId());
        if (dbEssay == null) {
            return "redirect:/404";
        }
        User user = (User) session.getAttribute("user");
        // 如果不是管理员，访问其他用户的数据，则跳转403
        if (!Objects.equals(dbEssay.getEssayUserId(), user.getUserId()) && !Objects.equals(user.getUserRole(), UserRole.ADMIN.getValue())) {
            return "redirect:/403";
        }
        Essay essay = new Essay();
        essay.setEssayThumbnail(EssayParam.getEssayThumbnail());
        essay.setEssayId(EssayParam.getEssayId());
        essay.setEssayTitle(EssayParam.getEssayTitle());
        essay.setEssayContent(EssayParam.getEssayContent());
        essay.setEssayStatus(EssayParam.getEssayStatus());
        //文章摘要
        int summaryLength = 150;
        String summaryText = HtmlUtil.cleanHtmlTag(article.getArticleContent());
        if (summaryText.length() > summaryLength) {
            String summary = summaryText.substring(0, summaryLength);
            article.setArticleSummary(summary);
        } else {
            article.setArticleSummary(summaryText);
        }
        //填充分类
        List<Category> categoryList = new ArrayList<>();
        if (articleParam.getArticleChildCategoryId() != null) {
            categoryList.add(new Category(articleParam.getArticleParentCategoryId()));
        }
        if (articleParam.getArticleChildCategoryId() != null) {
            categoryList.add(new Category(articleParam.getArticleChildCategoryId()));
        }
        article.setCategoryList(categoryList);
        //填充标签
        List<Tag> tagList = new ArrayList<>();
        if (articleParam.getArticleTagIds() != null) {
            for (int i = 0; i < articleParam.getArticleTagIds().size(); i++) {
                Tag tag = new Tag(articleParam.getArticleTagIds().get(i));
                tagList.add(tag);
            }
        }
        article.setTagList(tagList);
        articleService.updateArticleDetail(article);
        return "redirect:/admin/article";
    }

}
