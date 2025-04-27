/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXB; 
import java.sql.Connection;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import eXB.*;

/**
 *  This bean will be called when the listed order catalogs are selected.This class is 
 *  used to manipulate the query
 *
 */
public class XBQueryRender
{ 

  public static String qryContxt = "QRY_CNTXT";
  public static String strQueryId = "QRY_ID";
  public static String col = "noc";
  public static String maxRec = "maxRec";
  public static String  whereClause="whereClause";
  public static String vwEvntsQuery = "VWEVNTS_QRY";
  
/**
 * This method is used to get Query results 
 * @param  HttpServletRequest request
 * @param  HttpSession session
 * @param  Connection connection
 */
public static HashMap getResults(HttpServletRequest request,HttpSession session,Connection connection)
{
   
  XBQueryRender render = new XBQueryRender();
  XBDatabaseQuery dbQuery = new XBDatabaseQuery();

  String strActionType = XBDBAdapter.checkNull((String)request.getParameter("action_type"));

  System.out.println("XBQueryRender strActionType : "+strActionType);

  String qry_id ="";

  qry_id = XBDBAdapter.checkNull((String)request.getAttribute(strQueryId));
 
  System.out.println("XBQueryRender Qry_id : "+qry_id);
  
  if (((XBDBAdapter.checkNullZero(strActionType)).equals("0")) ||
          (XBDBAdapter.checkNullZero(strActionType)).equals("S"))
  {
  try
  {
	session.removeAttribute(qryContxt);
  }
  catch(Exception expRem)
  {
	  System.out.println("Error(1) in getresults method of xbqueryrender :"+expRem.toString()); 
	  expRem.printStackTrace(System.err);
  }
      
  XBQueryContext xbQuery = new XBQueryContextImpl();

  try
  {
      if ((request.getAttribute(maxRec))!= null)
      {
          xbQuery.setMaxRec(Byte.parseByte(""+request.getAttribute(maxRec)));
      }
  }
  catch(Exception ex)
  {
	 System.out.println("Error(2) in getresults method of  xbqueryrender :"+ex.toString()); 
	 ex.printStackTrace(System.err);
  }

	/* code inserted by Neelkamal Pyla
	--------------------------------------------*/
  if(qry_id.equals("MASTERSETUP") || qry_id.equals("EXPORTFILES") || qry_id.equals("VIEW_GENERAL_EVENTS_EBILL") ){ 
	
		String  query	 = "";

		if(qry_id.equals("EXPORTFILES")){
		String  WhrClause =(String)request.getAttribute(whereClause);
		  	  System.out.println("XBQueryRender WhrClause : "+WhrClause);
		query=XBSQLSet.getSQL(qry_id);
		query = query+WhrClause;
		  	  System.out.println("XBQueryRender query : "+query);
		}
		else 	if(qry_id.equals("VIEW_GENERAL_EVENTS_EBILL") ) {
			String vwevnts_qry = XBDBAdapter.checkNull((String)request.getAttribute(vwEvntsQuery));
				System.out.println("Vwquery : "+vwevnts_qry);
			query = vwevnts_qry;
		}
		else {
			query	 =	XBSQLSet.getSQL(qry_id);
		}
	   	  System.out.println("XBQueryRender qry_id 85: "+qry_id);
	  	  System.out.println("XBQueryRender query 86 : "+query);

	   xbQuery.setOriginalQuery(query);
	   xbQuery.setNoOfColumns(Byte.parseByte(""+request.getAttribute(col)));
       session.setAttribute(qryContxt,xbQuery);
  }

  	/* End of the code inserted by Neelkamal Pyla
	--------------------------------------------*/

 }
 
 render.manipulate(request,session); 
 try{
        return(dbQuery.getResults(request,session,connection));
    }catch(Exception exp){
                           System.out.println("Error(3) in getresults method of xbqueryrender :"+exp.toString()); 
		                   exp.printStackTrace(System.err);
                         }
        return null;        
}  // end of getResults

public static HashMap getResults(HttpServletRequest request,HttpSession session,Connection connection,String QueryOption)
{

	XBQueryRender render = new XBQueryRender();
	XBDatabaseQuery dbQuery = new XBDatabaseQuery();

	String strActionType = request.getParameter("action_type");


	System.out.println("XBQueryRender strActionType : "+strActionType);
	System.out.println("QueryOption"+QueryOption);
	String qry_id ="";

	qry_id = (String)request.getAttribute(strQueryId);

	System.out.println("XBQueryRender Qry_id : "+qry_id);

	if (((XBDBAdapter.checkNullZero(strActionType)).equals("0")) ||
	(XBDBAdapter.checkNullZero(strActionType)).equals("S"))
	{
	try
	{
		session.removeAttribute(qryContxt);
	}
	catch(Exception expRem)
	{
		System.out.println("Error(1) in getresults method of xbqueryrender :"+expRem.toString()); 
		expRem.printStackTrace(System.err);
	}


	XBQueryContext xbQuery = new XBQueryContextImpl();
	try
	{
		if ((request.getAttribute(maxRec))!= null)
		{
			xbQuery.setMaxRec(Byte.parseByte(""+request.getAttribute(maxRec)));
		}
	}catch(Exception ex)
	{
		System.out.println("Error(2) in getresults method of  xbqueryrender :"+ex.toString()); 
		ex.printStackTrace(System.err); 
	}
	if(qry_id.equals("DATAGROUPDETAILS")||qry_id.equals("APIBASEDINBOUND")||qry_id.equals("QUERYBASEDINBOUND")||qry_id.equals("MASTERSETUP"))
	{
	//		  System.out.println("XBQueryRender qryid DATAGROUPDETAILS APIBASEDINBOUND ");
		String  dataGroupWhereClause =(String)request.getAttribute(whereClause);
		  	  System.out.println("XBQueryRender dataGroupWhereClause : "+dataGroupWhereClause);
		String  querydataGroupDetail=XBSQLSet.getSQL(qry_id);
		querydataGroupDetail = querydataGroupDetail+dataGroupWhereClause;
	//	  	  System.out.println("XBQueryRender querydataGroupDetail : "+querydataGroupDetail);
		xbQuery.setOriginalQuery(querydataGroupDetail);
		xbQuery.setNoOfColumns(Byte.parseByte(""+request.getAttribute(col)));
		session.setAttribute(qryContxt,xbQuery);
	}
	
	}

	render.manipulate(request,session); 
	try{
	return(dbQuery.getResults(request,session,connection));
	}catch(Exception exp){
	System.out.println("Error(3) in getresults method of xbqueryrender :"+exp.toString()); 
	exp.printStackTrace(System.err);
	}
	return null;        
} // end of getResults



/**
 * This method is used to replace the SQL Query with the actual search text.
 * @param  StringBuffer strBuffer
 * @param  String strOriginal
 * @param  String strReplaced
 */

private void replace(StringBuffer strBuffer,String strOriginal,String strReplaced)
{
   while(true)
   {
      int index = strBuffer.indexOf(strOriginal);
      if (index >= 0)
      {
        strBuffer.replace(index,index+strOriginal.length(),strReplaced);
      }
      else
       break;
   }
}

/**
 * This method is used to manipulate the SQL Query with the actual search text.
 * HashMap contains the query context and the JSP requested parameters
 * @param  HttpServletRequest request
 * @param  HttpSession session
 *
 */
public void manipulate(HttpServletRequest request,HttpSession session)
{

 String action_type = XBDBAdapter.checkNullZero(request.getParameter("action_type")+"");
 if (action_type.equals("0"))
 {
    action_type = "S";
 }
 
 XBQueryContext qryContext = (XBQueryContext)session.getAttribute(qryContxt);
 //String strSQL = qryContext.getSQLSearch();
 String strSQLOriginal = qryContext.getOriginalQuery();
 StringBuffer strBuff = new StringBuffer(strSQLOriginal);
 
 int intStart = qryContext.getPreviousSet();
 int intEnd = qryContext.getNextSet();
 int max_records = qryContext.getMaxRecord();
 
 String strParam = "";
 String strParamValue = "0";
 
 //HashMap hashmpQueryCritera = qryContext.getQueryCriteria();
 Enumeration enum1 = request.getAttributeNames();
 
 String strAttributeName = "";
 
 if (action_type.equalsIgnoreCase("S"))
 {
	intStart = 0;
	intEnd = max_records;	
    while(enum1.hasMoreElements())
	{
        try{
             strAttributeName = ""+enum1.nextElement();
             replace(strBuff,"#"+strAttributeName,""+request.getAttribute(""+strAttributeName));   
           }catch(Exception exp){
                                  System.out.println("Error in manipulate method of xbqueryrender :"+exp.toString()); 
                       		      exp.printStackTrace(System.err);
                                }
	}  
      
	enum1 = request.getParameterNames();
	while ( enum1.hasMoreElements())
	{
		//Danger strParamValue = LabDBAdapter.checkNull(request.getParameter(strParam[j]));
        strParam = enum1.nextElement()+"";
       //inserted by srinivasa.N	  
  
        strParamValue = XBDBAdapter.checkNull(request.getParameter(strParam).trim());
        if (strParam.equalsIgnoreCase("orderbycolumns"))
        {
            if (strParamValue.equals(""))
            {
              strParamValue = "1";
            }
        }
        if (strParam.equalsIgnoreCase("sortMode"))
        {
           if (strParamValue.equals(""))
           {
              strParamValue = "";
            }
			if (strParamValue.equals("A"))
            {
              strParamValue = "asc";
            }
			if (strParamValue.equals("D"))
            {
              strParamValue = "desc";
            }
          }

          replace(strBuff,"#"+strParam,strParamValue);   
		  if (strParam.equalsIgnoreCase("search_criteria"))
		  {
		 	 if (strParamValue.equalsIgnoreCase("S"))
			 {
              replace(strBuff,"&first","");   
              replace(strBuff,"&last","%");   
			 }
			 else if (strParamValue.equalsIgnoreCase("E"))
			 {
              replace(strBuff,"&first","%");
              replace(strBuff,"&last","");
			 }
			 else if (strParamValue.equalsIgnoreCase("C"))
			 {
              replace(strBuff,"&first","%");
              replace(strBuff,"&last","%");
             }
		  }
        }
		
        qryContext.setSQLSeach(strBuff.toString());
        qryContext.setPreviousSet(intStart);
        qryContext.setNextSet(intEnd);
		}
		else if (action_type.equalsIgnoreCase("N"))
		{
			intStart = intStart+max_records;
			intEnd = intEnd+max_records;
			qryContext.setNextSet(intEnd);
			qryContext.setPreviousSet(intStart);
		}
		else if (action_type.equalsIgnoreCase("P"))
		{
			intStart = intStart-max_records;
			intEnd = intEnd-max_records;
			if (intStart<=0)
			{
				intStart = 0;
				intEnd = max_records;
			}
		qryContext.setNextSet(intEnd);
		qryContext.setPreviousSet(intStart);
     }
	
	}
	
}//end of class 
