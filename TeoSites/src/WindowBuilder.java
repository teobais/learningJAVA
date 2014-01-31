import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Canvas;
import javax.swing.JSlider;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import java.awt.Choice;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;


public class WindowBuilder {

	private JFrame frame;
	/**
	 * @wbp.nonvisual location=38,339
	 */
	private final Choice choice = new Choice();
	/**
	 * @wbp.nonvisual location=111,369
	 */
	private final JLabel label = DefaultComponentFactory.getInstance().createLabel("New JGoodies label");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowBuilder window = new WindowBuilder();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WindowBuilder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblTeo = new JLabel("teo");
		frame.getContentPane().add(lblTeo, BorderLayout.WEST);
		
		Canvas canvas = new Canvas();
		frame.getContentPane().add(canvas, BorderLayout.CENTER);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(canvas, popupMenu);
		
		JMenuBar menuBar = new JMenuBar();
		popupMenu.add(menuBar);
		
		JSlider slider = new JSlider();
		frame.getContentPane().add(slider, BorderLayout.SOUTH);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		frame.getContentPane().add(chckbxNewCheckBox, BorderLayout.EAST);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		frame.getContentPane().add(formattedTextField, BorderLayout.NORTH);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
