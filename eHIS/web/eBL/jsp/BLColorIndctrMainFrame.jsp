<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
20/07/2020 	  		       Ram kumar S											NMC-JD-CRF-0042
-------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<HTML>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>		
	<script language='javascript' src='../../eBL/js/BLColorIndctrDtls.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String params = request.getQueryString();
	if(params==null || params.equals("")) params="";
	String function_id=request.getParameter("function_id");
	if(function_id==null || function_id.equals("")) function_id="";
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?home_required_yn=Y";
	String source = url + params;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='BLColorIndctrDtlsFrame' id='BLColorIndctrDtlsFrame' src='../../eBL/jsp/BLColorIndctrDtls.jsp'<%=params%> frameborder=0 style='height:57vh;width:100vw'></iframe>
	<iframe name='TabsFrame' id='TabsFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' style='height:27vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:7vh;width:100vw'></iframe>
</HTML>

