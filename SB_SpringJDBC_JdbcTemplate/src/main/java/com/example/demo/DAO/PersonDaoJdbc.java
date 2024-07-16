package com.example.demo.DAO;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.Entitites.Person;

@Repository
public class PersonDaoJdbc {

	//getting database connections
		@Autowired
		JdbcTemplate jdbcTemplate;
		
		//BeanPropertyRowMapper = to map entity class with h2 table in results
		
		//creating custom RowMapper with org.springframework.jdbc.core.RowMapper;
		//-> when table column names and 
		//bean variable names are not same
		class PersonRowMapper implements RowMapper<Person>
		{

			@Override
			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				System.out.println("initiated....");
				Person p = new Person();
				//inner written are column names from table
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setLocation(rs.getString("location"));
				p.setBirthDate(rs.getTimestamp("birth_date"));
				return p;
			}
		}
		
		//getAll using custom row mapper
			public List<Person> getAllUsingCustomRowMapper()
			{
				return jdbcTemplate.query("select * from person",
						new PersonRowMapper());
			}
		
		
		//select * from person
		//getAll
		public List<Person> getAll()
		{
			return jdbcTemplate.query("select * from person",
					//BeanPropertyRowMapper automatically maps to entity fields
					new BeanPropertyRowMapper<Person>(Person.class));
		}
		
		
		//getById
		@SuppressWarnings("deprecation")
		public Person getByid(int id)
		{
			return jdbcTemplate.queryForObject
					("select * from person where id=?",
					new Object[] {id},
					//BeanPropertyRowMapper maps query results with bean class
					//column name and filed name should be same
					new BeanPropertyRowMapper<Person>(Person.class));
		}
		
		//get by location
		public List<Person> getAllById(String location)
		{
			return jdbcTemplate.query("select * from person where location='"+location+"'"
					,new BeanPropertyRowMapper<Person>(Person.class));
		}

		//delete by id
		public int deleteById(int id)
		{
			//return no of rows updated
			return jdbcTemplate.update
					("delete from person where id=?",
					new Object[] {id});
		}
		

		//delete by id
		public int deleteByIdAndName(int id,String user)
		{
			//return no of rows updated
			return jdbcTemplate.update
					("delete from person where id=? and name=?",
					new Object[] {id,user});
		}
		
		
		public int insert(Person person)
		{
			return jdbcTemplate.update(
					"insert into Person (id,name,location,birth_date) values (?,?,?,?)",
					new Object[] {person.getId(),
							person.getName(),
							person.getLocation(),
							//timestamp = java.util
							new Timestamp(person.getBirthDate().getTime())});
		}
		
		public int update(Person person)
		{
			return jdbcTemplate.update(
					"update person set name=? , location=? , birth_date=? where id=?",
					new Object[] {
							person.getName(),
							person.getLocation(),
							//timestamp = java.util
							new Timestamp(person.getBirthDate().getTime()),
							person.getId()
							});
		}
}
