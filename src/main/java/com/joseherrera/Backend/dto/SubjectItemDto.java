
package com.joseherrera.Backend.dto;

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
public class SubjectItemDto {
    
    private int id;
    private String title;
    private String date;
    private String certificate ;
    
}
