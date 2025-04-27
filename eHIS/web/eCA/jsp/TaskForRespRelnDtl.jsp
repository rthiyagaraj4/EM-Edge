<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title><fmt:message key="eCA.TaskForResponosibilityRelationshipDetails.label" bundle="${ca_labels}"/></title>
<% request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	/** added by kishore kumar n on 08/12/2009  */
	String imgUrl="";

	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
	 /** ends here*/
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/TaskForResp.js'></script>
<script language=javascript   src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
String label_desc ="", sql_query="" ;
String group_by = request.getParameter("group_by");

if(group_by == null || group_by.equals(""))group_by="";

if(group_by.equals("RS"))
{
	label_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.responsibility.label","common_labels");
	sql_query = "Select resp_id code, resp_name description from sm_resp where eff_status='E' and upper( resp_id) like upper(?) and  upper( resp_name) like upper(?)";
}else if(group_by.equals("TS"))
{
	label_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Task.label","common_labels");
	sql_query = "Select appl_task_id code, appl_task_desc description from ca_appl_task where splty_spec_yn = 'N' and upper( appl_task_id) like upper(?) and  upper( appl_task_desc) like upper(?)";
}else if(group_by.equals("RL"))
{
	label_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.relationship.label","common_labels");
	sql_query = "Select pract_reln_id code, pract_reln_name description from ca_pract_reln where upper( pract_reln_id) like upper(?) and  upper( pract_reln_name) like upper(?)";
}else{
	label_desc = "";
}

%>
<body onLoad="" class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<form name='formTaskForRespRelnDtl' id='formTaskForRespRelnDtl'>
<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
	<tr>
		<td class='label' width='25%'><%=label_desc%></td>
		<td class='fields'>
		<input type='text' name='grp_by_desc' id='grp_by_desc' value=""  onBlur='getGroup(this);'><input type='hidden' name='grp_by_code' id='grp_by_code' value=""><input type='button' name='grp_by_desc_search' id='grp_by_desc_search' value='?' class='button' onClick='getGroup(this);'><img src="../../eCommon/images/mandatory.gif"></img></td>
	<!--</tr> -->
	<%if(group_by.equals("TS")){%>
	<!--<tr>
		<td></td> -->
		<td  class='fields'><input type='radio' name='dtl_grp_by_code' id='dtl_grp_by_code' value="DRS" checked onClick='return validateGrpBy(this)'><fmt:message key="Common.responsibility.label" bundle="${common_labels}"/><input type='radio' name='dtl_grp_by_code' id='dtl_grp_by_code' value="DRL" onClick='return validateGrpBy(this)'><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td>
		<td></td>
		</tr>
	<%}%>
     <%if(group_by.equals("RS")){%>
	<!--<tr>
		<td></td> -->
		<td  class='fields'><input type='radio' name='dtl_grp_by_code' id='dtl_grp_by_code' value="DT" checked onClick='return validateGrpBy(this)'><fmt:message key="Common.Task.label" bundle="${common_labels}"/><input type='radio' name='dtl_grp_by_code' id='dtl_grp_by_code' value="DFN" onClick='return validateGrpBy(this)'><fmt:message key="Common.Function.label" bundle="${common_labels}"/></td>
		<td></td>
		</tr>
	<%}%>

<%if(group_by.equals("RL")){%>
	<!--<tr>
		<td></td> -->
		<td class='fields'><input type='radio' name='dtl_grp_by_code' id='dtl_grp_by_code' value="DT" checked onClick='return validateGrpBy(this)'><fmt:message key="Common.Task.label" bundle="${common_labels}"/><input type='radio' name='dtl_grp_by_code' id='dtl_grp_by_code' value="DFN" onClick='return validateGrpBy(this)'><fmt:message key="Common.Function.label" bundle="${common_labels}"/></td>
	    <td></td>
		</tr>
	<%}%>


	<tr><td></td><td></td><td></td>
	<td  class='fields' colspan='2' ><input type='button' class='button' name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick = "return fetchResults();"></td>
	</tr>
</table>
<!-- added by kishore kumar n on 08/12/2009  -->
<%if(!imgUrl.equals("")){ %>
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
<!--ends here -->
<input type="hidden" name="group_by" id="group_by" value="<%=group_by%>">
<input type="hidden" name="from" id="from" value="">
<input type="hidden" name="to" id="to" value="">
<input type="hidden" name="row_count" id="row_count" value="">
<input type="hidden" name="optionValStr" id="optionValStr" value="">
<input type="hidden" name="label_desc" id="label_desc" value="<%=label_desc%>">
<input type="hidden" name="sql_query" id="sql_query" value="<%=sql_query%>">

</form>
</body>
</html>

