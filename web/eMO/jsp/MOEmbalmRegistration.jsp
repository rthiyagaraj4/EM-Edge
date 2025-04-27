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
         String url 	= "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params 	= request.getQueryString() ;
    	String source 	= url + params ;
		
 %> 
   <frameset rows='42,*,25'>	   
                 <frame name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize>
				<frame name='f_query_add_mod' id='f_query_add_mod' 	src='../../eCommon/html/blank.html' frameborder=0>
				<frame name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'> 				
</HTML>

