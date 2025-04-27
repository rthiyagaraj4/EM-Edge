import javax.swing.*;

import java.applet.*;
import java.awt.*;

import org.apache.commons.codec.binary.*;

public class  ImageApplet extends Applet
{
	Image img;
	public void stop(){

	}

	public void start(){
			try{
		
		System.out.println("inot applet");
			String encodedData = getParameter("imageData");
			encodedData = (encodedData==null)?"":encodedData;

			System.out.println("encodedData: "+encodedData);

			byte[] decodedData = null;
			
			if (encodedData.length() >0){
				decodedData  = Base64.decodeBase64(encodedData.getBytes());				
				
				System.out.println("decodedData: "+decodedData);
				/*JScrollPane scrollPane = new JScrollPane();
				JLabel label = new JLabel (new ImageIcon(decodedData));
				scrollPane.setViewportView(label);

				setContentPane(scrollPane);
				setVisible(true);*/								
				
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				img = toolkit.createImage(decodedData);							
			}			
		}catch(Exception exc){
			exc.printStackTrace();
		}
	}

	public void paint(Graphics g){
System.out.println("inot paint");
			Graphics2D g2d = (Graphics2D) g;
			g2d.drawImage(img,0,0,getWidth(),getHeight(),null,this);
	}

	public void init(){
		
	}
}
