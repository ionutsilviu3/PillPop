package application;

import java.util.regex.Pattern;

public class RegexVerification {

	public enum state{
		INVALID,
		VALID,
		EMPTY
	}
	
	public static state validateUsername(String username)
	{
		
		if(username == null || username.isEmpty())
		{
			return state.EMPTY;
		}
		
		String usernameRegex = "^[A-Za-z+_.-]+.{6,20}$";
		Pattern pattern = Pattern.compile(usernameRegex);
		
		if(pattern.matcher(username).matches())
		{
			return state.VALID;
		}
		else
			return state.INVALID;
	}
	
	public static state validatePassword(String password)
	{
		if(password == null || password.isEmpty())
		{
			return state.EMPTY;
		}
		
		String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$";
		Pattern pattern = Pattern.compile(passwordRegex);
		
		if(pattern.matcher(password).matches())
		{
			return state.VALID;
		}
		else
			return state.INVALID;
	}
	
	public static state validateEmail(String email)
	{
		if(email == null || email.isEmpty())
		{
			return state.EMPTY;
		}
		
		String emailRegex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		Pattern pattern = Pattern.compile(emailRegex);
		
		if(pattern.matcher(email).matches())
		{
			return state.VALID;
		}
		else
			return state.INVALID;
	}

}
