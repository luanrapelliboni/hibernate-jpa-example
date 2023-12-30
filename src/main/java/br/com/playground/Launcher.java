package br.com.playground;

import br.com.playground.model.User;
import br.com.playground.repository.UserRepositoryImpl;
import br.com.playground.service.UserServiceImpl;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Launcher {
    public static void main(String[] args) {
        var userRepository = new UserRepositoryImpl();

//        var users = createFakeUsers(100);
        var users = userRepository.findAll();

        for (var user : users) {
            var userService = new UserServiceImpl(userRepository);
            var salaryWithDiscount = userService.calculate(user.getUuid());

            var formattedText = "Name is: "
                    .concat(user.getName())
                    .concat(" salary is: ")
                    .concat(String.valueOf(user.getSalary()))
                    .concat(" salary with discount is: ")
                    .concat(String.valueOf(salaryWithDiscount));

            System.out.println(formattedText);
        }
        //System.out.println("done.");
    }

    public static List<User> createFakeUsers(Integer quantityOfUsers) {
        var users = new ArrayList<User>();
        var userRepository = new UserRepositoryImpl();

        var faker = new Faker(new Locale("pt-BR"));

        for (var i = 0; i < quantityOfUsers; ) {
            var name = faker.name().fullName();
            var salary = faker.number().randomDouble(4, 0, 1000);
            var user = userRepository.create(User.builder()
                    .name(name)
                    .salary(salary)
                    .build());

            users.add(user);
            i++;
        }

        return users;
    }
}
