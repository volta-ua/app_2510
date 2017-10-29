package pairprogramming.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pair.com.domain.Book;
import pairprogramming.comming.service.BookService;

public class DisplayAllBooksServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request,
						HttpServletResponse response)
						throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8"); //додали роспізнавання кирилиці	
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");	
		HttpSession session = request.getSession();
		BookService bookservice=BookService.getService();
		List<Book> allBooks=bookservice.getEntireCatalogue();
		out.println("<html><head><meta charset=\"UTF-8\"> <title>Our entire catalogue</title></head></html>");
		out.println("<body><h1>Our Entire Catalogue Каталог</h1>");
		
		out.println("<ul>");
		for (Book nextBook:allBooks)
		{
			out.println("<li>");
			out.println(nextBook.getTitle());
			
			out.println("<form method='post' action='addToCart.html'>");
			out.println("<input type='hidden' name='id' value='"+nextBook.getId()+"'/>");
			out.println("<input type='submit' value='Додати до Корзини'/>");
			out.println("</form>");
			
			out.println("</li>");
		}
		out.println("</ul>");
		out.println("</body></html>");
		
		out.close();
		}
}
