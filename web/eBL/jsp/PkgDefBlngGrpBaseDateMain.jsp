<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>

<%
		String params = request.getQueryString();
%>
<HTML>

<HEAD>

</HEAD>
<!--
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link>
-->
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		 
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src='../../eBL/js/PkgDefCust.js'></script>
		<script language="javascript" src='../../eBL/js/PkgDefBlngGrp.js'></script>
		<script language="javascript" src='../../eBL/js/PkgDefGrp.js'></script>
		<script language="javascript" src='../../eBL/js/PkgDef.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
	 

		<iframe name='blng_grp_period_dtl' id='blng_grp_period_dtl'	src='PkgDefBlngGrpBaseDate.jsp?<%=params%>'  frameborder='0' noresize scrolling='auto' style='height:81vh;width:100vw'></iframe>
		<iframe name='blng_grp_btn' id='blng_grp_btn' src="../../eBL/jsp/PkgDefBlngGrpBtn.jsp?<%=params%>&table_name=blng_grp_period_tbl" frameborder='0' noresize scrolling='no' style='height:19vh;width:100vw'></iframe>

</HTML>

