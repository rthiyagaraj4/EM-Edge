<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name				Rev.Date	Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
21/10/2019	IN069242		Sivabagyam			22/10/2019	Ramesh Goli			GHL-CRF-0567							
------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCA.*,eCA.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>		
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		session = request.getSession(false);
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		String restrictId		= "";
		String mode				= "";
		String restrictDesc		= "";
		String restrictDataType	= "";
		String restrictDataChk1	= "";
		String restrictDataChk2	= "";
		String bean_id			= "@CARestrictCEHDataBean";
		String bean_name		= "eCA.CARestrictCEHDataBean";
		String calledFrom = request.getParameter("calledFrom")==null?"CEH":request.getParameter("calledFrom");
		restrictDataType = request.getParameter("restrictDataType")==null?"H":request.getParameter("restrictDataType");
		mode = request.getParameter("mode")==null?"UPDATE":request.getParameter("mode");
		if("CEH".equals(calledFrom)){
			restrictId 			= "*ALL";
			restrictDesc		= "*ALL";
		}
		if("H".equals(restrictDataType)){
			restrictDataChk1	= "Checked";
		}
		CARestrictCEHDataBean bean	= (CARestrictCEHDataBean)getObjectFromBean( bean_id, bean_name , session) ; 
		ArrayList histRecTypes = (ArrayList)bean.getHistRecType(locale);
		if("UPDATE".equals(mode))
			bean.getRestrictDataDetails(restrictId);
		%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src="../../eCommon/js/common.js"></script>
		<script language='javascript' src="../../eCA/js/CARestrictCEHData.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			
	</head>
	<body  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown ='lockKey()'>
		<form name="CARestrictCEHDataHeaderForm" id="CARestrictCEHDataHeaderForm">
			<BR><BR>
			<table  cellpadding='0' cellspacing='0' border='0' width='60%' align='center' >
			<tr>
				<td  class="label" valign="top" > <fmt:message key="eCA.RestrictionApplicableTo.label" bundle="${ca_labels}"/> <br> <fmt:message key="eCA.PrintCommentsManage.label" bundle="${ca_labels}"/></td>
				<td  class="label" >
				<input type='radio' id="restrictData" name='restrictData' id='restrictData'  onclick='chageRestrictDataType()' value ='H' <%=restrictDataChk1%>><fmt:message key="eCA.historyType.label" bundle="${ca_labels}"/>
				<input type='radio' id="restrictData" name='restrictData' id='restrictData'  onclick='chageRestrictDataType()' value ='E' <%=restrictDataChk2%>>	<fmt:message key="eCA.EventClassType.label" bundle="${ca_labels}"/></td>
			</tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			<tr id="historyDetails" style="display: none;">
				<td  class="label" valign="top" > <fmt:message key="eCA.historyType.label" bundle="${ca_labels}"/></td>
				<td  class="label" >
					<select name="historyType" id="historyType" onChange='chageRestrictDataType()'>
						<%
						for(int i=0;i<histRecTypes.size();i++){
								String[] histList  = (String[])histRecTypes.get(i);
							%>
								<option value="<%=histList[0]%>" ><%=histList[1]%></option> 
							<%
						}
					%>
					</select>
				</td>
			<tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			</table>
			<input type="hidden" name="restrictDataType" id="restrictDataType" value="<%=restrictDataType%>"/>
			<input type="hidden" name="restrictId" id="restrictId" value="<%=restrictId%>"/>
			<input type="hidden" name="restrictDesc" id="restrictDesc" value="<%=restrictDesc%>"/>
			<input type="hidden" name="histFunction" id="histFunction" value="<%=calledFrom%>"/>
		</form>
		<script>
			chageRestrictDataType();
		</script>
	</body>
</html>	
<%putObjectInBean(bean_id,bean,session);%>

