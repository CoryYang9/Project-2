package com.example.demoDBSpringjdbc.controller;

import java.awt.print.Book;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoDBSpringjdbc.model.BookDate;
import com.example.demoDBSpringjdbc.repository.BookDateRepository;

@RestController
@RequestMapping(path="/bookdate")
public class BookDateController {

	@Autowired
	BookDateRepository bookDateRepository ;
	
	@GetMapping(path = "/getall")
	public List<BookDate> getAllBookDate() {

		List<BookDate> allList = bookDateRepository.getAllBookDate();
		return allList;
	}
	
	@GetMapping(path = "/getall/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
		
		BookDate bd = bookDateRepository.getById(id);
		if (bd == null) {
            return new ResponseEntity<String>("No User found with this "+ id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<BookDate>(bd, HttpStatus.OK);
		
	}
	
	@PostMapping(path = "/addbookdate")
	public ResponseEntity<String>  addBookDate(@RequestBody BookDate bookdate) {
		
		 if (bookDateRepository.getById(bookdate.getID()) != null) {
	            return new ResponseEntity<String>("Duplicate Entry "+ bookdate.getID(), HttpStatus.IM_USED);
	        }
		
		String result= bookDateRepository.insertBookDate(bookdate);
	    return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	
	@DeleteMapping(path = "/deletebookdate/{id}")
	public ResponseEntity<?> deleteBookDate(@PathVariable Integer id) {
		
		BookDate bd = bookDateRepository.getById(id);
		if (bd == null) {
			return new ResponseEntity<String>("Unable to delete as  User id " + id + " not found.", HttpStatus.NOT_FOUND);
		}
		String result = bookDateRepository.deleteBookDate(id);
		return new ResponseEntity<String>(result,HttpStatus.NO_CONTENT);
	}
	
}
