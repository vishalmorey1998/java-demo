package com.user.app.exeception;

public class UserNotFoundException extends RuntimeException
{
	public UserNotFoundException( String message)
	{
		super(message);
	}

}
