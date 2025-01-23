package com.user.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.app.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{

	

}
