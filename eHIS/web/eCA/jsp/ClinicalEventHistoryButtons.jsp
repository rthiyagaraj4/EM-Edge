<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
21/06/2020  	IN071596	sivabagyam M 	21/06/2020		Ramesh G		MO-CRF-20101.7
21/09/2020  	IN072760	sivabagyam M 	21/06/2020		Ramesh G		MO-CRF-20101.9
26/11/2020	6450		SIVABAGYAM M	26/11/2020		RAMESH G	MO-CRF-20101.10

---------------------------------------------------------------------------------------------------------------
*/
%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE> New Document </TITLE>
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String selHistType			= request.getParameter("selHistType")==null	?"LBIN":request.getParameter("selHistType");
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCA/js/ClinicalEventHistoryNew.js'></script>
<script src='../../eCA/js/DateCheck.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>
<%
String disablePrev = " disabled "; //IN071596
String disableNext = ""; //IN071596
%>
<body>
<form>
<table border=1 cellpadding=0 cellspacing=0 width="100%">
	<tr>
		<td width='25%' align='right'>
			<%if("CLNT".equals(selHistType)||"RDIN".equals(selHistType)||"MEDN".equals(selHistType)||"SUNT".equals(selHistType)||"MERP".equals(selHistType)){//IN072760 //6450 %>
			&nbsp;
			<%}else{ %>
			<INPUT TYPE="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Viewgraph.label","ca_labels")%>' class='BUTTON' onClick='openGraph1()' title='Click here to view the graph'>&nbsp;
			<%} %>
		</td>
		<td width='50%'>&nbsp;</td>
		<td width='25%' align='right'>
			&nbsp;
		</td>
	</tr>
</table>
</body>
</HTML>

