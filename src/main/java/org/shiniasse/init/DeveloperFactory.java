package org.shiniasse.init;

import com.github.javafaker.Faker;
import org.shiniasse.models.Developer;
import org.shiniasse.models.Task;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DeveloperFactory {
    private final Faker faker = new Faker();
    private String name(){
        return faker.name().firstName();
    }
    private String surname(){
        return faker.name().lastName();
    }
    private String position(){
        List<String> position = new ArrayList<>();
        position.add("Junior");
        position.add("Midl");
        position.add("Sin");
        Random random = new Random();
        return position.get(random.nextInt(2));
    }
    private int experience(){
        Random random = new Random();
        return random.nextInt(20);
    }
    private BigDecimal salary(){
        return BigDecimal.valueOf(faker.number().numberBetween(100_000, 700_000));
    }

    public Developer create() {
        return Developer.builder()
                .name(name())
                .surname(surname())
                .position(position())
                .experience(experience())
                .salary(salary())
                .build();
    }

    public Set<Developer> createDevelopers(int number) {
        return IntStream.range(0, number)
                .mapToObj(i -> create())
                .collect(Collectors.toSet());
    }
}
