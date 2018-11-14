package hamlet.alexander.SpeakEasy.User;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, Integer> {

    public User findByUserName(String userName);
    public List<User> findByRole(String role);
}
