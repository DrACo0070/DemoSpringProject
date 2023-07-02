package com.bway.springDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.springDemo.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUsernameAndPassword(String un, String psw); //made for signin controller

}
//repository is used to work with database
//<User, Integer>
//we write User in place of T to represent for whom we made repository.
//we write Integer in place of ID to represent User's Id data type i.e. Primary Key(Int).
//input data go from view to controller to service to repository to database.