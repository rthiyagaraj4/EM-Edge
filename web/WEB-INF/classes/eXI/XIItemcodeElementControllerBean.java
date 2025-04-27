/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXI;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.*;
import javax.servlet.http.HttpSession;
/**
 * Bean Class used to represent the XH Application Elements Bean
 *
 */
  
public class XIItemcodeElementControllerBean implements java.io.Serializable
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
public static  String Segment_id="";
  public static  String standard_code="";
public static  String item_code="";
public static  String search_criteria="";

/** 
   * Method  to accesss the data which returns string array
   */  public String[][] getDatabaseData()
  {
    String str[][] = null; 
    String key = "";
    Iterator iterator = null;
    XIItemcodeElementBean xhBean = null;
    String strItm[] = new String[13];
    String strNeeded[][] = null;
    try
    {
        str = new String[treemp.size()][13];
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
          strNeeded = new String[j][14];
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
   * Method  getCodeDesc return bean element XIItemcodeElementBean  depending ob the key 
   * @param  String key
   * @return returns object type  XIItemcodeElementBean
   */   
  public XIItemcodeElementBean getCodeDesc(String key)
  {
    return((XIItemcodeElementBean)treemp.get(key));
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
	  Iterator iterator = enumerate();
    String strKey = "",gen_uom_code = "",sale_uom_code="",completed_yn="";
    XIItemcodeElementBean xhCode = null;
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
   
      gen_uom_code= XIDBAdapter.checkNull(request.getParameter(strKey+"_genuomcode")); 
	  sale_uom_code=XIDBAdapter.checkNull(request.getParameter(strKey+"_saleuomcode"));
      completed_yn = XIDBAdapter.checkNullForCheckBox(request.getParameter(strKey+"_check"));



 

   xhCode = getCodeDesc(strKey);
 


xhCode.setSaleUomCode(sale_uom_code);
xhCode.setGenUomCode(gen_uom_code);

xhCode.setCompletedYN(completed_yn);
      xhCode.setChanged();
   
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
   XIItemcodeElementBean xhCode = null;
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
   arrRow.clear();
   return(hashmp);
 }
/**
   * Method to get single bean element 
   * @param  String strBeanName
   * @param  HttpServletRequest request
   * @param  HttpSession session
   */

 public static XIItemcodeElementControllerBean getBean(String strBeanName,
														  HttpServletRequest request,
														  HttpSession session)
 {
     String action  = XIDBAdapter.checkNullZero(request.getParameter("action_type"));

//	 System.out.println("action :"+action);
     XIItemcodeElementControllerBean xhBean = null;
     if(action.equals("S")||action.equals("0"))
     {
      
      session.removeAttribute(strBeanName); 
      xhBean = new XIItemcodeElementControllerBean();
      session.setAttribute(strBeanName,xhBean); 
    }
    else
    {
      xhBean = (XIItemcodeElementControllerBean) session.getAttribute(strBeanName);
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
    String action  = XIDBAdapter.checkNullZero(request.getParameter("action_type"));
    item_code=XIDBAdapter.checkNull((String)request.getAttribute("item_code"));
    search_criteria=XIDBAdapter.checkNull((String)request.getAttribute("search_criteria"));
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
   * Method to populate the  XIItemcodeElementBean Bean 
   * @param  Connection conn
   * @param  HttpServletRequest request
   * @param  String locale
  */
  public void populateXHCodeDesc(Connection conn,String locale)
  {
		  String wherecaluse="";
		  if(search_criteria.equals("S"))
		  {
		   wherecaluse= " where COMPLETED_YN='N' and ITEM_CODE LIKE UPPER('"+item_code+"%') ";
		  }
		  else if(search_criteria.equals("E"))
		  {
			   wherecaluse= " where COMPLETED_YN='N' and ITEM_CODE LIKE UPPER('%"+item_code+"') ";
		  }
		  else if(search_criteria.equals("C"))
		  {
				wherecaluse= " where COMPLETED_YN='N' and ITEM_CODE LIKE UPPER('%"+item_code+"%') ";
		  }
		  else
		  {
			 wherecaluse= " where COMPLETED_YN='N' and ITEM_CODE LIKE UPPER('"+item_code+"%') ";
		  }
		String sql="SELECT ITEM_CODE, LONG_DESC, XI_UOM_CODE, ITEM_CLASS_CODE, MATERIAL_GROUP_CODE, GEN_UOM_CODE, QTY_ON_ORDER, SALE_UOM_CODE, COMPLETED_YN,APPLICATION_ID, FACILITY_ID, EVENT_TYPE, TRX_NO,TO_CHAR(TRX_DATE,'DD/MM/YYYY HH24:MI:SS') , LOAD_STATUS, COMM_STATUS from XI_ITEM"+wherecaluse;    
	//	System.out.println("XIItemcodeElementcontrollerbean sql :"+sql);
		
		PreparedStatement pstmt = null; 
		ResultSet rset = null; 
		 try  
		{
		  pstmt = conn.prepareStatement(sql);
			 rset = pstmt.executeQuery();
		  while(rset.next())
		  {
			treemp.put(rset.getString(1),new XIItemcodeElementBean(XIDBAdapter.checkNull(rset.getString(1)),XIDBAdapter.checkNull(rset.getString(2)),XIDBAdapter.checkNull(rset.getString(3)),XIDBAdapter.checkNull(rset.getString(4)),XIDBAdapter.checkNull(rset.getString(5)),XIDBAdapter.checkNull(rset.getString(6)),XIDBAdapter.checkNull(rset.getString(7)),XIDBAdapter.checkNull(rset.getString(8)),XIDBAdapter.checkNull(rset.getString(9)),XIDBAdapter.checkNull(rset.getString(10)),XIDBAdapter.checkNull(rset.getString(11)),XIDBAdapter.checkNull(rset.getString(12)),XIDBAdapter.checkNull(rset.getString(13)),XIDBAdapter.checkNull(rset.getString(14)),XIDBAdapter.checkNull(rset.getString(15)),XIDBAdapter.checkNull(rset.getString(16)))) ;
		  }
		  this.totalData = treemp.size();
		  if(rset!=null) rset.close();
		  if(pstmt!=null) pstmt.close();
		}
		catch(Exception exp) 
		{
		   System.out.println("Error in populatexhcodedesc method of XIItemcodeElementcontrollerbean :"+exp.toString());
		   exp.printStackTrace(System.err);
		}
  }
  
  
}//end of class
