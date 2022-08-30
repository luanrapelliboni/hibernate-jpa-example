package br.com.playground;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import br.com.playground.model.*;

public class Launcher {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("one", "two", "three");
        names.forEach(System.out::println);
        var user = new User(UUID.randomUUID(), "John", 1000d);

        System.out.println(user.name());
    }
}
