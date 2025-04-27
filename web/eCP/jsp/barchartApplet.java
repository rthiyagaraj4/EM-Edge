// Decompiled by DJ v3.0.0.63 Copyright 2002 Atanas Neshkov  Date: 8/6/2005 9:03:09 AM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   barchart.java
//This File is saved on 18/10/2005.
import java.applet.Applet;
import java.applet.AppletContext;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Vector;

public class barchartApplet extends Applet // implements ItemListener
	{

    public barchartApplet()
    {
//        rd_vector = new Vector(5, 5);
		rd1=new record_data();
        actif_count = 1;
        //_$2505 = 0;
        size2canvas = 0;
     //   _$995 = false;
        localchk = false;
        char_sep = '|';
        rotate_yn = true;
		complete_data=new StringBuffer();
    }

    public void init()
    {
        int i = 0xd0d0d0;
        String s = getParameter("csep");
        if(s != null)
            char_sep = s.charAt(0);
        s = getParameter("rotate");
       if(s != null)
            rotate_yn = s.equalsIgnoreCase("Y");

        s = getParameter("file");
        if(s == null)
            s = "file.txt";	

        s = getParameter("chart_data");

       // if(s == null)
          //  s = "Test 3 Bar   | 3 | Evaluated Dates  | 0 | 11";
        GridBagLayout gridbaglayout = new GridBagLayout();
        GridBagConstraints gridbagconstraints = new GridBagConstraints();
        setFont(new Font("Helvetica", 0, 14));
        setLayout(gridbaglayout);
        gridbagconstraints.anchor = 12;
        gridbagconstraints.fill = 2;
        gridbagconstraints.weightx = 1.0D;
		getData(s);
		//readFile(getCodeBase(), s);
	   //to get the values to display chart
		
        s = getParameter("actif");
        if(s != null && actif < 0)
            actif = Integer.parseInt(s);
        if(actif < 0 || actif >= actif_count)
            actif = 0;


		//to list the chart type from file
       /* c1 = new Choice();
        c1.addItemListener(this);
        for(int j = 0; j < actif_count; j++)
        {
            s = ((record_data)rd_vector.elementAt(j)).sIt;
            c1.addItem(s);
        }

        c1.select(actif);*/
        s = getParameter("bgcolor");
        if(s != null)
            i = color_check(s);
        Label label = new Label("");
        label.setBackground(new Color(i));
        if(actif_count < 2)
        {
            gridbagconstraints.gridwidth = 0;
            add(label, gridbagconstraints);
        } else
        {
            add(label, gridbagconstraints);
            gridbagconstraints.gridwidth = 0;
			//gridbaglayout.setConstraints(c1, gridbagconstraints);
			//add(c1);
        }
        s = getParameter("frame");
        size2canvas = 0;
        if(s != null)
            size2canvas = Integer.parseInt(s);
        s = getParameter("local");
        if(s != null)
            localchk = s.equalsIgnoreCase("YES");
        cv1 = new Chart();
        cv1.setBkColor(i);
        if(size2canvas != 0)
        {
            cv2 = new Chart();
            cv2.setBkColor(i);
        }
        cv1.setRotate(rotate_yn);
        s = getParameter("origine");
        if(s != null)
            cv1.setOrigine(s);
        s = getParameter("bullettitle");
        if(s != null)
            cv1.setBulletTitle(s.equalsIgnoreCase("YES"));
        s = getParameter("font");
        if(s == null)
            s = new String("Helvetica, 0, 12");
        cv1.setFont(s, ' ');
        if(size2canvas != 0)
        {
            cv2.setFont(s, ' ');
            cv2.setBkImage(null);
        }
        s = getParameter("fontL");
        if(s != null)
            cv1.setFont(s, 'L');
        s = getParameter("fontT");
        if(s != null)
            cv1.setFont(s, 'T');
        Image image = null;
        s = getParameter("bgImg");
        if(s != null)
        {
            MediaTracker mediatracker = new MediaTracker(this);
            image = getImage(getCodeBase(), s);
            mediatracker.addImage(image, 0);
            try
            {
                mediatracker.waitForAll();
            }
            catch(InterruptedException interruptedexception) { }
        }
        cv1.setBkImage(image);
        s = getParameter("cbg");
        if(s != null)
            cv1.cBg_align = s.charAt(0);
        s = getParameter("line");
        if(s != null)
        {
            cv1.bMM = Integer.parseInt(s);
            if(cv1.bMM > 0)
            {
                s = getParameter("colorline");
                if(s != null)
                    cv1.sMaxColor = color_check(s);
            }
        }
        s = getParameter("lnColor");
        if(s != null)
            cv1.setLnColor(color_check(s));
        gridbagconstraints.weighty = 1.0D;
       //setData();
		complete_data=new StringBuffer(getParameter("complete_data")==null?"":getParameter("complete_data"));

		if(!(complete_data.length() >0)){
			complete_data.append(getParameter("title")==null?"":(getParameter("title")+"~"));
			complete_data.append(getParameter("label")==null?"":(getParameter("label")+"~"));
		   values_count = Integer.parseInt(getParameter("values_count")==null?"0":getParameter("values_count"));
		   series_count = Integer.parseInt(getParameter("series_count")==null?"0":getParameter("series_count"));
			for(int k=0; k<series_count; k++){
				complete_data.append(getParameter("series"+k)+"~");
			}
			for(int j=0; j<values_count; j++){
				complete_data.append(getParameter("label"+j)+"|");
				for(int k=0; k<series_count; k++){
					complete_data.append(getParameter("series"+k+"data"+j)+"|");
				}
				complete_data. replace(complete_data.lastIndexOf("|"),complete_data.lastIndexOf("|")+1,"~");
			}
			complete_data. deleteCharAt(complete_data.lastIndexOf("~"));
		}
		setData(complete_data);
		
		if(size2canvas == 0)
            gridbagconstraints.gridheight = 0;
        gridbagconstraints.fill = 1;
        gridbagconstraints.weightx = 0.0D;
        gridbagconstraints.weighty = 10D - (double)(size2canvas / 10);
        gridbagconstraints.gridwidth = 0;
        gridbaglayout.setConstraints(cv1, gridbagconstraints);
        add(cv1);
        if(size2canvas != 0)
        {
            gridbagconstraints.weighty = size2canvas / 10;
            gridbagconstraints.gridheight = 0;
            gridbaglayout.setConstraints(cv2, gridbagconstraints);
            add(cv2);
        }	  
    }

    public void setPress(int i, int j)
    {
        //_$2505 = i;
        cv1.setPress(i, j);
        if(size2canvas != 0)
            cv2.setPress(4, j);
    }

    public void setBkColor(String s)
    {
        if(s != null)
        {
            cv1.setBkColor(color_check(s));
            cv1.clearBuffer();
            cv1.repaint();
        }
    }

    public void setLnColor(String s)
    {
        if(s != null)
            cv1.setLnColor(color_check(s));
        cv1.repaint();
    }

    private int color_check(String s)
    {
        int i = -2;
        if(s != null)
            if(s.charAt(0) == '#')
                i = Integer.parseInt(s.substring(1), 16);
            else
                i = Integer.parseInt(s);
        return i;
    }

  public void setData(StringBuffer cmp_data)
    {
        cv1.clearData();
        if(size2canvas != 0)
            cv2.clearData();

        cv1.setCol((int)rd1.iD[0]);
        if(size2canvas != 0)
            cv2.setCol((int)rd1.iD[0]);
        int j = (int)rd1.iD[0];
        //Object obj = null;
        //String s = rd1.sUrl;

		cv1.setUnit(rd1.sU);
        if(size2canvas != 0)
            cv2.setUnit(rd1.sU);
        cv1.setLg(rd1.iLg);
       // byte byte0 = 32;		  
		int index=0;
		int i=0;
		if(cmp_data == null)
			cmp_data=new StringBuffer("");
		do
        {
			int k=cmp_data.indexOf("~",index);
            String s1;
            if(k > 0)
                s1 = new String(cmp_data.substring(index, k).trim());
            else
                s1 = new String(cmp_data.substring(index).trim());

            char c;
            if(s1 != null)
                c = s1.charAt(0);
            else
                c = ' ';
            if(c == '|' || c == '/')
                continue;
            record_data Rd1 = new record_data();
            if(!Rd1.get(Rd1, s1, char_sep, j))
                break;
            if(Rd1.sIt.equals("col"))
            {
                cv1.addCol(i++, (int)Rd1.iD[0], Rd1.sUrl);
                if(size2canvas != 0)
                    cv2.addCol(i - 1, (int)Rd1.iD[0], Rd1.sUrl);
            } else
            if(Rd1.sIt.equals("title")){
                cv1.setTitle(Rd1.sUrl);
			}
            else
            if(Rd1.sIt.equals("label"))
            {
                cv1.setLegend(Rd1.sUrl, Rd1.sFont);
            } else
            {
                cv1.addRow(Rd1.iD, Rd1.sIt);
                if(size2canvas != 0)
                    cv2.addRow(Rd1.iD, Rd1.sIt);
            }
			if(k == -1)
				break;	
            index = k + 1;
      }while(true);
        setPress((int)rd1.iD[1], (int)rd1.iD[2]);
        if(rd1.iD[3] > (double)0 && rd1.iD[3] != record_data.iNan)
            cv1.setVal((int)rd1.iD[3]);
        if(rd1.iD[4] != rd1.iD[5])
            cv1.setMinMax(rd1.iD[4], rd1.iD[5]);
        if(rd1.sDec.length() > 0)
        {
            cv1.setDec(rd1.sDec);
            if(size2canvas != 0)
                cv2.setDec(rd1.sDec);
        }
        rp();
    }
/*
	public void setData()
    {
        cv1.clearData();
        if(size2canvas != 0)
            cv2.clearData();
        cv1.setCol((int)rd1.iD[0]);
        if(size2canvas != 0)
            cv2.setCol((int)rd1.iD[0]);
        int j = (int)rd1.iD[0];
        int k = 0;
        BufferedReader bufferedreader = null;
        int l = 0;
        Object obj = null;
        String s = rd1.sUrl;
        if(!localchk)
            try
            {
                bufferedreader = new BufferedReader(new InputStreamReader((new URL(getCodeBase(), s)).openStream()));
                localchk = false;
            }
            catch(Exception exception)
            {
                bufferedreader = null;
                localchk = true;
            }
        cv1.setUnit(rd1.sU);
        if(size2canvas != 0)
            cv2.setUnit(rd1.sU);
        cv1.setLg(rd1.iLg);
        byte byte0 = 32;
        do
        {
            String s1;
            if(localchk)
            {
                s1 = getParameter(String.valueOf(s) + String.valueOf(l));
                l++;
            } else
            {
                try
                {
                    s1 = bufferedreader.readLine();
                }
                catch(Exception exception1)
                {
                    break;
                }
            }
            char c;
            if(s1 != null)
                c = s1.charAt(0);
            else
                c = ' ';
            if(c == '|' || c == '/')
                continue;
            record_data rd1 = new record_data();
            if(!rd1.get(rd1, s1, char_sep, j))
                break;
            if(rd1.sIt.equals("col"))
            {
                cv1.addCol(k++, (int)rd1.iD[0], rd1.sUrl);
                if(size2canvas != 0)
                    cv2.addCol(k - 1, (int)rd1.iD[0], rd1.sUrl);
            } else
            if(rd1.sIt.equals("title"))
                cv1.setTitle(rd1.sUrl);
            else
            if(rd1.sIt.equals("label"))
            {
                cv1.setLegend(rd1.sUrl, rd1.sFont);
            } else
            {
                cv1.addRow(rd1.iD, rd1.sIt);
                if(size2canvas != 0)
                    cv2.addRow(rd1.iD, rd1.sIt);
            }
        } while(true);
        setPress((int)rd1.iD[1], (int)rd1.iD[2]);
        if(rd1.iD[3] > (double)0 && rd1.iD[3] != record_data.iNan)
            cv1.setVal((int)rd1.iD[3]);
        if(rd1.iD[4] != rd1.iD[5])
            cv1.setMinMax(rd1.iD[4], rd1.iD[5]);
        if(rd1.sDec.length() > 0)
        {
            cv1.setDec(rd1.sDec);
            if(size2canvas != 0)
                cv2.setDec(rd1.sDec);
        }
        rp();
    } 

	public void readFile(URL url, String s)
    {
        byte byte0 = 32;
        //rd_vector.removeAllElements();
        actif_count = 0;
        BufferedReader bufferedreader = null;
        int i = 0;
        Object obj = null;
        if(!localchk)
            try
            {
                bufferedreader = new BufferedReader(new InputStreamReader((new URL(getCodeBase(), s)).openStream()));
                localchk = false;
            }
            catch(Exception exception)
            {
                bufferedreader = null;
                localchk = true;
            }
        do
        {
            String s1;
            if(localchk)
            {
                s1 = getParameter(String.valueOf(s) + String.valueOf(i));
                i++;
            } else
            {
                try
                {
                    s1 = bufferedreader.readLine();
                }
                catch(Exception exception1)
                {
                    break;
                }
            }
            char c;
            if(s1 != null)
                c = s1.charAt(0);
            else
                c = ' ';
            if(c == '|' || c == '/')
                continue;
            record_data rd1 = new record_data();
            if(!rd1.get(rd1, s1, char_sep, 7))
                break;
            //rd_vector.addElement(rd1);
            actif_count++;
        } while(true);
    }		  
*/
    public void addRow(String s)
    {
        record_data rd1 = new record_data();
        int i = (int)rd1.iD[0];
        if(rd1.get(rd1, s, char_sep, i))
        {
            cv1.addRow(rd1.iD, rd1.sIt);
            if(size2canvas != 0)
                cv2.addRow(rd1.iD, rd1.sIt);
        }
    }

	public void getData(String s)
    {
		/*if(s==null)
			s="Test 3 Bar-2 ; 3 ; ./txt/tchart.txt  ; 0 ; 11  ";*/
        //rd_vector.removeAllElements();
        actif_count = 0;
       // int i = 0;
		//record_data rd1 = new record_data();
		rd1.get(rd1, s, char_sep, 7);
		//rd_vector.addElement(rd1);
		actif_count++;
    }

    public void addRow(double ad[], String s)
    {
        cv1.addRow(ad, s);
        if(size2canvas != 0)
            cv2.addRow(ad, s);
    }

    public void setOrigine(int i, int j)
    {
        cv1.setOrigine(i, j);
    }

    public void addCol(int i, int j, String s)
    {
        cv1.addCol(i, j, s);
        if(size2canvas != 0)
            cv2.addCol(i, j, s);
    }

    public void setDec(String s)
    {
        cv1.setDec(s);
        if(size2canvas != 0)
            cv2.setDec(s);
        cv1.repaint();
    }

    public void reDraw(int i)
    {
        cv1.clearBuffer();
        setPress((int)rd1.iD[1], (int)rd1.iD[2]);
        if(rd1.iD[3] > (double)0 && rd1.iD[3] != record_data.iNan)
            cv1.setVal((int)rd1.iD[3]);
        else
            cv1.setVal(cv1.iVal + i);
        if(rd1.iD[4] != rd1.iD[5])
            cv1.setMinMax(rd1.iD[4], rd1.iD[5]);
        rp();
    }

    public void rp()
    {
        cv1.repaint();
        if(size2canvas != 0)
            cv2.repaint();
    }

 /*    public void actionPerformed(ActionEvent actionevent)
    {
        try
        {
            getAppletContext().showDocument(new URL(sR), "_blank");
        }
        catch(Exception exception) { }
    }

   public void itemStateChanged(ItemEvent itemevent)
    {
        int i = c1.getSelectedIndex();
        if(i != actif)
        {
            actif = i;
          //  setData();
        }
    }*/

/*    public String getAppletInfo()
    {
        return "Name: barchart V 5.30\r\nAuthor: R. BERTHOU\r\nE-Mail : rbl@berthou.com\r\nURL : ".concat(String.valueOf(String.valueOf(sR)));
    }*/

   // private Vector rd_vector;
	private record_data rd1;
    private int actif_count;
    private int series_count;
    private int values_count;
    private static int actif = -1;
    //private int _$2505;
    private int size2canvas;
//    private boolean _$995;
    private boolean localchk;
    private char char_sep;
    private boolean rotate_yn;
	private StringBuffer complete_data;
    Chart cv1;
    Chart cv2;
  //  Choice c1;

}