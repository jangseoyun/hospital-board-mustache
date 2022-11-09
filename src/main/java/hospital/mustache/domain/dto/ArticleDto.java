package hospital.mustache.domain.dto;

import hospital.mustache.domain.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {
    private Long id;
    private String title;
    private String contents;

    public Article toEntity() {
        return new Article(title, contents);
    }

    public Article toEntityAll() {
        return new Article(id, title, contents);
    }

}
