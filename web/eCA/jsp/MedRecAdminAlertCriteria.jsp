<!DOCTYPE html>
<%--Author  Archna Kumari Dhal Created on 4/3/2009 --%>
<%@page import="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<title></title>
	
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			
	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }

				
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eCA/js/MedRecAdminAlert.js'></script>
	<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
	<script type='text/javascript' src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<%
        Properties p = (Properties)session.getValue("jdbc");
		String locale = (String) p.getProperty("LOCALE");
		String dateRange =request.getParameter("dateRange")==null?"":request.getParameter("dateRange");

		//String sql = "";
		String toDate = "";
		String frDate = "";
		String group_by = "";
		 String fnName = request.getParameter("function_id");
		 //out.println("fnName"+fnName);
		String facility_id=(String) session.getValue("facility_id");
		String practitioner_id 					=	(String) session.getValue("login_user");
		toDate	= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
		if (!dateRange.equals("N")){			
			frDate	= com.ehis.util.DateUtils.minusDate(toDate,"DMY",locale,1,"M");
		}
%>

<form name="MedRecAdminAlertCriteria_Form" id="MedRecAdminAlertCriteria_Form">
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='content'>
<table  border="0" width="100%" cellspacing='0' cellpadding='3' align='center'>
<tr>
    <td class='label'><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type='textbox' id='fromDt' name='fromDt' id='fromDt' value='<%=frDate%>' size=10 maxlength=10 onblur='CheckDate(this);ftDateCheck(this,toDt,"<%=toDate%>","DMY","<%=locale%>");'></input><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('fromDt')">&nbsp;-<input type='textbox' id='toDt' name='toDt' id='toDt' value='<%=toDate%>' size=10 maxlength=10 onblur='CheckDate(this);ftDateCheck(fromDt,this,"<%=toDate%>","DMY","<%=locale%>");'></input><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('toDt')"></input><img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	<%
	if(fnName.equals("CAMS_MRADMIN_ALERT")) {
%>
	<td class='label' width='18%'><fmt:message key='Common.user.label' bundle='${common_labels}'/></td>
	<td class='fields' width='30%'> <input type="text" name="practitioner" id="practitioner" value = "" size="25" OnKeyPress='return CheckForSpeChar(event)' onBlur='getPractCode(this)'><input type="hidden" name ="practitioner_id" value=""><input type='button' class='button' name='searchpctr' id='searchpctr' value='?' OnClick='populatePractLookup()'></td>
	</tr>
<tr>
	<td class='label'  ><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
	<td  class="fields"><select name='group_by' id='group_by'>
			<option value="PAT" selected><fmt:message key="Common.patient.label" bundle="${common_labels}"/></option>
			<option value="CATG"><fmt:message key="Common.user.label" bundle="${common_labels}"/>
		    </select>	
	</td>
		<td align='right' colspan='2' width='30%'><input type='button' class='button' value="<fmt:message key='Common.search.label' bundle='${common_labels}'/>" onclick='searchForMain()'>
	<input type='button' class='button' value="<fmt:message key='Common.clear.label' bundle='${common_labels}'/>" onclick='clearMain()'>
	</td>
	</tr>
</table>
	<%}else if (fnName.equals("CAMS_PRACT_ALERT")){//Pract
%>
<td class='label' width='18%'></td><td class='label'></td></tr> </table>
	<table  border="0" width="100%" cellspacing='0' cellpadding='3' align='center'>
<tr>
	<td align='right' colspan='2' width='30%'><input type='button' class='button' value="<fmt:message key='Common.search.label' bundle='${common_labels}'/>" onclick='searchForMain()'>
	</td>
</tr>
</table>
<input type="hidden" name="group_by" id="group_by" value="<%=group_by%>">	
<input type="hidden" name="practitioner_id" id="practitioner_id" value="<%=practitioner_id%>">
<%}%>

<%if(!imgUrl.equals("")){ %>
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>	
<input type="hidden" name="locale" id="locale" value="<%=locale%>">	
<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">		
<input type='hidden' name='fnName' id='fnName' value='<%=fnName%>'>

</body>
</form>
</html>

