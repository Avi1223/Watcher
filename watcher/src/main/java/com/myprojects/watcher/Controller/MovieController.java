package com.myprojects.watcher.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
	@GetMapping("/public/healthCheck")
	public ResponseEntity<Object> getPublicMovie(){
		return new ResponseEntity<>("Running Properly",HttpStatus.OK);
	}
	
	@GetMapping("/private/healthCheck")
	public ResponseEntity<Object> getPrivateMovie(){
		return new ResponseEntity<>("Running Properly",HttpStatus.OK);
	}
}
