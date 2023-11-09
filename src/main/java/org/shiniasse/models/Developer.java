package org.shiniasse.models;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Developer extends Base{
    private String name;
    private String surname;
    private String position;
    private int experience;
    private BigDecimal salary;
}
