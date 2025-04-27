/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import oracle.sql.ARRAY;
import oracle.sql.STRUCT;

/**
 * Bean Class used to represent the master code elements 
 *
 */
public class XHMasterCodeControllerBean implements java.io.Serializable
{
  public static String strBeanName = "XH_MASTER_CODE_SET_UP";
  private int start = 0;
  private int end = 0;
  private String module = "";
  private String mastertableId = "";
  private String facilityId = "";
  private String applicationId = "";
  private int totalData = 0;
  private int maxRec = 13;
  private TreeMap treemp = new TreeMap();
  private boolean boolNext = false;
  private boolean boolPrevious = false;
  private static String packageName = "{ call xhmast.populate_codes_for_all_modules(?,?,?,?) }";
  
  /**
   * Method  to accesss the data which returns string array
   */
  public String[][] getDatabaseData()
  {
    String str[][] = null;
    String key = "";
    Iterator iterator = null;
    XHMasterCodeElements xhBean = null;
    String strItm[] = new String[4];
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
          if (!(xhBean.getChanged()))
          {
            continue;
          }
          strItm = xhBean.getDatabaseData();
          strItm[0] = this.applicationId;
          strItm[1] = this.module;
          strItm[2] = this.mastertableId;
          strItm[3] = this.facilityId;
          str[j] =strItm;
          j++;
          
        }
          strNeeded = new String[j][5];
          System.arraycopy(str,0,strNeeded,0,j);
    }
    catch(Exception exp)
    {
	   System.out.println("Error in getdatabasedata method of xhmastercodecontrollerbean :"+exp.toString());
	   exp.printStackTrace(System.err);
      
    }
    return(strNeeded);
  }
  
  /**
   * Method  getCodeDesc return bean element XHMasterCodeElements  depending ob the key 
   * @param  String key
   * @return returns object type  XHMasterCodeElements
   */
  
  public XHMasterCodeElements getCodeDesc(String key)
  {
    return((XHMasterCodeElements)treemp.get(key));
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
   * Method to add element 
   * @param  String str
   */
  private boolean canAdd(String str)
  {
    if(!(str.equals("")))
    {
      return(true);
    }
    return(false);
  }
  /**
   * Method isChanged defined to check whether the elemnet is changed or not 
   * @param  String key
   */
  public boolean isChanged(String key)
  {
    XHMasterCodeElements xhCode = null;
    try
    {
      xhCode = (XHMasterCodeElements)treemp.get(key);
      return(xhCode.getChanged());
    }
    catch(Exception exp)
    {
      
    }
    return(false);
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
    String strKey = "",strCode = "",strDesc="";
    XHMasterCodeElements xhCode = null;
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
      strCode = XHDBAdapter.checkNull(request.getParameter(strKey+"_code"));
      strDesc = XHDBAdapter.checkNull(request.getParameter(strKey+"_desc"));
      if (canAdd(strCode))
      {
        xhCode = (XHMasterCodeElements)treemp.get(strKey);               
        xhCode.setExternalCode(strCode);
        xhCode.setExternalDesc(strDesc);
        xhCode.setChanged();
      }
     }
  }

  /**
   * Mwthod to add the values into the hashmap 
   */
 public HashMap getResultSet()
 {
   Iterator iterator = enumerate();
   ArrayList arrRow = null;
   String key = "";
   XHMasterCodeElements xhCode = null;
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
 public static XHMasterCodeControllerBean getBean(String strBeanName, HttpServletRequest request,HttpSession session)
 {
  try{
	request.setCharacterEncoding("UTF-8");
	}catch(Exception ex){}
   String action  = XHDBAdapter.checkNullZero(request.getParameter("action_type"));
   XHMasterCodeControllerBean xhBean = null;
    if(action.equals("S")||action.equals("0"))
    {
      session.removeAttribute(strBeanName); 
      xhBean = new XHMasterCodeControllerBean();
      session.setAttribute(strBeanName,xhBean); 
    }
    else
    {
      xhBean = (XHMasterCodeControllerBean) session.getAttribute(strBeanName);
    }
    return(xhBean);
 }
 /**
   * Method action to retrive jsp values 
   * @param  HttpServletRequest request
   * @param  Connection conn
   */

 public void action(HttpServletRequest request,Connection conn)
  {
   try{
	request.setCharacterEncoding("UTF-8");
	}catch(Exception ex){}
	//HttpSession session = request.getSession(false);
	/*Properties p;		
	p = (Properties) session.getValue("jdbc");	
	String locale  = p.getProperty("LOCALE");*/

	String action  = XHDBAdapter.checkNullZero(request.getParameter("action_type"));
    
    if ((action.equals("S"))||(action.equals("0")))
    {
      module = XHDBAdapter.checkNull(request.getParameter("moduleid"));
      mastertableId =  XHDBAdapter.checkNull(request.getParameter("mastertableid"));
      facilityId = XHDBAdapter.checkNull(request.getParameter("facilityid"));
      this.applicationId = XHDBAdapter.checkNull(request.getParameter("applicationid"));
      populateModuleCodes(conn);
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
        end = end - maxRec;
        
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
   * Method to populate the  XHMasterCode Descriptions
   * @param  Connection conn
   */
  public void populateXHCodeDesc(Connection conn)
  {
    String sql = "SELECT  MEDICOM_CODE,CROSSREF_CODE,CROSSREF_DESC FROM  XH_APPL_ELEMENT_TABVAL WHERE MEDICOM_MODULE_ID=? AND APPLICATION_ID=?  AND  MEDICOM_MASTER=? AND  MEDICOM_FACILITY_ID=?";
    PreparedStatement pstmt = null;
    ResultSet rset = null;
    XHMasterCodeElements xhCode = null;
    try
    {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1,this.module);
      pstmt.setString(2,this.applicationId);
      pstmt.setString(3,this.mastertableId);
      pstmt.setString(4,this.facilityId);
	 // System.out.println(" sql is :"+ sql);
      rset = pstmt.executeQuery();

      while(rset.next())
      {
        if (treemp.containsKey(rset.getString(1)))
        {
          xhCode = (XHMasterCodeElements)treemp.get(rset.getString(1));
          xhCode.setXHPresent();
          xhCode.setExternalCode(XHDBAdapter.checkNull(rset.getString(2)));
          xhCode.setExternalDesc(XHDBAdapter.checkNull(rset.getString(3)));
        }
      }
	  if(rset!=null) rset.close();
	  if(pstmt!=null) pstmt.close();
      
    }
    catch(Exception exp)
    {
       System.out.println("Error in populatexhcodedesc method of xhmastercodecontrollerbean :"+exp.toString());
	   exp.printStackTrace(System.err);
      
    }
  }
  /**
   * Method to populate the  XHMasterCode Module codes
   * @param  Connection conn
  */
  public void populateModuleCodes(Connection conn)
  {
        ARRAY arrayData = null;
        Object totalCollection[] = new Object[0];
        Object eachColumnData[] = new Object[0];
        STRUCT eachRowSTRUCT = null;
        CallableStatement ostmt = null;
        try
        {
          ostmt = conn.prepareCall(packageName); 
          ostmt.setString(1,this.module);
          ostmt.setString(2,this.mastertableId);
          ostmt.setString(3,this.facilityId);
          ostmt.registerOutParameter(4,oracle.jdbc.OracleTypes.ARRAY,"IBAEHIS.XH_MASTER_CODE_ARR_TP"); 
		//  ostmt.registerOutParameter(4,oracle.jdbc.OracleTypes.ARRAY); 
          ostmt.execute();
          arrayData = (ARRAY)ostmt.getArray(4);
          totalCollection = (Object[])arrayData.getArray();
          for (int i=0;i<totalCollection.length;i++)
          {
            eachRowSTRUCT = (STRUCT) totalCollection[i];
			if(eachRowSTRUCT!=null)
            eachColumnData = eachRowSTRUCT.getAttributes();
            treemp.put(eachColumnData[0]+"",new XHMasterCodeElements(eachColumnData[0]+"",eachColumnData[1]+""));
          }
           if(ostmt!=null) ostmt.close();
        }
        catch(Exception exp)
        {
          System.out.println("Error in pupoulatemodulecodes method of xhmastercodecontrollerbean :"+exp.toString());
	      exp.printStackTrace(System.err);
		  
        }
        populateXHCodeDesc(conn);
        totalData = treemp.size();
  }
}//end of class
