package pairprogramming.comming.service;

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

import pair.com.domain.Book;

public class BookService
{
    private List<Book> testBooks = new ArrayList<Book>();
	private static BookService reference;

    /**
     * Use this method if you want to share the service across many servlets.
     * 
     * This is simulating what a true container such as Spring would provide
     */
    public static BookService getService()
    {
    	if (reference == null)
    		reference = new BookService();
    	return reference;
    }
    
    public BookService() 
    {
        Book book1 = new Book("ISBN1", "Tai-Pen", "Clawell", 75.00);
        Book book2 = new Book("ISBN2", "Segun", "Clawell", 35.99);
        Book book3 = new Book("ISBN3", "The Gate of Europe", "Plokhiy", 120.00);
        Book book4 = new Book("ISBN4", "The Rise and Fall of the British Empire", "James", 45.50);
        Book book5 = new Book("ISBN5", "The Beatles. Anthology", "The Beatles", 999.99); 
        Book book6 = new Book("ISBN6", "Онегин", "Пушкин", 999.99); 
        testBooks.add(book1);
        testBooks.add(book2);
        testBooks.add(book3);
        testBooks.add(book4);
        testBooks.add(book5);
        testBooks.add(book6);
    }	

	public List<Book> getBookByIsbn(String isbn) 
	{
		List<Book> returnList = new ArrayList<Book>();
		for (Book next : testBooks)
		{
			if (next.getIsbn().equals(isbn))
			{
				returnList.add(next);
			}
		}
		return returnList;	
	}

	public List<Book> getEntireCatalogue() 
	{
		return new ArrayList<Book>(testBooks);
	}

	public void registerNewBook(Book newBook) 
	{
		testBooks.add(newBook);
	}
    
	public List<Book> getAllBooksByAuthor(String author) 
	{
		List<Book> returnList = new ArrayList<Book>();
		for (Book next : testBooks)
		{
			if (next.getAuthor().equals(author))
			{
				returnList.add(next);
			}
		}
		return returnList;
	}

	public void deleteBookFromStock(Book bookToRemove) 
	{
		testBooks.remove(bookToRemove.getIsbn());
	}
	
	public Book getBookById(int id)
	{
		for (Book next : testBooks)
		{
			if (next.getId() == id)
			{
				return next;
			}
		}
		return null;
	}
}
