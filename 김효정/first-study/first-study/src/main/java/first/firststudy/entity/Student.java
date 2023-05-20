package first.firststudy.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(
        name = "students"
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double average;
    private int total;

    @Builder
    public Student(String name, double average, int total) {
        this.name = name;
        this.average = average;
        this.total = total;
    }
}
