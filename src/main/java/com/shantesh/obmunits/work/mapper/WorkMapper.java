package com.shantesh.obmunits.work.mapper;

import org.springframework.stereotype.Service;

import com.shantesh.obmunits.work.dto.WorkDto;
import com.shantesh.obmunits.work.entity.Work;

@Service
public class WorkMapper {
	public Work workDtoToWork(WorkDto workDto) {
		return Work.builder()
				.personId(workDto.getPersonId())
				.weekNo(workDto.getWeekNo())
				.unitsOfWork(workDto.getUnitsOfWork())
				.projectNo(workDto.getProjectNo())
				.build();
	}
	public WorkDto workToWorkDto(Work work) {
		return WorkDto.builder()
				.personId(work.getPersonId())
				.weekNo(work.getWeekNo())
				.unitsOfWork(work.getUnitsOfWork())
				.projectNo(work.getProjectNo())
				.build();
	}
}
