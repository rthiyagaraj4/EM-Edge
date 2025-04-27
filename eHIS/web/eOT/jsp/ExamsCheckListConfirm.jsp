<!DOCTYPE html>
<%@page  import ="eOT.*,eOT.Common.*"%>
<%@page  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%><% request.setCharacterEncoding("UTF-8");%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
    <script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eOT/js/ExamsCheckList.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body  onKeyDown="lockKey()" >
<form name="ExamsCheckListConfirmForm" id="ExamsCheckListConfirmForm" >
<table cellpadding="3" cellspacing="0" width="100%" align="center" border="1">
<%
	String user_id	= request.getParameter("slate_user_id");
	String disable_checklist_fields = request.getParameter("disable_checklist_fields");		
	disable_checklist_fields=disable_checklist_fields==null?"":disable_checklist_fields;
	disable_checklist_fields=disable_checklist_fields.equalsIgnoreCase("null")?"":disable_checklist_fields;

	String checklist_completed_yn = request.getParameter("checklist_completed_yn");
	checklist_completed_yn=checklist_completed_yn==null?"":checklist_completed_yn;
	checklist_completed_yn=checklist_completed_yn.equalsIgnoreCase("null")?"":checklist_completed_yn;
	String disabled="";
	String checkbox_checked = "";
	String chklst_usr1_id = "(-----------)";	
%>

	<tr>
	<%
		if(checklist_completed_yn.equals("Y")){
			disabled="disabled";
			checkbox_checked="checked";
			chklst_usr1_id = "("+user_id+")";
		}else{
			checkbox_checked="";
			disabled="";
		}						
		if(disabled.equals("") && disable_checklist_fields.equals("disabled"))
			disabled=disable_checklist_fields;
	%>
		<td align="center" class="label" colspan="8" style="font-weight:normal"> 
			<fmt:message key="Common.completed.label" bundle="${common_labels}"/>? 
			<input type="checkbox" name="confirm_yn" id="confirm_yn" <%=disabled%> onClick="assignConfirm(this,'<%=user_id%>');" value="<%=checklist_completed_yn%>" <%=checkbox_checked%> ><br><br> <%=chklst_usr1_id%>
		</td> 
	</tr>
</table>
</form>
</body>
</html>

