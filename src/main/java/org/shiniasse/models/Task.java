package org.shiniasse.models;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@Builder
public class Task extends Base {

    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    //    TODO enums
    private String status; //(for example, “in progress”, “completed”)
    //    TODO enums
    private String priority;

    private Set<Developer> developers;
}
