/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.*;
import javax.servlet.http.HttpSession;											    
import java.net.*;
import java.util.LinkedList; 
/**
 * Bean Class used to represent the XH Application Elements Bean
 *																	    		  
 */
  
public class SRRMedicationListReportBean implements java.io.Serializable
{
  public static String strBeanName = "SRR_MEDICATION_LIST_REPORT";						 	 	    
  private String application_id = "";				    
  private int start = 0;															    
  private int end = 0;		
  private int rem = 0;															    
  private double coun = 0;	
  private int totalData = 0;
  private int maxRec = 15;
  private TreeMap treemp = new TreeMap();
//  private TreeMap treempselect = new TreeMap();
  private boolean boolNext = false;											 
  private boolean boolPrevious = false;
  public static  String patient_id="";
  public static  String adr_reported_date_from="";
  public static  String adr_reported_date_to="";
  public static  String doc_type_code="";			  
  public static  String sale_doc_no_from=""; 
  public static  String sale_doc_no_to="";
  public static  String locale="";	 			  
  public static  String facility="";	
  public static String store_code="";
  public static String user_name="";
  public static String selectAll=""; 
  public static LinkedList li=new LinkedList();	  
  public static int pageCou=0;
     public static List listA = new LinkedList();
   public static List listB = new LinkedList();

/**
   * Method  to accesss the data which returns string array
   */  public String[][] getDatabaseData()
  {
    String str[][] = null; 
    String key = "";
    Iterator iterator = null;
    SRRMedicationListReportDetailBean xhBean = null;
    String strItm[] = new String[9];
    String strNeeded[][] = null;
    try
    {
        str = new String[treemp.size()][9];
        iterator = this.enumerate();
        int j=0;
        while(iterator.hasNext())
        {
          key = iterator.next()+"";
          
          xhBean = this.getCodeDesc(key);
          if (!(xhBean.isChanged()))
          {
            continue;
          }
          strItm = xhBean.getDatabaseData();
          strItm[0] = this.application_id;
          str[j] =strItm;
          j++;
          
        }
          strNeeded = new String[j][10];
          System.arraycopy(str,0,strNeeded,0,j);
    }
    catch(Exception exp)
    {
	   exp.printStackTrace();
    }
    return(strNeeded);
  }
/**
   * Method  getCodeDesc return bean element SRRMedicationListReportDetailBean  depending ob the key 
   * @param  String key
   * @return returns object type  SRRMedicationListReportDetailBean
   */   
  public SRRMedicationListReportDetailBean getCodeDesc(String key)
  {
    return((SRRMedicationListReportDetailBean)treemp.get(key));
  }
/**
   * Method to enumerate the keys 
   */
  public Iterator enumerate()
  {
    Set set = treemp.keySet();
    Iterator iterator = set.iterator();
    return iterator;          
  }
/**
   * Method defined to get all the parameter values 
   * @param  HttpServletRequest request
   * @param  Connection conn
   */
  public void getAllParameterValues(HttpServletRequest request,Connection conn)
  {
	 // String elementattr1="";
	 // 	  String elementattr2="";
		ListIterator iterator = listA.listIterator(); 
 //   Iterator iterator = enumerate();
    String strKey = "",strOption = "";
    SRRMedicationListReportDetailBean xhCode = null;
	try{
	//request.setCharacterEncoding("UTF-8");
	}catch(Exception ex){ 
		ex.printStackTrace();
	}
    for (int i=0;i<start;i++)
    {
      iterator.next();
    }
    for(int i=start;i<end;i++)
    {
      if (iterator.hasNext())
      {												 
        strKey = iterator.next()+"";							  
      }
      else
      {
        break;
      }
	
	if(selectAll.equals("Y"))						    
	{
		strOption="Y";
	}
	else if(selectAll.equals("N"))																	 
	{
		 strOption="N";
	}													   
	else
	{
		strOption=checkNull(request.getParameter(strKey+"chk"));
	}
   xhCode = getCodeDesc(strKey);
   xhCode.setOption(strOption);
   xhCode.setChanged();
   									  
    }
  }															   
  /**
   * Method to add the values into the hashmap 
   */															    
 public HashMap getResultSet()		    
 {
	   ListIterator iterator = listA.listIterator();
  // Iterator iterator = enumerate();
   ArrayList arrRow = null;
   String key = "";
   SRRMedicationListReportDetailBean xhCode = null;
   arrRow = new ArrayList();
   HashMap hashmp = new HashMap();								 
   for(int i=0;i<start;i++)
   {
     iterator.next();
   }
   for(int i=start;i<end;i++)
   {
      if (iterator.hasNext())
      {
        key = iterator.next()+"";
      }
      else
      {
        break;
      }
     xhCode = getCodeDesc(key);
     arrRow.add(xhCode.getArrayData());
     
   }
 
   hashmp.put("qry_result",arrRow);
   hashmp.put("next",new Boolean(boolNext));
   hashmp.put("previous",new Boolean(boolPrevious));
   if(arrRow.size()>0)
 {
   hashmp.put("selectAll",li.get(pageCou)+"");	   
 }
 else
 {
	  hashmp.put("selectAll","");	   
 }
   return(hashmp);
 }
/**
   * Method to get single bean element 
   * @param  String strBeanName
   * @param  HttpServletRequest request
   * @param  HttpSession session
   */

 public static SRRMedicationListReportBean getBean(String strBeanName,
														  HttpServletRequest request,
														  HttpSession session)
 {
     String action  = "";
	 String action_attr=checkNull((String)request.getAttribute("action_attr"));
	 	if(action_attr.equals(""))
	 {
      action  = checkNullZero(request.getParameter("action_type"));
	 }
	 else
	 {																		  
	  action="R";
	 }

     SRRMedicationListReportBean xhBean = null;
     if(action.equals("S")||action.equals("0"))
     {
     listA.clear(); 
      session.removeAttribute(strBeanName); 
      xhBean = new SRRMedicationListReportBean();
      session.setAttribute(strBeanName,xhBean); 
    }
    else
    {
      xhBean = (SRRMedicationListReportBean) session.getAttribute(strBeanName);
    }
    return(xhBean);
 }

/**
   * Method to define whether need to access elements or not depending on the action
   * @param  String action
   */
 private boolean decideParameterValues(String action)
 {
   if ( action.equals("P")||
        action.equals("N")||
        action.equals("R"))
  {
    return(true);
  }
  return false;
 }

/**
   * Method action to retrive jsp values 
   * @param  HttpServletRequest request
   * @param  Connection conn
   */

 public void action(HttpServletRequest request,Connection conn)
  {
	 HttpSession session=null;
	 try{
	 //request.setCharacterEncoding("UTF-8");
	 session=request.getSession(false);
	 } catch(Exception ex){}
	 Properties p;		
	 p = (Properties) session.getValue("jdbc");	
     locale  = p.getProperty("LOCALE");
	String action  = "";
	 String action_attr=checkNull((String)request.getAttribute("action_attr"));
	 	if(action_attr.equals(""))
	 {

		//	li.clear();
			 action  = checkNullZero(request.getParameter("action_type")); 
	 }
      else
	  {
			action  ="R";
	  } 
	patient_id=checkNull((String)request.getAttribute("patient_id"));	   
    adr_reported_date_from=checkNull((String)request.getAttribute("adr_reported_date_from"));	   
	adr_reported_date_to=checkNull((String)request.getAttribute("adr_reported_date_to"));	 
    doc_type_code=checkNull((String)request.getAttribute("doc_type_code"));	
	sale_doc_no_from=checkNull((String)request.getAttribute("sale_doc_no_from"));
	sale_doc_no_to=checkNull((String)request.getAttribute("sale_doc_no_to"));
	store_code=checkNull((String)request.getAttribute("store_code"));
	selectAll=checkNull((String)request.getAttribute("selectAll"));
	String page=checkNullZero(request.getParameter("pageCount")); 
    pageCou=Integer.parseInt(page);
	 if((action.equals("R")))
	  {
		 li.remove(pageCou);	    
		 li.add(pageCou,selectAll);	    

	  }
	facility=(String)session.getValue("facility_id");
    user_name				=		(String) session.getValue( "login_user" ) ;
    if ((action.equals("S"))||(action.equals("0")))
    {
			li.clear();
      this.populateXHCodeDesc(conn,locale);
      end = maxRec;
    }																					 
    if (decideParameterValues(action) == true)
    getAllParameterValues(request,conn) ;			    
    if (action.equals("N"))
    {
      start = start+maxRec;
			end = end+maxRec;
      if(start>=totalData)
      {
        start = start - maxRec;									   
        end = end-maxRec;							 
        
      }
    }
    if (action.equals("P"))
    {
      start = start - maxRec;
      end = end-maxRec;
      if (start<=0)
      {
        start = 0;
        end = maxRec;
        
      }



    }
     if (totalData>end)
    {
      boolNext =  true;
    }
    else
    {
      boolNext =  false;      
    }														   
    if (end>maxRec)
    {
      boolPrevious =  true;
    }										  
    else
    {
      boolPrevious =  false;
    }
  }

/**
   * Method to populate the  SRRMedicationListReportDetailBean Bean 
   * @param  Connection conn
   * @param  HttpServletRequest request
   * @param  String locale																		 
  */
  public void populateXHCodeDesc(Connection conn,String locale)
  {

	  if(store_code.equals(""))
	  {
		store_code="%";
	  }

	   if(patient_id.equals(""))
	  {
		patient_id="%";
	  }

	 if(doc_type_code.equals(""))
	  {
		 doc_type_code="%";
	  }

    String sql="SELECT DISTINCT hdr.doc_type_code, hdr.doc_no,TO_CHAR (hdr.doc_date, 'dd/mm/yyyy') doc_date, hdr.store_code,fms.short_desc fm_store_desc, hdr.patient_id,NVL(hdr.ENCOUNTER_ID,'') encounter_id, DECODE(SAL_TRN_TYPE,'X', hdr.PATIENT_NAME, mp.patient_name) patient_name FROM ST_SAL_HDR hdr, mm_store_lang_vw fms, sy_doc_type_master_lang_vw sy,ST_USER_ACCESS_FOR_STORE uaca,mp_patient mp WHERE  hdr.store_code = fms.store_code AND hdr.patient_id=mp.patient_id AND uaca.store_code = hdr.store_code AND hdr.finalized_yn = 'Y' AND hdr.module_id = 'ST' AND uaca.sal_allowed_yn = 'Y' AND hdr.doc_type_code LIKE UPPER('"+doc_type_code+"') AND TO_CHAR(hdr.doc_no) BETWEEN TO_CHAR(NVL('"+sale_doc_no_from+"','!')) AND TO_CHAR(NVL('"+sale_doc_no_to+"','~')) AND trunc(hdr.doc_date) BETWEEN TO_DATE (NVL ('"+adr_reported_date_from+"', '01/01/1901'), 'dd/mm/yyyy') AND TO_DATE (NVL ('"+adr_reported_date_to+"', TO_CHAR (SYSDATE, 'DD/MM/YYYY')),'dd/mm/yyyy') AND hdr.store_code LIKE '"+store_code+"' AND uaca.user_id ='"+user_name+"' AND hdr.facility_id ='"+facility+"' AND hdr.PATIENT_ID LIKE  '"+patient_id+"' AND sy.language_id = fms.language_id AND sy.language_id ='"+locale+"' ORDER BY TO_DATE(doc_date,'dd/mm/yyyy') DESC ,doc_no DESC ";     

		



	PreparedStatement pstmt = null;
    ResultSet rset = null; 						 	   
     try  
    {
      pstmt = conn.prepareStatement(sql);

      //pstmt.setString(1,this.application_id);									 
      rset = pstmt.executeQuery();
      while(rset.next())
      {
		   listA.add(rset.getString(1)+rset.getString(2));
        treemp.put(rset.getString(1)+rset.getString(2),new SRRMedicationListReportDetailBean(checkNull(rset.getString(1)),checkNull(rset.getString(2)),checkNull(rset.getString(3)),checkNull(rset.getString(4)),checkNull(rset.getString(5)),checkNull(rset.getString(6)),checkNull(rset.getString(7)),checkNull(rset.getString(8)),"N")) ;	
		 
      }		
      this.totalData = treemp.size();
	  coun=Math.abs(this.totalData/maxRec);
	  rem=this.totalData%maxRec;									  
		 if(rem>0)
		{
		   coun=coun+1;
		}
		 for(int g=0;g<coun;g++)
		{
			li.add("N");  
		}
	  if(rset!=null) rset.close();					 				   			  
      if(pstmt!=null) pstmt.close();					 							 
    }													   
    catch(Exception exp)						 
    {
	   exp.printStackTrace();
    }
  }

  /*  public String getOptionYN(String key)
  {
   
  }	*/
	  private static String checkNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
  	  private static String checkNullZero(String inputString)
	{
		return (inputString==null)	?	"0"	:	inputString;
	}
  
}//end of class
