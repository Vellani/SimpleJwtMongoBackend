package aero.flightreview.database.service.impl;

import aero.flightreview.database.model.document.ReviewDoc;
import aero.flightreview.database.model.document.UserDoc;
import aero.flightreview.database.repository.UserRepository;
import aero.flightreview.database.service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UserDoc save(UserDoc doc) {
        doc.setPassword(passwordEncoder.encode(doc.getPassword()));
        return userRepository.save(doc);
    }

    @Override
    public UserDoc findByUsername(String username) {
        Optional<UserDoc> optionalUser = userRepository.findUserDocByUsername(username);
        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("Cannot find username");
        }
        return optionalUser.get();
    }

   /* @Override
    public UserDoc addReview(ReviewDoc newReview, String username) {
        UserDoc userDoc = findByUsername(username);
        userDoc.getReviews().add(newReview);
        return save(userDoc);
    }

    @Override
    public void deleteReview(ReviewDoc reviewDoc, String username) {
        UserDoc userDoc = findByUsername(username);
        userDoc.getReviews().remove(reviewDoc);
        save(userDoc);
    }*/
}
