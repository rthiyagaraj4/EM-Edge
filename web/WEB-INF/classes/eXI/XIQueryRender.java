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
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import eXI.*;

/**
 *  This bean will be called when the listed order catalogs are selected.This class is 
 *  used to manipulate the query
 *
 */
public class XIQueryRender
{ 

  public static String qryContxt = "QRY_CNTXT";
  public static String strQueryId = "QRY_ID";
  public static String col = "noc";
  public static String maxRec = "maxRec";
  public static String  whereClause="whereClause";
  
/**
 * This method is used to get Query results 
 * @param  HttpServletRequest request
 * @param  HttpSession session
 * @param  Connection connection
 */
public static HashMap getResults(HttpServletRequest request,HttpSession session,Connection connection)
{
   
  XIQueryRender render = new XIQueryRender();
  XIDatabaseQuery dbQuery = new XIDatabaseQuery();

  String strActionType = XIDBAdapter.checkNull((String)request.getParameter("action_type"));  

  String qry_id ="";

  qry_id = XIDBAdapter.checkNull((String)request.getAttribute(strQueryId));  
  
  if (((XIDBAdapter.checkNullZero(strActionType)).equals("0")) ||
          (XIDBAdapter.checkNullZero(strActionType)).equals("S"))
  {
  try
  {
	session.removeAttribute(qryContxt);
  }
  catch(Exception expRem)
  {	  
	  expRem.printStackTrace(System.err);
  }
      
  XIQueryContext xiQuery = new XIQueryContextImpl();

  try
  {
      if ((request.getAttribute(maxRec))!= null)
      {
          xiQuery.setMaxRec(Byte.parseByte(""+request.getAttribute(maxRec)));
      }
  }
  catch(Exception ex)
  {	 
	 ex.printStackTrace(System.err);
  }

	/* code inserted by Neelkamal Pyla
	--------------------------------------------*/

  /* 
  qry_id.equals("TRANSACTIONSTATUS")||qry_id.equals("TRANSACTIONSTATUSREQ")||qry_id.equals("TRANSACTIONSTATUSREC")||qry_id.equals("TRANSACTIONSTATUSRET")||qry_id.equals("TRANSACTIONREQUISITION")||qry_id.equals("TRANSACTIONGOODSRECEIPTS")||qry_id.equals("TRANSACTIONGRNRETURNS")||
  */
  if(qry_id.equals("ITEMSTATUS")||qry_id.equals("ORGWSITEMSTATUS")||qry_id.equals("GOODSRETURNS")||qry_id.equals("NEWARRAIVALITEM")||qry_id.equals("REQHDR")||qry_id.equals("RECWRH")||qry_id.equals("RECWORH")||qry_id.equals("RETWGRNH")||qry_id.equals("RETWOGRNH")||qry_id.equals("REQDTL")||qry_id.equals("RECWRD")||qry_id.equals("RECWORD")||qry_id.equals("RETWGRND")||qry_id.equals("RETWOGRND")){ 
	   String  WhrClause =(	String)request.getAttribute(whereClause);
	   String  query	 =	XISQLSet.getSQL(qry_id);
			   query = query+WhrClause; 	   	  
	   xiQuery.setOriginalQuery(query);
	   xiQuery.setNoOfColumns(Byte.parseByte(""+request.getAttribute(col)));
       session.setAttribute(qryContxt,xiQuery);
  }

  	/* End of the code inserted by Neelkamal Pyla
	--------------------------------------------*/

 }
 
 render.manipulate(request,session); 
 try{
        return(dbQuery.getResults(request,session,connection));
    }catch(Exception exp){                           
		                   exp.printStackTrace(System.err);
                         }
        return null;        
}  // end of getResults

public static HashMap getResults(HttpServletRequest request,HttpSession session,Connection connection,String QueryOption)
{

	XIQueryRender render = new XIQueryRender();
	XIDatabaseQuery dbQuery = new XIDatabaseQuery();

	String strActionType = request.getParameter("action_type");	
	String qry_id ="";

	qry_id = (String)request.getAttribute(strQueryId);	

	if (((XIDBAdapter.checkNullZero(strActionType)).equals("0")) ||
	(XIDBAdapter.checkNullZero(strActionType)).equals("S"))
	{
	try
	{
		session.removeAttribute(qryContxt);
	}
	catch(Exception expRem)
	{		
		expRem.printStackTrace(System.err);
	}


	XIQueryContext xiQuery = new XIQueryContextImpl();
	try
	{
		if ((request.getAttribute(maxRec))!= null)
		{
			xiQuery.setMaxRec(Byte.parseByte(""+request.getAttribute(maxRec)));
		}
	}catch(Exception ex)
	{		
		ex.printStackTrace(System.err); 
	}
	if(qry_id.equals("DATAGROUPDETAILS")||qry_id.equals("APIBASEDINBOUND")||qry_id.equals("QUERYBASEDINBOUND"))
	{
	//		  System.out.println("XIQueryRender qryid DATAGROUPDETAILS APIBASEDINBOUND ");
		String  dataGroupWhereClause =(String)request.getAttribute(whereClause);		  	  
		String  querydataGroupDetail=XISQLSet.getSQL(qry_id);
		querydataGroupDetail = querydataGroupDetail+dataGroupWhereClause;
	//	  	  System.out.println("XIQueryRender querydataGroupDetail : "+querydataGroupDetail);
		xiQuery.setOriginalQuery(querydataGroupDetail);
		xiQuery.setNoOfColumns(Byte.parseByte(""+request.getAttribute(col)));
		session.setAttribute(qryContxt,xiQuery);
	}
	else
	{	  
	int index = qry_id.indexOf("_");
	if(index != -1)
	{
		String module = qry_id.substring(0,qry_id.indexOf("_"));
		String moduleName = qry_id.substring(qry_id.indexOf("_")+1);
		String purgeStatus = (String)request.getAttribute("purge_status");
		if(purgeStatus != null)
		{
			purgeStatus = "_PURGE";
		}
		else
		{
			purgeStatus = "";
		}		
		if((module != null) && (module.equalsIgnoreCase("OUTBOUND")))
		{								
			String  viewEventsOutboundWhereClause = (String)request.getAttribute(whereClause);
			String  queryViewEventsOutbound = XISQLSet.getSQL("VIEW_GENERAL_EVENTS");
			if(purgeStatus.equals(""))
			{
				queryViewEventsOutbound = queryViewEventsOutbound + " " + moduleName + purgeStatus + "_EVENT_APPL_MESSAGE_VW ";
			}
			else
			{
				queryViewEventsOutbound = queryViewEventsOutbound + " " + moduleName + purgeStatus + "_APPL_MESSAGE_VW ";
			}

			queryViewEventsOutbound = queryViewEventsOutbound + viewEventsOutboundWhereClause;			
			xiQuery.setOriginalQuery(queryViewEventsOutbound);
			xiQuery.setNoOfColumns(Byte.parseByte(""+request.getAttribute(col)));
			session.setAttribute(qryContxt,xiQuery);	
		}
		else if((module != null) && (module.equalsIgnoreCase("INBOUND")))
		{								
			String  viewEventsInboundWhereClause = (String)request.getAttribute(whereClause);
			String  queryViewEventsInbound = XISQLSet.getSQL("VIEW_INBOUND_EVENTS");
			queryViewEventsInbound = queryViewEventsInbound + " " + moduleName + purgeStatus + "_INBOUND_MESSAGE X ";
			queryViewEventsInbound = queryViewEventsInbound + viewEventsInboundWhereClause;
			
			xiQuery.setOriginalQuery(queryViewEventsInbound);
			xiQuery.setNoOfColumns(Byte.parseByte(""+request.getAttribute(col)));
			session.setAttribute(qryContxt,xiQuery);	
		}
		else
		{
			xiQuery.setOriginalQuery(XISQLSet.getSQL(qry_id));
			//System.out.println(" XISQLSet.getSQL(qry_id) :"+XISQLSet.getSQL(qry_id));
			xiQuery.setNoOfColumns(Byte.parseByte(""+request.getAttribute(col)));
			session.setAttribute(qryContxt,xiQuery);
		}
	}
	else
	{

	if(QueryOption.equals("P"))
	{
		qry_id="VIEWQUERY";
		//xiQuery.setOriginalQuery(XISQLSet.getSQL(qry_id));
		//System.out.println(" XISQLSet.getSQL(qry_id) :"+XISQLSet.getSQL(qry_id));
		//xiQuery.setNoOfColumns(Byte.parseByte(""+request.getAttribute(col)));
		//session.setAttribute(qryContxt,xiQuery);
	}
	else if(QueryOption.equals("A"))
	{
		qry_id="VIEWQUERY1";
	}
	xiQuery.setOriginalQuery(XISQLSet.getSQL(qry_id));
	//System.out.println(" XISQLSet.getSQL(qry_id) :"+XISQLSet.getSQL(qry_id));
	xiQuery.setNoOfColumns(Byte.parseByte(""+request.getAttribute(col)));
	session.setAttribute(qryContxt,xiQuery);

	}
	}
	}

	render.manipulate(request,session); 
	try{
	return(dbQuery.getResults(request,session,connection));
	}catch(Exception exp){	
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

 String action_type = XIDBAdapter.checkNullZero(request.getParameter("action_type")+"");
 if (action_type.equals("0"))
 {
    action_type = "S";
 }
 
 XIQueryContext qryContext = (XIQueryContext)session.getAttribute(qryContxt);
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
                       		      exp.printStackTrace(System.err);
                                }
	}  
      
	enum1 = request.getParameterNames();
	while ( enum1.hasMoreElements())
	{
		//Danger strParamValue = LabDBAdapter.checkNull(request.getParameter(strParam[j]));
        strParam = enum1.nextElement()+"";
       //inserted by srinivasa.N	  
  
        strParamValue = XIDBAdapter.checkNull(request.getParameter(strParam).trim());
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
