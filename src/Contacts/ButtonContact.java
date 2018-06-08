package Contacts;

import java.awt.Dimension;

import javax.swing.JButton;

public class ButtonContact extends JButton{
	public ButtonContact(String name)
	{
		setText(name);
		setMaximumSize(new Dimension(300,40));
	}
}
