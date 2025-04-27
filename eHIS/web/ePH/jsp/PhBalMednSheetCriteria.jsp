<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
	<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../ePH/js/PhBalMednSheet.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="javascript" src="../../ePH/js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	String bean_id				= "PHRepDispStatisByDispBean" ;
	String bean_name			= "ePH.PHRepDispStatisByDispBean";
	PHRepDispStatisByDispBean bean	= (PHRepDispStatisByDispBean)getBeanObject( bean_id,bean_name, request ) ;
	bean.setLanguageId(locale);
	//String  med_pr_yn				= bean.getMednPrnList();
	String  med_pr_yn				="Y";
	ArrayList localLang1 = new ArrayList();	//Code Added For FD-Bru-HIMS-CRF-075 - Start
	String newLocalLanguage ="";
	String localLang ="";
	String sDefaultLocLang = "";
	String newLang = "";
	if(!locale.equals("en")){
	    localLang1 = bean.getLangNameAndId(locale);
		newLocalLanguage =(String)localLang1.get(0);
		newLang = (String)localLang1.get(0);  //newly added
		//localLang =(String)localLang1.get(1);
		sDefaultLocLang ="selected";
	}
	else{
		newLang = bean.getSMLOcalLanguageID();
		localLang1 = bean.getLangNameAndId(newLang);
	}
	if(localLang1 !=null && localLang1.size()>0)
		localLang =(String)localLang1.get(1);
	//Code Added For FD-Bru-HIMS-CRF-075 - End
	if(med_pr_yn.equals("N"))
		out.println("<script>GoBack()</script>");
%>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.formPhBalMednSheetCriteria.p_disp_no.focus();"> 
						
		<form name="formPhBalMednSheetCriteria" id="formPhBalMednSheetCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				<TH COLSPAN="4"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
				<tr>
					<td class="label"><fmt:message key="ePH.DispenseNo.label" bundle="${ph_labels}"/></td>
					<td class="label"><input type="text" maxlength="15" size="15" name="p_disp_no" id="p_disp_no" onKeyPress='return CheckForSpecChars(event)'>&nbsp;</SELECT>
					<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td class="label"><input type="text" name="p_patient_id" id="p_patient_id" maxlength="<%=bean.getPatientIDLength()%>" size="20" value="" onKeyPress="changeToUpper()" onblur="Duplicatecheck()" ><!-- onblur="Duplicatecheck();" added for ML-BRU-SCF-0621[IN036565]-->		<input type="button" class="button" value="?" name="pat_search" id="pat_search" onClick="callPatientSearch(document.formPhBalMednSheetCriteria.p_patient_id)">
					
				</tr>
				<tr><!-- Code Added For FD-Bru-HIMS-CRF-075 -Start -->
					<td class="label"></td><td></td><td class="label">
					<label class="label"><fmt:message key="Common.Language.label" bundle="${common_labels}"/></label>
					</td>
					<td class="label"><select name="label_language" id="label_language" style="display:visible" onchange="changeLanguage(this)">
						<option value="E"><fmt:message key="Common.English.label" bundle="${common_labels}"/></option> 
<%
						if(localLang != null && !localLang.equals("")){
%>
							<option value="<%=newLang%>" <%=sDefaultLocLang%>><%= localLang%></option>  
<%
						}
%>
						</select>
					</td><!-- Code Added For FD-Bru-HIMS-CRF-075 -End -->
				</tr>
				<tr>
					<td colspan="4" align="Right"> 
						<input type="button" name="btnSearch" id="btnSearch" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class="button" onClick="showResults()">&nbsp;&nbsp;&nbsp;
					</td>
				</tr>
			</table>
			<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
			<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHPRBALMS">
			<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
			<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
			<INPUT TYPE="hidden" name="newLocalLanguage" id="newLocalLanguage" VALUE="<%=newLocalLanguage%>"><!-- Code Added For FD-Bru-HIMS-CRF-075 -Start -->
		</form>
	</body>
	<% putObjectInBean(bean_id,bean,request ) ; %>
</html>

