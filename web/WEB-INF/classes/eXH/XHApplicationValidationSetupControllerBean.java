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
/**
 * Bean Class used to represent the XH Application Elements Bean
 *
 */

public class XHApplicationValidationSetupControllerBean implements java.io.Serializable
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
public String appliction_value="";
 public static String  whereClause="whereClause";
public static String strQueryId = "QRY_ID";



/**
   * Method  to accesss the data which returns string array
   */  public String[][] getDatabaseData()
  {
	  
    String str[][] = null;
    String key = "";
    Iterator iterator = null;
    XHApplicationValidationElementsBean xhBean = null;
    String strItm[] = new String[9];
    String strNeeded[][] = null; 
    try
    {
	//	System.out.println("--- getDateBase Data");
        str = new String[treemp.size()][10];
        iterator = this.enumerate();
        int j=0;


        while(iterator.hasNext())
        {
	
          key = iterator.next()+"";
  //           System.out.println("strItm50"+key);
          xhBean = this.getCodeDesc(key);
		
        if (!(xhBean.isChanged()))
          {
            continue;
          }
	//	
		   System.out.println("strItm59");
          strItm = xhBean.getDatabaseData();

	//	  System.out.println("strItm"+strItm);
          strItm[0] = this.application_id;
          str[j] =strItm;
 //`System.out.println("str"+str[j]);
          j++;
          
        }
          strNeeded = new String[j][11];
          System.arraycopy(str,0,strNeeded,0,j);
    }
    catch(Exception exp)
    {
       System.out.println("Error in getdatabasedata method of xhapplicationcontrollerbean :"+exp.toString());
	   exp.printStackTrace(System.err);
    }
//System.out.println("strNeeded"+strNeeded);

    return(strNeeded);
  }
/**
   * Method  getCodeDesc return bean element XHApplicationElementsBean  depending ob the key 
   * @param  String key
   * @return returns object type  XHApplicationElementsBean
   */   
  public XHApplicationValidationElementsBean getCodeDesc(String key)
  {
//	   System.out.println("treemp.get(key)"+treemp.get(key));
    return((XHApplicationValidationElementsBean)treemp.get(key));
  }
/**
   * Method to enumerate the keys 
   */
  public Iterator enumerate()
  {
    Set set = treemp.keySet();
    Iterator iterator = set.iterator();
//	System.out.println("line100-->"+set.size());
    return iterator;
  }
/**
   * Method defined to get all the parameter values 
   * @param  HttpServletRequest request
   * @param  Connection conn
   */
  public void getAllParameterValues(HttpServletRequest request,Connection conn)
  {
//	  System.out.println("---- getAllparamaeteres --- XDF");
    Iterator iterator = enumerate();
    String strKey = "",strFormat = "",strExceorder="",strActvalue="",strErrvalue="",strCondi="",strPosi="";
    XHApplicationValidationElementsBean xhCode = null;
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
    //  strInUse = XHDBAdapter.checkNullForCheckBox(request.getParameter(strKey+"_check"));
      strFormat= XHDBAdapter.checkNull(request.getParameter(strKey+"C"));
    strExceorder=XHDBAdapter.checkNull(request.getParameter(strKey+"EO"));
strCondi=XHDBAdapter.checkNull(request.getParameter(strKey+"CE"));
strErrvalue=XHDBAdapter.checkNull(request.getParameter(strKey+"ER"));
 strActvalue=XHDBAdapter.checkNull(request.getParameter(strKey+"EA"));
 xhCode = getCodeDesc(strKey);
//	 System.out.println("strKey142"+strKey);

	

	  xhCode.setActionValue(strActvalue);
//	  System.out.println("strActvalue154"+strActvalue);
	  xhCode.setCondition(strCondi);
    xhCode.setErrorText(strErrvalue);
//		 System.out.println("strerrvalue2157"+strErrvalue);
  
// System.out.println("strCondi161"+strCondi);
      xhCode.setChanged();
	
      xhCode.setFormatType(strFormat);
      //xhCode.setElementValue(strElementValue);
// System.out.println("strFormat"+strFormat);


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
   XHApplicationValidationElementsBean xhCode = null;
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
	//	 System.out.println("key : "+key);
      }
      else
      {
        break;
      }
     xhCode = getCodeDesc(key);
//	 	 System.out.println("xhCode : "+xhCode);
//	 System.out.println("xhCode Arr Data: "+xhCode.getArrayData());
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

 public static XHApplicationValidationSetupControllerBean getBean(String strBeanName,
														  HttpServletRequest request,
														  HttpSession session)
 {
     String action  = XHDBAdapter.checkNullZero(request.getParameter("action_type"));
//	 System.out.println("getBean action178"+action);
//	 System.out.println("getBean action179"+strBeanName);
     XHApplicationValidationSetupControllerBean xhBean = null;
     if(action.equals("S")||action.equals("0"))
     {
//		System.out.println("--- getBean action S O1245---");
      session.removeAttribute(strBeanName); 
  xhBean = new XHApplicationValidationSetupControllerBean();
      session.setAttribute(strBeanName,xhBean); 
    }
    else
    {
      xhBean = (XHApplicationValidationSetupControllerBean) session.getAttribute(strBeanName);
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
//    System.out.println("action253"+action);
    if ((action.equals("S"))||(action.equals("0")))
    {
//		System.out.println("--- Action -- S O ");

      this.application_id =  request.getParameter("applicationid");

      this.populateXHCodeDesc(request,conn,locale);
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
   * Method to populate the  XHApplicationElementsBean Bean 
   * @param  Connection conn
   * @param  HttpServletRequest request
   * @param  String locale
  */
  public void populateXHCodeDesc(HttpServletRequest request,Connection conn,String locale)
  {
  
  //  String sql="select B.ELEMENT_ID,B.ELEMENT_NAME,A.DERIVATION_TYPE,B.IN_USE_YN,A.CONDITION_EXP1_VAL,A.EXPECTED_VALUE,A.EXECUTION_ORDER " +
				//"from xh_appl_derivation_rules A, xh_element_crossref B where A.ELEMENT_ID=B.ELEMENT_ID and B.IN_USE_YN='Y'" +
				///"union " +
			//	"select ELEMENT_ID,ELEMENT_NAME,NULL,IN_USE_YN,NULL,NULL,NULL from xh_element_crossref where ELEMENT_ID not in (select ELEMENT_ID from xh_appl_derivation_rules)"; 

//appliction_value=request.getParameter("application_id");
String  viewqueryWhereClause =(String)request.getAttribute(whereClause);
String qry_id ="";
	qry_id = (String)request.getAttribute(strQueryId);
//	System.out.println("qry_id334"+qry_id);
String query=XHSQLSet.getSQL(qry_id)+viewqueryWhereClause;

//System.out.println("query337"+query);
PreparedStatement pstmt = null;
    ResultSet rset = null;
    try
    { 
      pstmt = conn.prepareStatement(query);
      
      rset = pstmt.executeQuery();
      while(rset.next())
      {
	//	  System.out.println("RS.Next() "+rset.getString(1));
        treemp.put(rset.getString(1)+rset.getString(3),new XHApplicationValidationElementsBean(
											XHDBAdapter.checkNull(rset.getString(1)),
											XHDBAdapter.checkNull(rset.getString(2)),
											XHDBAdapter.checkNull(rset.getString(3)),
                                            XHDBAdapter.checkNull(rset.getString(4)),
											XHDBAdapter.checkNull(rset.getString(5)),
                                            XHDBAdapter.checkNull(rset.getString(6)),
											XHDBAdapter.checkNull(rset.getString(7)),
			                                XHDBAdapter.checkNull(rset.getString(8)),
			                                XHDBAdapter.checkNull(rset.getString(9)),  XHDBAdapter.checkNull(rset.getString(10)))) ;
      }
      this.totalData = treemp.size();
//System.out.println("this.totalData"+this.totalData);

	  if(rset!=null) rset.close();
      if(pstmt!=null) pstmt.close();
    }
    catch(Exception exp)
    {
       System.out.println("Error in populatexhcodedesc method of XHApplicationValidationSetupControllerBean.java :"+exp.toString());
	   exp.printStackTrace(System.err);
    }
  }
  
  
}//end of class
