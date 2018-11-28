package hamlet.alexander.SpeakEasy.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private static final String ORIGINAL = " ";
    private static final String ENCODED_DELIMETER = "_";

    public User findByUserName(String userName) {
        User user = userRepository.findByUserName(userName.replace(ORIGINAL, ENCODED_DELIMETER));
        user.setUserName(userName);
        return user;
    }

    public List<User> findByRole(String role) {

        List<User> users = userRepository.findByRole(role);
        for(User user : users) {
            user.setUserName(user.getUserName().replace(ENCODED_DELIMETER, ORIGINAL));
        }

        return users;
    }

    public void save(User user) {
        user.setUserName(user.getUserName().replace(ORIGINAL, ENCODED_DELIMETER));
        userRepository.save(user);
    }
}
