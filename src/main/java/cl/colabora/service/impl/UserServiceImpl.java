package cl.colabora.service.impl;


import cl.colabora.model.User;
import cl.colabora.repository.UserRepository;
import cl.colabora.service.UserService;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        Optional<User> userFinded = userRepository.findById(user.getId());
        if (userFinded.isPresent()){
            User userUpdated = userFinded.get();
            userUpdated.setName(user.getName());
            userRepository.save(userUpdated);
            return userUpdated;
        } else {
            throw new NoResultException("User with id" + user.getId() + "was not found");
        }
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new NoResultException("User with id" + id + "was not found");
        }
    }

    @Override
    public void deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            userRepository.delete(user.get());
        } else {
            throw new NoResultException("User with id" + id + "was not found");
        }
    }
}
