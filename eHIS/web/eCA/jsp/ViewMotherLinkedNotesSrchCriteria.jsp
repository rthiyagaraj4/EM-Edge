<!DOCTYPE html>
<% 
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
20/10/2016	Created 		Raja S											MO-CRF-20108[IN058912] 
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<title>Mother Clinical Notes</title>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		
		String imgUrl="";

		if(sStyle.equals("IeStyle.css"))
				imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	
	<script language='javascript' src='../../eCA/js/ViewMotherLinkedNotes.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<center>
<form name='ViewMotherLinkedNotesSrchCriteriaForm' id='ViewMotherLinkedNotesSrchCriteriaForm'>
<%
	
		

	String	query_string		=	"";
	String	from_date_time		=	"";
	String	to_date_time		=	"";

	query_string = request.getQueryString();

%>
	<table border="0" cellpadding="3" cellspacing="0" width="100%" align='center'>
		<tr>
			<td class="LABEL"  width='10%' ><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
			<td class="fields" width='40%' nowrap>
				<input type='text' name='from_date_time' id='from_date_time' value="<%=from_date_time%>" size='14' maxLength='16'  onBlur=' CheckDateNew(this); checkPeriodFromTo(this,to_date_time, "DMYHM","<%=locale%>")'><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('from_date_time');">
				&nbsp;&nbsp;-&nbsp;&nbsp;<input type='text' name='to_date_time' id='to_date_time' value="<%=to_date_time%>" size='14' maxLength='16'  onBlur='CheckDateNew(this);checkPeriodFromTo(from_date_time,this,"DMYHM","<%=locale%>")'><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('to_date_time');">
			</td>
			<td class="label" width='15%'><fmt:message key="eCA.RefNo.label" bundle="${ca_labels}"/></td>
			<td  class="fields" width='20%'>
				<input type="text" name="ref_no" id="ref_no" value="" width="30%" size="50" maxlength = '100' onkeyPress="if(event.keyCode == 39) return false;">
			</td>
			<td  width='15%' class = button align ='right' ><input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='BUTTON' onClick="return showPreviousNotesSearchResults();"></td>
		</tr>	
	</table>
		<input type='hidden' name='query_string' id='query_string'	value="<%=query_string%>">	
		<%if(!imgUrl.equals("")){ %>
			 <img src='<%=imgUrl%>' width='100%' height='15'/> 
		<%}%>
</form>
</center>
</body>
</html>
<script language='javascript'>	
	parent.ViewMotherLinkedNotesSrchResultsFrame.location.href = "../../eCA/jsp/ViewMotherLinkedNotesSrchResults.jsp?<%=query_string%>&from_date_time=<%=from_date_time%>&to_date_time=<%=to_date_time%>";
</script>
		


