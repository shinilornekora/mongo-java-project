package org.shiniasse.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Builder
@Document(collection = "projects")
public class Project extends Base{
    @Indexed(unique = true)
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    //    TODO enums
    private String status; //(for example, “in progress”, “completed”)
    private BigDecimal budget;

    private List<Task> tasks;
}
