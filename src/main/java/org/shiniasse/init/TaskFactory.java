package org.shiniasse.init;

import com.github.javafaker.Faker;
import org.shiniasse.models.Task;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TaskFactory {
    @Autowired
    private DeveloperFactory developerFactory;
    private final Faker faker = new Faker();

    private String name(){
        return faker.funnyName().name();
    }
    private String description(){
        return "some text";
    }
    private Date startDate(){
        return faker.date().between(new Date(2010, 01,01), new Date(2020, 01,01));
    }
    private Date endDate(){
        return faker.date().between(new Date(2023, 01,01), new Date(2030, 01,01));
    }

    private String priority(){
        List<String> priority = new ArrayList<>();
        priority.add("Easy");
        priority.add("Medium");
        priority.add("Hard");
        Random random = new Random();
        return priority.get(random.nextInt(2));
    }
    public Task create(int number) {
        return Task.builder()
                .name(name())
                .description(description())
                .startDate(startDate())
                .endDate(endDate())
                .priority(priority())
                .developers(developerFactory.createDevelopers(number))
                .build();
    }

    public List<Task> createTasks(int number) {
        return IntStream.range(0, number)
                .mapToObj(i -> create(number))
                .collect(Collectors.toList());

    }
}
