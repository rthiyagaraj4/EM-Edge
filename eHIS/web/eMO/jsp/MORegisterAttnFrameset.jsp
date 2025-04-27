<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
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
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 	
</head>

<%
String function_id=request.getParameter("function_id")==null ?"":request.getParameter("function_id");
String functionid=request.getParameter("functionid")==null ?"":request.getParameter("functionid");

%>
<!-- <frameset rows='4.5%,7%,0%,*,0%'  >-->
<%String patientID=request.getParameter("patientID")==null?"":request.getParameter("patientID");	
String mode=request.getParameter("mode")==null?"":request.getParameter("mode");	
String menudis=request.getParameter("menudis")==null ?"":request.getParameter("menudis");
String external=request.getParameter("external")==null ?"N":request.getParameter("external");

String register_no=request.getParameter("register_no")==null ?"":request.getParameter("register_no"); //Added for this CRF Bru-HIMS-CRF-407 [IN:045167]
/*Below line added for this CRF ML-MMOH-CRF-0695*/
 String function_id1=request.getParameter("function_id1")==null?"":request.getParameter("function_id1");

if(!patientID.equals(""))
	{
	//Below line modified for this CRF ML-MMOH-CRF-0695
	%>
	<iframe name='patientFrame' id='patientFrame' src='../../eMO/jsp/MORegisterAttnSearch.jsp?function_id=<%=function_id%>&functionid=<%=functionid%>&patientID=<%=patientID%>&mode=<%=mode%>&menudis=<%=menudis%>&external=<%=external%>&register_no=<%=register_no%>&function_id1=<%=function_id1%>'frameborder=0 scrolling='no' style='height:7vh;width:100vw'></iframe>
	
<%	}
	else
	{%>
	<iframe name='patientFrame' id='patientFrame' src='../../eMO/jsp/MORegisterAttnSearch.jsp?function_id=<%=function_id%>&functionid=<%=functionid%>&external=<%=external%>&menudis=<%=menudis%>&register_no=<%=register_no%>' frameborder=0 scrolling='no' style='height:6vh;width:100vw'></iframe>
	<%}%>
	<iframe name='patientLine' id='patientLine' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:8vh;width:100vw'></iframe>
	<iframe name='encounterFrame' id='encounterFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:2vh;width:100vw'></iframe>
	<iframe name='patientDetailsFrame' id='patientDetailsFrame' src='../	../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:85vh;width:100vw'></iframe>
	<iframe name='dummyframe' id='dummyframe' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:0vh;width:100vw'></iframe>  
<!-- </frameset>-->
	
		<form>
	<input type='hidden' name='function_id' id='function_id' value=<%=function_id%>>
	<input type='hidden' name='functionid' id='functionid' value=<%=functionid%>>
	</form>		 
</html>

