// Let's use panels

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class PanelCommsDemo {

    private JFrame _frame;

    private JPanel _top;
    private JPanel _bottom;

    private JButton _randButton;

    private JLabel _randVal;

    public void bridge(String s) {
	_randVal.setText(s);
	_randVal.setVisible(true);
    }

    public static void main(String [] args) {
	new PanelCommsDemo();
    }

    public PanelCommsDemo() {

	_frame = new JFrame("Random Number Generator");
	_frame.setLayout(new FlowLayout());
	_frame.setSize(400, 400);

	_randButton = new JButton("Rand");


	_randVal = new JLabel("???");
	_randVal.setFont(new Font("CourierNew", Font.PLAIN, 48));
	_randVal.setHorizontalAlignment(SwingConstants.CENTER);


	_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	SetterListener sListener = new SetterListener(this);
	_randButton.addActionListener(sListener);
	_frame.add(_randButton);
	_frame.add(_randVal);

	_frame.setVisible(true);
    }

    class SetterListener implements ActionListener {

	private PanelCommsDemo _main = null;
	private Random prng = new Random();

	public SetterListener(PanelCommsDemo p) {
	    _main = p;
	}

	public void actionPerformed(ActionEvent e) {
	    String newText = String.valueOf(prng.nextInt(99) + 1);
	    _main.bridge(newText);
	}
    }

}
