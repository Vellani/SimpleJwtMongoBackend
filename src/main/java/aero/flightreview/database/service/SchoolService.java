package aero.flightreview.database.service;

import aero.flightreview.database.model.document.ReviewDoc;
import aero.flightreview.database.model.document.SchoolDoc;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SchoolService {

    SchoolDoc save(SchoolDoc schoolServiceModel);

    ResponseEntity<List<SchoolDoc>> getAll();

    SchoolDoc findById(String school);

    /*SchoolDoc addReview(ReviewDoc newReview, String schoolId);

    void deleteReview(ReviewDoc reviewDoc, String schoolId);*/
}
