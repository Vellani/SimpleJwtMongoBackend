package aero.flightreview.database.model.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document("reviews")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReviewDoc {


    @Id
    private String id;
    @DBRef(lazy = true)
    private SchoolDoc school;
    @DBRef(lazy = true)
    private UserDoc creator;

    private LocalDate createdOn;

    private String reviewTitle;
    private String reviewBody;

    private int ratingTotal;


}
