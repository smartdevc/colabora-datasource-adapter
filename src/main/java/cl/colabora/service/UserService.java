package cl.colabora.service;

import cl.colabora.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> getAllUser();

    User updateUser(User user);

    User getUserById(Long id);

    void deleteUser(Long id);
}
