package hospital.mustache.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String contents;

    public Article(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
