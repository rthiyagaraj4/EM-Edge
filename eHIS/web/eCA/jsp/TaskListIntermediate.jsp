<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History     Name      			Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
13/04/2020	IN072674		Ramesh Goli				13/04/2020		Ramesh G		MMS-KH-CRF-0032
---------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>

<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*, eCA.*,java.text.*" contentType="text/html;charset=UTF-8"%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;
	java.util.Date To_date= new java.util.Date();
	java.util.Date From_date= new java.util.Date();
	String ToDateStr = "";
	String FromDateStr = "";
	try{
		String Todate			=	(String) hash.get("Todate")==null?"":(String) hash.get("Todate");
		String Fromdate			=	(String) hash.get("Fromdate")==null?"":(String) hash.get("Fromdate");
		String taskSelect		=	(String) hash.get("taskSelect")==null?"":(String) hash.get("taskSelect");
		SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy HH:mm");
		SimpleDateFormat formatter2=new SimpleDateFormat("dd/MM/yyyy");
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
		if(!"".equals(Todate)){
			try{	
				To_date = df.parse(Todate.toString().trim());			
			}catch(ParseException ex){
				To_date = df1.parse(Todate.toString().trim());
			}
			if("V".equals(taskSelect)){
				int hours = To_date.getHours();
				int minutes = To_date.getMinutes();
				if(hours==0 && minutes==0){
					To_date.setHours(23);
					To_date.setMinutes(59);
				}
				ToDateStr = formatter1.format(To_date);
			}else{
				ToDateStr = formatter2.format(To_date);
			}
		}
		
		
		if(!"".equals(Fromdate)){
			try{	
				From_date = df.parse(Fromdate.toString().trim());			
			}catch(ParseException ex){
				From_date = df1.parse(Fromdate.toString().trim());
			}
			if("V".equals(taskSelect)){
				FromDateStr = formatter1.format(From_date);
			}else{
				FromDateStr = formatter2.format(From_date);
			}
		}
		
		out.println(FromDateStr+"|"+ToDateStr);
	}
	catch(Exception ee)
	{
		//out.println("Error from TaskListIntermediate.jsp :"+ee.toString());//COMMON-ICN-0181
		ee.printStackTrace();//COMMON-ICN-0181
	}
%>
