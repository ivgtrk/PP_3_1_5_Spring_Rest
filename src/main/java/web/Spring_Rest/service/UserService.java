package web.Spring_Rest.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import web.Spring_Rest.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> getAllUsers();

    User getByUsername(String username);

    User getUserById(Long id);

    void saveUser(User user);

    void deleteUser(Long id);

    void createNewUser(User user);
}
