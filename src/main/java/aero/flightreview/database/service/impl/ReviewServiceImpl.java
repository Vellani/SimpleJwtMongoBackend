package aero.flightreview.database.service.impl;

import aero.flightreview.database.model.document.ReviewDoc;
import aero.flightreview.database.model.document.SchoolDoc;
import aero.flightreview.database.model.document.UserDoc;
import aero.flightreview.database.model.servicemodel.ReviewServiceModel;
import aero.flightreview.database.repository.ReviewRepository;
import aero.flightreview.database.service.ReviewService;
import aero.flightreview.database.service.SchoolService;
import aero.flightreview.database.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final SchoolService schoolService;
    private final UserService userService;
    private final ModelMapper modelMapper;


    public ReviewServiceImpl(ReviewRepository reviewRepository,
                             SchoolService schoolService,
                             UserService userService,
                             ModelMapper modelMapper) {
        this.reviewRepository = reviewRepository;
        this.schoolService = schoolService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<List<ReviewDoc>> getAll() {
        List<ReviewDoc> all = reviewRepository.findAll();
        ResponseEntity<List<ReviewDoc>> ok = ResponseEntity.ok(all);
        return ok;
    }

    @Override
    public ReviewDoc save(ReviewServiceModel rev) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        String schoolId = rev.getSchool();

        ReviewDoc newReview = modelMapper.map(rev, ReviewDoc.class);

//        UserDoc userDoc = userService.addReview(newReview, username);
//        SchoolDoc schoolDoc = schoolService.addReview(newReview, schoolId);
        UserDoc userDoc = userService.findByUsername(username);
        SchoolDoc schoolDoc = schoolService.findById(schoolId);

        newReview.setCreator(userDoc);
        newReview.setSchool(schoolDoc);

        return reviewRepository.save(newReview);
    }

    @Override
    public ReviewDoc delete(String id) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<ReviewDoc> optionalReview = reviewRepository.findReviewDocByIdAndCreator_Username(id, username);

        if (optionalReview.isEmpty()) {
            throw new IllegalArgumentException("Deletion is not possible, you are not the owner of the review or such review does not exist");
        }
        ReviewDoc reviewDoc = optionalReview.get();

       /* userService.deleteReview(reviewDoc, username);
        schoolService.deleteReview(reviewDoc, reviewDoc.getSchool().getName());*/
        reviewRepository.delete(reviewDoc);
        return null;
    }



}
