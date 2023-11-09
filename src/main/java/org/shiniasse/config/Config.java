package org.shiniasse.config;

import org.shiniasse.init.DeveloperFactory;
import org.shiniasse.init.ProjectFactory;
import org.shiniasse.init.TaskFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class Config extends AbstractMongoClientConfiguration {
    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoDbFactory());
    }
    @Bean
    public ProjectFactory projectFactory() {
        return new ProjectFactory();
    }
    @Bean
    public TaskFactory taskFactory() {
        return new TaskFactory();
    }
    @Bean
    public DeveloperFactory developerFactory() {
        return new DeveloperFactory();
    }
    @Override
    protected String getDatabaseName() {
        return "projects";
    }
}
