//importing 
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.util.EventObject;
//Class CentralizedInBoundPanel
public class CentralizedInBoundPanel extends JPanel
{
     JButton     LabelButton;
//*************************************************************************************************************/
// init () method 
//*************************************************************************************************************/
   public void init (JScrollPane scrollpane)
    {
       LabelButton = new JButton("        I  n  b  o  u  n  d        ");
	   Color cl =new Color(190,245,100);
	   LabelButton.setBackground(Color.BLACK);
	   LabelButton.setForeground(Color.WHITE);
	   this.setLayout(new BorderLayout());
	   this.add(LabelButton,BorderLayout.NORTH);
	   this.add(scrollpane,BorderLayout.CENTER);
    
	}
//************************************************************************************//
  // constructor
//*************************************************************************************
	CentralizedInBoundPanel(JScrollPane scrollpane)
    {
	
	  setBackground(new Color(230,230,255));
      init(scrollpane);
	}

} //end of class   CentralizedInBoundPanel