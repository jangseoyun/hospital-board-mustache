package hospital.mustache.controller;

import hospital.mustache.domain.dto.ArticleDto;
import hospital.mustache.domain.entity.Article;
import hospital.mustache.domain.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/articles")
@RequiredArgsConstructor
@Slf4j
public class ArticleController {

    //spring이 articleRepository 구현체를 DI (인터페이스 아님)
    private final ArticleRepository articleRepository;

    @GetMapping(value = "/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("")
    public String createArticle(ArticleDto articleDto) {
        log.info(articleDto.toString());
        Article article = articleDto.toEntity();
        Article saveOne = articleRepository.save(article);
        log.info("saveOne:{}", saveOne);
        return String.format("redirect:/articles/%d", saveOne.getId());
    }

    @GetMapping("/{id}")
    public String findContents(@PathVariable("id") Long id, Model model) {
        log.info("controller find id 요청");
        Optional<Article> optArticle = articleRepository.findById(id);
        log.info("{}", optArticle);
        if (!optArticle.isEmpty()) {
            model.addAttribute("article", optArticle);
            return "show";
        } else {
            return "error";
        }

    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Article> articleList = articleRepository.findAll();
        model.addAttribute("articleList", articleList);
        return "list";
    }

    @GetMapping("")
    public String index() {
        return "redirect:/articles/list";
    }
}
