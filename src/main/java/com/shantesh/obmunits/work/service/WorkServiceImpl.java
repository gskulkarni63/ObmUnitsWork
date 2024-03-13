package com.shantesh.obmunits.work.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.shantesh.obmunits.work.dto.WorkDto;
import com.shantesh.obmunits.work.dto.WorkDtoSave;
import com.shantesh.obmunits.work.exception.ObjectNotFound;
import com.shantesh.obmunits.work.mapper.WorkMapper;
import com.shantesh.obmunits.work.repository.WorkRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WorkServiceImpl implements WorkService {

	private final WorkRepository workRepository;
	private final WorkMapper workMapper;
	
	@Override
	public void saveWork(WorkDtoSave workDto) {
		// TODO Auto-generated method stub
		workRepository.save(workMapper.workDtoToWork(workDto));
	}

	@Override
	public List<WorkDto> getWorkByPersonId(String personId) {
		// TODO Auto-generated method stub
		List<WorkDto> listOfWorkDto= workRepository.findByPersonId(personId).stream().map((work)->{
			return workMapper.workToWorkDto(work);
		}).collect(Collectors.toList());
		return listOfWorkDto;
	}
	@Override
	public void putWorkByWorkId(String id, WorkDto workDto) {
		// TODO Auto-generated method stub
		workRepository.findById(id).ifPresentOrElse(
				(work)->{
					workRepository.save(workMapper.workDtoToWork(workDto));
					}, 
				()->{
					throw new ObjectNotFound("the id is not found");
				});
		
	}

	@Override
	public void deleteWorkByWorkId(String id) {
		// TODO Auto-generated method stub
		workRepository.findById(id).ifPresentOrElse(
				(work)->{
					workRepository.deleteById(id);
					}, 
				()->{
					throw new ObjectNotFound("the id is not found");
				});
	}

	@Override
	public void patchWorkByWorkId(String id,WorkDto workDto) {
		// TODO Auto-generated method stub
		workRepository.findById(id).ifPresentOrElse((work)->{
			if(StringUtils.hasText(workDto.getPersonId())) {
				work.setPersonId(workDto.getPersonId());
			}
			if( StringUtils.hasText(workDto.getProjectNo()) ) {
				work.setProjectNo(workDto.getProjectNo());
			}
			if(workDto.getUnitsOfWork() !=0 ) {
				work.setUnitsOfWork(workDto.getUnitsOfWork());
			}
			if(workDto.getWeekNo() !=0){
				work.setWeekNo(workDto.getWeekNo());
			}
		}, ()->{
			throw new ObjectNotFound("the id is not found");
		});
	}

	@Override
	public Optional<WorkDto> getWorkById(String workId) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(workMapper.workToWorkDto(workRepository.findById(workId).get())); 
				
	}

}
