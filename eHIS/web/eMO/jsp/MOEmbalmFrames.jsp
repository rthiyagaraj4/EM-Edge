<!DOCTYPE html>
<!--
   
   Developed By : Venkatesh.S
   Date         : 28-Nov-2013    
   Against      : Bru-HIMS-CRF-348 [IN038247] 
 
 -->



<HTML>
<HEAD>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%
	request.setCharacterEncoding("UTF-8");
 	String sStyle		=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eMO/js/MOEmbalmRegistration.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
 <%
         String url 		= "../../eCommon/jsp/commonToolbar.jsp?" ;
		 String params 		= request.getQueryString() ;
    	String source 		= url + params ;
		String mode         =request.getParameter("mode");
	 	String patientID	=request.getParameter("patient_id");
		String app_id       =request.getParameter("app_id");
		
		
 %> 

   <iframe name='EmbalmCriteria' id='EmbalmCriteria' 	src="../../eMO/jsp/MOEmbalmCriteria.jsp?<%=request.getQueryString()%>" frameborder=0 style='height:9%;width:100vw'></iframe><iframe name='EmbalmResult' id='EmbalmResult'		src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:100vh;width:100vw'></iframe>
</HTML>

