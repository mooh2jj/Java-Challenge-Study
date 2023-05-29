package first.firststudy.service;

import first.firststudy.dto.ScoreDto;
import first.firststudy.entity.Score;
import first.firststudy.entity.Student;
import first.firststudy.repository.ScoreRepository;
import first.firststudy.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class ScoreService {

    private static final Pattern KOREAN_PATTERN = Pattern.compile("[ㄱ-ㅎ가-힣]+");

    private final ScoreRepository scoreRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public ScoreService(ScoreRepository scoreRepository, StudentRepository studentRepository) {
        this.scoreRepository = scoreRepository;
        this.studentRepository = studentRepository;
    }

    public int getTotalScore(List<ScoreDto> scores) {
        return scores.stream()
                .mapToInt(ScoreDto::getScore)
                .sum();
    }

    public double getAverageScore(List<ScoreDto> scores) {
        int total = getTotalScore(scores);
        return (double) total / scores.size();
    }

    public List<ScoreDto> filterKorean(List<ScoreDto> scores) {
        return scores.stream()
                .filter(score -> KOREAN_PATTERN.matcher(score.getName()).matches())
                .collect(Collectors.toList());
    }

    public void saveScores(List<ScoreDto> scores, String studentName) {
        List<ScoreDto> koreanScores = filterKorean(scores);

        List<Score> scoreEntities = koreanScores.stream()
                .map(this::convertToScoreEntity)
                .collect(Collectors.toList());

        int totalScore = getTotalScore(koreanScores);
        double averageScore = getAverageScore(koreanScores);

        Student student = new Student(studentName, averageScore, totalScore);
        studentRepository.save(student);

        scoreRepository.saveAll(scoreEntities);
    }


    private Score convertToScoreEntity(ScoreDto scoreDto) {
        return new Score(scoreDto.getName(), scoreDto.getScore());
    }
}
