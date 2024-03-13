package com.shantesh.obmunits.work.service;

import java.util.List;
import java.util.Optional;

import com.shantesh.obmunits.work.dto.WorkDto;
import com.shantesh.obmunits.work.dto.WorkDtoSave;

public interface WorkService {
	public void saveWork(WorkDtoSave workDto);
	public List<WorkDto> getWorkByPersonId(String workId);
	public void putWorkByWorkId(String workId,WorkDto workDto);
	public void deleteWorkByWorkId(String workId);
	public void patchWorkByWorkId(String workId,WorkDto workDto);
	public Optional<WorkDto> getWorkById(String workId);
	 
}
