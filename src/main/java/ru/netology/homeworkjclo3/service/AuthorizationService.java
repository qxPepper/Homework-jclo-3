package ru.netology.homeworkjclo3.service;

import ru.netology.homeworkjclo3.exceptions.UnauthorizedUser;
import ru.netology.homeworkjclo3.repository.Authorities;
import ru.netology.homeworkjclo3.repository.UserRepository;
import ru.netology.homeworkjclo3.user.User;

import java.util.List;

public class AuthorizationService {
    private String user;
    private String password;
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User userObject) {
        HandlerMethodArgumentResolver(userObject);

        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }

    private void HandlerMethodArgumentResolver(User userObject) {
        user = userObject.getUser();
        password = userObject.getPassword();
    }
}

