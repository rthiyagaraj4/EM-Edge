<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      	Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
21/06/2018	IN065341	   Prakash C 			21/06/2018		Ramesh G			MMS-DM-CRF-0115
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eCA.*,eOR.*,eOR.Common.*, eCommon.Common.*, java.sql.*, webbeans.eCommon.*,eCA.Common.*"%>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>


<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<% 
	request.setCharacterEncoding("UTF-8");
	Connection con=null;

	try{
		
		 con = ConnectionManager.getConnection(request);
		
		String bean_id = "Ca_CentralizedBean" ;
		String bean_name = "eCA.CentralizedBean";
		CentralizedBean bean = (CentralizedBean)getBeanObject( bean_id, bean_name , request ) ;
		String mode	   = "1";
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		bean.clear() ;
		bean.setMode( mode ) ;
		
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get( "SEARCH" ) ;
		
		String from_date="";
		String to_date="";
		String resp_id		= "CA";
		String RepDb		= (String)hash.get("RepDb");
		String facility_id	= (String)hash.get("facility_id");
			
		if(facility_id.equals("")||facility_id==null){
			RepDb="";
		}
		ArrayList result =new ArrayList();
		 result = (ArrayList)bean.getDefaultCDRDateRange(con,resp_id,RepDb);
				
		if (result.get(0) != null)
			from_date = ((String) result.get(0)).trim();
	   	if (result.get(1) != null)
	   		to_date  = ((String) result.get(1)).trim();
				
				out.println("document.getElementById('from_date').value='"+from_date+"'");
				out.println("document.getElementById('to_date').value='"+to_date+"'");
				
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)con.close();
		}
	
%>
