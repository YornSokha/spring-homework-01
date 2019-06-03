package com.hrd.springhomework.controller;

import com.hrd.springhomework.repository.model.Article;
import com.hrd.springhomework.service.ArticleService.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleController {

    private ArticleService articleService;

    @Autowired
    public void setArticleService(ArticleService articleService){
        this.articleService = articleService;
    }
    @GetMapping({"/", "/article"})
    public String index(Model model){
        for (int i = 0; i < 5; i++)
            articleService.add(new Article("Fdksj","fj", "dfskj", "fdjks"));
        System.out.println(articleService.findAll().size());
        model.addAttribute("articles", articleService.findAll());
        return "/articles/index";
    }
}
