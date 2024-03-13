package com.shantesh.obmunits.work.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "work")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Work {
	@Id
	private String id;
	
    @Field("person_id")
    private String personId;
    
    @Field("week_no")
    private Integer weekNo;
    
    @Field("units_of_work")
    private Integer unitsOfWork;
    
    @Field("project_no")
    private String projectNo;
}
