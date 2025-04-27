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
import oracle.jdbc.driver.*;
import oracle.sql.*;
/**
 * Bean Class used to represent the XH Elements
 *
 */
public class XHElementControllerBean implements java.io.Serializable
{
 
  public static String strBeanName = "XH_ELEMENT_CROSS_REF";
  private int start = 0;
  private int end = 0;
  private int totalData = 0;
  private int maxRec = 15;
  private TreeMap treemp = new TreeMap();
  private boolean boolNext = false;
  private boolean boolPrevious = false;

/**
  * Method  to accesss the data which returns string array
  */
    public String[][] getDatabaseData()
  {
     
	 String str[][] = null;
     String key = "";
     Iterator iterator = null;
     XHElementsBean xhBean = null;
     String strItm[] = new String[3];
	   String strNeeded[][] = null;
     try
     {
        str = new String[treemp.size()][4];
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

	
          str[j] =strItm;
          j++;
        }
	strNeeded = new String[j][5];
    System.arraycopy(str,0,strNeeded,0,j);
    }
    catch(Exception exp)
    {       
	   exp.printStackTrace(System.err);
    }
   return(strNeeded);
  }

 /**
   * Method  getCodeDesc return bean element XHElementsBean  depending ob the key 
   * @param  String key
   * @return returns object type  XHElementsBean
   */       
  public XHElementsBean getCodeDesc(String key)
  {
     return((XHElementsBean)treemp.get(key));
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
     try{
	request.setCharacterEncoding("UTF-8");
	}catch(Exception ex){}
	 Iterator iterator = enumerate();
     String strKey = "",strInUse="",strFacility="",strElementdesc="";
     XHElementsBean xhCode = null;
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
	   strElementdesc=XHDBAdapter.checkNull(request.getParameter(strKey+"e"));	   
      strInUse = XHDBAdapter.checkNullForCheckBox(request.getParameter(strKey));
	  strFacility = XHDBAdapter.checkNullForCheckBox(request.getParameter(strKey+"f"));
      xhCode = getCodeDesc(strKey);
      xhCode.setInuse(strInUse);
	  xhCode.setChanged();
      xhCode.setDescription(strElementdesc);

	 // xhCode.setFacility(strFacility);
    }
  }
 
 /**
   * Method to add the values into the hashmap 
   */
   public HashMap getResultSet()
   {
   Iterator iterator = enumerate();
   ArrayList arrRow = null;
   String key = "";
   XHElementsBean xhCode = null;
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
 
 public static XHElementControllerBean getBean(String strBeanName, HttpServletRequest request,HttpSession session) 
 {
   String action  = XHDBAdapter.checkNullZero(request.getParameter("action_type"));

   XHElementControllerBean xhBean = null;
    if(action.equals("S")||action.equals("0"))
    {
      session.removeAttribute(strBeanName); 
      xhBean = new XHElementControllerBean();
      session.setAttribute(strBeanName,xhBean); 
    }
    else
    {
      xhBean = (XHElementControllerBean) session.getAttribute(strBeanName);
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
	 HttpSession session=request.getSession(false);
	 Properties p;		
	 p = (Properties) session.getValue("jdbc");	
	 String locale  = p.getProperty("LOCALE");

	try{
	request.setCharacterEncoding("UTF-8");
	}catch(Exception ex){}
	String action  = XHDBAdapter.checkNullZero(request.getParameter("action_type"));

    
    if ((action.equals("S"))||(action.equals("0")))
    {
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
   * Method to populate the  XHElementsBean Bean 
   * @param  Connection conn
   * @param  HttpServletRequest request
   * @param  String locale
  */
  public void populateXHCodeDesc(Connection conn,String locale)
  {
    
    String sql = "SELECT  ELEMENT_ID, ELEMENT_NAME ,NVL(IN_USE_YN,'N'),NVL(FACILITY_BASED_YN,'N') FROM XH_ELEMENT_CROSSREF_LANG_VW WHERE LANGUAGE_ID='"+locale+"' order by ELEMENT_NAME asc ";
	
    PreparedStatement pstmt = null;
    ResultSet rset = null;
    try
    { 
      pstmt = conn.prepareStatement(sql);
      
      rset = pstmt.executeQuery();
      while(rset.next())
      {


        treemp.put(rset.getString(1),new XHElementsBean(XHDBAdapter.checkNull(rset.getString(1)),XHDBAdapter.checkNull(rset.getString(2)),XHDBAdapter.checkNull(rset.getString(3)),XHDBAdapter.checkNull(rset.getString(4)))) ;
      }
      this.totalData = treemp.size();
	 
	  if(pstmt!=null) pstmt.close();
	  if(rset!=null)rset.close();
     }
    catch(Exception exp)
    {	   
	   exp.printStackTrace(System.err);
      
    }
  }
  
  
}//end of class
