package com.user.app.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.user.app.model.User;

public interface UserServiceI {

	public User saveUser(String userjson, MultipartFile pancard, MultipartFile aadharcard, MultipartFile profile);

	public List<User> getAllUser();

	public void deleteById(int id);

	public User onGetById(int id);

	public User onEditUser(int id, String userJson, MultipartFile pancard, MultipartFile aadharcard,
			MultipartFile profile);

}
