<!DOCTYPE html>
  <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<!-- 	<script language="javascript" src="../../ePH/js/PhMessages.js"></script>
 -->	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/DispMedication.js"></SCRIPT>
    <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<title><fmt:message key="ePH.PrepareAdmixtureLogin.label" bundle="${ph_labels}"/></title>
</HEAD>

<%
	String disp_locn_details = request.getParameter("disp_locn_details");

	String bean_id = "DispMedicationBean" ;
	String bean_name = "ePH.DispMedicationBean";
	DispMedicationBean bean = (DispMedicationBean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);
	String normalLogin="Y";
	String password = "";
	String passwordDisable="";
	if(!(bean.getPassword()).equals("")){
		normalLogin="N";
		password = bean.getPassword();
		passwordDisable = "disabled";
	}
	bean.setDispLocnDetails(disp_locn_details);
	StringTokenizer stdisp_locn_details = new StringTokenizer(disp_locn_details,"|");
	int no_of_disp_locns = stdisp_locn_details.countTokens();
	String disableDispLocn = "";
	if(no_of_disp_locns==1){
		disableDispLocn = "disabled";
	}else{
		disableDispLocn = "";
	}

	bean.setAdmixtureIdentity("IV_CYTO_TPN");
	Hashtable param_legends = bean.getLegendsFromParam();
	bean.setFunctionIdentity("PrepareAdmixture");
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="focusInToPassword('<%=normalLogin%>')">
<form name="frmDispMedicationLogin" id="frmDispMedicationLogin">
<table cellpadding="0" cellspacing="0" width="102%" align="center" border="0" >
<tr><td colspan="2">&nbsp;</tr>
<tr>
	<td class="label"><fmt:message key="Common.username.label" bundle="${common_labels}"/></td>
	<td>&nbsp;&nbsp;
		<input type="user_name" name="user_name" id="user_name" size="55" maxlength="60" value="<%=bean.getUserName()%>" readOnly>
	</td>
</tr>
<tr>
	<td class="label"><fmt:message key="Common.password.label" bundle="${common_labels}"/></td>
	<td>&nbsp;&nbsp;
		<input type="password" name="password" id="password" size="55" maxlength="60" value="<%=password%>" <%=passwordDisable%>>
		<img src="../../eCommon/images/mandatory.gif" align="center"></img>
	</td>
</tr>
<tr>
	<td class="label"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
	<td >&nbsp;&nbsp;
		<select name="disp_locn" id="disp_locn" onChange="getDrugCatg(this);defaultStageForPrepareAdmixture(disp_locn_category)"  <%=disableDispLocn%>>
		<%	
			if (no_of_disp_locns > 1){
		%>
			<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
		<%
			}
			while (stdisp_locn_details.hasMoreTokens()){
				String disp_locn = stdisp_locn_details.nextToken();
				String selectDispLocation = "";
				StringTokenizer st_disp_locn = new StringTokenizer(disp_locn,",");
				String strdisp_locn_code = st_disp_locn.nextToken();
				if(!(bean.getPassword()).equals("")){
					if((strdisp_locn_code).equals(bean.getDispLocnCode())){
						selectDispLocation="selected";
					}else{
						selectDispLocation="";
					}
				}
				String disp_locn_name = st_disp_locn.nextToken();
		%>
			<option value="<%=strdisp_locn_code%>" <%=selectDispLocation%> ><%=disp_locn_name%></option>		
		<%
				st_disp_locn.nextToken();
			}
		%>
		</select>
		<img src="../../eCommon/images/mandatory.gif" align="center"></img>
	</td>	
</tr>
<tr>
	<td class="label"><fmt:message key="Common.category1.label" bundle="${common_labels}"/></td>
	<%
		String disableDispLocnCatg="";
		if(normalLogin.equals("N")){
			disableDispLocnCatg = "disabled";
		}
	%>
	<td>&nbsp;&nbsp;
		<select name="disp_locn_category" id="disp_locn_category" onChange="defaultStageForPrepareAdmixture(this)" <%=disableDispLocnCatg%>>
		<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
		<%
			if(normalLogin.equals("N")){
				String strCatg= bean.getDispLocnCatg();
				if(strCatg.equals("I")){
		%>
			<option value="I" selected><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
		<%
				}else if(strCatg.equals("O")){
		%>
			<option value="O" selected><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
		<%
				}
			}
		%>
		</select>
		<img src="../../eCommon/images/mandatory.gif" align="center"></img>
	</td>
</tr>
<tr>
	<td class="label"><fmt:message key="ePH.DispenseStage.label" bundle="${ph_labels}"/></td>
	<td class="label" >&nbsp;&nbsp;
		<b><label id="lbl_alloc"> <%=param_legends.get("A")%> </label></b>
		<b><label id="lbl_fill" style="display:none"> <%=param_legends.get("F")%> </label></b>
	</td> 		
</tr>
<tr><td colspan="2">&nbsp;</tr>
<tr>
	<td colspan="2" class="white">
		<input type="button" class="button" value="OK" onClick="showQueryCriteria('PrepareAdmixture')">	
		<input type="button" class="button" value="Cancel" onclick="goHome()">
	</td>	
</tr>
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="patient_class" id="patient_class" value="">
</form>
<% putObjectInBean(bean_id,bean,request); %>
</body>
<script language="javascript">
<%
	if(disableDispLocn.equals("disabled")){
%>
	getDrugCatg(document.frmDispMedicationLogin.disp_locn)
<%
	}
	if(normalLogin.equals("N")){
%>
		getDrugCatg(document.getElementById("disp_locn"));
<%
	}
%>	
	if(document.frmDispMedicationLogin.disp_locn_category.value=="I"){
		document.getElementById("lbl_alloc").style.display="none";
		document.getElementById("lbl_fill").style.display="inline";
		document.getElementById("disp_locn_category").value="I";
	}else if(document.frmDispMedicationLogin.disp_locn_category.value=="O"){
		document.getElementById("lbl_alloc").style.display="inline";
		document.getElementById("lbl_fill").style.display="none";
		document.getElementById("disp_locn_category").value="O";
	}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</html>

