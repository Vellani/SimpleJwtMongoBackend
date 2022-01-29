package aero.flightreview.database.service;

import aero.flightreview.database.model.document.ReviewDoc;
import aero.flightreview.database.model.document.UserDoc;

public interface UserService {

    UserDoc save(UserDoc userServiceModel);
    UserDoc findByUsername(String username);
   /* UserDoc addReview(ReviewDoc newReview, String username);
    void deleteReview(ReviewDoc reviewDoc, String username);*/

}
