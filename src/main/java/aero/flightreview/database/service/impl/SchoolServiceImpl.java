package aero.flightreview.database.service.impl;

import aero.flightreview.database.model.document.ReviewDoc;
import aero.flightreview.database.model.document.SchoolDoc;
import aero.flightreview.database.repository.SchoolRepository;
import aero.flightreview.database.service.SchoolService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;

    public SchoolServiceImpl(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @Override
    public SchoolDoc save(SchoolDoc schoolDoc) {
        return schoolRepository.save(schoolDoc);
    }

    @Override
    public ResponseEntity<List<SchoolDoc>> getAll() {
        ResponseEntity<List<SchoolDoc>> ok = ResponseEntity.ok(schoolRepository.findAll());
        return ok;
    }

    @Override
    public SchoolDoc findById(String school) {
        Optional<SchoolDoc> optionalSchool = schoolRepository.findById(school);
        if (optionalSchool.isEmpty()) {
            throw new UsernameNotFoundException("Cannot find school");
        }
        return optionalSchool.get();
    }

    /*@Override
    public SchoolDoc addReview(ReviewDoc newReview, String schoolId) {
        SchoolDoc schoolDoc = findById(schoolId);
        schoolDoc.getReviews().add(newReview);
        return save(schoolDoc);
    }

    @Override
    public void deleteReview(ReviewDoc reviewDoc, String schoolId) {
        SchoolDoc schoolDoc = findById(schoolId);
        schoolDoc.getReviews().remove(reviewDoc);
        save(schoolDoc);
    }*/

}
