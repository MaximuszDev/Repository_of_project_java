import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "students")
public class Student
{
    @Id
    private int id;

    private String name;
    private int age;


    @Column(name = "registration_date")
    private Date registrationDate;

}
