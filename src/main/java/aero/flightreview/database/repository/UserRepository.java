package aero.flightreview.database.repository;

import aero.flightreview.database.model.document.UserDoc;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserDoc, String> {

    Optional<UserDoc> findUserDocByUsername(String username);
}
