<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
 <script language='javascript' src='../../eOT/js/PreOpIndicator.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String mode=request.getParameter("mode");
//out.println(mode);
String DISCR_MSR_ID = request.getParameter("DISCR_MSR_ID")==null?"":request.getParameter( "DISCR_MSR_ID" );

String short_description="";
String sql="";

/*if(mode.equals("delete"))
{
	con=ConnectionManager.getConnection(request);
		sql=" SELECT  A.DISCR_MSR_ID,  B.SHORT_DESC FROM  OT_DISCR_MSR  A,  AM_DISCR_MSR  B WHERE  A.DISCR_MSR_ID =  B.DISCR_MSR_ID AND  A.DISCR_MSR_ID=? ";
		stmt=con.prepareStatement(sql);
		stmt.setString(1,DISCR_MSR_ID);
		rs=stmt.executeQuery();
		if(rs!=null && rs.next())
		{
			DISCR_MSR_ID=rs.getString(1);
			short_description=rs.getString(2);
	}
}*/
%>
<form name="PreOpIndicator_form" id="PreOpIndicator_form"  onload='FocusFirstElement()'  action="../../servlet/eOT.PreOpIndicatorServlet" method="post" target="messageFrame"> 
<br><br><br><br><br><br>
<table border=0 cellspacing=0 cellpadding=3 width='100%'  align=center>

<tr>
	<td class='label' width="25%" >
	<fmt:message key="Common.description.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width="25%" >
	<input type="text" name="SHORT_DESC" id="SHORT_DESC" value="<%=short_description%>"  size='40' maxlength='40' onBlur="if(this.value!='')callLOVForDISCR_MSR_ID(DISCR_MSR_ID,SHORT_DESC); else DISCR_MSR_ID.value='';">
	<input type="button" class="button" name="generic_search" id="generic_search" value="?" onclick="callLOVForDISCR_MSR_ID(DISCR_MSR_ID,SHORT_DESC);">
	<img src='../../eCommon/images/mandatory.gif'>

	</td>
</tr>
<tr>
	<td class=label width="25%">
	<fmt:message key="Common.DiscreteMeasureCode.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width="25%">
	<input type="text" name="DISCR_MSR_ID" id="DISCR_MSR_ID" value="<%=DISCR_MSR_ID%>" size='15' maxlength='15' readonly >
	
	</td>
</tr>

</table>
<input type="hidden" name='mode' id='mode' value='<%=mode%>'>
<input type="hidden" name="DISCR_MSR_ID1" id="DISCR_MSR_ID1" value="<%=DISCR_MSR_ID%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


