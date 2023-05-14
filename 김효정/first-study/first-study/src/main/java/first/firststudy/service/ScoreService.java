package first.firststudy.service;

import first.firststudy.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ScoreService {

    private static final Pattern KOREAN_PATTERN = Pattern.compile("[ㄱ-ㅎ가-힣]+");

    public int getTotalScore(List<StudentDto> students) {
        int total = 0;
        for (StudentDto student : students) {
            total += student.getScore();
        }
        return total;
    }

    public double getAverageScore(List<StudentDto> students) {
        int total = getTotalScore(students);
        return (double) total / students.size();
    }

    public List<StudentDto> filterKorean(List<StudentDto> students) {
        List<StudentDto> filteredStudents = new ArrayList<>();
        for (StudentDto student : students) {
            String name = student.getName();
            Matcher matcher = KOREAN_PATTERN.matcher(name);
            if (matcher.matches()) {
                filteredStudents.add(student);
            }
        }
        return filteredStudents;
    }
}
