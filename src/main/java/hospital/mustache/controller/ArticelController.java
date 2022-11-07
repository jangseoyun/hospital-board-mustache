package hospital.mustache.controller;

import hospital.mustache.domain.dto.ArticleDto;
import hospital.mustache.domain.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/articles")
@Slf4j
public class ArticelController {

    @GetMapping(value = "/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/posts")
    public String createArticle(ArticleDto articleDto) {
        log.info(articleDto.toString());
        Article article = articleDto.toEntity();
        return "";
    }
}
