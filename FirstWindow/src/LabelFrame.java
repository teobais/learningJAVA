import  java.awt.FlowLayout;		//ka9orizei tn taktopoiisi tn sustaktikwn(diata3i 
									//tous sto xwro(px ta labels kai to icon edw-bottom,
									//centr,left,etc...
import javax.swing.JFrame;			//periexei ta vsk xaraktiristika enos window
import javax.swing.JLabel;			//emfanizei keimeno kai eikones
import javax.swing.SwingConstants;	//koines sta9eres used with Swing
import javax.swing.Icon;			//diasundesi gia image handling
import javax.swing.ImageIcon;		//image loading

public class LabelFrame extends JFrame {

	private JLabel label1;			//mono me keimeno
	private JLabel label2;			//keimeno kai eikonidio
	private JLabel label3;			//exei proste9ei keimeno + eikonidio
	
	
	//constructor LabelFrame->pros9etei ta JLabels sto JFrame
	public LabelFrame()
	{
		super("Testing JLabel");
		setLayout(new FlowLayout());	//orizei ti diata3i plaisiou
		
		//dimiourgia JLabel me orisma string
		label1=new JLabel("Label with text");
		label1.setToolTipText("This is label1");
		add(label1);		//pros9iki label1 sto JFrame
		
		
		//constructor JLabel me orisma string,eikonidio kai stoixisi
		Icon bug=new ImageIcon(getClass().getResource("bug1"));
		label2=new JLabel("Label with text and icon",bug,SwingConstants.LEFT);
		label2.setToolTipText("This is label2");
		add(label2);
		
		
		label3=new JLabel();		//constructor JLabel xwris orismata
		label3.setText("Label with icon and text at bottom");
		label3.setIcon(bug);		//pros9iki eikonidiou sto JLabel
		label3.setHorizontalTextPosition(SwingConstants.CENTER);
		label3.setVerticalTextPosition(SwingConstants.BOTTOM);
		label3.setToolTipText("This is label3");
		add(label3);
		
	
	}
}
