<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8"	import="java.util.*,ePH.*,ePH.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
	try{
		String locale = "";
		String aa[] = null;
		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
		request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		//ends
		locale = (String) session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		String sql_Pres_Remark_for_drug_LookUp = "SELECT DRUG_CODE CODE, DRUG_DESC DESCRIPTION FROM PH_DRUG_LANG_VW PH_DRUG WHERE DISCONTINUED_YN='N' AND UPPER(DRUG_CODE) LIKE UPPER(?) AND UPPER(DRUG_DESC) LIKE UPPER(?)  AND LANGUAGE_ID = #";

		String bean_id = "PresRemarkForDrugBean";
		String bean_name = "ePH.PresRemarkForDrugBean";
		String mode = "";
		String params = "";
		String remarksCode = "";
		String remarksDesc = "";
		String drugCode = "";
		String drugDesc = "";
		String effStatus = "";
		String form = "";
		String routeCode = "";
		String formCode = "";
		String formDesc = "";
		String routeDesc = "";
		String route_color="", fntColor="", backgrndColor="";// added for CRF RUT-CRF-0034.1[IN:037389]

		PresRemarkForDrugBean bean = (PresRemarkForDrugBean) getBeanObject(	bean_id, bean_name, request);
		mode = request.getParameter("mode");

		bean.setRemarkscode(remarksCode);
		bean.setDrugdesc(drugDesc);
		bean.setDrugcode(drugCode);
		bean.setMode(mode);
		bean.setLanguageId(locale);
		bean.setEffstatus(effStatus);
		bean.setRemarksDesc(remarksDesc);

		params = request.getParameter("params");

		if (mode.equals("2")) {
			drugCode = request.getParameter("drug_code")==null?"":request.getParameter("drug_code");
			formCode =  request.getParameter("form_code")==null?"":request.getParameter("form_code");
			drugDesc =  request.getParameter("drug_desc")==null?"":request.getParameter("drug_desc");
			remarksDesc =  request.getParameter("remarks_desc")==null?"":request.getParameter("remarks_desc");
			effStatus =  request.getParameter("eff_status")==null?"":request.getParameter("eff_status");
			routeCode =  request.getParameter("route_code")==null?"":request.getParameter("route_code");
			formDesc =  request.getParameter("form_desc")==null?"":request.getParameter("form_desc");
			routeDesc =  request.getParameter("route_desc")==null?"":request.getParameter("route_desc");
			route_color =  request.getParameter("reoute_color")==null?"":request.getParameter("reoute_color");
			if(route_color!= null && !route_color.equals("")){ // added for CRF RUT-CRF-0034.1[IN:037389]-start
				if(route_color.length()==12){
					fntColor= route_color.substring(0, 6);
					backgrndColor= route_color.substring(6, 12);
				}
			}
			else{
				fntColor= "";
				backgrndColor= "";
			}// added for CRF RUT-CRF-0034.1[IN:037389]-end

			bean.setDrugdesc(drugDesc);
			bean.setDrugcode(drugCode);
			bean.setEffstatus(effStatus);
		}
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<!-- <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
		<script language="javascript" src="../js/PhCommon.js"></script>
		<script language="JavaScript" src="../js/PresRemarkForDrug.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown="lockKey()" topmargin="0">
		<form name="PresRemarkForDrugHeaderForm" id="PresRemarkForDrugHeaderForm">
			<table cellpadding="0" cellspacing="3" width="100%" align="center"
				border="0">
				<tr>

					<td align="right" class="label"><fmt:message key="Common.Drug.label" bundle="${ph_labels}" /></td>
					<td align="left"><input type="text" name="drugSearch" id="drugSearch" maxlength="60" size="40" onKeyPress=" charsCapsSpaceDotCamasOnly()" value="<%=drugDesc%>"><input type="button" class="button"	value="?" name="DrugSearch_lookup" id="DrugSearch_lookup"	onClick="searchDrug(document.PresRemarkForDrugHeaderForm.drugSearch)">
					<img src="../../eCommon/images/mandatory.gif" align="center"> <input type="hidden" name="drug_code" id="drug_code" value="<%=drugCode%>">
				</tr>
				<tr>
					<td align="right" class="label"><fmt:message key="ePH.Form.label"
						bundle="${ph_labels}" /></td>
					<td align="left" colspan="2"><input type="text" name="Forms" id="Forms"
						maxlength="60" size="20" disabled value="<%=formDesc%>"></td>
					<input type="hidden" name="form_code" id="form_code" value="<%=formCode%>">

				</tr>
				<tr>
					<td align="right" class="label"><fmt:message key="Common.Route.label" bundle="${common_labels}" /></td>
					<td align="left" colspan="2">
<%
					if (mode.equals("1")) {
%>
						<select name="route" id="route" width="20" style="width: 140px">
						</select> 
<%
 					}
					else {
%>
						<input type="text" name="routeDesc" id="routeDesc" style='color:<%=fntColor%>;background-color:<%=backgrndColor%>;' maxlength="60" size="20" value="<%=routeDesc%>"> 
						<input type="hidden" name="route" id="route"	value="<%=routeCode%>"> 
<%
			 		}
%>
					</td>
					<input type="hidden" name="route_code" id="route_code" value="<%=routeCode%>">
				</tr>
				<tr>
					<td align="right"></td>
					<td align="center"><!-- code added by 667 for search --> <input type="button" class="button" name="search" id="search" colspan="1"
						value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'
						onclick="getSearchResult(document.PresRemarkForDrugHeaderForm.form_code);">
					</td>
				</table>
				<input type="hidden" name="language_id" id="language_id" value="<%=locale%>"> 
				<input type="hidden" name="mode" id="mode" value="<%=mode%>"> 
				<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>"> 
				<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>"> 
				<input type="hidden" name="sql_Pres_Remark_for_drug_LookUp" id="sql_Pres_Remark_for_drug_LookUp" value="<%=sql_Pres_Remark_for_drug_LookUp%>">
			</form>
			<script>
<% 
			if(mode.equals("2")) { 
%>
				document.PresRemarkForDrugHeaderForm.search.click();
<% 
			}
%>
			</script>
		</body>
<%
		putObjectInBean(bean_id, bean, request);
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>
</html>

