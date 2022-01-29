package aero.flightreview.database.repository;

import aero.flightreview.database.model.document.SchoolDoc;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends MongoRepository<SchoolDoc, String> {
}
