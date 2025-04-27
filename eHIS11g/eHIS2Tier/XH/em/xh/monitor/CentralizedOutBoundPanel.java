package em.xh.monitor;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.util.EventObject;

public class CentralizedOutBoundPanel extends JPanel
{

	JButton LabelButton;

	//*************************************************************************************************************/
	// init () method 
	//*************************************************************************************************************/
	public void init (JScrollPane scrollpane)
	{
		LabelButton = new JButton("        O  u  t  b  o  u  n  d        ");
	//	Color cl = new Color(190,245,100);
		LabelButton.setBackground(Color.BLACK);
		LabelButton.setForeground(Color.WHITE);
		this.setLayout(new BorderLayout());
		scrollpane.setBackground(new Color(230,230,255));
		this.add(LabelButton,BorderLayout.NORTH);
		this.add(scrollpane,BorderLayout.CENTER);
	}

	//************************************************************************************//
	// constructor
	//*************************************************************************************
	CentralizedOutBoundPanel(JScrollPane scrollpane)
	{
		setBackground(new Color(230,230,255));
		init(scrollpane);
	}

}//end of class  OutBoundPanel