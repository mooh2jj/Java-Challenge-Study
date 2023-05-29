package first.firststudy.dto;

import first.firststudy.entity.Student;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StudentDto {
    private Long id;
    private String name;
    private double average;
    private int total;

    @Builder
    public StudentDto(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.average = student.getAverage();
        this.total = student.getTotal();
    }
}

