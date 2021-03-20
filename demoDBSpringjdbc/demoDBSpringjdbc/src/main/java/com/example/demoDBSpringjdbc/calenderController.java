package com.example.demoDBSpringjdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class calenderController {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/home")
	public List<bookdate> home() {
		
		LocalDateTime d=LocalDateTime.now();
		
		String sql="DELETE FROM bookdate WHERE LastName=?";
		int r=jdbcTemplate.update(sql, "abc");
		
		if(r>0) {
			System.out.println("raws deleted");
		}
		var rowmapper=BeanPropertyRowMapper.newInstance(bookdate.class);
		String sql1= "SELECT * FROM bookdate";
		List<bookdate> lb=jdbcTemplate.query(sql1, rowmapper);
				
				
				/*sql, new RowMapper<bookdate>() {
 
            public bookdate mapRow(ResultSet result, int rowNum) throws SQLException {
                bookdate bd = new bookdate();
                bd.setLastName(result.getString("LastName"));
                bd.setFirstName(result.getString("FirstName"));
                bd.setBookingDate(result.getLocalDateTime("BookingDate"));
                 
                return bd;
            });
		*/
		return lb;
	}
	
}
