<!DOCTYPE html>

<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
//		String queryString = request.getQueryString() == null ? "" : request.getQueryString();
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script src='../../eCA/js/CAMainMenu.js' language='javascript'></script>
	<script src='../../eCA/js/ProgressNotes.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>	
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<%

	String progression_ref = request.getParameter("progression_ref")==null?"":request.getParameter("progression_ref");
	String module_id = request.getParameter("module_id")==null?"":request.getParameter("module_id");
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String progression_no = request.getParameter("progression_no")==null?"":request.getParameter("progression_no");


%>
<body  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
	<form METHOD=POST ACTION="" name="matconsscycle" id="matconsscycle"  >
		<BR><BR><BR>
		<TABLE width='50%' align='left' border=0 cellspacing=0 >
			<TR>
				<td class='label'  WIDTH='25%' ><fmt:message key="eCA.OutCome.label" bundle="${ca_labels}"/></td>
				<td class='field' width='25%'>
					<select name="outcome" id="outcome" onchange='chkNoteStatus(this)'>
						<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
						<option value='C'><fmt:message key="Common.close.label" bundle="${common_labels}"/></option>
					</select>
				</td>
			</tr>
		</table>
		<input type=hidden name='progression_ref' id='progression_ref' value='<%=progression_ref%>'>
		<input type=hidden name='mode' id='mode' value=''>
		<input type=hidden name='queryString' id='queryString' value=''>
		<input type=hidden name='module_id' id='module_id' value='<%=module_id%>'>
		<input type=hidden name='patient_id' id='patient_id' value='<%=patient_id%>'>
		<input type=hidden name='progression_no' id='progression_no' value='<%=progression_no%>'>
	</form>
</body>
</html>

