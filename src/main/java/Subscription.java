import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Entity
@Getter
@Setter
@Table(name = "subscriptions")
public class Subscription
{
    @EmbeddedId
    private SubscriptionKey id;

    @Column(name = "student_id", insertable = false,updatable = false)
    private int studentId;
    @Column(name = "course_id", insertable = false,updatable = false)
    private int courseId;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

}
