package com.example.demoDBSpringjdbc.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demoDBSpringjdbc.model.BookDate;
import com.example.demoDBSpringjdbc.model.BookDateRowMapper;

@Repository
public class BookDateRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<BookDate> getAllBookDate() {
		
		var rowmapper=BeanPropertyRowMapper.newInstance(BookDate.class);
		String sql1= "SELECT * FROM bookdate";
		List<BookDate> lb=jdbcTemplate.query(sql1, rowmapper);
		
		return lb; 
	}
	
	public BookDate getById(Integer id) {
	
		String sql1= "SELECT * FROM bookdate where ID=?";
		try
		{
		BookDate objectbd =(BookDate) jdbcTemplate.queryForObject(sql1, new BookDateRowMapper(), id);
		//BookDate objectbd = jdbcTemplate.queryForObject(sql1, BookDate.class, new Object[] {id});
		return objectbd;
		}
		catch(EmptyResultDataAccessException ex){
            return null;
        }
	}
	
	public String insertBookDate(BookDate bookdate) {
		
		LocalDateTime d=LocalDateTime.now();
		String sql="INSERT INTO bookdate (FirstName, LastName, BookingDate) VALUES (?, ?, ?)";
		int r=jdbcTemplate.update(sql, bookdate.getFirstName(), bookdate.getLastName(), bookdate.getBookingDate());
		
		if(r>0) {
			return "one raw inserted";
		}
		else {
			return "insertion failed";
		}
	}
	
	public String deleteBookDate(int id ) {
		
		String sql="DELETE FROM bookdate WHERE id=?";
		int r=jdbcTemplate.update(sql, id);
		
		if(r>0) {
			return "raws deleted";
		}
		else {
			return "no record found !!!";
		}
	}

}
