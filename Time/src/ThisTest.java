
public class ThisTest {

	public static void main(String[] args)
	{
		SimpleTime time = new SimpleTime(15,30,19);
		System.out.printf("%s\n",time.buildString());
	}
}	
	class SimpleTime
	{
		private int hour; //0-23
		private int minute; //0-59
		private int second; //0-59
		
		//an o constructor xrisimopoiei onomata parametrwn idia me ta onomata metavlitwn stigmiotupou, i anafora
		//this apaiteitai gia ti diakrisi meta3u onomatwn
		public SimpleTime(int hour, int minute, int second)
		{
			//defining parameters in object "this"
			this.hour = hour;
			this.minute = minute;
			this.second = second;
		}
		
		public String buildString()
		{
			return String.format("%24s: %s\n%24s: %s","this.toUniversalString()",this.toUniversalString(),
					"toUniversalString()",toUniversalString());
					
		}
		
		public String toUniversalString()
		{
			//edw, den apaiteitai i "this" gia prosvasi se metavlites stigmiotupou, epeidi
			//i me9odos den exei topikes metavlites me idia onomata kai metavlites stigmiotupou
			return String.format("%02d:%02d:%02d",this.hour,this.minute,this.second);
		}
	}

