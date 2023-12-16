package br.com.playground;

import br.com.playground.model.User;
import br.com.playground.repository.UserRepositoryImpl;
import br.com.playground.service.UserServiceImpl;

public class Launcher {
    public static void main(String[] args) {
        var userRepository = new UserRepositoryImpl();

        var johnUser = userRepository.create(User.builder()
                        .name("John")
                        .salary(1000d)
                .build());

        var userService = new UserServiceImpl(userRepository);
        var salary = userService.calculate(johnUser.getUuid());

        var formattedText = johnUser.getName()
                                .concat(" salary is: ")
                                .concat(String.valueOf(salary));

        System.out.println(formattedText);

    }
}
