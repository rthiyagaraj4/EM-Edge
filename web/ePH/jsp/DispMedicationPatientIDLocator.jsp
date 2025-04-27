<!DOCTYPE html>

  <%--corrected on 10/25/2005--%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
<head>
	<%
	 request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String login_user	=	(String)session.getValue("login_user");
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
 <script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../ePH/js/DispMedication.js"></script>
	
</head>
<%	
	String bean_id = "DispMedicationBean" ;
	String bean_name = "ePH.DispMedicationBean";
	DispMedicationBean bean = (DispMedicationBean)getBeanObject( bean_id, bean_name, request ) ;
	String disp_locn_catg = bean.getDispLocnCatg();
    
	String disp_stage = bean.getDispStage();
	String fill_list = bean.getFillList();
    String disp_locn_code	 = bean.getDispLocnCode();
	String priority = bean.getPriority();
	//SKR-CRF-017 - Ability to display selected priority which was selected in search criteria on dispense medication screen.
    String customer_id = "SKR";//bean.getCustomerID();
	//Ability to display selected priority - SKR-CRF-017
%>
<body onMouseDown="" onKeyDown="lockKey()"  topmargin="0">
<form name="frmPatientIDLocator" id="frmPatientIDLocator" >
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" id="patient_id_locator_table" > 
	<tr>
		<td  class="white" ><input style="color:red;"  type="text" name="patient_id_locator" id="patient_id_locator" size="10" maxlength="<%=bean.getPatientIDLength()%>" value='<fmt:message key="ePH.EnterPatientIDTo.label" bundle="${ph_labels}"/>' onFocus="this.value=''"  onkeydown="PresskeylocatePatientID(event);" onKeyPress="uppercase()" onBlur="clearTextFromPatientIdLocator()"><input type="button" value='<fmt:message key="ePH.Locate.label" bundle="${ph_labels}"/>' class="button" name="btnLocate"  id="btnLocate" style="font-size:9" onClick="locatePatientID()">
		<label style="font-size:9">
		<b>
			<%
			/*
				SKR-CRF-017 - Ability to display selected priority which was selected in search criteria on dispense medication screen.
			*/
				if(customer_id.equals("SKR") && disp_locn_catg != null && disp_locn_catg.equals("O") && priority!=null && !priority.equals("")){
			%>
					<fmt:message key="Common.priority.label" bundle="${common_labels}"/>-
			<%
					if( priority.equals("U")){
			%>
						<fmt:message key="Common.urgent.label" bundle="${common_labels}"/>
			<%
					}
					else if(priority.equals("R")){
			%>
						<fmt:message key="Common.routine.label" bundle="${common_labels}"/>
			<%
					}
				}
			/*
				SKR-CRF-017 - Ability to display selected priority which was selected in search criteria on dispense medication screen.
			*/
			%>
			</b>
			</label>
		</td>
		<td  class="white" ><input type="image" src="../../ePH/images/max.gif" onClick="return checkRestoreChanges('<%=disp_locn_catg%>','<%=login_user%>','<%=disp_stage%>','<%=disp_locn_code%>')" name="bt" id="bt" height="20" title="Restore Down" style="display:none"></td>

	</tr>
</table>
<input type="hidden" name="disp_locn_catg" id="disp_locn_catg" value="<%=disp_locn_catg%>">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getSFunctionId()%>">
<input type="hidden" name="fill_list" id="fill_list" value="<%=fill_list%>"><!--Added for MMS Internal Testing-->
</form>
</body>
<script language="javascript">
	expand();
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</html>
<%
//putObjectInBean(bean_id,bean,request);
%>

