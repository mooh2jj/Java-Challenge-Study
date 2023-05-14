package first.firststudy.controller;

import first.firststudy.dto.ScoreResponseDto;
import first.firststudy.dto.StudentDto;
import first.firststudy.service.ScoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScoreController {

    private final ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @PostMapping("/score")
    public ResponseEntity<ScoreResponseDto> calculateScore(@RequestBody List<StudentDto> students) {
        List<StudentDto> koreanStudents = scoreService.filterKorean(students);
        int totalScore = scoreService.getTotalScore(koreanStudents);
        double averageScore = scoreService.getAverageScore(koreanStudents);

        ScoreResponseDto responseDto = new ScoreResponseDto(totalScore, averageScore);
        return ResponseEntity.ok(responseDto);
    }
}
