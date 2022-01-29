package aero.flightreview.web.controller;

import aero.flightreview.database.model.document.ReviewDoc;
import aero.flightreview.database.model.document.SchoolDoc;
import aero.flightreview.database.model.servicemodel.ReviewServiceModel;
import aero.flightreview.database.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/api/v1/get/reviews")
    public ResponseEntity<List<ReviewDoc>> getAllReviews() {
        return reviewService.getAll();
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/api/v1/create/review")
    public void createReview(@RequestBody ReviewServiceModel doc) {
        reviewService.save(doc);
    }

    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/api/v1/delete/review")
    public void deleteReview(@RequestBody String reviewId) {
        reviewService.delete(reviewId);
    }

}
