/* 
--------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name        	Description
--------------------------------------------------------------------------------------------------------------------
06/09/2013	IN030457		Ramesh G		Bru-HIMS-CRF-016
06/09/2013	IN030458		Ramesh G		Bru-HIMS-CRF-017
20/09/2013  IN043482		Ramesh G		The added Medical History is not displayed in Genogram
--------------------------------------------------------------------------------------------------------------------
*/
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import netscape.javascript.JSObject;



public class CAGenogramApplet extends JApplet
{
	Stroke drawingStroke = new BasicStroke();
  	Stroke drawingStroke1 = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0);
  	HashMap<String,Integer> hm = new HashMap<String,Integer>();  	
  	
  	String patientDetails		=	"";
  	HashMap<String,HashMap<String,Object>> patDetails = new HashMap<String,HashMap<String,Object>>();
// Current Generation	
	String patientID			=	"";
//2nd Generation	
	String patFatherId			=	"";
	String patMotherId 			=	"";

	
	
//4th Generation
	ArrayList<String> fourthGenerationFathers = new ArrayList<String>();
	ArrayList<String> fourthGenerationMothers = new ArrayList<String>();
	ArrayList<String> fourthGenerationRelations = new ArrayList<String>();
//3rd Generation	
	ArrayList<String> thirdGenerationPersons = new ArrayList<String>();
	ArrayList<String> thirdGenerationTotalList = new ArrayList<String>();
//2nd Generation
	ArrayList<String> secondGenerationPersons = new ArrayList<String>();
	ArrayList<String> secondGenerationTotalList = new ArrayList<String>();
	
	HashMap<String,String> patChildHashMap = new HashMap<String,String>(); 
	//String[] patFamilyArr	=null;
	String[] patFamilyArr	=new String[]{};
	String[] esiRelationArr	=new String[]{};
	String[] mhRelationArr	=new String[]{};  //IN043482
	
    JPanel toolTip;
    JLabel label;
	int distance	= 80;
	
    @Override
    public void init()
    {        
        JScrollPane scroll  = new JScrollPane();
        getContentPane().add(scroll, "Center");
        scroll.getViewport().add(new Imagepanel());
		scroll.setBackground(Color.WHITE);
		scroll.setBorder(null);		
    }
    
    private class Imagepanel extends JPanel implements MouseListener,MouseMotionListener,ActionListener
    {
        
        Imagepanel()
        {
            addMouseMotionListener(this);
            addMouseListener(this);
            setBackground(Color.white);
            label = new JLabel();
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setBorder(UIManager.getBorder("ToolTip.border"));
			Font lf = new Font("Arial", Font.PLAIN, 10);
            label.setFont(lf);
            toolTip = new JPanel(new BorderLayout());
            toolTip.setOpaque(true);
            toolTip.setBackground(UIManager.getColor("ToolTip.background"));
            toolTip.add(label);
            setLayout(null);
            add(toolTip);
            
            patientID =(String)getParameter("patient_id");
			
          //Total Number Details
    	    patientDetails=getParameter("patientsDetails");
    	    String[] tempPatientDetails=patientDetails.split("\\|");
    	    for(int i=0;i<tempPatientDetails.length;i++){
    	    	  String[] patientDetails_ = (tempPatientDetails[i]).split("\\~"); 
    	    	  HashMap<String,Object> patDetails_ = new HashMap<String,Object>();
    	    	  		patDetails_.put("PATIENT_ID", patientDetails_[0]);
    	    	  		patDetails_.put("PATIENT_NAME", patientDetails_[1]);	    	  		
    	    	  		patDetails_.put("DATE_OF_BIRTH", patientDetails_[2]);
    	    	  		patDetails_.put("DECESED_YN", patientDetails_[3]);
    	    	  		patDetails_.put("MARRIED_YN", patientDetails_[4]);
    	    	  		patDetails_.put("FATHER_ID", patientDetails_[5]);
    	    	  		patDetails_.put("MOTHER_ID", patientDetails_[6]);
						patDetails_.put("PATIENTID", checkForNull(patientDetails_[7]));
    	    	  		patDetails_.put("PATIENT_SEX", patientDetails_[8]);
    	    	  patDetails.put(patientDetails_[0], patDetails_);
    	    	 
    	    }
    	    
    	    //4th Generation	    	
    	    	//persons 
    			if(!"".equals((String)getParameter("patFFGrandFatherId")))
    				fourthGenerationFathers.add(getParameter("patFFGrandFatherId"));
    			if(!"".equals((String)getParameter("patFMGrandFatherId")))
    				fourthGenerationFathers.add(getParameter("patFMGrandFatherId"));
    			if(!"".equals((String)getParameter("patMFGrandFatherId")))
    				fourthGenerationFathers.add(getParameter("patMFGrandFatherId"));
    			if(!"".equals((String)getParameter("patMMGrandFatherId")))
    				fourthGenerationFathers.add(getParameter("patMMGrandFatherId"));
    			
    			if(!"".equals((String)getParameter("patFFGrandMotherId")))
    				fourthGenerationMothers.add(getParameter("patFFGrandMotherId"));
    			if(!"".equals((String)getParameter("patFMGrandMotherId")))
    				fourthGenerationMothers.add(getParameter("patFMGrandMotherId"));
    			if(!"".equals((String)getParameter("patMFGrandMotherId")))
    				fourthGenerationMothers.add(getParameter("patMFGrandMotherId"));
    			if(!"".equals((String)getParameter("patMMGrandMotherId")))
    				fourthGenerationMothers.add(getParameter("patMMGrandMotherId"));
    			//Relationship	
    			if(!"".equals((String)getParameter("patFFGrandFatherAndHisWife_Relation")))
    				fourthGenerationRelations.add(getParameter("patFFGrandFatherAndHisWife_Relation"));
    			if(!"".equals((String)getParameter("patFMGrandFatherAndHisWife_Relation")))
    				fourthGenerationRelations.add(getParameter("patFMGrandFatherAndHisWife_Relation"));
    			if(!"".equals((String)getParameter("patMFGrandFatherAndHisWife_Relation")))
    				fourthGenerationRelations.add(getParameter("patMFGrandFatherAndHisWife_Relation"));
    			if(!"".equals((String)getParameter("patMMGrandFatherAndHisWife_Relation")))
    				fourthGenerationRelations.add(getParameter("patMMGrandFatherAndHisWife_Relation"));
    				
    		//3rd Generation
    			if(!"".equals((String)getParameter("patFGrandFatherId")))
    				thirdGenerationPersons.add(getParameter("patFGrandFatherId"));
    			if(!"".equals((String)getParameter("patFGrandMotherId")))
    				thirdGenerationPersons.add(getParameter("patFGrandMotherId"));
    			if(!"".equals((String)getParameter("patMGrandFatherId")))
    				thirdGenerationPersons.add(getParameter("patMGrandFatherId"));
    			if(!"".equals((String)getParameter("patMGrandMotherId")))
    				thirdGenerationPersons.add(getParameter("patMGrandMotherId"));
    			
    			if(!"".equals((String)getParameter("patFGrandFatherFather_Childs")))
    				thirdGenerationTotalList.add(getParameter("patFGrandFatherFather_Childs"));
    			if(!"".equals((String)getParameter("patFGrandMotherFather_Childs")))
    				thirdGenerationTotalList.add(getParameter("patFGrandMotherFather_Childs"));
    			if(!"".equals((String)getParameter("patMGrandFatherFather_Childs")))
    				thirdGenerationTotalList.add(getParameter("patMGrandFatherFather_Childs"));
    			if(!"".equals((String)getParameter("patMGrandMotherFather_Childs")))
    				thirdGenerationTotalList.add(getParameter("patMGrandMotherFather_Childs"));
    		//2nd Generation
    			if(!"".equals((String)getParameter("patFatherId")))
    				secondGenerationPersons.add(getParameter("patFatherId"));
    			if(!"".equals((String)getParameter("patMotherId")))
    				secondGenerationPersons.add(getParameter("patMotherId"));
    				
    			if(!"".equals((String)getParameter("patFGrandFather_Childs")))
    				secondGenerationTotalList.add(getParameter("patFGrandFather_Childs"));
    			if(!"".equals((String)getParameter("patMGrandFather_Childs")))
    				secondGenerationTotalList.add(getParameter("patMGrandFather_Childs"));
    				
    		//Current Generation
				if(!"".equals((String)getParameter("patientFamily_Details"))){
					patFamilyArr = ((String)getParameter("patientFamily_Details")).split("\\|");
				}
    		
				if(!"".equals((String)getParameter("patientChilds"))){
					String[] patientTotalChilds=((String)getParameter("patientChilds")).split("\\^");
					for(int i=0;i<patientTotalChilds.length;i++){
						String[] patientChilds = ((String)patientTotalChilds[i]).split("\\~");
						patChildHashMap.put((String)patientChilds[0], (String)patientChilds[1]);
					}
				}
				if(!"".equals((String)getParameter("esiDetails"))){
					esiRelationArr	=  ((String)getParameter("esiDetails")).split("\\|");
				}
				//IN043482 Start.
				if(!"".equals((String)getParameter("mhDetails"))){
					mhRelationArr	=  ((String)getParameter("mhDetails")).split("\\|");
				}
				//IN043482 End.
        }
		private String checkForNull(String inputString)
		{
			return (inputString==null)	?	""	:	inputString;
		}
        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            
            Graphics2D g2 = (Graphics2D)g;
            this.setDoubleBuffered(true);   
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);	 
			g2.setPaint(Color.BLACK);			
			int x_axis_value 	= 10;
			int y_axis_value 	= 25;
			//4th Genaration
				for(int i=0;i<fourthGenerationFathers.size();i++){
					if((!"".equals(fourthGenerationFathers.get(i))) && (!"".equals(fourthGenerationMothers.get(i)))){	
						int xvalue = x_axis_value +(250*i);						
						
							HashMap<String,Object> fDetails =(HashMap<String,Object>)	patDetails.get((String)fourthGenerationFathers.get(i))	;
							if("M".equals((String)fDetails.get("PATIENT_SEX"))){
								drawRectangle((xvalue),(y_axis_value),g2,"","B","",(String)fDetails.get("DECESED_YN"),"N",(String)fDetails.get("PATIENT_NAME"),(String)fDetails.get("PATIENT_SEX"),(String)fDetails.get("PATIENT_ID"));
					        }else if("F".equals((String)fDetails.get("PATIENT_SEX"))){
					        	drawCricle((xvalue),(y_axis_value),g2,"","B","",(String)fDetails.get("DECESED_YN"),"N",(String)fDetails.get("PATIENT_NAME"),(String)fDetails.get("PATIENT_SEX"),(String)fDetails.get("PATIENT_ID"));
					        }else if("U".equals((String)fDetails.get("PATIENT_SEX"))){
					        	drawUnknown((xvalue),(y_axis_value),g2,"","B","",(String)fDetails.get("DECESED_YN"),"N",(String)fDetails.get("PATIENT_NAME"),(String)fDetails.get("PATIENT_SEX"),(String)fDetails.get("PATIENT_ID"));
					        }
							hm.put((String)fourthGenerationFathers.get(i)+"X_axis", xvalue);
							hm.put((String)fourthGenerationFathers.get(i)+"Y_axis", y_axis_value);					
						
						int xvalue1 = xvalue + distance;
						
							HashMap<String,Object> mDetails =(HashMap<String,Object>)	patDetails.get((String)fourthGenerationMothers.get(i))	;
							if("M".equals((String)mDetails.get("PATIENT_SEX"))){
								drawRectangle((xvalue1),(y_axis_value),g2,"","B","",(String)mDetails.get("DECESED_YN"),"N",(String)mDetails.get("PATIENT_NAME"),(String)mDetails.get("PATIENT_SEX"),(String)mDetails.get("PATIENT_ID"));
					        }else if("F".equals((String)mDetails.get("PATIENT_SEX"))){
					        	drawCricle((xvalue1),(y_axis_value),g2,"","B","",(String)mDetails.get("DECESED_YN"),"N",(String)mDetails.get("PATIENT_NAME"),(String)mDetails.get("PATIENT_SEX"),(String)mDetails.get("PATIENT_ID"));
					        }else if("U".equals((String)mDetails.get("PATIENT_SEX"))){
					        	drawUnknown((xvalue1),(y_axis_value),g2,"","B","",(String)mDetails.get("DECESED_YN"),"N",(String)mDetails.get("PATIENT_NAME"),(String)mDetails.get("PATIENT_SEX"),(String)mDetails.get("PATIENT_ID"));
					        }
							hm.put((String)fourthGenerationMothers.get(i)+"X_axis", xvalue1);
							hm.put((String)fourthGenerationMothers.get(i)+"Y_axis", y_axis_value);
													
							drawRelationShip((Integer)hm.get((String)fourthGenerationFathers.get(i)+"X_axis"),(Integer)hm.get((String)fourthGenerationFathers.get(i)+"Y_axis"),(Integer)hm.get((String)fourthGenerationMothers.get(i)+"X_axis"),(Integer)hm.get((String)fourthGenerationMothers.get(i)+"Y_axis"),g2,(String)fourthGenerationRelations.get(i));
							
					}
				} 
			
			//3rd Generation Details
				if((fourthGenerationFathers.size())>0){
					y_axis_value = y_axis_value+110;
				}
		
				for(int i=0;i<thirdGenerationPersons.size();i++){	
					if(!"".equals((String)thirdGenerationPersons.get(i))){
						int xvalue = x_axis_value +(250*i);
						String communic_TB ="B";
						HashMap<String,Object> Details =(HashMap<String,Object>)patDetails.get((String)thirdGenerationPersons.get(i));
					
						String father_id= Details.get("FATHER_ID")==null?"":(String)Details.get("FATHER_ID");
						String mother_id= Details.get("MOTHER_ID")==null?"":(String)Details.get("MOTHER_ID");
						if(father_id!=null && !"".equals(father_id) && !"".equals(mother_id) && mother_id!=null){
							int no_ofChilds =0;
							String[] childsArr = ((String)thirdGenerationTotalList.get(i)).split("\\|");
								no_ofChilds =childsArr.length;							
							
							if(no_ofChilds>0){									
								g2.drawLine((hm.get(father_id+"X_axis")+(hm.get(mother_id+"X_axis")-hm.get(father_id+"X_axis"))/2)+15, (hm.get(father_id+"Y_axis"))+60, (hm.get(father_id+"X_axis")+(hm.get(mother_id+"X_axis")-hm.get(father_id+"X_axis"))/2)+15, (hm.get(mother_id+"Y_axis")+80));
							}
								
							int x_axis_temp		= 0;
							int x1_axis_temp	= 0;
							int y_axis_temp		= 0;
							int y1_axis_temp	= 0;
							
							if(no_ofChilds>1){
								x_axis_temp		= ((hm.get(father_id+"X_axis")+(hm.get(mother_id+"X_axis")-hm.get(father_id+"X_axis"))/2))+15-(((60*(no_ofChilds-1)))/2);
								x1_axis_temp	= ((hm.get(father_id+"X_axis")+(hm.get(mother_id+"X_axis")-hm.get(father_id+"X_axis"))/2))+15+(((60*(no_ofChilds-1)))/2);
								y_axis_temp 	= (hm.get(mother_id+"Y_axis")+80);
								y1_axis_temp	= (hm.get(mother_id+"Y_axis")+80);					
							}else{
								x_axis_temp		= (hm.get(father_id+"X_axis")+(hm.get(mother_id+"X_axis")-hm.get(father_id+"X_axis"))/2)+15;
								x1_axis_temp	= (hm.get(father_id+"X_axis")+(hm.get(mother_id+"X_axis")-hm.get(father_id+"X_axis"))/2)+15;
								y_axis_temp 	= (hm.get(mother_id+"Y_axis"))+80;
								y1_axis_temp 	= (hm.get(mother_id+"Y_axis"))+80;
							}								
								
							g2.drawLine(x_axis_temp, y_axis_temp, x1_axis_temp, y1_axis_temp);
							int xvalue1 = x_axis_temp-15;
							for(int j=0;j<childsArr.length;j++){			
								if(((String)childsArr[j]).equals((String)thirdGenerationPersons.get(i)))
									communic_TB="TB";
								else
									communic_TB ="T";
									
								HashMap<String,Object> Details_ =(HashMap<String,Object>)patDetails.get((String)childsArr[j]);
									
								if("M".equals((String)Details_.get("PATIENT_SEX"))){
									drawRectangle((xvalue1),(y_axis_value),g2,"",communic_TB,"",(String)Details_.get("DECESED_YN"),"N",(String)Details_.get("PATIENT_NAME"),(String)Details_.get("PATIENT_SEX"),(String)Details_.get("PATIENT_ID"));
								}else if("F".equals((String)Details_.get("PATIENT_SEX"))){
									drawCricle((xvalue1),(y_axis_value),g2,"",communic_TB,"",(String)Details_.get("DECESED_YN"),"N",(String)Details_.get("PATIENT_NAME"),(String)Details_.get("PATIENT_SEX"),(String)Details_.get("PATIENT_ID"));
							    }else if("U".equals((String)Details_.get("PATIENT_SEX"))){
									drawUnknown((xvalue1),(y_axis_value),g2,"",communic_TB,"",(String)Details_.get("DECESED_YN"),"N",(String)Details_.get("PATIENT_NAME"),(String)Details_.get("PATIENT_SEX"),(String)Details_.get("PATIENT_ID"));
								}
								hm.put((String)Details_.get("PATIENT_ID")+"X_axis", xvalue1);
								hm.put((String)Details_.get("PATIENT_ID")+"Y_axis", y_axis_value);
									
								xvalue1 = xvalue1 + distance;
							}							
						}else{
							communic_TB ="B";
							if("M".equals((String)Details.get("PATIENT_SEX"))){
								drawRectangle((xvalue),(y_axis_value),g2,"",communic_TB,"",(String)Details.get("DECESED_YN"),"N",(String)Details.get("PATIENT_NAME"),(String)Details.get("PATIENT_SEX"),(String)Details.get("PATIENT_ID"));
					        }else if("F".equals((String)Details.get("PATIENT_SEX"))){
					        	drawCricle((xvalue),(y_axis_value),g2,"",communic_TB,"",(String)Details.get("DECESED_YN"),"N",(String)Details.get("PATIENT_NAME"),(String)Details.get("PATIENT_SEX"),(String)Details.get("PATIENT_ID"));
					        }else if("U".equals((String)Details.get("PATIENT_SEX"))){
								drawUnknown((xvalue),(y_axis_value),g2,"",communic_TB,"",(String)Details.get("DECESED_YN"),"N",(String)Details.get("PATIENT_NAME"),(String)Details.get("PATIENT_SEX"),(String)Details.get("PATIENT_ID"));
							}
							hm.put((String)Details.get("PATIENT_ID")+"X_axis", xvalue);
							hm.put((String)Details.get("PATIENT_ID")+"Y_axis", y_axis_value);
									
						}
					}	
				}
			//3rd Generation Relations
				if(!"".equals(getParameter("patFGrandFatherId")) && getParameter("patFGrandFatherId")!=null && getParameter("patFGrandMotherId")!=null && !"".equals(getParameter("patFGrandMotherId"))){
					drawRelationShip((Integer)hm.get(getParameter("patFGrandFatherId")+"X_axis"),(Integer)hm.get(getParameter("patFGrandFatherId")+"Y_axis"),(Integer)hm.get(getParameter("patFGrandMotherId")+"X_axis"),(Integer)hm.get(getParameter("patFGrandMotherId")+"Y_axis"),g2,(String)getParameter("patFFather_Mother_Relation"));
				}
				
				if(!"".equals(getParameter("patMGrandFatherId")) && getParameter("patMGrandFatherId")!=null && getParameter("patMGrandMotherId")!=null && !"".equals(getParameter("patMGrandMotherId"))){
					drawRelationShip((Integer)hm.get(getParameter("patMGrandFatherId")+"X_axis"),(Integer)hm.get(getParameter("patMGrandFatherId")+"Y_axis"),(Integer)hm.get(getParameter("patMGrandMotherId")+"X_axis"),(Integer)hm.get(getParameter("patMGrandMotherId")+"Y_axis"),g2,(String)getParameter("patMFather_Mother_Relation"));
				}
		
			//2nd Generation  Details
				if((thirdGenerationPersons.size())>0){
					y_axis_value = y_axis_value+110;
				}
				
				for(int i=0;i<secondGenerationPersons.size();i++){	
					if(!"".equals((String)secondGenerationPersons.get(i))){
						int xvalue = x_axis_value +(500*i);
						String communic_TB ="B";
						HashMap<String,Object> Details =(HashMap<String,Object>)patDetails.get((String)secondGenerationPersons.get(i));
					
						String father_id= Details.get("FATHER_ID")==null?"":(String)Details.get("FATHER_ID");
						String mother_id= Details.get("MOTHER_ID")==null?"":(String)Details.get("MOTHER_ID");
						if(father_id!=null && !"".equals(father_id) && !"".equals(mother_id) && mother_id!=null){
							int no_ofChilds =0;
							String[] childsArr = ((String)secondGenerationTotalList.get(i)).split("\\|");
								no_ofChilds =childsArr.length;							
							
							if(no_ofChilds>0){									
								g2.drawLine((hm.get(father_id+"X_axis")+(hm.get(mother_id+"X_axis")-hm.get(father_id+"X_axis"))/2)+15, (hm.get(father_id+"Y_axis"))+60, (hm.get(father_id+"X_axis")+(hm.get(mother_id+"X_axis")-hm.get(father_id+"X_axis"))/2)+15, (hm.get(mother_id+"Y_axis")+80));
							}
								
							int x_axis_temp		= 0;
							int x1_axis_temp	= 0;
							int y_axis_temp		= 0;
							int y1_axis_temp	= 0;
							
							if(no_ofChilds>1){
								x_axis_temp		= ((hm.get(father_id+"X_axis")+(hm.get(mother_id+"X_axis")-hm.get(father_id+"X_axis"))/2))+15-(((60*(no_ofChilds-1)))/2);
								x1_axis_temp	= ((hm.get(father_id+"X_axis")+(hm.get(mother_id+"X_axis")-hm.get(father_id+"X_axis"))/2))+15+(((60*(no_ofChilds-1)))/2);
								y_axis_temp 	= (hm.get(mother_id+"Y_axis")+80);
								y1_axis_temp	= (hm.get(mother_id+"Y_axis")+80);					
							}else{
								x_axis_temp		= (hm.get(father_id+"X_axis")+(hm.get(mother_id+"X_axis")-hm.get(father_id+"X_axis"))/2)+15;
								x1_axis_temp	= (hm.get(father_id+"X_axis")+(hm.get(mother_id+"X_axis")-hm.get(father_id+"X_axis"))/2)+15;
								y_axis_temp 	= (hm.get(mother_id+"Y_axis"))+80;
								y1_axis_temp 	= (hm.get(mother_id+"Y_axis"))+80;
							}								
								
							g2.drawLine(x_axis_temp, y_axis_temp, x1_axis_temp, y1_axis_temp);
							int xvalue1 = x_axis_temp-15;
							for(int j=0;j<childsArr.length;j++){			
								if(((String)childsArr[j]).equals((String)secondGenerationPersons.get(i)))
									communic_TB="TB";
								else
									communic_TB ="T";
									
								HashMap<String,Object> Details_ =(HashMap<String,Object>)patDetails.get((String)childsArr[j]);
									
								if("M".equals((String)Details_.get("PATIENT_SEX"))){
									drawRectangle((xvalue1),(y_axis_value),g2,"",communic_TB,"",(String)Details_.get("DECESED_YN"),"N",(String)Details_.get("PATIENT_NAME"),(String)Details_.get("PATIENT_SEX"),(String)Details_.get("PATIENT_ID"));
								}else if("F".equals((String)Details_.get("PATIENT_SEX"))){
									drawCricle((xvalue1),(y_axis_value),g2,"",communic_TB,"",(String)Details_.get("DECESED_YN"),"N",(String)Details_.get("PATIENT_NAME"),(String)Details_.get("PATIENT_SEX"),(String)Details_.get("PATIENT_ID"));
							    }else if("U".equals((String)Details_.get("PATIENT_SEX"))){
									drawUnknown((xvalue1),(y_axis_value),g2,"",communic_TB,"",(String)Details_.get("DECESED_YN"),"N",(String)Details_.get("PATIENT_NAME"),(String)Details_.get("PATIENT_SEX"),(String)Details_.get("PATIENT_ID"));
								}
								hm.put((String)Details_.get("PATIENT_ID")+"X_axis", xvalue1);
								hm.put((String)Details_.get("PATIENT_ID")+"Y_axis", y_axis_value);
									
								xvalue1 = xvalue1 + distance;
							}							
						}else{
							communic_TB ="B";
							if("M".equals((String)Details.get("PATIENT_SEX"))){
								drawRectangle((xvalue),(y_axis_value),g2,"",communic_TB,"",(String)Details.get("DECESED_YN"),"N",(String)Details.get("PATIENT_NAME"),(String)Details.get("PATIENT_SEX"),(String)Details.get("PATIENT_ID"));
					        }else if("F".equals((String)Details.get("PATIENT_SEX"))){
					        	drawCricle((xvalue),(y_axis_value),g2,"",communic_TB,"",(String)Details.get("DECESED_YN"),"N",(String)Details.get("PATIENT_NAME"),(String)Details.get("PATIENT_SEX"),(String)Details.get("PATIENT_ID"));
					        }else if("U".equals((String)Details.get("PATIENT_SEX"))){
								drawUnknown((xvalue),(y_axis_value),g2,"",communic_TB,"",(String)Details.get("DECESED_YN"),"N",(String)Details.get("PATIENT_NAME"),(String)Details.get("PATIENT_SEX"),(String)Details.get("PATIENT_ID"));
							}
							hm.put((String)Details.get("PATIENT_ID")+"X_axis", xvalue);
							hm.put((String)Details.get("PATIENT_ID")+"Y_axis", y_axis_value);
									
						}
					}	
				}
			
			//2nd Generation Relations
				if(!"".equals(getParameter("patFatherId")) && getParameter("patFatherId")!=null && getParameter("patMotherId")!=null && !"".equals(getParameter("patMotherId"))){
					drawRelationShip((Integer)hm.get(getParameter("patFatherId")+"X_axis"),(Integer)hm.get(getParameter("patFatherId")+"Y_axis"),(Integer)hm.get(getParameter("patMotherId")+"X_axis"),(Integer)hm.get(getParameter("patMotherId")+"Y_axis"),g2,(String)getParameter("patFather_Mother_Relation"));
				}
			
			//CurrentGeneration Generation  Details
				if((secondGenerationPersons.size())>0){
					y_axis_value = y_axis_value+110;	
				}
				//IN044809 Start.
				if(x_axis_value==10){
					x_axis_value = x_axis_value+250;
				}
				//INO44809 End.
				if(!"".equals((String)getParameter("patient_id"))){
					int xvalue = x_axis_value;
					String communic_TB ="B";
					String Victim_YN = "Y";
					HashMap<String,Object> Details =(HashMap<String,Object>)patDetails.get((String)getParameter("patient_id"));
				
					String father_id	= Details.get("FATHER_ID")==null?"":(String)Details.get("FATHER_ID");
					String mother_id	= Details.get("MOTHER_ID")==null?"":(String)Details.get("MOTHER_ID");
					String married_yn	= Details.get("MARRIED_YN")==null?"N":(String)Details.get("MARRIED_YN"); 
					if(father_id!=null && !"".equals(father_id) && !"".equals(mother_id) && mother_id!=null){
						int no_ofChilds =0;
						String[] childsArr = ((String)getParameter("patFather_Childs")).split("\\|");
							no_ofChilds =childsArr.length;							
						
						if(no_ofChilds>0){									
							g2.drawLine((hm.get(father_id+"X_axis")+(hm.get(mother_id+"X_axis")-hm.get(father_id+"X_axis"))/2)+15, (hm.get(father_id+"Y_axis"))+60, (hm.get(father_id+"X_axis")+(hm.get(mother_id+"X_axis")-hm.get(father_id+"X_axis"))/2)+15, (hm.get(mother_id+"Y_axis")+80));
						}
							
						int x_axis_temp		= 0;
						int x1_axis_temp	= 0;
						int y_axis_temp		= 0;
						int y1_axis_temp	= 0;
						
						if(no_ofChilds>1){
							x_axis_temp		= ((hm.get(father_id+"X_axis")+(hm.get(mother_id+"X_axis")-hm.get(father_id+"X_axis"))/2))+15-(((60*(no_ofChilds-1)))/2);
							x1_axis_temp	= ((hm.get(father_id+"X_axis")+(hm.get(mother_id+"X_axis")-hm.get(father_id+"X_axis"))/2))+15+(((60*(no_ofChilds-1)))/2);
							y_axis_temp 	= (hm.get(mother_id+"Y_axis")+80);
							y1_axis_temp	= (hm.get(mother_id+"Y_axis")+80);					
						}else{
							x_axis_temp		= (hm.get(father_id+"X_axis")+(hm.get(mother_id+"X_axis")-hm.get(father_id+"X_axis"))/2)+15;
							x1_axis_temp	= (hm.get(father_id+"X_axis")+(hm.get(mother_id+"X_axis")-hm.get(father_id+"X_axis"))/2)+15;
							y_axis_temp 	= (hm.get(mother_id+"Y_axis"))+80;
							y1_axis_temp 	= (hm.get(mother_id+"Y_axis"))+80;
						}								
							
						g2.drawLine(x_axis_temp, y_axis_temp, x1_axis_temp, y1_axis_temp);
						int xvalue1 = x_axis_temp-15;
						for(int j=0;j<childsArr.length;j++){			
							if(((String)childsArr[j]).equals((String)getParameter("patient_id"))){								
								Victim_YN = "Y";
								if("Y".equals(married_yn))
									communic_TB="TB";
								else
									communic_TB="T";
							}else{
								communic_TB ="T";
								Victim_YN = "N";
							}	
							HashMap<String,Object> Details_ =(HashMap<String,Object>)patDetails.get((String)childsArr[j]);
								
							if("M".equals((String)Details_.get("PATIENT_SEX"))){
								drawRectangle((xvalue1),(y_axis_value),g2,Victim_YN,communic_TB,"",(String)Details_.get("DECESED_YN"),"N",(String)Details_.get("PATIENT_NAME"),(String)Details_.get("PATIENT_SEX"),(String)Details_.get("PATIENT_ID"));
							}else if("F".equals((String)Details_.get("PATIENT_SEX"))){
								drawCricle((xvalue1),(y_axis_value),g2,Victim_YN,communic_TB,"",(String)Details_.get("DECESED_YN"),"N",(String)Details_.get("PATIENT_NAME"),(String)Details_.get("PATIENT_SEX"),(String)Details_.get("PATIENT_ID"));
						    }else if("U".equals((String)Details_.get("PATIENT_SEX"))){
								drawUnknown((xvalue1),(y_axis_value),g2,Victim_YN,communic_TB,"",(String)Details_.get("DECESED_YN"),"N",(String)Details_.get("PATIENT_NAME"),(String)Details_.get("PATIENT_SEX"),(String)Details_.get("PATIENT_ID"));
							}
							hm.put((String)Details_.get("PATIENT_ID")+"X_axis", xvalue1);
							hm.put((String)Details_.get("PATIENT_ID")+"Y_axis", y_axis_value);
								
							xvalue1 = xvalue1 + distance;
						}						
						xvalue=xvalue1;
					}else{
						if("Y".equals(married_yn)){
							communic_TB ="B";
						}else{
							communic_TB ="";
						}
						if("M".equals((String)Details.get("PATIENT_SEX"))){
							drawRectangle((xvalue),(y_axis_value),g2,Victim_YN,communic_TB,"",(String)Details.get("DECESED_YN"),"N",(String)Details.get("PATIENT_NAME"),(String)Details.get("PATIENT_SEX"),(String)Details.get("PATIENT_ID"));
				        }else if("F".equals((String)Details.get("PATIENT_SEX"))){
				        	drawCricle((xvalue),(y_axis_value),g2,Victim_YN,communic_TB,"",(String)Details.get("DECESED_YN"),"N",(String)Details.get("PATIENT_NAME"),(String)Details.get("PATIENT_SEX"),(String)Details.get("PATIENT_ID"));
				        }else if("U".equals((String)Details.get("PATIENT_SEX"))){
							drawUnknown((xvalue),(y_axis_value),g2,Victim_YN,communic_TB,"",(String)Details.get("DECESED_YN"),"N",(String)Details.get("PATIENT_NAME"),(String)Details.get("PATIENT_SEX"),(String)Details.get("PATIENT_ID"));
						}
						hm.put((String)Details.get("PATIENT_ID")+"X_axis", xvalue);
						hm.put((String)Details.get("PATIENT_ID")+"Y_axis", y_axis_value);
						
						xvalue=xvalue+distance;								
					}
					if(!"".equals((String)getParameter("patientFamily_Details"))){
						
						String[] patFamilyRelArr = ((String)getParameter("patientFamily_Relations")).split("\\|");
						String ss = (String)getParameter("patient_id");
						for(int i=0;i<patFamilyArr.length;i++){
							communic_TB = "B";
							Victim_YN	= "N" ;
							HashMap<String,Object> Details_ =(HashMap<String,Object>)patDetails.get((String)patFamilyArr[i]);
							if("M".equals((String)Details_.get("PATIENT_SEX"))){
								drawRectangle((xvalue),(y_axis_value),g2,Victim_YN,communic_TB,"",(String)Details_.get("DECESED_YN"),"N",(String)Details_.get("PATIENT_NAME"),(String)Details_.get("PATIENT_SEX"),(String)Details_.get("PATIENT_ID"));
					        }else if("F".equals((String)Details_.get("PATIENT_SEX"))){
					        	drawCricle((xvalue),(y_axis_value),g2,Victim_YN,communic_TB,"",(String)Details_.get("DECESED_YN"),"N",(String)Details_.get("PATIENT_NAME"),(String)Details_.get("PATIENT_SEX"),(String)Details_.get("PATIENT_ID"));
					        }else if("U".equals((String)Details_.get("PATIENT_SEX"))){
								drawUnknown((xvalue),(y_axis_value),g2,Victim_YN,communic_TB,"",(String)Details_.get("DECESED_YN"),"N",(String)Details_.get("PATIENT_NAME"),(String)Details_.get("PATIENT_SEX"),(String)Details_.get("PATIENT_ID"));
							}
							hm.put((String)Details_.get("PATIENT_ID")+"X_axis", xvalue);
							hm.put((String)Details_.get("PATIENT_ID")+"Y_axis", y_axis_value);
							
							drawRelationShip((Integer)hm.get(ss+"X_axis"),(Integer)hm.get(ss+"Y_axis"),(Integer)hm.get((String)Details_.get("PATIENT_ID")+"X_axis"),(Integer)hm.get((String)Details_.get("PATIENT_ID")+"Y_axis"),g2,(String)patFamilyRelArr[i]);
							ss=(String)Details_.get("PATIENT_ID");
							xvalue = xvalue + distance;	
						}					
					}
				}	
			//Victim Child Generation
				y_axis_value = y_axis_value+110;
				String start_id =patientID;
				int change_ypois = 0;
				for(int i=0;i<patFamilyArr.length;i++){						
					String father_id= (String)getParameter("patient_id");
					String mother_id= (String)patFamilyArr[i];
					if(father_id!=null && !"".equals(father_id) && !"".equals(mother_id) && mother_id!=null){						
						String  patChildstr = (String)patChildHashMap.get(father_id+"-"+mother_id);
						if(patChildstr!=null){
							String[] patChildArray =patChildstr.split("\\|");
								
							int no_ofChilds =0;
								
							no_ofChilds = patChildArray.length;
							if(no_ofChilds>0){	
								g2.drawLine((hm.get(start_id+"X_axis")+(hm.get(mother_id+"X_axis")-hm.get(start_id+"X_axis"))/2)+15, (hm.get(start_id+"Y_axis"))+60, (hm.get(start_id+"X_axis")+(hm.get(mother_id+"X_axis")-hm.get(start_id+"X_axis"))/2)+15, (hm.get(mother_id+"Y_axis")+80+change_ypois));
								
							}
								
							int x_axis_temp		= 0;
							int x1_axis_temp	= 0;
							int y_axis_temp		= 0;
							int y1_axis_temp	= 0;
								
							if(no_ofChilds>1){
								x_axis_temp		= ((hm.get(start_id+"X_axis")+(hm.get(mother_id+"X_axis")-hm.get(start_id+"X_axis"))/2))+15-(((distance*(no_ofChilds-1)))/2);
								x1_axis_temp	= ((hm.get(start_id+"X_axis")+(hm.get(mother_id+"X_axis")-hm.get(start_id+"X_axis"))/2))+15+(((distance*(no_ofChilds-1)))/2);
								y_axis_temp 	= (hm.get(mother_id+"Y_axis")+80);
								y1_axis_temp	= (hm.get(mother_id+"Y_axis")+80);					
							}else{
								x_axis_temp		= (hm.get(start_id+"X_axis")+(hm.get(mother_id+"X_axis")-hm.get(start_id+"X_axis"))/2)+15;
								x1_axis_temp	= (hm.get(start_id+"X_axis")+(hm.get(mother_id+"X_axis")-hm.get(start_id+"X_axis"))/2)+15;
								y_axis_temp 	= (hm.get(mother_id+"Y_axis"))+80;
								y1_axis_temp 	= (hm.get(mother_id+"Y_axis"))+80;
							}								
								
							g2.drawLine(x_axis_temp, y_axis_temp+change_ypois, x1_axis_temp, y1_axis_temp+change_ypois);						
								
							int xvalue1 = x_axis_temp-15;
							for(int j=0;j<patChildArray.length;j++){
								HashMap<String,Object> Details_ =(HashMap<String,Object>)patDetails.get((String)patChildArray[j]);
								if("M".equals((String)Details_.get("PATIENT_SEX"))){
									drawRectangle((xvalue1),(y_axis_value),g2,"","T","",(String)Details_.get("DECESED_YN"),"N",(String)Details_.get("PATIENT_NAME"),(String)Details_.get("PATIENT_SEX"),(String)Details_.get("PATIENT_ID"));
								}else if("F".equals((String)Details_.get("PATIENT_SEX"))){
									drawCricle((xvalue1),(y_axis_value),g2,"","T","",(String)Details_.get("DECESED_YN"),"N",(String)Details_.get("PATIENT_NAME"),(String)Details_.get("PATIENT_SEX"),(String)Details_.get("PATIENT_ID"));
								}else if("U".equals((String)Details_.get("PATIENT_SEX"))){
									drawUnknown((xvalue1),(y_axis_value),g2,"","T","",(String)Details_.get("DECESED_YN"),"N",(String)Details_.get("PATIENT_NAME"),(String)Details_.get("PATIENT_SEX"),(String)Details_.get("PATIENT_ID"));
								}
								hm.put((String)Details_.get("PATIENT_ID")+"X_axis", xvalue1);
								hm.put((String)Details_.get("PATIENT_ID")+"Y_axis", y_axis_value);
								
								xvalue1 = xvalue1 + distance;
							}
						}					
					}
					start_id = mother_id;
					change_ypois = change_ypois+80;
					y_axis_value = y_axis_value+change_ypois;
				}
			//esi Relations
				for(int k=0;k<esiRelationArr.length;k++){
					String[] esiRelationArray =esiRelationArr[k].split("\\~");
					drawESIRelationShip((Integer)hm.get(esiRelationArray[0]+"X_axis"),(Integer)hm.get(esiRelationArray[0]+"Y_axis"),(Integer)hm.get(esiRelationArray[2]+"X_axis"),(Integer)hm.get(esiRelationArray[2]+"Y_axis"),g2,(String)esiRelationArray[1],(String)esiRelationArray[3],(String)esiRelationArray[4]);			
				}
		
			//IN043482 Start.
			//Medical History Relations.
		
				for(int k=0;k<mhRelationArr.length;k++){
					String[] mhRelationArray =mhRelationArr[k].split("\\~");
					drawMHRelationShip((Integer)hm.get(mhRelationArray[0]+"X_axis"),(Integer)hm.get(mhRelationArray[0]+"Y_axis"),g2,(String)mhRelationArray[1],(String)mhRelationArray[2]);			
				}
			//IN043482 End.
        }
        public void mouseClicked(MouseEvent e) {
			Point p = e.getPoint(); 
			Iterator entries = patDetails.entrySet().iterator();
			while (entries.hasNext()) {
				Map.Entry entry = (Map.Entry) entries.next();
				String key = (String)entry.getKey();
				HashMap<String,Object> temp = (HashMap<String,Object>)entry.getValue();
				if("F".equals((String)temp.get("PATIENT_SEX"))){
					Ellipse2D r2=(Ellipse2D)temp.get("drawXY");
					if(r2!=null){
						if(r2.contains(p))
						{	                
							callPopupWindow((String)temp.get("PATIENTID"),(String)temp.get("PATIENT_NAME"));
							
						
						}
					}
				}else{				
					Rectangle r1 = (Rectangle)temp.get("drawXY");
					if(r1!=null){
						if(r1.contains(p))
						{	
							callPopupWindow((String)temp.get("PATIENTID"),(String)temp.get("PATIENT_NAME"));
						}
					}
				}
				
			}
		}
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
        public void mouseDragged(MouseEvent e) 
        {
            
        }       
        public void mouseMoved(MouseEvent e) 
        {	
            boolean traversing = false;
            Point p = e.getPoint(); 
			
			Iterator entries = patDetails.entrySet().iterator();
			while (entries.hasNext()) {
				Map.Entry entry = (Map.Entry) entries.next();
				String key = (String)entry.getKey();
				HashMap<String,Object> temp = (HashMap<String,Object>)entry.getValue();
				if("F".equals((String)temp.get("PATIENT_SEX"))){
					Ellipse2D r2=(Ellipse2D)temp.get("drawXY");
					if(r2!=null){
						if(r2.contains(p))
						{	                
							SwingUtilities.convertPointToScreen(p, this);
							p.x = (int)Math.round(r2.getX())+(int)Math.round(r2.getWidth())+ 10;
							p.y = (int)Math.round(r2.getY())- 5;
							showToolTip((String)temp.get("PATIENT_NAME"), p);
							
							traversing = true;
							repaint();
							
						}
					}
				}else{				
					Rectangle r1 = (Rectangle)temp.get("drawXY");
					if(r1!=null){
						if(r1.contains(p))
						{	                
							SwingUtilities.convertPointToScreen(p, this);
							p.x = r1.x + r1.width + 10;
							p.y = r1.y - 5;
							showToolTip((String)temp.get("PATIENT_NAME"), p);
							
							traversing = true;
							repaint();
							
						}
					}
				}
				
			}
            if(!traversing && isToolTipShowing())
                hideToolTip();
        }
		
        public void showToolTip(String patName, Point p)
        {	
            label.setText(patName);
            Dimension d = label.getPreferredSize();
            toolTip.setBounds(p.x, p.y, d.width, d.height);
            toolTip.setVisible(true);
            toolTip.repaint();
        }
        public boolean isToolTipShowing()
        {
               return true;
        }
        public void hideToolTip()
        {
            toolTip.setVisible(false);
        }
        public void actionPerformed(ActionEvent e) {}
        
    }
	public void callPopupWindow(String index,String pName)
        {	
			JSObject window = JSObject.getWindow(this);
			String pName_= "";
			try{
				pName_= URLEncoder.encode(pName,"UTF-8");
				String functionName="patHistory('"+index+"','"+pName_+"')";
				window.eval(functionName);
			}catch (UnsupportedEncodingException eue){
				System.out.println(eue.getMessage());
			}catch (Exception ex){
				System.out.println(ex.getMessage());
			}
        }
    public void drawRectangle(int x_axis_value,int y_axis_value, Graphics g1,String victimStatus,String comLineStatus,String fillStauts,String deceasedStatus,String drugAbuseProblemStauts,String patientName,String patientSex,String patientId) {
		//Y- Victim
		//TB-Both,T-Top,B-Bottom    
		//FC-Fill Color,FG-Fill Grid,FB-Fill Color and Grid
		// Y- Deceased 
		// Y- Drug Abuse Problem
		Graphics2D gr = null;
	    if (g1 instanceof Graphics2D) {
	        gr = (Graphics2D) g1;
	    } 
		gr.setStroke(drawingStroke);
	    String patientName_ ="";
	    if((patientName.length())>10){
	    	patientName_ =patientName.substring(0, 8)+"...";
	    }else{	    	
	    	patientName_ =patientName;
	    }
		Font f = new Font("Arial", Font.PLAIN, 10); 
		gr.setFont(f);
	    gr.drawString(patientName_, (x_axis_value-8), (y_axis_value-10));
		if("TB".equals(comLineStatus)){;
			gr.drawLine((x_axis_value+15), (y_axis_value), (x_axis_value+15),(y_axis_value-30));		
			gr.drawLine((x_axis_value+15), (y_axis_value+30), (x_axis_value+15),(y_axis_value+60));		
			
		}else if("T".equals(comLineStatus)){
			gr.drawLine((x_axis_value+15), (y_axis_value), (x_axis_value+15),(y_axis_value-30));
		}else if("B".equals(comLineStatus)){
			gr.drawLine((x_axis_value+15), (y_axis_value+30), (x_axis_value+15),(y_axis_value+60));
		}
		
		if("Y".equals(victimStatus)){
			gr.setStroke(drawingStroke1);
			gr.drawRect((x_axis_value),  (y_axis_value), 30, 30);
			gr.drawRect((x_axis_value)+5,  (y_axis_value)+5, 20, 20);
			gr.setStroke(drawingStroke);
		}else{
			gr.drawRect((x_axis_value),  (y_axis_value), 30, 30); //(x, y, width, height)
		}
		HashMap<String,Object> temp=(HashMap<String,Object>)patDetails.get(patientId);
			temp.put("drawXY",new Rectangle((x_axis_value),  (y_axis_value), 30, 30));
		
		if("FC".equals(fillStauts)){
			gr.setColor(Color.LIGHT_GRAY); 
			gr.fillRect((x_axis_value+1),  (y_axis_value+1), 29, 29);
			gr.setColor(Color.BLACK);
		}else if("FG".equals(fillStauts)){
			gr.setColor(Color.BLACK);
			gr.drawLine((x_axis_value+5), (y_axis_value), (x_axis_value+5), (y_axis_value+30));
			gr.drawLine((x_axis_value+10), (y_axis_value), (x_axis_value+10), (y_axis_value+30));
			gr.drawLine((x_axis_value+15), (y_axis_value), (x_axis_value+15), (y_axis_value+30));
			gr.drawLine((x_axis_value+20), (y_axis_value), (x_axis_value+20), (y_axis_value+30));
			gr.drawLine((x_axis_value+25), (y_axis_value), (x_axis_value+25), (y_axis_value+30));
		}else if("FB".equals(fillStauts)){
			gr.setColor(Color.LIGHT_GRAY); 
			gr.fillRect((x_axis_value+1),  (y_axis_value+1), 29, 29);
			gr.setColor(Color.BLACK);
			gr.drawLine((x_axis_value+5), (y_axis_value), (x_axis_value+5), (y_axis_value+30));
			gr.drawLine((x_axis_value+10), (y_axis_value), (x_axis_value+10), (y_axis_value+30));
			gr.drawLine((x_axis_value+15), (y_axis_value), (x_axis_value+15), (y_axis_value+30));
			gr.drawLine((x_axis_value+20), (y_axis_value), (x_axis_value+20), (y_axis_value+30));
			gr.drawLine((x_axis_value+25), (y_axis_value), (x_axis_value+25), (y_axis_value+30));
		}
		
		if("Y".equals(deceasedStatus)){
			gr.setColor(Color.BLACK);
			gr.drawLine((x_axis_value), (y_axis_value), (x_axis_value+30),(y_axis_value+30));
			gr.drawLine((x_axis_value), (y_axis_value+30), (x_axis_value+30),(y_axis_value));
		}
		
		if("Y".equals(drugAbuseProblemStauts)){
			gr.setColor(Color.BLACK);
			gr.drawLine((x_axis_value), (y_axis_value+15), (x_axis_value+30),(y_axis_value+15));
		}
		
	}

	public void drawCricle(int x_axis_value,int y_axis_value, Graphics g1,String victimStatus,String comLineStatus,String fillStauts,String deceasedStatus,String drugAbuseProblemStauts,String patientName,String patientSex,String patientId) {
		Graphics2D gr = null;
	    if (g1 instanceof Graphics2D) {
	        gr = (Graphics2D) g1;
	    }
		gr.setStroke(drawingStroke);
	    String patientName_ ="";
	    if((patientName.length())>10){
	    	patientName_ =patientName.substring(0, 8)+"...";
	    }else{	    	
	    	patientName_ =patientName;
	    }
		Font f = new Font("Arial", Font.PLAIN, 10); 
		gr.setFont(f);
	    gr.drawString(patientName_, (x_axis_value-8), (y_axis_value-10));
	    
		if("Y".equals(victimStatus)){
			//System.out.println(x_axis_value+"<-------------->"+y_axis_value);
			gr.setStroke(drawingStroke1);
			Shape circle = new Ellipse2D.Float((x_axis_value), (y_axis_value), 30, 30);
			gr.draw(circle);
			Shape circle1 = new Ellipse2D.Float((x_axis_value)+5, (y_axis_value)+5, 20, 20);
			gr.draw(circle1);
			gr.setStroke(drawingStroke);
			
			//add(m);  //onclick function
			//m.reshape((x_axis_value)+10, (y_axis_value)+10,10,10);
			
		}else{
			Shape circle = new Ellipse2D.Float((x_axis_value), (y_axis_value), 30, 30);
			gr.draw(circle);
		}
		HashMap<String,Object> temp=(HashMap<String,Object>)patDetails.get(patientId);
			temp.put("drawXY",new Ellipse2D.Float((x_axis_value), (y_axis_value), 30, 30));
		
		if("TB".equals(comLineStatus)){
			gr.drawLine((x_axis_value+15), (y_axis_value), (x_axis_value+15),(y_axis_value-30));
			gr.drawLine((x_axis_value+15), (y_axis_value+30), (x_axis_value+15),(y_axis_value+60));
		}else if("T".equals(comLineStatus)){
			gr.drawLine((x_axis_value+15), (y_axis_value), (x_axis_value+15),(y_axis_value-30));
		}else if("B".equals(comLineStatus)){
			gr.drawLine((x_axis_value+15), (y_axis_value+30), (x_axis_value+15),(y_axis_value+60));
		}
		  
		if("FC".equals(fillStauts)){
			gr.setColor(Color.LIGHT_GRAY); 
			Shape circle1 = new Ellipse2D.Float((x_axis_value+1), (y_axis_value+1), 29, 29);
			gr.fill(circle1);
			gr.setColor(Color.BLACK);
		}else if("FG".equals(fillStauts)){
			gr.setColor(Color.BLACK);		
			gr.drawLine((x_axis_value+5), (y_axis_value+5), (x_axis_value+5), (y_axis_value+25));
			gr.drawLine((x_axis_value+10), (y_axis_value+2), (x_axis_value+10), (y_axis_value+28));
			gr.drawLine((x_axis_value+15), (y_axis_value), (x_axis_value+15), (y_axis_value+30));
			gr.drawLine((x_axis_value+20), (y_axis_value+2), (x_axis_value+20), (y_axis_value+28));
			gr.drawLine((x_axis_value+25), (y_axis_value+5), (x_axis_value+25), (y_axis_value+25));
		}else if("FB".equals(fillStauts)){
			gr.setColor(Color.LIGHT_GRAY); 
			Shape circle1 = new Ellipse2D.Float((x_axis_value+1), (y_axis_value+1), 29, 29);
			gr.fill(circle1);
			gr.setColor(Color.BLACK);
			gr.drawLine((x_axis_value+5), (y_axis_value+5), (x_axis_value+5), (y_axis_value+25));
			gr.drawLine((x_axis_value+10), (y_axis_value+2), (x_axis_value+10), (y_axis_value+28));
			gr.drawLine((x_axis_value+15), (y_axis_value), (x_axis_value+15), (y_axis_value+30));
			gr.drawLine((x_axis_value+20), (y_axis_value+2), (x_axis_value+20), (y_axis_value+28));
			gr.drawLine((x_axis_value+25), (y_axis_value+5), (x_axis_value+25), (y_axis_value+25));
		}
		
		if("Y".equals(deceasedStatus)){
			gr.setColor(Color.BLACK);
			gr.drawLine((x_axis_value+5), (y_axis_value+5), (x_axis_value+25),(y_axis_value+25));
			gr.drawLine((x_axis_value+5), (y_axis_value+25), (x_axis_value+25),(y_axis_value+5));		
		}
		
		if("Y".equals(drugAbuseProblemStauts)){
			gr.setColor(Color.BLACK);
			gr.drawLine((x_axis_value), (y_axis_value+15), (x_axis_value+30),(y_axis_value+15));
		}
		
	}
	public void drawUnknown(int x_axis_value,int y_axis_value, Graphics g1,String victimStatus,String comLineStatus,String fillStauts,String deceasedStatus,String drugAbuseProblemStauts,String patientName,String patientSex,String patientId) {
		Graphics2D gr = null;
	    if (g1 instanceof Graphics2D) {
	        gr = (Graphics2D) g1;
	    }
		gr.setStroke(drawingStroke);
	    String patientName_ ="";
	    if((patientName.length())>10){
	    	patientName_ =patientName.substring(0, 8)+"...";
	    }else{	    	
	    	patientName_ =patientName;
	    }
		Font f1 = new Font("Arial", Font.PLAIN, 10); 
		gr.setFont(f1);
	    gr.drawString(patientName_, (x_axis_value-8), (y_axis_value-10));
	    
		if("Y".equals(victimStatus)){
			Font f = new Font("Mono", Font.BOLD, 36); 
			gr.setFont(f);
			gr.drawString("?", (x_axis_value), (y_axis_value+30));
			gr.setStroke(drawingStroke);
			gr.setFont(f1);
			gr.setStroke(drawingStroke);
			
			
		}else{
			Font f = new Font("Mono", Font.BOLD, 36); 
			gr.setFont(f);
			gr.drawString("?", (x_axis_value), (y_axis_value+30));
			gr.setStroke(drawingStroke); 
			gr.setFont(f1);
			gr.setStroke(drawingStroke);
		}
		HashMap<String,Object> temp=(HashMap<String,Object>)patDetails.get(patientId);
			temp.put("drawXY",new Rectangle((x_axis_value), (y_axis_value+30), 15, 15));
		
		if("TB".equals(comLineStatus)){
			gr.drawLine((x_axis_value+15), (y_axis_value), (x_axis_value+15),(y_axis_value-30));
			gr.drawLine((x_axis_value+15), (y_axis_value+30), (x_axis_value+15),(y_axis_value+60));
		}else if("T".equals(comLineStatus)){
			gr.drawLine((x_axis_value+15), (y_axis_value), (x_axis_value+15),(y_axis_value-30));
		}else if("B".equals(comLineStatus)){
			gr.drawLine((x_axis_value+15), (y_axis_value+30), (x_axis_value+15),(y_axis_value+60));
		}
		  
		if("FC".equals(fillStauts)){
			gr.setColor(Color.LIGHT_GRAY); 
			Shape circle1 = new Ellipse2D.Float((x_axis_value+1), (y_axis_value+1), 29, 29);
			gr.fill(circle1);
			gr.setColor(Color.BLACK);
		}else if("FG".equals(fillStauts)){
			gr.setColor(Color.BLACK);		
			gr.drawLine((x_axis_value+5), (y_axis_value+5), (x_axis_value+5), (y_axis_value+25));
			gr.drawLine((x_axis_value+10), (y_axis_value+2), (x_axis_value+10), (y_axis_value+28));
			gr.drawLine((x_axis_value+15), (y_axis_value), (x_axis_value+15), (y_axis_value+30));
			gr.drawLine((x_axis_value+20), (y_axis_value+2), (x_axis_value+20), (y_axis_value+28));
			gr.drawLine((x_axis_value+25), (y_axis_value+5), (x_axis_value+25), (y_axis_value+25));
		}else if("FB".equals(fillStauts)){
			gr.setColor(Color.LIGHT_GRAY); 
			Shape circle1 = new Ellipse2D.Float((x_axis_value+1), (y_axis_value+1), 29, 29);
			gr.fill(circle1);
			gr.setColor(Color.BLACK);
			gr.drawLine((x_axis_value+5), (y_axis_value+5), (x_axis_value+5), (y_axis_value+25));
			gr.drawLine((x_axis_value+10), (y_axis_value+2), (x_axis_value+10), (y_axis_value+28));
			gr.drawLine((x_axis_value+15), (y_axis_value), (x_axis_value+15), (y_axis_value+30));
			gr.drawLine((x_axis_value+20), (y_axis_value+2), (x_axis_value+20), (y_axis_value+28));
			gr.drawLine((x_axis_value+25), (y_axis_value+5), (x_axis_value+25), (y_axis_value+25));
		}
		
		if("Y".equals(deceasedStatus)){
			gr.setColor(Color.BLACK);
			gr.drawLine((x_axis_value+5), (y_axis_value+5), (x_axis_value+25),(y_axis_value+25));
			gr.drawLine((x_axis_value+5), (y_axis_value+25), (x_axis_value+25),(y_axis_value+5));		
		}
		
		if("Y".equals(drugAbuseProblemStauts)){
			gr.setColor(Color.BLACK);
			gr.drawLine((x_axis_value), (y_axis_value+15), (x_axis_value+30),(y_axis_value+15));
		}
		
	}
	public void drawRelationShip(int x_axis_value,int y_axis_value,int x1_axis_value,int y1_axis_value, Graphics g1,String relationStatus){
		Stroke drawingStroke = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0);
		Stroke drawingStroke1 = new BasicStroke();
		Stroke drawingStroke2 = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{7}, 0);
		Stroke drawingStroke3 = new BasicStroke(1, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND, 0, new float[]{5.0f, 4.0f, 1.0f, 4.0f}, 0);
		Stroke drawingStroke4 = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0);
		Graphics2D gr = null;
	    if (g1 instanceof Graphics2D) {
	        gr = (Graphics2D) g1;
	    }
	    if("MA".equals(relationStatus)){
			//Married
			gr.setStroke(drawingStroke);
	    	gr.setColor(Color.BLACK);
			gr.drawLine((x_axis_value+15), (y_axis_value+60), (x1_axis_value+15),(y1_axis_value+60));
	    }else if("MS".equals(relationStatus)){
	    	//Married/Separated[Process]
			gr.setColor(Color.BLACK);
			gr.setStroke(drawingStroke);
			gr.drawLine((x_axis_value+15), (y_axis_value+60), (x1_axis_value+15),(y1_axis_value+60));
			gr.drawLine(((x_axis_value+15)+((x1_axis_value+15)-(x_axis_value+15))/2), (y_axis_value+70), ((x_axis_value+15)+((x1_axis_value+15)-(x_axis_value+15))/2+10),(y1_axis_value+50));
	    }else if("BS".equals(relationStatus)){
	    	//Back Together After Separation[Process]
			gr.setColor(Color.BLACK);
			gr.setStroke(drawingStroke);
			gr.drawLine((x_axis_value+15), (y_axis_value+60), (x1_axis_value+15),(y1_axis_value+60));
			gr.drawLine(((x_axis_value+15)+((x1_axis_value+15)-(x_axis_value+15))/2), (y_axis_value+70), ((x_axis_value+15)+((x1_axis_value+15)-(x_axis_value+15))/2+10),(y1_axis_value+50));
			gr.drawLine(((x_axis_value+15)+((x1_axis_value+15)-(x_axis_value+15))/2), (y_axis_value+50), ((x_axis_value+15)+((x1_axis_value+15)-(x_axis_value+15))/2+10),(y1_axis_value+70));
	    }else if("DI".equals(relationStatus)){
			//Divorce
	    	//gr.setColor(new Color(201,20,20));
			gr.setColor(Color.BLACK);
			gr.setStroke(drawingStroke);
			gr.drawLine((x_axis_value+15), (y_axis_value+60), (x1_axis_value+15),(y1_axis_value+60));
			gr.drawLine(((x_axis_value+15)+((x1_axis_value+15)-(x_axis_value+15))/2), (y_axis_value+60)+5, ((x_axis_value+15)+((x1_axis_value+15)-(x_axis_value+15))/2+5),(y1_axis_value+60)-5);
			gr.drawLine(((x_axis_value+15)+((x1_axis_value+15)-(x_axis_value+15))/2+5), (y_axis_value+60)+5, ((x_axis_value+15)+((x1_axis_value+15)-(x_axis_value+15))/2+10),(y1_axis_value+60)-5);
			gr.setColor(Color.BLACK);
	    }else if("DR".equals(relationStatus)){
	    	//Divorce and Reconciled[Process]
			gr.setColor(Color.BLACK);
			gr.setStroke(drawingStroke);
			gr.drawLine((x_axis_value+15), (y_axis_value+60), (x1_axis_value+15),(y1_axis_value+60));
			gr.drawLine(((x_axis_value+15)+((x1_axis_value+15)-(x_axis_value+15))/2), (y_axis_value+60)+5, ((x_axis_value+15)+((x1_axis_value+15)-(x_axis_value+15))/2+5),(y1_axis_value+60)-5);
			gr.drawLine(((x_axis_value+15)+((x1_axis_value+15)-(x_axis_value+15))/2+5), (y_axis_value+60)+5, ((x_axis_value+15)+((x1_axis_value+15)-(x_axis_value+15))/2+10),(y1_axis_value+60)-5);
			gr.drawLine(((x_axis_value+15)+((x1_axis_value+15)-(x_axis_value+15))/2), (y1_axis_value+60)-5, ((x_axis_value+15)+((x1_axis_value+15)-(x_axis_value+15))/2+10),(y_axis_value+60)+5);
	    }else if("LT".equals(relationStatus)){
	    	//Living Together[Process]
			gr.setColor(Color.BLACK);
			gr.setStroke(drawingStroke2);
			gr.drawLine((x_axis_value+15), (y_axis_value+60), (x1_axis_value+15),(y1_axis_value+60));
	    }else if("LS".equals(relationStatus)){
	    	//Living Together and Separated[Process]
			gr.setColor(Color.BLACK);
			gr.setStroke(drawingStroke2);
			gr.drawLine((x_axis_value+15), (y_axis_value+60), (x1_axis_value+15),(y1_axis_value+60));
			gr.setStroke(drawingStroke);
			gr.drawLine(((x_axis_value+15)+((x1_axis_value+15)-(x_axis_value+15))/2), (y_axis_value+70), ((x_axis_value+15)+((x1_axis_value+15)-(x_axis_value+15))/2+10),(y1_axis_value+50));
	    }else if("SA".equals(relationStatus)){
	    	//Secret Affair[Process]
			gr.setColor(Color.BLACK);
			gr.drawLine((x_axis_value+15), (y_axis_value+60), (x1_axis_value+15),(y1_axis_value+60));
	    }	
		
	}
	public void drawESIRelationShip(int x_axis_value,int y_axis_value,int x1_axis_value,int y1_axis_value, Graphics g1,String toSex,String fromSex,String relationStatus){
		Stroke drawingStroke = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0);
		Stroke drawingStroke1 = new BasicStroke();
		Stroke drawingStroke2 = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{7}, 0);
		Stroke drawingStroke3 = new BasicStroke(1, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND, 0, new float[]{5.0f, 4.0f, 1.0f, 4.0f}, 0);
		Stroke drawingStroke4 = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0);
		Graphics2D gr = null;
	    if (g1 instanceof Graphics2D) {
	        gr = (Graphics2D) g1;
	    }
		
	    if("PO".equals(relationStatus)){
			//Positive
			gr.setStroke(drawingStroke);
	    	gr.setColor(Color.BLACK);
			gr.drawLine((x_axis_value+15), (y_axis_value+15), (x1_axis_value+15),(y1_axis_value+15));
	    }else if("CL".equals(relationStatus)){
			//Close
			gr.setStroke(drawingStroke);
	    	gr.setColor(Color.BLACK);
			gr.drawLine((x_axis_value+15), (y_axis_value+12), (x1_axis_value+15),(y1_axis_value+12));
			gr.drawLine((x_axis_value+15), (y_axis_value+18), (x1_axis_value+15),(y1_axis_value+18));
	    }else if("CH".equals(relationStatus)){			
			//Close-Hostile
			gr.setStroke(drawingStroke);
	    	gr.setColor(Color.BLACK);
			gr.drawLine((x_axis_value+15), (y_axis_value+8), (x1_axis_value+15),(y1_axis_value+8));
			DrawZingZangLine((x_axis_value+15), (y_axis_value+15), (x1_axis_value+15),(y1_axis_value+15),gr,toSex,fromSex);
			gr.drawLine((x_axis_value+15), (y_axis_value+22), (x1_axis_value+15),(y1_axis_value+22));
	    }else if("DT".equals(relationStatus)){
			//Distant
			gr.setStroke(drawingStroke2);
	    	gr.setColor(Color.BLACK);
			gr.drawLine((x_axis_value+15), (y_axis_value+15), (x1_axis_value+15),(y1_axis_value+15));
	    }else if("FU".equals(relationStatus)){
			//Fused
			gr.setStroke(drawingStroke);
	    	gr.setColor(Color.BLACK);
			gr.drawLine((x_axis_value+15), (y_axis_value+10), (x1_axis_value+15),(y1_axis_value+10));
			gr.drawLine((x_axis_value+15), (y_axis_value+15), (x1_axis_value+15),(y1_axis_value+15));
			gr.drawLine((x_axis_value+15), (y_axis_value+20), (x1_axis_value+15),(y1_axis_value+20));
	    }else if("HO".equals(relationStatus)){
			//Hostile
			gr.setStroke(drawingStroke);
	    	gr.setColor(Color.BLACK);
			DrawZingZangLine((x_axis_value+15), (y_axis_value+15), (x1_axis_value+15),(y1_axis_value+15),gr,toSex,fromSex);
	    }else if("FH".equals(relationStatus)){
			//Fused-Hostile
			gr.setStroke(drawingStroke);
	    	gr.setColor(Color.BLACK);
			gr.drawLine((x_axis_value+15), (y_axis_value+8), (x1_axis_value+15),(y1_axis_value+8));
			DrawZingZangLine((x_axis_value+15), (y_axis_value+15), (x1_axis_value+15),(y1_axis_value+15),gr,toSex,fromSex);
			gr.drawLine((x_axis_value+15), (y_axis_value+15), (x1_axis_value+15),(y1_axis_value+15));
			gr.drawLine((x_axis_value+15), (y_axis_value+22), (x1_axis_value+15),(y1_axis_value+22));
	    }else if("FN".equals(relationStatus)){
			//Focussed On Negatively
			/*gr.setStroke(drawingStroke2);
	    	gr.setColor(Color.BLACK);
			DrawZingZangLine((x_axis_value+15),(y_axis_value+15),(x1_axis_value+15),(y1_axis_value+15),gr,toSex,fromSex);*/
	    }
		
		
		
	}
	public void DrawZingZangLine(int xaxis_value,int yaxis_value,int xaxis1_value,int yaxis1_value, Graphics g1,String indPatSex,String relPerSex){
	
		if(indPatSex.equals("M") && relPerSex.equals("M")){
			
		}else if(indPatSex.equals("F") && relPerSex.equals("F")){
			xaxis_value 	= xaxis_value+2;
			yaxis_value 	= yaxis_value+2;
			xaxis1_value 	= xaxis1_value;
			yaxis1_value	= yaxis1_value;		
		}else if(indPatSex.equals("M") && relPerSex.equals("F")){
			
		}else if(indPatSex.equals("F") && relPerSex.equals("M")){
			
		}
		
		float amplitude = 10.0f;
		float wavelength = 5.0f;
		float next = 0;
		int phase = 0;
		
		float thisX = xaxis_value; 
		float thisY = yaxis_value;
		float lastX = xaxis1_value; 
		float lastY = yaxis1_value;
		
		
		float tempX = xaxis_value;
		float tempY = yaxis_value;
		
		float dx = thisX-lastX;
		float dy = thisY-lastY;
		
		float distance = (float)Math.sqrt( dx*dx + dy*dy );
		
		if ( distance >= next ) {
			float r = 1.0f/distance;
			//float angle = (float)Math.atan2( dy, dx );
			int i=0;
			while ( distance >= next ) {
				float x = lastX + next*dx*r;
				float y = lastY + next*dy*r;
			   // float tx = amplitude*dy*r;
			   // float ty = amplitude*dx*r;
				if ( (phase & 1) == 0 ){               
					if(i!=0){
					g1.drawLine((int)tempX, (int)tempY, (int)(x+amplitude*dy*r), (int)(y-amplitude*dx*r));
					}
					tempX = (x+amplitude*dy*r);
					tempY = (y-amplitude*dx*r);
				}else{
					g1.drawLine((int)tempX, (int)tempY, (int)(x-amplitude*dy*r), (int)(y+amplitude*dx*r));
					tempX = (x-amplitude*dy*r);
					tempY = (y+amplitude*dx*r);
				}
				next += wavelength;
				phase++;
				i++;
			}
		}
		
	}	
	//IN043482 Start.
	public void drawMHRelationShip(int xaxis_value,int yaxis_value, Graphics g2,String sex,String mhrelation){
		
		if("M".equals(sex)){
			if("SU".equals(mhrelation)){
				g2.setColor(Color.getHSBColor(241, 237, 73));
				g2.fillRect((xaxis_value+1),  (yaxis_value+15), 15, 15);
				g2.setColor(Color.BLACK);
				g2.drawRect((xaxis_value+1),  (yaxis_value+15), 15, 15);
			}else if("CA".equals(mhrelation)){
				g2.setColor(new Color(252,97,97));
				g2.fillRect((xaxis_value+1),  (yaxis_value+15), 15, 15);
				g2.setColor(Color.BLACK);
				g2.drawRect((xaxis_value+1),  (yaxis_value+15), 15, 15);
			}else if("IR".equals(mhrelation)){
				g2.setColor(new Color(102, 241, 99)); 
				g2.fillRect((xaxis_value+1),  (yaxis_value+15), 15, 15);
				g2.setColor(Color.BLACK);
				g2.drawRect((xaxis_value+1),  (yaxis_value+15), 15, 15);
			}else if("SS".equals(mhrelation)){
				g2.setColor(new Color(249, 7, 7));
				g2.fillRect((xaxis_value+1),  (yaxis_value), 15, 15);
				g2.setColor(Color.BLACK);
				g2.drawRect((xaxis_value+1),  (yaxis_value), 15, 15);
			}else if("SH".equals(mhrelation)){
				g2.setColor(new Color(249, 7, 7));
				g2.fillRect((xaxis_value+15),  (yaxis_value), 15, 15);
				g2.setColor(Color.BLACK);
				g2.drawRect((xaxis_value+15),  (yaxis_value), 15, 15);
			}else if("SM".equals(mhrelation)){
				g2.setColor(Color.BLACK);	   
				g2.drawString("S", (xaxis_value+32), (yaxis_value+10));
			}else if("OB".equals(mhrelation)){
				g2.setColor(Color.BLACK);	   
				g2.drawString("O", (xaxis_value+32), (yaxis_value+32));
			}
			
		}else if("F".equals(sex)){
			if("SU".equals(mhrelation)){
				g2.setColor(new Color(241, 237, 73)); 
				g2.fillArc((xaxis_value+1),(yaxis_value+1),29,29,-90,-90); //(x, y, width, height, startAngle, arcAngle)
				g2.setColor(Color.BLACK);
				g2.drawLine(xaxis_value, (yaxis_value+15), (xaxis_value+15),(yaxis_value+15));
				g2.drawLine((xaxis_value+15), (yaxis_value+15), (xaxis_value+15),(yaxis_value+30));
			}else if("CA".equals(mhrelation)){
				g2.setColor(new Color(252,97,97));
				g2.fillArc((xaxis_value+1),(yaxis_value+1),29,29,-90,-90); //(x, y, width, height, startAngle, arcAngle)
				g2.setColor(Color.BLACK);
				g2.drawLine(xaxis_value, (yaxis_value+15), (xaxis_value+15),(yaxis_value+15));
				g2.drawLine((xaxis_value+15), (yaxis_value+15), (xaxis_value+15),(yaxis_value+30));
			}else if("IR".equals(mhrelation)){
				g2.setColor(new Color(102, 241, 99)); 
				g2.fillArc((xaxis_value+1),(yaxis_value+1),29,29,-90,-90); //(x, y, width, height, startAngle, arcAngle)
				g2.setColor(Color.BLACK);
				g2.drawLine(xaxis_value, (yaxis_value+15), (xaxis_value+15),(yaxis_value+15));
				g2.drawLine((xaxis_value+15), (yaxis_value+15), (xaxis_value+15),(yaxis_value+30));
			}else if("SS".equals(mhrelation)){
				g2.setColor(new Color(249, 7, 7)); 
				g2.fillArc((xaxis_value+1),(yaxis_value+1),29,29,90,90); //(x, y, width, height, startAngle, arcAngle)
				g2.setColor(Color.BLACK);
				g2.drawLine(xaxis_value, (yaxis_value+15), (xaxis_value+15),(yaxis_value+15));
				g2.drawLine((xaxis_value+15), (yaxis_value), (xaxis_value+15),(yaxis_value+15));
			}else if("SH".equals(mhrelation)){
				g2.setColor(new Color(249, 7, 7)); 
				g2.fillArc((xaxis_value+1),(yaxis_value+1),29,29,90,-90); //(x, y, width, height, startAngle, arcAngle)
				g2.setColor(Color.BLACK);
				g2.drawLine((xaxis_value+15), (yaxis_value+15), (xaxis_value+30),(yaxis_value+15));
				g2.drawLine((xaxis_value+15), (yaxis_value), (xaxis_value+15),(yaxis_value+15));
			}else if("SM".equals(mhrelation)){
				g2.setColor(Color.BLACK);	   
				g2.drawString("S", (xaxis_value+32), (yaxis_value+10));
			}else if("OB".equals(mhrelation)){
				g2.setColor(Color.BLACK);	   
				g2.drawString("O", (xaxis_value+32), (yaxis_value+32));
			}
			
		}
	}
    public static void main(String[] args)
    {
        JFrame f = new JFrame("ShapesDemo2D");
	    f.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {
	        System.exit(0);
	      }
	    });
	    JApplet applet = new CAGenogramApplet();
	    f.getContentPane().add("Center", applet);
	    applet.init();
	    f.pack();
	    
	    //f.setSize(new Dimension(1000, 600));
		
	    f.show();
    }
}





