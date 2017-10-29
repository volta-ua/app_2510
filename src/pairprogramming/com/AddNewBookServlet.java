package pairprogramming.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pair.com.domain.Book;
import pairprogramming.comming.service.BookService;

public class AddNewBookServlet extends HttpServlet{

	public void service (HttpServletRequest request,
						HttpServletResponse response)
						throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8"); //додали роспізнавання кирилиці	
		request.setCharacterEncoding("UTF-8"); //додали прийняття кирилиці через POST
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");	
		
		BookService service=BookService.getService();
		String isbn=request.getParameter("ISBN");
		String title=request.getParameter("TITLE");
		String author=request.getParameter("AUTHOR");
		double price=new Double(request.getParameter("PRICE"));
		
		Book newBook=new Book(isbn, title, author, price);
		service.registerNewBook(newBook);
		out.println("<html><body><h1>Thanks</h1></body></html>");
		
		out.close();
	}
	
}
