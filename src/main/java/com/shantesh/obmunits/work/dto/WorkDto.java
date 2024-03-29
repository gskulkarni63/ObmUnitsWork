package com.shantesh.obmunits.work.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkDto {
	private String workId;
	
    private String personId;
    
    private Integer weekNo;
    
    private Integer unitsOfWork;
    
    private String projectNo;
}
