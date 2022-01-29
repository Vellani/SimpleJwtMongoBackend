package aero.flightreview.web.controller;

import aero.flightreview.database.model.document.ReviewDoc;
import aero.flightreview.database.model.servicemodel.ReviewServiceModel;
import aero.flightreview.database.service.ReviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IndexController {

    private final ReviewService reviewService;

    public IndexController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/")
    public ReviewDoc index() {
        return null;
    }



}
