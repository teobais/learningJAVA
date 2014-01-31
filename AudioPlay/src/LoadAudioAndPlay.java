import java.applet.AudioClip;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.FlowLayout;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class LoadAudioAndPlay extends JApplet{

	private AudioClip sound1, sound2, currentSound;
	private JButton play, loop, stop;
	private JComboBox soundCombo;
	
	//fortwsi ixou me tn ekkinisi t applet
	public void init()
	{
		System.out.println(getDocumentBase());
		setLayout(new FlowLayout() );
		String choices[] = {"Welcome", "Hi" };
		soundCombo = new JComboBox(choices);
		
		soundCombo.addItemListener
			(
				
				new ItemListener()
				{
					public void itemStateChanged(ItemEvent e)
					{
						currentSound.stop();
						currentSound = soundCombo.getSelectedIndex() == 0 ? sound1 : sound2;
					}
				}
			);
		add(soundCombo);
		
		ButtonHandler handler = new ButtonHandler();
		play = new JButton("Play");
		play.addActionListener(handler);
		add(play);
		
		loop = new JButton("Loop");
		loop.addActionListener(handler);
		add(loop);
		
		stop = new JButton("Stop");
		stop.addActionListener(handler);
		add(stop);
		
		sound1 = getAudioClip(getDocumentBase(), "welcome.wav");
		sound2 = getAudioClip(getDocumentBase(), "hi.wav");
	}
	
	public void stop()
	{
		currentSound.stop();
	}
	
	private class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == play)
				currentSound.play();
			else if(e.getSource() == loop)
				currentSound.loop();
			else if(e.getSource() == stop)
				currentSound.stop();
		}
	}
	
}

