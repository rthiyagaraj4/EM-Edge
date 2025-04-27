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
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import eXH.*;

/**
*  This bean will be called when the listed order catalogs are selected.This class is 
*  used to manipulate the query
*
*/
public class XHQueryRender
{ 
	public static String qstatus="";
	public static String qryContxt = "QRY_CNTXT";  
	public static String strQueryId = "QRY_ID";
	public static String col = "noc";
	public static String maxRec = "maxRec";
	public static String  whereClause="whereClause";
	public static String  sql_query="";
	public static String vwEvntsQuery = "VIEW_GATEWAY_LIST";
	public static String  sqlQuery="";
	public static String  orderByColumns="orderByColumns";

	/**
	 * This method is used to get Query results 
	 * @param  HttpServletRequest request
	 * @param  HttpSession session
	 * @param  Connection connection
	 */
	public static HashMap getResults(HttpServletRequest request,HttpSession session,Connection connection)
	{
		XHQueryRender render	= new XHQueryRender();
		XHDatabaseQuery dbQuery = new XHDatabaseQuery();

		String strActionType = request.getParameter("action_type");
		String qry_id		 = (String)request.getAttribute(strQueryId);
		String [] commonQryIDs = {"XB_TRANS_MNGR","MANAGE_PATIENT_QUEUE"};

		System.out.println("strActionType "+strActionType);
		

		try
		{
			sqlQuery = "";

			if (((XHDBAdapter.checkNullZero(strActionType)).equals("0")) ||
					(XHDBAdapter.checkNullZero(strActionType)).equals("S"))
			{
				try
				{
					session.removeAttribute(qryContxt);
				}
				catch(Exception expRem)
				{				
					expRem.printStackTrace(System.err);
				}

				XHQueryContext xhQuery = new XHQueryContextImpl();

				try
				{
					if ((request.getAttribute(maxRec))!= null)
					{
						xhQuery.setMaxRec(Byte.parseByte(""+request.getAttribute(maxRec)));
					}
				}
				catch(Exception ex)
				{				
					ex.printStackTrace(System.err);
				}

				if(qry_id.equals("VIEW_GENERAL_EVENTS")
						||qry_id.equals("VIEW_INBOUND_EVENTS") 
						|| qry_id.equals("VIEW_TRACE_EVENTS")
						|| qry_id.equals("INVENTORY_MONITORING_SCR"))
				{
					String sqlQuery  = XHSQLSet.getSQL(qry_id);
					String tableName = (String)request.getAttribute("tableName");
					String WhrClause = (String)request.getAttribute(whereClause);
                    
					if(tableName != null && !tableName.equals(""))
					{
						sqlQuery = sqlQuery + tableName + WhrClause;
					}
					else
					{
						sqlQuery = sqlQuery + WhrClause;
					}
					xhQuery.setOriginalQuery(sqlQuery);
					xhQuery.setNoOfColumns(Byte.parseByte("" + request.getAttribute(col)));

					session.setAttribute(qryContxt,xhQuery);					
				} 

				/* code inserted by Neelkamal Pyla
				--------------------------------------------*/

				else if(qry_id.equals("DATAGROUPDETAILS") 
							||qry_id.equals("APIBASEDINBOUND")
							||qry_id.equals("QUERYBASEDINBOUND")
							||qry_id.equals("TABLEBASEDINBOUND")
							||qry_id.equals("COMMPROTFILECTRLSTRUCTURE")
							||qry_id.equals("INTERFACEAPIDETAILS")
							||qry_id.equals("EVENTTYPES")
							||qry_id.equals("MSGFORAPPLEVNTYP")
							||qry_id.equals("MSGFORAPPLEVNTWSGMNT")
							||qry_id.equals("EVENTWISESEGMENTS")
							||qry_id.equals("EVENTTYPSEG")
							||qry_id.equals("VIEWELEMENTSETTING")
							||qry_id.equals("VIEW_GATEWAY_LIST"))
				{
					String query = "";
					if(qry_id.equals("MSGFORAPPLEVNTYP") || qry_id.equals("MSGFORAPPLEVNTWSGMNT"))
					{
						query = (String)request.getAttribute(sql_query);				  
					}
					else
					{
						String WhrClause = (String)request.getAttribute(whereClause);
						query =	XHSQLSet.getSQL(qry_id);
						query = query + WhrClause; 				
					}

					if(qry_id.equals("APIBASEDINBOUND") 
						|| qry_id.equals("QUERYBASEDINBOUND") 
						|| qry_id.equals("TABLEBASEDINBOUND") 
						|| qry_id.equals("DATAGROUPDETAILS"))
					{
						xhQuery.setMaxRec(Byte.parseByte("9"));
					}
					if(qry_id.equals("MSGFORAPPLEVNTWSGMNT"))
					{
						xhQuery.setMaxRec(Byte.parseByte("14"));
					}
					if(qry_id.equals("VIEW_GATEWAY_LIST") ) 
					{
						String vwevnts_qry = XHDBAdapter.checkNull((String)request.getAttribute(vwEvntsQuery));					
						query = vwevnts_qry;			
					}
					xhQuery.setOriginalQuery(query);
					xhQuery.setNoOfColumns(Byte.parseByte(""+request.getAttribute(col)));
					session.setAttribute(qryContxt,xhQuery);
				}
				else if(XHUtil.equalsAny(qry_id,commonQryIDs))
				{	
					String query = (String)request.getAttribute("query");
					xhQuery.setOriginalQuery(query);
					xhQuery.setNoOfColumns(Byte.parseByte(""+request.getAttribute(col)));
					session.setAttribute(qryContxt,xhQuery);						
				}
				else
				{				
					xhQuery.setOriginalQuery(XHSQLSet.getSQL(qry_id));				
					xhQuery.setNoOfColumns(Byte.parseByte(""+request.getAttribute(col)));
					session.setAttribute(qryContxt,xhQuery);
				}

				/* End of the code inserted by Neelkamal Pyla
				--------------------------------------------*/			
			}
			else if(qry_id.equals("VIEW_GENERAL_EVENTS")
						||qry_id.equals("VIEW_INBOUND_EVENTS")
						|| qry_id.equals("VIEW_TRACE_EVENTS"))
			{
				XHQueryContext qryContext = (XHQueryContext) session.getAttribute(XHQueryRender.qryContxt);

				String sqlQuery  = XHSQLSet.getSQL(qry_id);
				String tableName = (String)request.getAttribute("tableName");
				String WhrClause = (String)request.getAttribute(whereClause);

				if(tableName != null && !tableName.equals(""))
				{
					sqlQuery = sqlQuery + tableName + WhrClause;
				}
				else
				{
					sqlQuery = sqlQuery + WhrClause;
				}

				qryContext.setOriginalQuery(sqlQuery);
				qryContext.setNoOfColumns(Byte.parseByte(""+request.getAttribute(col)));

				if ((request.getAttribute(maxRec))!= null)
				{
					qryContext.setMaxRec(Byte.parseByte(""+request.getAttribute(maxRec)));
				}

				session.removeAttribute(qryContxt);
				session.setAttribute(qryContxt,qryContext);						 			 
			}
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);
		}

		render.manipulate(request,session); 
		try
		{
			if(qry_id.equals("INVENTORY_MONITORING_SCR")) 
			{
				return dbQuery.getResultWithColNames(request,session,connection);
			}
			else
			{
				return dbQuery.getResults(request,session,connection);
			}
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);
		}
		return null;        
	}

	public static HashMap getResults(HttpServletRequest request,HttpSession session,Connection connection,String QueryOption)
	{
		XHQueryRender render = new XHQueryRender();
		XHDatabaseQuery dbQuery = new XHDatabaseQuery();

		String viewWhereClause = "";
		String strActionType = request.getParameter("action_type");
		qstatus = request.getParameter("qstatus");

		String qry_id = "";
		String query = "";
		qry_id = (String)request.getAttribute(strQueryId);

		String viewOrderByColumns = "";

		if (((XHDBAdapter.checkNullZero(strActionType)).equals("0")) 
					||	(XHDBAdapter.checkNullZero(strActionType)).equals("S"))
		{
			try
			{
				session.removeAttribute(qryContxt);
			}
			catch(Exception expRem)
			{				
				expRem.printStackTrace(System.err);
			}

			XHQueryContext xhQuery = new XHQueryContextImpl();

			try
			{
				if ((request.getAttribute(maxRec))!= null)
				{
					xhQuery.setMaxRec(Byte.parseByte(""+request.getAttribute(maxRec)));
				}
			}
			catch(Exception ex)
			{				
				ex.printStackTrace(System.err); 
			}				  
			
		/*	
			qry_id = (String)request.getAttribute(strQueryId);
			if(qry_id.equals("VIEW_EVENTS(OUTBOUND)")||qry_id.equals("VIEW_EVENTS(INBOUND)")||qry_id.equals("VIEW_PURGE_EVENTS(OUTBOUND)")||qry_id.equals("VIEW_XP_EVENTS")||qry_id.equals("VIEWXHINTERACTIVE"))
			{
			String  viewEventsOutboundWhereClause =(String)request.getAttribute(whereClause);
			String  queryViewEventsOutbound=XHSQLSet.getSQL(qry_id);
			queryViewEventsOutbound=queryViewEventsOutbound+viewEventsOutboundWhereClause;
			xhQuery.setOriginalQuery(queryViewEventsOutbound);
			xhQuery.setNoOfColumns(Byte.parseByte(""+request.getAttribute(col)));
			session.setAttribute(qryContxt,xhQuery);
			System.out.println(" queryViewEventsOutbound :"+queryViewEventsOutbound);
			} 
		*/

			if(qry_id.equals("VIEW_GENERAL_EVENTS")||qry_id.equals("VIEW_INBOUND_EVENTS"))
			{
				String sqlQuery = XHSQLSet.getSQL(qry_id);
				String tableName = (String)request.getAttribute("tableName");
				String WhrClause = (String)request.getAttribute(whereClause);

				sqlQuery = sqlQuery+tableName+WhrClause;
				xhQuery.setOriginalQuery(sqlQuery);
				xhQuery.setNoOfColumns(Byte.parseByte(""+request.getAttribute(col)));

				session.setAttribute(qryContxt,xhQuery);
			//	System.out.println("SQL QEURY SET "+xhQuery.getOriginalQuery());
			} 

			else if(qry_id.equals("DATAGROUPDETAILS")||qry_id.equals("APIBASEDINBOUND")||qry_id.equals("QUERYBASEDINBOUND"))
			{
			//	System.out.println("XHQueryRender qryid DATAGROUPDETAILS APIBASEDINBOUND ");
				String dataGroupWhereClause = (String)request.getAttribute(whereClause);
			//	System.out.println("XHQueryRender dataGroupWhereClause : "+dataGroupWhereClause);
				String querydataGroupDetail = XHSQLSet.getSQL(qry_id);
				querydataGroupDetail = querydataGroupDetail+dataGroupWhereClause;
			//	System.out.println("XHQueryRender querydataGroupDetail : "+querydataGroupDetail);
				xhQuery.setOriginalQuery(querydataGroupDetail);
				xhQuery.setNoOfColumns(Byte.parseByte(""+request.getAttribute(col)));
				session.setAttribute(qryContxt,xhQuery);
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
						String viewEventsOutboundWhereClause = (String)request.getAttribute(whereClause);
						String queryViewEventsOutbound = XHSQLSet.getSQL("VIEW_GENERAL_EVENTS");

						if(purgeStatus.equals(""))
						{
							queryViewEventsOutbound = queryViewEventsOutbound + " " + moduleName + purgeStatus + "_EVENT_APPL_MESSAGE_VW ";
						}
						else
						{
							queryViewEventsOutbound = queryViewEventsOutbound + " " + moduleName + purgeStatus + "_APPL_MESSAGE_VW ";
						}

						queryViewEventsOutbound = queryViewEventsOutbound + viewEventsOutboundWhereClause;						

						xhQuery.setOriginalQuery(queryViewEventsOutbound);
						xhQuery.setNoOfColumns(Byte.parseByte(""+request.getAttribute(col)));
						session.setAttribute(qryContxt,xhQuery);	
					}
					else if((module != null) && (module.equalsIgnoreCase("INBOUND")))
					{																	
						String viewEventsInboundWhereClause = (String)request.getAttribute(whereClause);
						String queryViewEventsInbound = XHSQLSet.getSQL("VIEW_INBOUND_EVENTS");
						queryViewEventsInbound = queryViewEventsInbound + " " + moduleName + purgeStatus + "_INBOUND_MESSAGE X ";
						queryViewEventsInbound = queryViewEventsInbound + viewEventsInboundWhereClause;						
						xhQuery.setOriginalQuery(queryViewEventsInbound);
						xhQuery.setNoOfColumns(Byte.parseByte(""+request.getAttribute(col)));
						session.setAttribute(qryContxt,xhQuery);	
					}
					else
					{
						xhQuery.setOriginalQuery(XHSQLSet.getSQL(qry_id));
						//System.out.println(" XHSQLSet.getSQL(qry_id) :"+XHSQLSet.getSQL(qry_id));
						xhQuery.setNoOfColumns(Byte.parseByte(""+request.getAttribute(col)));
						session.setAttribute(qryContxt,xhQuery);
					}
				}
				else
				{
					if(QueryOption.equals("P"))
					{

					/*	
						if(qstatus.equals("*A"))
						{
						qry_id="VIEWQUERY2";

						}
					*/
					//	else
					//	{
						qry_id="VIEWADMINQUERYPROCESS";

					//	}

						//query=XHSQLSet.getSQL(qry_id); 
						String viewQueryProcesswherecaluse = (String)request.getAttribute(whereClause);

//						System.out.println("view Query Process query "+viewQueryProcesswherecaluse);
						query=XHSQLSet.getSQL(qry_id)+(String)request.getAttribute("tableName")+viewQueryProcesswherecaluse;
					}
					else if(QueryOption.equals("A"))
					{
					/*  if(qstatus.equals("*A"))
						{
						qry_id="VIEWQUERY3";

						}
					*/
					//	else
					//	{
						qry_id = "VIEWADMINQUERYINITIATE";
					//	}

						query = XHSQLSet.getSQL(qry_id);
					}
					else
					{

						if(qry_id.equals("VIEWXHAPPLELEMENTNONTABVAL"))
						{
							viewWhereClause = (String)request.getAttribute(whereClause);
							query=XHSQLSet.getSQL(qry_id)+viewWhereClause;
						}
						else if(qry_id.equals("NEWARRAIVALITEM"))
						{
							viewWhereClause=(String)request.getAttribute(whereClause);
							query=XHSQLSet.getSQL(qry_id)+viewWhereClause;
						}
						else if(qry_id.equals("VIEWINTERFACESTANDARD") || qry_id.equals("VIEWINTERFACESTANDARDSCTRL") || qry_id.equals("VIEWXHFILTERANDSCDHULINGLEVEL")||qry_id.equals("VIEWXHAPPLVALIDATIONRULES")||qry_id.equals("VIEWELEMENTSETTING"))
						{
							viewWhereClause=(String)request.getAttribute(whereClause);
							query=XHSQLSet.getSQL(qry_id)+viewWhereClause;
						}
						else if(qry_id.equals("VIEWXHINTERACTIVE"))
						{
						  viewWhereClause=(String)request.getAttribute(whereClause);
						  query=XHSQLSet.getSQL(qry_id)+(String)request.getAttribute("tableNameSuffix")+viewWhereClause;
						}
						else if(qry_id.equals("PAYERELIGIBILITYCHECK"))
						{
						  viewWhereClause=(String)request.getAttribute(whereClause);

						  System.out.println(" ::: viewWhereClause : "+viewWhereClause);
						  
						  query=XHSQLSet.getSQL(qry_id)+viewWhereClause;

						  System.out.println(" ::: query : "+query);
						  
						}
						else if(qry_id.equals("PRINTITEMBARCODE"))
						{
						  System.out.println("print bar code...11");
						  viewWhereClause=(String)request.getAttribute(whereClause);
						  viewOrderByColumns=(String)request.getAttribute(orderByColumns);
						  
						  query=XHSQLSet.getSQL(qry_id)+viewWhereClause+viewOrderByColumns;

						  System.out.println("print bar code...22......."+query);
						}
						else if(qry_id.equals("PREADMISSIONELIGIBILITYCHECK"))
						{
						  //System.out.println("print eligibly check...11");
						  viewWhereClause=(String)request.getAttribute(whereClause);
						  
						  query=XHSQLSet.getSQL(qry_id)+viewWhereClause;

						  //System.out.println("print eligiblity check...22......."+query);
						}
						else if(qry_id.equals("ONADMISSIONELIGIBILITYCHECK"))
						{
						  //System.out.println("print eligibly check...11");
						  viewWhereClause=(String)request.getAttribute(whereClause);
						  
						  query=XHSQLSet.getSQL(qry_id)+viewWhereClause;

						  //System.out.println("print eligiblity check...22......."+query);
						}
						else if(qry_id.equals("MEDICLAIMSCHECK")|| qry_id.equals("ELIGIBILITYCHECKQUERY")|| qry_id.equals("MEDICLAIMSBATCHPROCESS")|| qry_id.equals("MEDICLAIMSERAPROCESS"))
						{
						System.out.println("MEDICLAIMSCHECK...11");
						  viewWhereClause=(String)request.getAttribute(whereClause);
						  
						  query=XHSQLSet.getSQL(qry_id)+viewWhereClause;

						  System.out.println("MEDICLAIMSCHECK...22......."+query);
						}

						else
						{
							query=XHSQLSet.getSQL(qry_id);
						}

					}
					
					sqlQuery = query;

					xhQuery.setOriginalQuery(query);
	
					xhQuery.setNoOfColumns(Byte.parseByte(""+request.getAttribute(col)));
					session.setAttribute(qryContxt,xhQuery);
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
	}

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
	*/
	public void manipulate(HttpServletRequest request,HttpSession session)
	{

		String action_type = XHDBAdapter.checkNullZero(request.getParameter("action_type"));


		if (action_type.equals("0"))
		{
			action_type = "S";
		}

		XHQueryContext qryContext = (XHQueryContext)session.getAttribute(qryContxt);
		String strSQLOriginal = qryContext.getOriginalQuery();
		StringBuffer strBuff = new StringBuffer(strSQLOriginal);

		int intStart = qryContext.getPreviousSet();
		int intEnd = qryContext.getNextSet();
		int max_records = qryContext.getMaxRecord();

	
		String strParam = "";
		String strParamValue = "0";

		Enumeration enum1 = request.getAttributeNames();

		String strAttributeName = "";

		if (action_type.equalsIgnoreCase("S"))
		{
			intStart = 0;
			intEnd = max_records;	
			while(enum1.hasMoreElements())
			{
				try
				{
					strAttributeName = ""+enum1.nextElement();
					replace(strBuff,"#"+strAttributeName,""+request.getAttribute(""+strAttributeName));   
				}
				catch(Exception exp)
				{					
					exp.printStackTrace(System.err);
				}
			}  

			enum1 = request.getParameterNames();
			while ( enum1.hasMoreElements())
			{
				//Danger strParamValue = LabDBAdapter.checkNull(request.getParameter(strParam[j]));
				strParam = enum1.nextElement()+"";
				//inserted by srinivasa.N	  

				strParamValue = XHDBAdapter.checkNull(request.getParameter(strParam).trim());
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
			String qry_id = (String)request.getAttribute(strQueryId);
			
			if(qry_id.equals("VIEW_GENERAL_EVENTS")||qry_id.equals("VIEW_INBOUND_EVENTS") || qry_id.equals("VIEW_TRACE_EVENTS") || qry_id.equals("PAYERELIGIBILITYCHECK1"))
			{
				while(enum1.hasMoreElements())
				{
					try
					{
						strAttributeName = ""+enum1.nextElement();
						replace(strBuff,"#"+strAttributeName,""+request.getAttribute(""+strAttributeName));   
					}
					catch(Exception exp)
					{						
						exp.printStackTrace(System.err);
					}
				}  

				enum1 = request.getParameterNames();
				while ( enum1.hasMoreElements())
				{
					//Danger strParamValue = LabDBAdapter.checkNull(request.getParameter(strParam[j]));
					strParam = enum1.nextElement()+"";
					//inserted by srinivasa.N	  

					strParamValue = XHDBAdapter.checkNull(request.getParameter(strParam).trim());
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
			}

			intStart = intStart+max_records;
			intEnd = intEnd+max_records;
			
			qryContext.setNextSet(intEnd);
			qryContext.setPreviousSet(intStart);
		}
		else if (action_type.equalsIgnoreCase("P"))
		{
			String qry_id = (String)request.getAttribute(strQueryId);
			
			if(qry_id.equals("VIEW_GENERAL_EVENTS")||qry_id.equals("VIEW_INBOUND_EVENTS") || qry_id.equals("VIEW_TRACE_EVENTS") || qry_id.equals("PAYERELIGIBILITYCHECK1"))
			{
				while(enum1.hasMoreElements())
				{
					try
					{
						strAttributeName = ""+enum1.nextElement();
						replace(strBuff,"#"+strAttributeName,""+request.getAttribute(""+strAttributeName));   
					}
					catch(Exception exp)
					{						
						exp.printStackTrace(System.err);
					}
				}  

				enum1 = request.getParameterNames();
				while ( enum1.hasMoreElements())
				{
					//Danger strParamValue = LabDBAdapter.checkNull(request.getParameter(strParam[j]));
					strParam = enum1.nextElement()+"";
					//inserted by srinivasa.N	  

					strParamValue = XHDBAdapter.checkNull(request.getParameter(strParam).trim());
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
			}

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
