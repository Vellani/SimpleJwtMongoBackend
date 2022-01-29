package aero.flightreview.database.service;

import aero.flightreview.database.model.document.ReviewDoc;
import aero.flightreview.database.model.servicemodel.ReviewServiceModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReviewService {
    ResponseEntity<List<ReviewDoc>> getAll();
    ReviewDoc save(ReviewServiceModel rev);
    ReviewDoc delete(String id);

}
