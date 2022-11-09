package hospital.mustache.controller;

import hospital.mustache.domain.dto.ArticleDto;
import hospital.mustache.domain.entity.Article;
import hospital.mustache.domain.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/articles")
@RequiredArgsConstructor
@Slf4j
public class ArticleController {

    private final ArticleRepository articleRepository;

    //---------main---------------
    @GetMapping("")
    public String index() {
        return "redirect:/articles/list";
    }

    //---------insert form---------------
    @GetMapping(value = "/new")
    public String addForm() {
        return "articles/new";
    }

    //---------insert---------------
    @PostMapping("")
    public String add(ArticleDto articleDto) {
        log.info(articleDto.toString());
        Article article = articleDto.toEntity();
        Article saveOne = articleRepository.save(article);
        log.info("saveOne:{}", saveOne);
        return String.format("redirect:/articles/%d", saveOne.getId());
    }

    //---------select One---------------
    @GetMapping("/{id}")
    public String getContentsOne(@PathVariable("id") Long id, Model model) {
        log.info("id:{}", id);
        Optional<Article> optArticle = articleRepository.findById(id);
        log.info("{}", optArticle);
        if (optArticle.isEmpty()) {
            return "error";
        }

        model.addAttribute("article", optArticle.get());
        return "show";

    }

    //---------Select All---------------
    @GetMapping("/list")
    public String getListAll(Model model) {
        List<Article> articleList = articleRepository.findAll();
        model.addAttribute("articleList", articleList);
        return "list";
    }

    //---------delete one---------------
    @DeleteMapping("/{id}")
    public String deleteOne(@PathVariable("id") Long id) {
        log.info("delete 요청 : {}", id);
        articleRepository.deleteById(id);
        return "redirect:/articles/list";
    }

    //---------update one---------------
    @PutMapping("/{id}")
    public String updateOne(@PathVariable("id") Long id) {
        return "";
    }

}
