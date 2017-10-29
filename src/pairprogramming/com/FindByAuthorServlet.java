package pairprogramming.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pair.com.domain.Book;
import pairprogramming.comming.service.BookService;

public class FindByAuthorServlet extends HttpServlet {

public void service(HttpServletRequest request,
					HttpServletResponse response)
					throws ServletException, IOException
{
		
	response.setContentType("text/html;charset=UTF-8"); //додали роспізнавання кирилиці	
	request.setCharacterEncoding("UTF-8"); //додали прийняття кирилиці через POST
	
	PrintWriter out=response.getWriter();
	response.setContentType("text/html");
	
	BookService service=BookService.getService();
	String author=request.getParameter("AUTHOR");
	
	List<Book> allBooks=service.getAllBooksByAuthor(author);

	out.println("<html><head><title>Books by Author</title>");
	out.println("<body><h1>Books by the Author (книги по автору) "+author+"</h1>");
	
	out.println("<ul>");
	for (Book nextBook:allBooks)
	{
		out.println("<li>");
		out.println(nextBook.getTitle());
		out.println("</li>");
	}
	out.println("</ul>");
	out.println("</body></html>");

	out.close();
}	
	
}
