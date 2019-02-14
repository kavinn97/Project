	package com.chainsys.jdbc;

import java.util.Scanner;

public class TestBookDAO {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		Scanner scanner = new Scanner(System.in);
		BookDAO bookDAO = new BookDAO();
		Book book=new Book();
	int choice;
		do
		{
			
			System.out.println("1.ADD");
			System.out.println("2.Display all");
			System.out.println("3.Update");
			System.out.println("4.Delete");
			choice=scanner.nextInt();
			switch(choice)
			{
			case 1:{
				
				System.out.println("Enter name,price and id");
				
			
				book.name= scanner.next();
				book.price = scanner.nextInt();
				book.id = scanner.nextInt();
				BookValidator validator = new BookValidator();
				try {
					validator.validateBook(book);
					bookDAO.addBook(book);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				break;
				case 2:
				{
					bookDAO.findAll();
				}
				break;
				case 3:
				{

					System.out.println("Enter the user id and name");
					book.name=scanner.next();
					book.id=scanner.nextInt();
					bookDAO.updateBook(book);
					
				}
				break;
				case 4:
				{
					
					System.out.println("Enter the user id and name");
					book.name=scanner.next();
					book.id=scanner.nextInt();
					bookDAO.deleteBook(book);
					
					
					
				
				
			}
			
			}
			
		}
		while(choice<5);
		
		
		
		
		
		
		
		
		
		
		
	
		
		
		scanner.close();
	}

}
