/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;
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
  
public class XHGatewayListControllerBean implements java.io.Serializable					   
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
  private TreeMap treempselect = new TreeMap();
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
  public static String commode="";
  public static String interfc_mod_id=""; 					   
  public static String selectAll=""; 
  public static LinkedList li=new LinkedList();	  
  public static int pageCou=0;
  public static String whereCaluse="";
     public static List listA = new LinkedList();
   public static List listB = new LinkedList();
    public static LinkedList list = new LinkedList();
/**
   * Method  to accesss the data which returns string array
   */  public String[][] getDatabaseData()
  {
    String str[][] = null; 
    String key = "";
    Iterator iterator = null;
    XHGatewayListElementBean xhBean = null;
    String strItm[] = new String[3];
    String strNeeded[][] = null;
    try
    {
        str = new String[treemp.size()][3];
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
          strNeeded = new String[j][4];
          System.arraycopy(str,0,strNeeded,0,j);
    }
    catch(Exception exp)
    {
       System.out.println("Error in getdatabasedata method of xhapplicationcontrollerbean :"+exp.toString());
	   exp.printStackTrace(System.err);
    }
    return(strNeeded);
  }
/**
   * Method  getCodeDesc return bean element XHGatewayListElementBean  depending ob the key 
   * @param  String key
   * @return returns object type  XHGatewayListElementBean
   */   
  public XHGatewayListElementBean getCodeDesc(String key)
  {
    return((XHGatewayListElementBean)treemp.get(key));
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
	  String elementattr1="";
	  String elementattr2="";
		ListIterator iterator = listA.listIterator(); 
 //   Iterator iterator = enumerate();				    
    String strKey = "",strOption = "";
    XHGatewayListElementBean xhCode = null;
	try{
	request.setCharacterEncoding("UTF-8");
	}catch(Exception ex){ System.out.println("Error in getallparamtervalues method of xhapplicationcontrollerbean :"+ex.toString());
	   ex.printStackTrace(System.err);}
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
		strOption=checkNull(request.getParameter(strKey+"_check"));	    
	}
       
   xhCode = getCodeDesc(strKey);
   xhCode.setOptionYN(strOption);					   
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
   XHGatewayListElementBean xhCode = null;
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
	hashmp.put("listA",listA);
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

 public static XHGatewayListControllerBean getBean(String strBeanName,
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

     XHGatewayListControllerBean xhBean = null;
     if(action.equals("S")||action.equals("0"))
     {
     listA.clear(); 
      session.removeAttribute(strBeanName); 
      xhBean = new XHGatewayListControllerBean();
      session.setAttribute(strBeanName,xhBean); 
	   whereCaluse=checkNull((String)request.getAttribute("Query"));
    }
    else
    {
      xhBean = (XHGatewayListControllerBean) session.getAttribute(strBeanName);
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
	 request.setCharacterEncoding("UTF-8");
	 session=request.getSession(false);
	 } catch(Exception ex){}
	 Properties p;		
	 p = (Properties) session.getValue("jdbc");	
     locale  = p.getProperty("LOCALE");
	String action  = "";
	 String action_attr=checkNull((String)request.getAttribute("action_attr"));
	 	if(action_attr.equals(""))
	 {
		 action  = checkNullZero(request.getParameter("action_type")); 
	 }
      else
	  {
			action  ="R";										  					   
	  } 																		    
	selectAll=checkNull((String)request.getAttribute("selectAll"));
	String page=checkNullZero(request.getParameter("pageCount")); 
	commode=checkNull((String)request.getAttribute("commode"));  
	interfc_mod_id=checkNull((String)request.getAttribute("interfce_module_id"));      


    pageCou=Integer.parseInt(page);
	 if((action.equals("R")))
	  {																							  
		 li.remove(pageCou);	    
		 li.add(pageCou,selectAll);	    

	  }
																					   	   
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
   * Method to populate the  XHGatewayListElementBean Bean 
   * @param  Connection conn
   * @param  HttpServletRequest request
   * @param  String locale													 					 
  */
  public void populateXHCodeDesc(Connection conn,String locale)
  {
  
 //  String ResultQry=" SELECT a.PROTOCOL_LINK_ID,a.PROTOCOL_LINK_NAME,'Y'  FROM XH_PROTOCOL_LINK a,xh_protocol b  WHERE a.protocol_id = b.protocol_id AND b.protcol_mode = '"+commode+"' AND b.interface_module_id = NVL('"+interfc_mod_id+"',b.interface_module_id) "+whereCaluse+" ORDER BY 1";
   PreparedStatement pstmt = null;
    ResultSet rset = null; 					 	 	   
     try  
    {
      pstmt = conn.prepareStatement(whereCaluse);
	  //System.out.println("(XHGatewayListControllerBean:populateXHCodeDesc) sqlQuery:"+whereCaluse);

      //pstmt.setString(1,this.application_id);									 
      rset = pstmt.executeQuery();
      while(rset.next())
      {
		   listA.add(rset.getString(1));
		 treemp.put(rset.getString(1),new XHGatewayListElementBean(checkNull(rset.getString(1)),checkNull(rset.getString(2)),checkNull(rset.getString(3)))) ;	
		  if(checkNull(rset.getString(3)).equals("Y"))
		  {
			  list.add(checkNull(rset.getString(1)));	  
		  }

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
       System.out.println("Error in populatexhcodedesc method of XHGatewayListControllerBean:"+exp.toString());
	   exp.printStackTrace(System.err);
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
