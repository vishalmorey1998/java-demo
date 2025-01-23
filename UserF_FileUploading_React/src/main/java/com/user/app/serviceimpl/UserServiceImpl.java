package com.user.app.serviceimpl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.app.exeception.UserNotFoundException;
import com.user.app.model.User;
import com.user.app.repository.UserRepository;
import com.user.app.service.UserServiceI;
@Service
public class UserServiceImpl implements UserServiceI
{  @Autowired  private UserRepository userepo;
   @Autowired private ObjectMapper mapper;

	@Override
	public User saveUser(String userjson, MultipartFile pancard, MultipartFile aadharcard, MultipartFile profile) 
	{

		User user=null;
		try {
			user = mapper.readValue(userjson, User.class);
		if(!pancard.isEmpty()) user.setPancardImage(pancard.getBytes());
		if(!aadharcard.isEmpty()) user.setAadharCardImage(aadharcard.getBytes());
		if(!profile.isEmpty()) user.setProfileImage(profile.getBytes());
		
		return userepo.save(user);
			
		} 
		catch (JsonMappingException e) {
			
			e.printStackTrace();
		} 
		catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<User> getAllUser() {
		
		return userepo.findAll();
	}

	@Override
	public void deleteById(int id) {
		boolean isuser = userepo.existsById(id);
		if(isuser)
		{
			userepo.deleteById(id);
		}
		else {
			throw new UserNotFoundException("Id not Found"+id);
		}
	}

	@Override
	public User onGetById(int id) {
		Optional<User> optionalUser= userepo.findById(id);
		if(optionalUser.isEmpty())
		{
			throw new UserNotFoundException("User Not Found on Given id "+id);
		}
		return optionalUser.get();
	}

	@Override
	public User onEditUser(int id, String userJson, MultipartFile pancard, MultipartFile aadharcard,
			MultipartFile profile) {
		  Optional<User> optinalUser = userepo.findById(id);
		  if(optinalUser.isEmpty())
		  {
			  throw new UserNotFoundException("user not found on given id"+id);
		  }
		  ObjectMapper mapper=new ObjectMapper();
		       User user = optinalUser.get();
		       
		       try {
				User ur=mapper.readValue(userJson, User.class);
			if(ur.getFullName()!=null) user.setFullName(ur.getFullName());
            if(ur.getUserName()!=null) user.setUserName(ur.getUserName());
            if(ur.getPassword()!=null) user.setPassword(ur.getPassword());
            if(ur.getContactNumber()!=0)user.setContactNumber(ur.getContactNumber());
           if(pancard!=null)
			try {
				user.setPancardImage(pancard.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           if(aadharcard!=null)
			try {
				user.setAadharCardImage(aadharcard.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           if(profile!=null)
			try {
				user.setProfileImage(profile.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
           return userepo.save(user);
		       
		       } 
		       
		       
		       catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	}

}
