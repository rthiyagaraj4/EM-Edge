<!DOCTYPE html>
<%
 /*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name        		Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------------------
06/04/2018  	IN058827		Kamalakannan G  		06/04/2018 		 Ramesh G 		ML-MMOH-CRF-0485
21/05/2018 	IN067699		Kamalakannan G  		21/05/2018 		 Ramesh G 		GHL_CRF_0485/02
---------------------------------------------------------------------------------------------------------------------------------------------

*/
%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@page  import="java.util.*,eOR.* ,webbeans.eCommon.ConnectionManager ,eOR.Common.*" %>
<%@page
	import="java.util.*, eCP.*, eMR.*, eCA.Common.*, eCommon.Common.*, java.sql.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>
<%
	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String bean_id = "CP_ReportBean" ;
	String bean_name = "eCP.ReportBean";
	ReportBean bean = (ReportBean)getBeanObject( bean_id, bean_name , request ) ;
	String mode	   = "1";
	request.setCharacterEncoding("UTF-8");
	bean.clear() ;
	bean.setMode( mode ) ;
	String imgUrl = "";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eCP/js/TaskStatusReport.js"></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String date_from="",date_to="";
	Properties p = (Properties)session.getValue("jdbc");
	String locale= (String) p.getProperty("LOCALE");
	String ca_practitioner_id = (String)session.getValue("ca_practitioner_id");
	String facility_id = (String)session.getValue("facility_id");
	String patient_id = request.getParameter("patient_id");
	String userName = (String)session.getValue("appl_user_name");//IN067699
	if (date_from.equals(""))
	{
		date_to		= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
		date_from	= com.ehis.util.DateUtils.minusDate(date_to,"DMY",locale,3,"M");
	}
	else
	{
		date_to = com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
		date_from = com.ehis.util.DateUtils.convertDate(date_from,"DMY","en",locale);				
	}	
%>
	
	
	<form name="TaskStatusReportCriteria" id="TaskStatusReportCriteria"  target="messageFrame">
	

		<table border=0 width='100%' cellPadding="3" cellSpacing="3"  align='center' >

		<tr>
			<td  class='label' id='patientId_lbl_td' colspan=1 width="20%" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				<td class='fields' id='patientId_td' >
						<input type='text' name='p_patientId' id='p_patientId' value='<%=patient_id%>'  readonly size="20">
				</td>
			<td  class='label' id='taskId' colspan=1 width="20%" ><fmt:message key="eCA.Task.label" bundle="${ca_labels}"/></td>
				<td class='fields' id='task_td' >
						<input type='hidden' name='p_task_stmt' id='p_task_stmt' value=""><input type='text' name='p_task_stmt_desc' id='p_task_stmt_desc' value=''  onKeyPress='return CheckForSpecChars(event)' onBlur="populateTaskSearch(p_task_stmt_desc,p_task_stmt);" size="20" ><input type=button name=search value='?'  class=button tabIndex="4" onClick="TaskSearch(p_task_stmt_desc,p_task_stmt)" >	
				</td>
		</tr>
		
		<tr>
			<td  class='label' width = '25%'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'>
			<select name='p_status' id='p_status'>
				<option value='ALL' selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				<option value='O' ><fmt:message key="Common.Pending.label" bundle="${common_labels}"/></option>
				<option value='P'><fmt:message key="eCA.Performed.label" bundle="${common_labels}"/></option>
				<option value='N'><fmt:message key="eCA.NotPerformed.label" bundle="${common_labels}"/></option>
				<option value='D' ><fmt:message key="Common.Discontinued.label" bundle="${common_labels}"/></option>
				<option value='9'><fmt:message key="Common.cancelled.label" bundle="${common_labels}"/></option>
			</select>
		</td>
		<td  class='label' id='GoalStmt' colspan=1 width="20%" ><fmt:message key="eCA.GoalStmt.label" bundle="${common_labels}"/></td>
				<td class='fields' id='GoalStmt_id' >
						<input type='hidden' name='p_goal_stmt' id='p_goal_stmt' value=""><input type='text' name='p_goal_Stmt_desc' id='p_goal_Stmt_desc' value=''  onKeyPress='return CheckForSpecChars(event)' onBlur="populateGoalStmtSearch(p_goal_Stmt_desc,p_goal_stmt);" size="20" ><input type=button name=search value='?'  class=button tabIndex="4" onClick="goalStmtSearch(p_goal_Stmt_desc,p_goal_stmt)" >
				</td>
		</tr>

		<tr>
		<td colspan=1 class="label"><fmt:message key="Common.DateRange.label" bundle="${common_labels}"/></td>
				<td colspan=1 >
					<input type="text" maxlength=10 size="8" value='<%=date_from%>' name="p_date_from" id = "from_date" onBlur='chkDateTime(this,"DMY","<%=locale%>"); '><img src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('p_date_from');" >&nbsp;- &nbsp;<!--IN067699-->
					
					<input type="text" maxlength=10 size="8" value='<%=date_to%>' name="p_date_to" id = "to_date" onBlur='chkDateTime(this,"DMY","<%=locale%>");'><img src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('p_date_to');" ><img src='../../eMP/images/mandatory.gif'align='center'></img><!--IN067699-->
				</td>
				
		</tr>
		<tr>
			<td colspan=4 align='right'><INPUT TYPE="button" class="button" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick="populateResult();"><INPUT TYPE='button' class='button' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onclick='clearresult()'></td><!--IN067699-->
		</tr>
		</table>
		<input type="hidden" name="goal_sql" id="goal_sql" value="SELECT OUTCOME_CODE code, SHORT_DESC description FROM CP_OUTCOME_LANG_VW WHERE LANGUAGE_ID='en' AND EFF_STATUS='E' AND upper(OUTCOME_CODE) like upper(?) and upper(SHORT_DESC) like upper(?)">
		<input type="hidden" name="task_sql" id="task_sql" value="SELECT distinct a.TASK_CODE code, b.short_desc description FROM ca_pat_task_list a,ca_intervention b WHERE b.intervention_code = a.task_code AND upper(a.TASK_CODE) like upper(?) and upper(b.short_desc) like upper(?)">
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
		<input type="hidden" name="p_userName" id="p_userName" value="<%=userName%>"><!-- IN067699 -->
		<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=facility_id%>">
		<input type="hidden" name="p_language_id" id="p_language_id" value="<%=locale%>">
	</form>
	
	
	
</body>
</html>

