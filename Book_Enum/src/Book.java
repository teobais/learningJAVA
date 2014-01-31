
public enum Book {

	//defining enum constants
	JHTP("Java How to Program","2010"),
	CHTP("C How to Program","2007"),
	IW3HTP("Internet & World Wide Web How to Program","2008"),
	CPPHTP("C++ How to Program","2008"),
	VBHTP("Visual Basic How to Program","2009"),
	CSHARP("Visual C# 2008 How to Program","2009");
	
	public final String title;
	private final String copyrightYear;
	
	Book(String bookTitle,String year)
	{
		title=bookTitle;
		copyrightYear = year;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getCopyrightYear()
	{
		return copyrightYear;
	}
}
