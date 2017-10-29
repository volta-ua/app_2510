package pair.com.domain;

public class Book implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	private static int nextId = 1;
	private int id;	
	private String isbn;
	private String title;
	private String author;
	private double price;
	
	public Book(String isbn, String title, String author, double price)
	{
		this.id = nextId++;
		this.isbn=isbn;
		this.title=title;
		this.author=author;
		this.price=price;		
	}
			
	public String toString()
	{
		return this.title + " by " + this.author;
	}

	public String getIsbn() 
	{
		return this.isbn;
	}
	
	public String getTitle() 
	{
		return title;
	}

	public String getAuthor() 
	{
		return author;
	}

	public double getPrice() 
	{
		return price;
	}

	public int getId() 
	{
		return this.id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
}
