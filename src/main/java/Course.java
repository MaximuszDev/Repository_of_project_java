import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Entity
@Setter
@Table(name = "courses")
public class Course
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int duration;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    private CourseType type;

    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    private Teacher teacher;

    @Column(name = "students_count")
    private Integer studentsCount;
    private int price;

    @Column(name = "price_per_hour")
    private float pricePerHour;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "subscriptions",
            joinColumns = {@JoinColumn(name ="course_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")})
    private List<Student> studentsList;
}
