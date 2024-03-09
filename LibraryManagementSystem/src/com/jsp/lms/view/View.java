package com.jsp.lms.view;

import java.util.Scanner;

import com.jsp.lms.controller.Controller;
import com.jsp.lms.model.Book;
import com.jsp.lms.model.Library;

public class View {
	static Library library = new Library();
	public static Library getLibrary() {
		return library;
	}

	public static void setLibrary(Library library) {
		View.library = library;
	}
	static Scanner myInput = new Scanner(System.in);
	static Controller controller = new Controller();
	static {
		System.out.println("---Welcome to LMS----");
		System.out.print("Enter name of Library :");
		String libeaeyname = myInput.nextLine();
		library.setLibraryName(libeaeyname);
		System.out.println("Enter address of library : ");
		library.setLibraryAddress(myInput.nextLine());
		System.out.print("Enter pin code : ");
		library.setPincode(myInput.nextInt());
		myInput.nextLine();
		System.out.println("---------- Library Information Stored As : ----------\n" + library.getLibraryName() + ".\n"
				+ library.getLibraryAddress() + ".PINCODE - " + library.getPincode()
				+ "\n_\n");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		do {
			System.out.println("Select Option To Perform : ");
			System.out.println("1. Add book\n2. Remove book\n3. Update book\n4. Get book\n0. Exit");
			System.out.print("Enter Digit Respective to Desired Option : ");
			byte userChoice = myInput.nextByte();
			myInput.nextLine();
			switch (userChoice) {
			case 0:
				myInput.close();
				System.out.println("--------- E X I T E D ---------\n");
				System.exit(0);
				break;
			case 1:
				Book book = new Book();
				System.out.print("Enter Book Name :");
				book.setBookName(myInput.nextLine());
				System.out.print("Enter Book Author:");
				book.setBookAuthor(myInput.nextLine());
				System.out.print("Enter Book Price :");
				book.setBookPrice(myInput.nextDouble());
				myInput.nextLine();
				controller.addBook(book);
				System.out.println("-------| B O O K   A D D E D |-------\n");
				break;
			case 2:
				System.out.print("Enter Book Name To Be Removed : ");
				String bookToRemove = myInput.nextLine();
				if (controller.removeBook(bookToRemove)) {
					System.out.println("Requested Book Has Been Removed\n");
				} else {
					System.out.println("Book Does Not Exist, Cannot Be Removed\n");
				}
				break;
			case 3:
				System.out.print("Enter Book Name To Update : ");
				Book bookExist = controller.getBook(myInput.nextLine());
				if (bookExist != null) {
					Book bookToUpdate = bookExist;
					System.out.println("What To Update??");
					System.out.println("1.Book name\n2.Author name\n3.Book Price");
					System.out.print("Enter digit respective to desired option : ");
					byte userInput = myInput.nextByte();
					myInput.nextLine();
					switch (userInput) {
					case 1:
						System.out.print("Enter Book Name to Update : ");
						bookToUpdate.setBookName(myInput.nextLine());
						break;
					case 2:
						System.out.print("Enter Book Author  to Update : ");
						bookToUpdate.setBookAuthor(myInput.nextLine());
						break;
					case 3:
						System.out.print("Enter Book Price to Update : ");
						double newbookPrice = myInput.nextDouble();
						myInput.nextLine();
						bookToUpdate.setBookPrice(newbookPrice);
						break;
					default:
						System.out.println("Invalid Selection");
						break;
					}
					if (controller.update(bookExist, bookToUpdate)) {
						System.out.println("Book Updated\n");
					}else {
						System.out.println("Not Updated\n");
					}	
				} else {
					System.out.println("Book does not Exist.\n");

				}
				break;
			case 4:
				System.out.print("Enter Book Name You Are Looking For : ");
				Book fetchedBook = controller.getBook(myInput.nextLine());
				if (fetchedBook != null) {
					System.out.println("Book Is Available !");
					System.out.println("Details :");
					System.out.println(fetchedBook+"\n");
				} else {
					System.out.println("Book Is Not Available!\n");
				}

				break;
			default:
				System.out.println("Invalid Selection\n");
				break;
			}
		} while (true);
	}
}


