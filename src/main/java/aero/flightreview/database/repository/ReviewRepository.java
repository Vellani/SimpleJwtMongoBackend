package aero.flightreview.database.repository;

import aero.flightreview.database.model.document.ReviewDoc;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReviewRepository extends MongoRepository<ReviewDoc, String> {

    Optional<ReviewDoc> findReviewDocByIdAndCreator_Username(String id, String creator_username);
}
