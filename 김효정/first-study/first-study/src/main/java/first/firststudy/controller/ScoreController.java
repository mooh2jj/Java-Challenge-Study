package first.firststudy.controller;

import first.firststudy.dto.ScoreResponseDto;
import first.firststudy.dto.ScoreDto;
import first.firststudy.service.ScoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScoreController {

    private final ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @PostMapping("/score")
    public ResponseEntity<ScoreResponseDto> calculateScore(@RequestBody List<ScoreDto> scores, @RequestParam("name") String studentName) {
        List<ScoreDto> koreanScores = scoreService.filterKorean(scores);
        int totalScore = scoreService.getTotalScore(koreanScores);
        double averageScore = scoreService.getAverageScore(koreanScores);

        // Save students to the database
        scoreService.saveScores(scores, studentName);

        ScoreResponseDto responseDto = new ScoreResponseDto(totalScore, averageScore);
        return ResponseEntity.ok(responseDto);
    }
}
