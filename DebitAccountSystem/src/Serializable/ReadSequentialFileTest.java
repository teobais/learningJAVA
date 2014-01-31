package Serializable;

public class ReadSequentialFileTest {

	public static void main(String[] args)
	{
		ReadSequentialFile app=new ReadSequentialFile();
		app.openFile();
		app.readRecords();
		app.closeFile();
	}
}
