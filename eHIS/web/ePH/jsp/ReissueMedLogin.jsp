<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<HTML>
	<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
<%
		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale			= (String)session.getAttribute("LOCALE");
		String facility_id = (String) session.getValue( "facility_id" ); //added for the incident num:26057
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
		<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/ReissueMed.js"></SCRIPT>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title><fmt:message key="ePH.ReissueMedicationLogin.label" bundle="${ph_labels}"/></title>
	</HEAD>
<% 
	String disp_locn_details = (String)request.getParameter("disp_locn_details")==null?"":(String)request.getParameter("disp_locn_details");
	disp_locn_details=java.net.URLDecoder.decode(disp_locn_details,"UTF-8");
	String bean_id		= "ReissueMedBean" ;
	String bean_name	= "ePH.ReissueMedBean";
	ReissueMedBean bean = (ReissueMedBean)getBeanObject( bean_id,bean_name,request) ;
	ArrayList result = bean.checkToProceed(facility_id.trim(),"Reissue Medication"); //added 26057
	disp_locn_details=(String)result.get(0); //added 26057
	bean.setLanguageId(localeName);
	String password			= "";
	String passwordDisable	="";
	bean.setDispLocnDetails(disp_locn_details); 
	/*StringTokenizer stdisp_locn_details = new StringTokenizer(disp_locn_details,",");
	int no_of_disp_locns	= stdisp_locn_details.countTokens();
	String disableDispLocn	= "";
	if(no_of_disp_locns==1){
		disableDispLocn		= "disabled";
	}else{
		disableDispLocn		= "";
	} */
	String homepage			= request.getParameter("homepage")==null?"":request.getParameter("homepage"); //Added for Bru-HIMS-CRF-073 [IN:029939] -start
	String store_code			= request.getParameter("store_code")==null?"": request.getParameter("store_code"); 
%>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="focusInToPassword('Y')">
		<form name="frmReissueMedLogin" id="frmReissueMedLogin">
			<table cellpadding="0" cellspacing="0" width="102%" align="center" border="0" >
				<tr><td colspan="2">&nbsp;</tr>
				<tr>
					<td align="right" class="label"><fmt:message key="Common.username.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;
						<input type="user_name" name="user_name" id="user_name" size="25" maxlength="30" value="<%=bean.getUserName()%>" readOnly>
					</td>
				</tr>
				<tr>
					<td align="right" class="label"><fmt:message key="Common.password.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;
						<input type="password" name="password" id="password" size="25" maxlength="30" value="<%=password%>" <%=passwordDisable%>>
						<img src="../../eCommon/images/mandatory.gif" align="center"></img>
					</td>
				</tr>
				<tr>
					<td align="right" class="label"><fmt:message key="Common.category.label" bundle="${common_labels}"/></td>
					<td align="left" >&nbsp;&nbsp;
						<select name="Patient_Category" id="Patient_Category" onChange="populateDispLocn()">	
							<option value="O" ><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
							<option value="I" ><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
						</select>
						<img src="../../eCommon/images/mandatory.gif" align="center"></img>
					</td>
				</tr>
				<tr>
					<td align="right" class="label"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
					<td align="left">&nbsp;&nbsp;
						<select name="disp_locn" id="disp_locn"   onChange="storeDesc(this)">
						
						</select>
						<img src="../../eCommon/images/mandatory.gif" align="center"></img>
					</td>	
				</tr>
				<tr><td colspan="2">&nbsp;</tr>
				<tr>
					<td align="right" colspan="2" class="white">
						<input type="button" class="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="showQueryCriteria(document.frmReissueMedLogin)">	
						<input type="button" class="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'  onclick="goHome()">&nbsp;&nbsp;&nbsp;
					</td>	
				</tr>
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
		</form>
		<% putObjectInBean(bean_id,bean,request); %>
		<script>populateDispLocn('<%=homepage%>', '<%=store_code%>');</script>
	</body>
</html>

