import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Entity
@Getter
@Setter
public class PurchaseList
{
    @EmbeddedId
    private LinkedPurchaseListId id;

    @Column(name = "student_name",insertable = false,updatable = false)
    private String studentName;

    @Column(name = "course_name",insertable = false,updatable = false)
    private String courseName;

    private int price;
    @Column(name = "subscription_date")
    private Date subscriptionDate;
}
