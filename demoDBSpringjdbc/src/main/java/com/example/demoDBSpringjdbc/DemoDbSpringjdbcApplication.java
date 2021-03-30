package com.example.demoDBSpringjdbc;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class DemoDbSpringjdbcApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoDbSpringjdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*LocalDateTime d=LocalDateTime.now();
		
		String sql="INSERT INTO bookdate (LastName, FirstName, BookingDate) VALUES (?, ?, ?)";
		int r=jdbcTemplate.update(sql, "abc1", "xyz1", d);
		
		if(r>0) {
			System.out.println("one raw inserted");
		}*/
	}

}
