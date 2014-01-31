package Serializable;

import Serializable.AccountRecordSerializable;
import Serializable.CreateSequentialFile;

public class CreateSeuquentialFileTest {

	public static void main(String[] args)
	{
		CreateSequentialFile app=new CreateSequentialFile();
		app.openFile();
		app.addRecords();
		app.closeFile();
	}
}
