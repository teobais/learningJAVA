
public class DeckOfCardsTest {

	public static void main(String[] args)
	{
		DeckOfCards myCards=new DeckOfCards();
		myCards.shuffle();	//topo9etisi fullwn se tuxaia seira
		
		//emfanisi kai twn 52 fullwn me ti seira pou moirazontai
		for (int i=1;i<=52;i++)
		{
			//moirasma kai emfanisi fullou
			System.out.printf("%-19s", myCards.dealCard());
			
			if(i%4==0)
				System.out.println();	//nea grammi ka9e 4 fulla
		}
	}
}
