 package com.user.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.user.app.model.User;
import com.user.app.service.UserServiceI;
@CrossOrigin("http://localhost:5174")
@RestController
public class UserController {
	@Autowired private UserServiceI userservicei;
	
	@PostMapping("/user")
	public ResponseEntity<User> createUser(
			                                 @RequestPart("data")String userjson,
			                                 @RequestPart(value = "pan",required = false) MultipartFile pancard,
			                                 @RequestPart("aadhar") MultipartFile aadharcard,
			                                 @RequestPart("prof") MultipartFile profile)
	{
		User userRef=userservicei.saveUser(userjson,pancard,aadharcard,profile);
		
		return new ResponseEntity<User>(userRef,HttpStatus.CREATED);
	}
	@GetMapping("/getAllUser")
	public ResponseEntity<List<User>> onGetAllUser()
	{
		List<User> userRef =userservicei.getAllUser();
		return new ResponseEntity<List<User>>(userRef,HttpStatus.OK);
	}
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<Void> deleteUser (@PathVariable("id") int id)
	{
		userservicei.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
  @GetMapping("/getAllUser/{id}")
  public ResponseEntity<User>onGetSingleData(@PathVariable("id") int id)
  {
	  User userRef=userservicei.onGetById(id);
	  return new ResponseEntity<User>(userRef,HttpStatus.OK); 
  }
  
  @PutMapping("/editUserData/{id}")
  public ResponseEntity<User> onEditUser(@PathVariable("id")int id,
		                                 @RequestPart( value = "data",required = false) String userJson,
		                                 @RequestPart(value = "pan", required = false) MultipartFile pancard,
		                                 @RequestPart( value = "aadhar",required = false) MultipartFile aadharcard,
		                                 @RequestPart ( value = "prof", required = false) MultipartFile profile)
  {
	  User userRef=userservicei.onEditUser(id,userJson,pancard,aadharcard,profile);
	  return new ResponseEntity<User>(userRef,HttpStatus.CREATED);
  }

}
