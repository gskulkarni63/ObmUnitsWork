package com.shantesh.obmunits.work.controller;

import java.util.List;

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
import com.shantesh.obmunits.work.service.WorkServiceImpl;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class WorkController {

	private final WorkServiceImpl workService;
	
	@PostMapping("/work")
	public ResponseEntity<?> saveWork(@RequestBody WorkDto workDto){
		System.out.println(workDto.toString());
		workService.saveWork(workDto);
		return ResponseEntity.ok("The work is created");
	}
	
	@GetMapping("/work/{personId}")
	public ResponseEntity<?> findWorkByPersonId(@PathVariable String personId){
		List<WorkDto> listOfWorkByPersonId=workService.getWorkByPersonId(personId);
		if(listOfWorkByPersonId.size()==0) {
			return new ResponseEntity<String>("not found",HttpStatusCode.valueOf(404));
		}
		return ResponseEntity.ok(listOfWorkByPersonId);
	}
	@PutMapping("/work/{id}")
	public ResponseEntity<?> updateWorkById(@PathVariable String id,@RequestBody WorkDto workDto){
		workService.putWorkByWorkId(id, workDto);
		return ResponseEntity.ok("The work is updated");
	}
	
	@DeleteMapping("/work/{id}")
	public ResponseEntity<?> deleteWorkById(@PathVariable String id){
		workService.deleteWorkByWorkId(id);
		return ResponseEntity.ok("The work is deleted");
	}
}
