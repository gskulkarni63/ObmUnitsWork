package com.shantesh.obmunits.work.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.shantesh.obmunits.work.dto.WorkDto;
import com.shantesh.obmunits.work.dto.WorkDtoSave;
import com.shantesh.obmunits.work.service.WorkServiceImpl;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class WorkController {

	private final WorkServiceImpl workService;
	private final String API_URL="/work";
	private final String API_URL_ID=API_URL+"/{id}";
	private final String API_URL_PERSON_ID = API_URL+"/person/{personId}";
	
	@PostMapping(API_URL)
	public ResponseEntity<String> saveWork(@RequestBody WorkDtoSave workDto){
		System.out.println(workDto.toString());
		workService.saveWork(workDto);
		return ResponseEntity.ok("The work is created");
		
	}
	
	@GetMapping(API_URL_PERSON_ID)
	public ResponseEntity<List<WorkDto>> findWorkByPersonId(@PathVariable String personId){
		List<WorkDto> listOfWorkByPersonId=workService.getWorkByPersonId(personId);
		if(listOfWorkByPersonId.size()==0) {
			return new ResponseEntity<List<WorkDto>>(new ArrayList<>(),HttpStatusCode.valueOf(404));
		}
		return ResponseEntity.ok(listOfWorkByPersonId);
	}
	@PutMapping(API_URL_ID)
	public ResponseEntity<String> updateWorkById(@PathVariable String id,@RequestBody WorkDto workDto){
		workService.putWorkByWorkId(id, workDto);
		return ResponseEntity.ok("The work is updated");
	}
	
	@DeleteMapping(API_URL_ID)
	public ResponseEntity<String> deleteWorkById(@PathVariable String id){
		workService.deleteWorkByWorkId(id);
		return ResponseEntity.ok("The work is deleted");
	}
	@GetMapping(API_URL_ID)
	public ResponseEntity<WorkDto> getWorkByWorkId(@PathVariable String id){
		Optional<WorkDto> work= workService.getWorkById(id);
		return ResponseEntity.ok(work.get());
	}
}
