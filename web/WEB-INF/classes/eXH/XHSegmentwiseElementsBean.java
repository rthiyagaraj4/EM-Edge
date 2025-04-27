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
/**
 * Bean Class used to represent the XH Application Elements Bean
 *
 */ 
  
public class XHSegmentwiseElementsBean implements java.io.Serializable
{
  public static String strBeanName = "XH_APPL_ELEMENT_CROSS_REF";

  private String application_id = "";
  private int start = 0;
  private int end = 0;
  private int totalData = 0;
  private int maxRec = 13;
  private TreeMap treemp = new TreeMap();
  private boolean boolNext = false;
  private boolean boolPrevious = false;

  public static  String appl_id="";
  public static  String standard_code="";
  public static  String msg_type="";
   public static List listA = new LinkedList();
   public static List listB = new LinkedList();
/**
   * Method  to accesss the data which returns string array
   */  public String[][] getDatabaseData()
  {
    String str[][] = null; 
    String key = "";
    Iterator iterator = null;
    XHWiseElementsBean xhBean = null;
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
   * Method  getCodeDesc return bean element XHWiseElementsBean  depending ob the key 
   * @param  String key
   * @return returns object type  XHWiseElementsBean
   */   
  public XHWiseElementsBean getCodeDesc(String key)
  {
    return((XHWiseElementsBean)treemp.get(key));
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
	 
		ListIterator iterator = listA.listIterator();
 //   Iterator iterator = enumerate();
	 String strKey = "",strInUse="",strField="";
    XHWiseElementsBean xhCode = null;
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
	      strInUse = XHDBAdapter.checkNullForCheckBox(request.getParameter(strKey+"_inuse"));
 strField = XHDBAdapter.checkNullForCheckBox(request.getParameter(strKey+"_field"));
	
     // strDtltype2= XHDBAdapter.checkNull(request.getParameter(strKey+"_type"));
	//strDtltype=XHDBAdapter.checkNull(request.getParameter(strKey+"_type1"));
   xhCode = getCodeDesc(strKey);
 


xhCode.setFieldchange(strField);
     // xhCode.setDTLType(setDtl);
     xhCode.setInuse(strInUse);
   xhCode.setChanged();

    }
  }
  /**
   * Method to add the values into the hashmap 
   */
 public HashMap getResultSet()
 {
  // Iterator iterator = enumerate();
  ListIterator iterator = listA.listIterator();
   ArrayList arrRow = null;
   String key = "";
   XHWiseElementsBean xhCode = null;
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
   return(hashmp);
 }
/**
   * Method to get single bean element 
   * @param  String strBeanName
   * @param  HttpServletRequest request
   * @param  HttpSession session
   */

 public static XHSegmentwiseElementsBean getBean(String strBeanName,
														  HttpServletRequest request,
														  HttpSession session)
 {
     String action  = XHDBAdapter.checkNullZero(request.getParameter("action_type"));
     XHSegmentwiseElementsBean xhBean = null;
     if(action.equals("S")||action.equals("0"))
     {
       msg_type=XHDBAdapter.checkNull((String)request.getAttribute("message_type"));
    
	 standard_code= XHDBAdapter.checkNull((String)request.getAttribute("standard_code"));
           session.removeAttribute(strBeanName); 
      xhBean = new XHSegmentwiseElementsBean();
      session.setAttribute(strBeanName,xhBean); 
    }
    else
    {
      xhBean = (XHSegmentwiseElementsBean) session.getAttribute(strBeanName);
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
     String locale  = p.getProperty("LOCALE");
        String action  = XHDBAdapter.checkNullZero(request.getParameter("action_type"));


 
   
	 
     

    if ((action.equals("S"))||(action.equals("0")))
    {
		

		listA.clear();
   
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
   * Method to populate the  XHWiseElementsBean Bean 
   * @param  Connection conn
   * @param  HttpServletRequest request
   * @param  String locale
  */
  public void populateXHCodeDesc(Connection conn,String locale)
  {
                       
     String sqlString="SELECT  * FROM (SELECT DISTINCT a.SEGMENT_TYPE,b.SEGMENT_NAME,a.OPTIONAL_YN,a.IN_USE_YN,C.STANDARD_DESC,A.EVENT_TYPE,a.SEGMENT_SEQ,B.STANDARD_CODE  FROM  XH_EVENT_TYPE_SEGMENT a, XH_SEGMENT_LANG_VW b, XH_STANDARD C  WHERE   DECODE(a.EVENT_TYPE,NULL,'XX',a.EVENT_TYPE) = 	 	 NVL('"+msg_type+"',DECODE(a.EVENT_TYPE,NULL,'XX',a.EVENT_TYPE)) AND a.SEGMENT_TYPE=b.SEGMENT_TYPE AND DECODE(C.STANDARD_CODE,NULL,'XX',C.STANDARD_CODE) = NVL('"+standard_code+"',DECODE(C.STANDARD_CODE,NULL,'XX',C.STANDARD_CODE))  AND  		 B.STANDARD_CODE=C.STANDARD_CODE(+) AND b.LANGUAGE_ID='en'  ORDER BY a.SEGMENT_SEQ)  order by 6,7";
//     System.out.println("XHSegmentwiseElementsBean sql"+sqlString); 
	 PreparedStatement pstmt = null;
    ResultSet rset = null; 
     try  
    {
      pstmt = conn.prepareStatement(sqlString);
      //pstmt.setString(1,this.application_id);
      rset = pstmt.executeQuery();
      while(rset.next())
      {
		   listA.add(rset.getString(1)+rset.getString(6));
              treemp.put(rset.getString(1)+rset.getString(6),new XHWiseElementsBean(XHDBAdapter.checkNull(rset.getString(1)),XHDBAdapter.checkNull(rset.getString(2)),XHDBAdapter.checkNull(rset.getString(3)),XHDBAdapter.checkNull(rset.getString(4)),XHDBAdapter.checkNull(rset.getString(5)),XHDBAdapter.checkNull(rset.getString(6)),XHDBAdapter.checkNull(rset.getString(7)),XHDBAdapter.checkNull(rset.getString(8)),"N")) ;
      }
      this.totalData = treemp.size();
	  if(rset!=null) rset.close(); 
      if(pstmt!=null) pstmt.close();
    }
    catch(Exception exp)
    {
       System.out.println("Error in populatexhcodedesc method of xhapplicationcontrollerbean :"+exp.toString());
	   exp.printStackTrace(System.err);
    }
  } 
  
  
}//end of class
