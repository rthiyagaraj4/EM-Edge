<!DOCTYPE html>
<%@page  import ="eOT.*,eOT.Common.*" %>
<%@page  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<html>
<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOT/js/ExamsCheckList.js" ></SCRIPT> 
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String patient_id	= request.getParameter("patient_id") ;
	String patient_name		= request.getParameter("patient_name") ;
	String sex		= request.getParameter("sex") ;
	String dob		= request.getParameter("dob") ;
	String encounter_id		= request.getParameter("encounter_id") ;
	String patient_disply_title = patient_id+", "+patient_name+", "+sex+", "+dob+", "+encounter_id;

%>
<body  onKeyDown = 'lockKey()' >
<form name="ExamCheckListHeaderTitlesForm" id="ExamCheckListHeaderTitlesForm" >
	<table cellpadding="3" cellspacing="0" width="100%" align="center" border="1" id="exam_checklist_table_header">
		<tr id="exam_checklist_table_header_row1">
			<td class="CAGROUPHEADING" align="left" nowrap><%=patient_disply_title%>
			</td>
		</tr>
	</table>
</form>
</body>
</html>

