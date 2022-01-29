package aero.flightreview.database.model.servicemodel;

import aero.flightreview.database.model.document.SchoolDoc;
import aero.flightreview.database.model.document.UserDoc;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReviewServiceModel {

    @Id
    private String id;
    @NotNull
    private String school;
    @NotNull
    private String creator;

    @CreatedDate
    private Date createdOn;

    @NotBlank
    private String reviewTitle;
    @NotBlank
    private String reviewBody;
    @NotBlank
    private Double ratingTotal;


}
