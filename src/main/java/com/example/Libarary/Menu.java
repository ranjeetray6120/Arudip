package com.example.Libarary;

import DOA.BooksDOA;
import DOAImpl.BooksDOAImpl;
import model.Books;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Menu {
	private void menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=====================================================");
		System.out.println("        Welcome to Liarary management System.");
		System.out.println("=====================================================");
		
		while(true) {
			
			System.out.println("1.Add a Book.");
			System.out.println("2.View All Books.");
			System.out.println("3.Search for a Book by ID");
			System.out.println("4.Delete a Book by ID");
			System.out.println("5.Exit the System");
			System.out.println("Enter the choice.");
			int ch = sc.nextInt();
			
			sc.nextLine();
			
			switch(ch) {
					case 1:{
						System.out.print("Enter the Book Tital Name: ");
						String title = sc.nextLine();
						System.out.print("Enter the Author Name: ");
						String author = sc.nextLine();
						System.out.print("Enter the price:");
						double price = sc.nextDouble();
						BooksDOA book = new BooksDOAImpl();
						 Books newBook = new Books(title, author, price);
						book.addbooks(newBook);
						break;
					}
					case 2:{
						BooksDOA bookDOA = new BooksDOAImpl();
						List<Books> allList = bookDOA.getAllBooks();
						if(allList.isEmpty()) {
							System.out.println("No book found.");
						}else {
							for(Books book:allList) {
								System.out.println("Book ID: "+book.getBool_id());
								System.out.println("Title: "+book.getTital());
								System.out.println("Author: "+book.getAuthor());
								System.out.println("Price: "+book.getPrice());
								System.out.println("_________________________________________");
							}
						}
						
						break;
					}
					case 3:{
							System.out.print("Enter the Book ID: ");
							int bookId = sc.nextInt();
							BooksDOA bookDOA = new BooksDOAImpl();
							Books book = bookDOA.getBookbybookid(bookId);
							if(book != null) {
								System.out.println("Book ID: "+bookId);
								System.out.println("Title: "+book.getTital());
								System.out.println("Author: "+book.getAuthor());
								System.out.println("Price: "+book.getPrice());
								System.out.println("_______________________________");
							}
							
						break;
					}
					case 4:{
						System.out.println();
						break;
					}
					case 5:{
						System.exit(0);
						break;
					}
					default:{
						System.out.println("");
					}
			}
			
		}
	}
	
	public void display() {
		menu();
	}
}
