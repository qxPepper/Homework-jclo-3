package ru.netology.homeworkjclo3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.homeworkjclo3.controller.AuthorizationController;
import ru.netology.homeworkjclo3.repository.UserRepository;
import ru.netology.homeworkjclo3.service.AuthorizationService;

@Configuration
public class JavaConfig {
    @Bean
    public AuthorizationController authorizationController(AuthorizationService service) {
        return new AuthorizationController(service);
    }

    @Bean
    public AuthorizationService authorizationService(UserRepository repository) {
        return new AuthorizationService(repository);
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }
}
