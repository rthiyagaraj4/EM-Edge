<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
	<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");	
%>

      <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eMO/js/MORegisterAttn.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js' ></script>
<%
String function_id=request.getParameter("functionid");
if(function_id == null) function_id = "";
String functionid=request.getParameter("function_id");
if(functionid == null) functionid = "";
%>
<%
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String mode = request.getParameter("mode") ==null?"":request.getParameter("mode");
		String source = url + params ;
		
		String register_no= request.getParameter("register_no") ==null?"":request.getParameter("register_no"); //Added for this CRF Bru-HIMS-CRF-407 [IN:045167]
		
		/*Below line added for this CRF ML-MMOH-CRF-0695*/
	    String function_id1=request.getParameter("function_id1")==null?"":request.getParameter("function_id1");
	
	
		if(mode.equals("viewdata")){%>
       <title><fmt:message key="eMO.RegistrationDtls.label" bundle="${mo_labels}"/></title>
		 </head>

			<!-- <frameset rows='0%,*,5%' id='a'> -->
			<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder=0 scrolling='no' style='height:6vh;width:100vw'></iframe>
		<% }else{%>
			<!-- <frameset rows='6%,*,5%' id='a'> -->
			<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder=0 scrolling='no' style='height:6vh;width:100vw'></iframe>
			<%}%>
			<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eMO/jsp/MORegisterAttnFrameset.jsp?function_id=<%=function_id%>&functionid=<%=functionid%>&mode=<%=mode%>&<%=params%>&register_no=<%=register_no%>&function_id1=<%=function_id1%>' frameborder=0 scrolling='yes' style='height:83vh;width:100vw'></iframe>
			<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='no' style='height:9vh;width:100vw'></iframe>
			<!-- </frameset> -->
			<input type="hidden" name="tlbrsrc" value="<%=source%>">
			<form>
	<input type='hidden' name='function_id' value=<%=function_id%>>
	<input type='hidden' name='functionid' value=<%=functionid%>>
	</form>
			
</html>
