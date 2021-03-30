package com.example.demoDBSpringjdbc.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BookDateRowMapper implements RowMapper<BookDate> {
	
	public BookDate mapRow(ResultSet rs, int rowNum) throws SQLException {
        BookDate bd = new BookDate();
        bd.setID(rs.getInt("ID"));
        bd.setFirstName(rs.getString("FirstName"));
        bd.setLastName(rs.getString("LastName"));
        bd.setBookingDate(rs.getDate("BookingDate"));
       
        return bd;
    }

}
