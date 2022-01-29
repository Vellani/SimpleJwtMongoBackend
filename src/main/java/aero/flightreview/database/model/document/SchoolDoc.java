package aero.flightreview.database.model.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("schools")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SchoolDoc {

    @Id
    private String id;

    private String name;
    private String img;

//    @DocumentReference(lazy = true)
//    private Set<ReviewDoc> reviews;


}
