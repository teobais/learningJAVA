import java.util.Random;

public class DeckOfCards {

	private Card deck[];	//pinakas antikeimenwn Card
	private int currentCard;	//deiktis epomenis pros moirasma kartas
	private static final int NUMBER_OF_CARDS=52;
	
	//random numbers generator
	private static final Random randomNumbers=new Random();
	
	public DeckOfCards()
	{
		String[] faces={"Ace","Deuce","Three","Four","Five","Six",
				"Seven","Eight","Nine","Ten","Jack","Queen","King"};
		String[] suits={"Hearts","Diamonds","Clubs","Spades"};
		
		deck=new Card[NUMBER_OF_CARDS];	//dimiourgei pinaka antikeimwnen Card
		currentCard=0;					//oritzei tin currentCard,wste to 1o pou
										//moirazetai, na einai to deck[0]
	
		//gemisma ts trapoulas(deck) me antikeimena)
		for(int count=0;count<deck.length;count++)
		{
			deck[count]=new Card(faces[count%13],suits[count/13]);
		}
	}
		
	
		//anakatema trapoulas me algori9mo enos perasmatos
		public void shuffle()
		{
			//meta to anakatema, to moirasma prp n 3ekinisei pali apo to deck[0]
			currentCard=0;
			
			
			//gia ka9e Card,epilegei ena allo tuxaio Card kai ta enalassei
			for(int first=0;first<deck.length;first++)
			{
				
				//epilogi tyxaiou ari9mou 0-51
				int second=randomNumbers.nextInt(NUMBER_OF_CARDS);
				
				//enallagi trexousas kartas me tin tuxaia epilegmeni
				Card temp=deck[first];
				deck[first]=deck[second];
				deck[second]=temp;
			}
		}

		
		//moirasma fullou
		public Card dealCard()
		{
			//prosdiorizei an ta enapomeinanta Cards 9a moirastoun
			if(currentCard<deck.length)
			{
				return deck[currentCard++]; 	//epistrofi trexon Card stn pinaka
			}
			else
				return null;	//epistrofi null gia na dei3ei oti moirastikan olat Cards
		}
}

