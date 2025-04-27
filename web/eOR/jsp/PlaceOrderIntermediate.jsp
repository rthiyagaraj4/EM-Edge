<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------
Date			Edit History	Name			Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------
12/02/2018		IN066055		Raja S			12/02/2018		Ramesh 			ML-MMOH-CRF-0891.2				  
---------------------------------------------------------------------------------------------
*/
%>

<%@ page import ="java.sql.*,java.net.*,java.text.*,java.util.*,eCA.*,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>
<% 
request.setCharacterEncoding("UTF-8"); 
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	try 
	{
		Properties properties				= (Properties) session.getValue( "jdbc" );
		String modeId 		=  request.getParameter("Mode")==null ? "" : request.getParameter("Mode");		
		String extph_function_id 		=  request.getParameter("extph_function_id")==null ? "" : request.getParameter("extph_function_id");
		String patient_id 		=  request.getParameter("patient_id")==null ? "" : request.getParameter("patient_id");
		String encounter_id 		=  request.getParameter("encounter_id")==null ? "" : request.getParameter("encounter_id");
		String user_id =  request.getParameter("user_id")==null ? "" : request.getParameter("user_id");
		if(user_id ==null || "".equals(user_id)) //IN071501
			user_id =(String)session.getValue("login_user");
		String phExtUrlarr[] = null;
		String externalUrl="";
		if("GenerateExtURL".equals(modeId))
		{

			externalUrl=beanQueryObj.getExtPHLink(properties,extph_function_id,patient_id,encounter_id,user_id);
			
			if(externalUrl.indexOf("$!^")!=-1){
				 phExtUrlarr=externalUrl.split("\\$!\\^");
			}
			
			if(extph_function_id.equals("PHIS_MEDICATION_ORDER") || (extph_function_id.equals("PHIS_DISCHARGE_MEDICATION")))
			{
				if(phExtUrlarr[0].equals("E"))
					out.println("alert('"+phExtUrlarr[2]+"')");
				else if(phExtUrlarr[0].equals("S"))
					out.println("phWindowCall('"+phExtUrlarr[1]+"')");
				else 
					out.println("alert('"+externalUrl+"')");
			}
			else{
				if(phExtUrlarr[0].equals("E"))
					out.println("<script>alert('"+phExtUrlarr[2]+"')</script>");
				else if(phExtUrlarr[0].equals("S")){
					out.println("<script language='Javascript' src='../../eCommon/js/common.js'></script>");
					out.println("<script>phWindowCall('"+phExtUrlarr[1]+"')</script>");
				}
				else 
					out.println("</script>alert('"+externalUrl+"')</script>");
			}
		}
		
	}
	catch (Exception e) 
	{
		//out.println("alert(\"" + e + "\");") ;//COMMON-ICN-0181
		e.printStackTrace();
	}
%>

