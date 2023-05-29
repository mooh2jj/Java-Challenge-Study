package first.firststudy.dto;

import first.firststudy.entity.Score;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ScoreDto {
    private Long id;
    private String name;
    private int score;

    @Builder
    public ScoreDto(Score score) {
        this.id = score.getId();
        this.name = score.getName();
        this.score = score.getScore();
    }
}
