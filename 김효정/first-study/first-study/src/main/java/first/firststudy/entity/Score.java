package first.firststudy.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(
        name = "scores"
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int score;

    @Builder
    public Score(String name, int score) {
        this.name = name;
        this.score = score;
    }
}