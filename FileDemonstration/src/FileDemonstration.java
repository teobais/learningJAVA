import java.io.File;
import java.util.Scanner;

public class FileDemonstration {

	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		
		System.out.print("Enter file or directory name:");
		analyzePath(input.nextLine());
	}//end of main
	
	//data exporting for user's preferred file
	public static void analyzePath(String path)
	{
		//creating a File object based on user's input
		File name=new File(path);
		
		//if name exists,our programme prints some info about the specific file
		if(name.exists())
		{
			System.out.printf("%s%s\n%s\n%s\n%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s\n",
					name.getName()," exists",(name.isFile() ? "is a file" : "is not a file"),
					(name.isDirectory() ? "is a directory" : "is not a directory" ),
					(name.isAbsolute() ? "is absolute path" : "is not an absolute path"),
					"Last modified: ",name.lastModified(),"Length: ",name.length(),
					"Path: ",name.getPath(),"Absolute path: ",name.getAbsolutePath(),
					"Parent: ",name.getParent());
			
			//printing the directory list
			if(name.isDirectory()){
				String[] directory=name.list();
				System.out.println("\n\nDirectory contents:\n");
				
				for(String directoryName : directory)
					System.out.printf("%s\n", directoryName);
			}//if end
		}//external if end
		
		else//neither a file, nor a directory==>prints message error
		{
			System.out.printf("%s %s",path,"Does not exist");
		}//else end
	}//analyzePath end
}//class FileDemonstration end
