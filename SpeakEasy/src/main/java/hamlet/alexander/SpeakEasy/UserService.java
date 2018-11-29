package hamlet.alexander.SpeakEasy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User DATA ACCESS OBJECT service layer.
 *
 * Object that interacts with
 * user data coming in and out of the
 * USER Collection in the Mongo Database.
 *
 * Applys minimal business logic to ensure
 * correct formatting.
 */
@Service
public class UserService {

    /**
     * MongoRepository object for User data.
     */
    @Autowired
    private UserRepository userRepository;

    private static final String ORIGINAL = " ";
    private static final String ENCODED_DELIMETER = "_";

    /**
     * Grabs user data by using a username as a search query.
     * Insures spaces are converted to underscores for query.
     *
     * @param userName
     * @return
     */
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName.replace(ORIGINAL, ENCODED_DELIMETER));
    }

    /**
     * Grabs all user data with a specified role.
     *
     * @param role
     * @return
     */
    public List<User> findByRole(String role) {
        return userRepository.findByRole(role);
    }

    /**
     * Inputs user information into MongoDB.
     * Insures all spaces become underscores for simple storage.
     *
     * @param user
     */
    public void save(User user) {
        user.setUserName(user.getUserName().replace(ORIGINAL, ENCODED_DELIMETER));
        userRepository.save(user);
    }
}
