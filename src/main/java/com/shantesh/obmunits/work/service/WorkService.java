package com.shantesh.obmunits.work.service;

import java.util.List;

import com.shantesh.obmunits.work.dto.WorkDto;

public interface WorkService {
	public void saveWork(WorkDto workDto);
	public List<WorkDto> getWorkByPersonId(String workId);
	public void putWorkByWorkId(String workId,WorkDto workDto);
	public void deleteWorkByWorkId(String workId);
	public void patchWorkByWorkId(String workId,WorkDto workDto);
	
}
