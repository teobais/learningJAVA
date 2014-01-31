
public class Card {

	private String face;	//eikona fullou("Ace","Deuce",...)
	private String suit;	//xrwma fullou("Hearts","Diamond",...)
	
	//i sunartisi dimiourgias 2 orismatwn arxikopoiei to xrwma kai tin eikona tou fullou
	public Card(String cardFace,String cardSuit)
	{
		face=cardFace;	//arxikopoiisi eikonas fullou
		suit=cardSuit;	//arxikopoiisi xrwmatos fullou
	}
	
	//epistrefei tin String anaparastasi tou Card
	public String toString()	//i toString() xrisimopoieitai emmesa se ka9e printf me 
	{							//%s i otn to object enwnetai se string me to +
		return face + " of " + suit; 	//gia na ginoun ta parapanw,i toString prp
	}									//na dilw9ei me afti tin kefalida
}
