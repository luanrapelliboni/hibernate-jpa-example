package br.com.playground.service;

import br.com.playground.model.User;
import br.com.playground.repository.UserRepository;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public double calculate(Long id) {
        User user = userRepository.get(id);
        double salary = user.salary();
        Double tax = 0D;
        if (salary >= 0 && salary <= 2000)
            tax = 2d;
        else if (salary > 2000 && salary <= 4000)
            tax = 3d;
        else
            tax = 4d;
        return salary * (1-(tax/100));
    }
}
