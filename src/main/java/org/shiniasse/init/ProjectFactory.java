package org.shiniasse.init;

import com.github.javafaker.Faker;
import org.shiniasse.models.Project;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProjectFactory {
    @Autowired
    private TaskFactory taskFactory;
    private final Faker faker = new Faker();

    private String name(){
        return faker.beer().name();
    }
    private String description(){
        return "some text";
    }
    private Date startDate(){
        return faker.date().between(new Date(2017, 01,01), new Date(2020, 01,01));
    }
    private Date endDate(){
        return faker.date().between(new Date(2021, 01,01), new Date(2025, 01,01));
    }
    private BigDecimal budget(){
        return BigDecimal.valueOf(faker.number().numberBetween(1_000_000, 7_000_000));
    }
    public Project create(int number) {
        return Project.builder()
                .name(name())
                .description(description())
                .startDate(startDate())
                .endDate(endDate())
                .budget(budget())
                .tasks(taskFactory.createTasks(number))
                .build();
    }

    public List<Project> createProjects(int number) {
        return IntStream.range(0, number)
                .mapToObj(i -> create(number))
                .collect(Collectors.toList());
    }
}
