package org.shiniasse.repositories;

import org.shiniasse.models.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends MongoRepository<Project, String> {
    Project findByName(String name);

    void deleteByName(String name);
    @Query("[{$match:{budget:{$gte:5000}}}, {$group:{_id:\"$name\", total:{$sum:1}}}, {$out:\"sums\"}]")
    List<Project> aggregateProjectsBySum();
}


