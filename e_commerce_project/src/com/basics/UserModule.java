package com.basics;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class User
{
	private String userName, userPassword, securityQuestion, securityAnswer;
	
	public User(String userName, String userPassword, String securityQuestion, String securityAnswer)
	{
		this.userName = userName;
		this.userPassword = userPassword;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
	}

	public String getUserPassword() 
	{
		return userPassword;
	}

	public String getUserSecQuestion() {
		return securityQuestion;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setPassword(String newPassword) {
		this.userPassword = newPassword;
	}
}

public class UserModule 
{
	static Map<String, User> users = new HashMap<>();
	
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1. login \n2. register ");
		int choice = scanner.nextInt();
		scanner.nextLine();
		
		switch (choice)
		{
		case 1 :
			loginUser(scanner);
			break;
		   
		case 2 :
			registerUser(scanner);
			break;
			
		default :
			System.out.println("Invalid");
		}	
		scanner.close();
	}
	
	public static void loginUser(Scanner scanner)
	{
		System.out.println("Enter user name : ");
		String username = scanner.next();
		scanner.nextLine();
		
		User user = users.get(username);
		
		System.out.println("1. Enter password \n 2.Forgot password : ");
		int choice = scanner.nextInt();
		scanner.nextLine();
		
		switch (choice) 
		{
		case 1 :
			
            System.out.println("Enter password: ");
            String password = scanner.nextLine();
            
            if (user.getUserPassword().equals(password)) 
                System.out.println("Successfully logged in...");
            else 
            	
                System.out.println("Incorrect password.");
            
		case 2 :
			
			System.out.println("Security question : " + user.getUserSecQuestion());
			System.out.println("Answer : ");
			
			String answer = scanner.next();
			
	        if (user.getSecurityAnswer().equalsIgnoreCase(answer)) 
	        {
	            System.out.print("Set a new password: ");
	            String newPassword = scanner.nextLine();
	            user.setPassword(newPassword);
	            System.out.println("Password reset successfully! You can now login.");
	            loginUser(scanner);
	            break;
	        }
	        else 
	            System.out.println("Incorrect answer.");
		}
			
	}
	
	public static void registerUser(Scanner scanner)
	{
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Set your password: ");
        String password = scanner.nextLine();

        System.out.print("Security question : \n What is your pet's name? \n Name of your childhood bestfriend?  ");
        String securityQuestion = scanner.nextLine();

        System.out.print("Set the answer to the security question: ");
        String securityAnswer = scanner.nextLine();

        users.put(username, new User(username, password, securityQuestion, securityAnswer));
        System.out.println("\nRegistration successful! You can now login.\n");
        loginUser(scanner);
	}

}
