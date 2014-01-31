import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;



public class EuroConverter extends JFrame implements ActionListener{
	
private JLabel Dollar;
private JLabel Euro;
private JTextField txtDollar;
private JTextField txtEuro;
private JButton btnConverter;


private JLabel English ;
private JLabel Euro2;
private JTextField txtEnglish;
private JTextField txtEuro2;
private JButton btnConverter2;

Double dollar;
Double lires;

public EuroConverter()
	{
		super("USD to Euro Converter");
		setLayout(new FlowLayout());
		
		Dollar = new JLabel("Dollars");
		Euro = new JLabel("Euros");
		txtDollar = new JTextField(12);
		txtEuro = new JTextField(12);
		txtEuro.setEditable(false);
		
		btnConverter = new JButton("Convert");
		btnConverter.addActionListener(this);
		
		
		English = new JLabel("Lires");
		Euro2 = new JLabel("Euros");
		txtEnglish = new JTextField(12);
		txtEuro2 = new JTextField(12);
		txtEuro2.setEditable(false);
		
		btnConverter2 = new JButton("Convert");
		btnConverter2.addActionListener(this);
		
		add(Dollar);
		add(txtDollar);
		add(btnConverter);
		add(Euro);
		add(txtEuro);
		
		add(English);
		add(txtEnglish);
		add(btnConverter2);
		add(Euro2);
		add(txtEuro2);
	}


public double callDollar(double dollar){
	return dollar*0.749681385;
}

public double callLires(double lires){
	return lires*1.18;
}

public void actionPerformed(ActionEvent e) {

	try
	{
	dollar = Double.parseDouble(txtDollar.getText());
	
	double euro = callDollar(dollar);
	txtEuro.setText(String.format("%.2f",euro));

	}
	catch(Exception exc)
	{
		JOptionPane.showMessageDialog(this,"Only numbering format is allowed.","Input Error",JOptionPane.INFORMATION_MESSAGE);
		//System.err.println("Error");
	}
}

public void actionPerformed1(ActionEvent e) {

	try
	{
	lires = Double.parseDouble(txtEnglish.getText());
	
	double euro = callLires(lires);
	txtEuro2.setText(String.format("%.2f",euro));

	}
	catch(Exception exc)
	{
		JOptionPane.showMessageDialog(this,"Only numbering format is allowed.","Input Error",JOptionPane.INFORMATION_MESSAGE);
		//System.err.println("Error");
	}
}
}