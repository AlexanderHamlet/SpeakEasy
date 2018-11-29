package hamlet.alexander.SpeakEasy;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * MongoRepository for user data. Only object to directly
 * interact with user collection in MongoDB.
 */
public interface UserRepository extends MongoRepository<User, Integer> {

    User findByUserName(String userName);
    List<User> findByRole(String role);
}
