
public class SubString {

	public static  void main(String[] args)
	{
		String letters = "abcdefghijklmabcdefghijklm";
		
		//substring method check
		System.out.printf("Substring from index 20 to end is \"%s\"\n",letters.substring(20));
		System.out.printf("Substring from index 3 up to, but not including 6 is \"%s\"\n",
				letters.substring(3,6));
		
		System.out.println("\n\ntesting concat method");
		String s1 = "hello ";
		String s2 = " world";
		
		System.out.printf("s1 = %s\ns2 = %s\n",s1,s2);
		System.out.printf("Result of s1.concat(s2)= %s\n",s1.concat(s2));
		System.out.printf("s1 is unaffected, as we can see: s1 = %s\n",s1);
	}
}
