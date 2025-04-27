<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name				Rev.Date	Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
26/10/2020	IN067210		SIVABAGYAM M	26/10/2020	RAMESH G	ML-MMOH-CRF-1144							
------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eCA.*, eCA.Common.*, eCommon.Common.*,java.text.DecimalFormat,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String bean_id		= "CARoleBasedTaskList" ;
String bean_name	= "eCA.CARoleBasedTaskList";
CARoleBasedTaskList bean = (CARoleBasedTaskList)getObjectFromBean( bean_id, bean_name , session); 
		Properties p;
		session = request.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		
		String function=request.getParameter("function")==null?"":request.getParameter("function");
		 if(function.equals("MAP_VALUES"))
		{
			String chkYN=request.getParameter("chkYN")==null?"":request.getParameter("chkYN");	
			String index=request.getParameter("index")==null?"":request.getParameter("index");
			String inner_index=request.getParameter("inner_index")==null?"":request.getParameter("inner_index");
			String pract_id=request.getParameter("pract_id")==null?"":request.getParameter("pract_id");
			String selectd_facility=request.getParameter("facility")==null?"":request.getParameter("facility");
			LinkedHashMap<String, ArrayList<ArrayList<String>>> Results=bean.updateList(chkYN,Integer.parseInt(index),Integer.parseInt(inner_index),pract_id,selectd_facility);	
			//bean.setMap(selectd_facility,Results);
			out.println(Results);
			//System.out.println("REsults====>"+Results);
		}
		

	putObjectInBean(bean_id,bean,session);
%>
