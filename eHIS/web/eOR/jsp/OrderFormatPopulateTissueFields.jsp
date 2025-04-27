<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--------------------------------------------------------------------------------------------------------------
Date       	Edit History      		Name        		Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------------------
03/02/2020		IN072648	SIVABAGYAM M		03/02/2020		RAMESH G		ML-MMOH-SCF-1495
-------------------------------------------------------------------------------------------------------------------------------
--%>
<%@page import="java.util.*, eOR.Common.*, eOR.* " contentType="text/html;charset=UTF-8"%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryFormatBean"/>
<%
	request.setCharacterEncoding("UTF-8");
	

	
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" );

	
	String anatomy_site_code = (String) hash.get("anatomy_site_code");
	//String anatomy_site_name = (String) hash.get("anatomy_site_name");
	String catalog_code = (String) hash.get("catalog_code");
	String fixativeField = (String) hash.get("fixative_field");
	Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean
	
	String tissue_field_name_key = (String) hash.get("tissueDescField");
	String[] record =null;
	if(!tissue_field_name_key.equals(""))
	{
		//out.println("clearTissueDetails('document',\""+tissue_field_name_key+"\");");//IN072648
		ArrayList tissueDetails = (ArrayList) beanQueryObj.populateTissueFields(properties,anatomy_site_code);

		for( int i=0 ; i< tissueDetails.size() ; i++ ) 
		{
			record = (String[])tissueDetails.get(i);
			out.println( "addTissueDetailsData2List(\"" + record[0] + "\",\"" + record[1] + "\",\""+tissue_field_name_key+"\") ; " ) ;
		}
		if(tissueDetails!=null)
		{
			tissueDetails.clear(); 
			tissueDetails = null;
		}
	}
	if(!fixativeField.equals(""))
	{
		String fixativeCode = (String) beanQueryObj.getFixativeField(properties,anatomy_site_code,catalog_code);

		if(null!=fixativeCode && !fixativeCode.equals(""))
		{
			ArrayList fixativeDetails = (ArrayList) beanQueryObj.populateFixativeFields(properties);
			out.println("clearFixativeDetails('document',\""+fixativeField+"\");");
			record =null;
			for( int i=0 ; i< fixativeDetails.size() ; i++ ) 
			{
				record = (String[])fixativeDetails.get(i);
				out.println( "addFixativeDetailsData2List(\"" + record[0] + "\",\"" + record[1] + "\",\""+fixativeField+"\",\""+fixativeCode+"\") ; " ) ;
			}
			if(fixativeDetails!=null)
			{
				fixativeDetails.clear(); 
				fixativeDetails = null;
			}
		}

	}
	

	if(hash!=null)
	{
		hash.clear();			 
		hash	= null;
	}
%>
