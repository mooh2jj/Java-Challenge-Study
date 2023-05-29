package first.firststudy.dto;

public class ScoreResponseDto {

    private final int totalScore;
    private final double averageScore;

    public ScoreResponseDto(int totalScore, double averageScore) {
        this.totalScore = totalScore;
        this.averageScore = averageScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public double getAverageScore() {
        return averageScore;
    }
}
