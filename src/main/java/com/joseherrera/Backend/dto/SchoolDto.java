package com.joseherrera.Backend.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SchoolDto {

    private int id;
    private String company;
    private String logo;
    private List<SubjectItemDto> classes;

}
