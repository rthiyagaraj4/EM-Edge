<!DOCTYPE html>
<%
/*
------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------
?             	100            		?           	?				?					created 
18/11/2015    	IN057467		 	Ramesh G		      								Query template data should also allow date field to be included for query.	
------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eCA.*" contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	try 
	{
		request.setCharacterEncoding("UTF-8");		
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get( "SEARCH" ) ;	
		QueryTemplateDataFunctionBean qryDataBean = (QueryTemplateDataFunctionBean)getObjectFromBean("qryDataBean","eCA.QueryTemplateDataFunctionBean",session);

		String callMode = (String) hash.get("callMode");
		String element = (String) hash.get("element");
		String elementVal = (String) hash.get("elementVal");

		if(callMode.equals("ADD"))
		{
			if(element != null)
			{				
				qryDataBean.setKeyComponent(element, elementVal);
			}
		}
		else if(callMode.equals("REMOVE"))
		{
			if(element != null)
			{
				qryDataBean.removeKeyComponent(element);
			}
		}
		//IN057467 Start.
		else if(callMode.equals("COMPCHK"))
		{
			if(element != null)
			{
				if("Y".equals(elementVal)){
					qryDataBean.setDateChk(element);
				}else if("N".equals(elementVal)){
					qryDataBean.removeDateChk(element);
				}
			}
		}else if(callMode.equals("ADDDT")){
		
			if(element != null)
			{	
				
				String elementID = (String) hash.get("elementId");
				String elementTYPE = (String) hash.get("elementType");
				qryDataBean.setKeyComponent(element, "DT");
				qryDataBean.setKeyComponent(elementID+elementTYPE, elementVal);
			}
		}
		//IN057467 End.
		putObjectInBean("qryDataBean",qryDataBean,session);

	}
	catch(Exception e)
	{
		e.printStackTrace();	
	}
%>	 
	 
