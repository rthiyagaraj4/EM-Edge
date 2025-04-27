<!DOCTYPE html>
	<!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>

<% 
	request.setCharacterEncoding("UTF-8");
		String locale = (String) session.getAttribute("LOCALE");
		String facility_id = (String) session.getValue( "facility_id" ); //added for the incident num:25860


String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
	<script language="javascript" src="../../ePH/js/PhMessages.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/DispMedication.js"></SCRIPT>
    <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<title><fmt:message key="ePH.VerifyPrescriptionsLogin.label" bundle="${ph_labels}"/></title>
</HEAD>

<%
	String disp_locn_details = request.getParameter("disp_locn_details");
	
	disp_locn_details=java.net.URLDecoder.decode(disp_locn_details,"UTF-8");
	String bean_id = "DispMedicationBean" ;
	String bean_name = "ePH.DispMedicationBean";
	DispMedicationBean bean = (DispMedicationBean)getBeanObject(bean_id,bean_name ,request) ;
	ArrayList result = bean.checkToProceed(facility_id.trim(),"VerifyPrescriptions");  //Added for the incident num:25860 on 25/JAN/2011
	String homepage			= request.getParameter("homepage")==null?"":request.getParameter("homepage"); //Added for Bru-HIMS-CRF-073 [IN:029939]
	String store_code			= request.getParameter("store_code")==null?"": request.getParameter("store_code"); //Added for Bru-HIMS-CRF-073 [IN:029939]
	disp_locn_details=(String)result.get(0); //Added for 25860
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
	}
	else{
		disableDispLocn = "";
	}
	if(homepage.equals("Y")){ //Added for Bru-HIMS-CRF-073 [IN:029939]
		bean.setDispLocnCode(store_code);
	}
	String strCatg ="";	 //This variable define globally for ML-BRU-SCF-0097[31836]
	Hashtable param_legends = bean.getLegendsFromParam();
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="focusInToPassword('<%=normalLogin%>')">
<form name="frmDispMedicationLogin" id="frmDispMedicationLogin">
<table cellpadding="0" cellspacing="0" width="102%" align="center" border="0" >
<tr><td colspan="2">&nbsp;</tr>
<tr>
	<td align="right" class="label"><fmt:message key="Common.username.label" bundle="${common_labels}"/></td>
	<td>&nbsp;&nbsp;
		<input type="user_name" name="user_name" id="user_name" size="55" maxlength="60" value="<%=bean.getUserName()%>" readOnly>
	</td>
</tr>
<tr>
	<td align="right" class="label"><fmt:message key="Common.password.label" bundle="${common_labels}"/></td>
	<td>&nbsp;&nbsp;
		<input type="password" name="password" id="password" size="55" maxlength="60" onKeyPress="uppercase()" value="<%=password%>" <%=passwordDisable%>>
		<img src="../../eCommon/images/mandatory.gif" align="center"></img>
	</td>
</tr>
<tr>
	<td align="right" class="label"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
	<td align="left">&nbsp;&nbsp;
		<select name="disp_locn" id="disp_locn" onChange="getDrugCatg(this);getApplicableDispStage(disp_locn_category)"  <%=disableDispLocn%>> <!-- add function 'getApplicableDispStage(disp_locn_category)' for  ML-BRU-SCF-0097[31836]-->
		<%	
			if (no_of_disp_locns > 1){
		%>
			<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
		<%
			}
			String disp_locn = "";
			String selectDispLocation = "";
			StringTokenizer st_disp_locn = null;
			String strdisp_locn_code = "";
			String disp_locn_name = "", curr_enc_financial_dtl_yn="";
			while (stdisp_locn_details.hasMoreTokens()){
				disp_locn = stdisp_locn_details.nextToken();
				selectDispLocation = "";
				st_disp_locn = new StringTokenizer(disp_locn,",");
				strdisp_locn_code = st_disp_locn.nextToken();
				if(!(bean.getPassword()).equals("") || homepage.equals("Y")){  //Added || homepage.equals("Y") for Bru-HIMS-CRF-073 [IN:029939]
					if((strdisp_locn_code).equals(bean.getDispLocnCode())){
						selectDispLocation="selected";
					}
					else{
						selectDispLocation="";
					}
				}
				disp_locn_name = st_disp_locn.nextToken();
				st_disp_locn.nextToken();
%>
				<option value="<%=strdisp_locn_code%>" <%=selectDispLocation%> ><%=disp_locn_name%></option>		
<%
			}
			stdisp_locn_details = new StringTokenizer(disp_locn_details,"|");
			while (stdisp_locn_details.hasMoreTokens()){
				disp_locn			= stdisp_locn_details.nextToken();
				selectDispLocation	= "";
				st_disp_locn		= new StringTokenizer(disp_locn,",");
				strdisp_locn_code	= st_disp_locn.nextToken();
				st_disp_locn.nextToken();
				st_disp_locn.nextToken();
				curr_enc_financial_dtl_yn = st_disp_locn.nextToken();
%>
				<input type='hidden' name='dispFinDtl_<%=strdisp_locn_code%>' id='dispFinDtl_<%=strdisp_locn_code%>' value='<%=curr_enc_financial_dtl_yn%>'>
<%
			}
		%>
		</select>
		<img src="../../eCommon/images/mandatory.gif" align="center"></img>
	</td>	
</tr>
<tr>
	<td align="right" class="label"><fmt:message key="Common.category1.label" bundle="${common_labels}"/></td>
	<%
		String disableDispLocnCatg="";
		if(normalLogin.equals("N")){
			disableDispLocnCatg = "disabled";
		}
	%>
	<td align="left" >&nbsp;&nbsp;
		<select name="disp_locn_category" id="disp_locn_category" onChange="getApplicableDispStage(this.value);" <%=disableDispLocnCatg%>>
		<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
		<%
			if(normalLogin.equals("N")){
				 strCatg= bean.getDispLocnCatg();
				} // Condition closed for  ML-BRU-SCF-0097[31836]
			if(strCatg!=null && strCatg.equals("O")){
		%>
				<option value="I"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option><!-- add this for  ML-BRU-SCF-0097[31836]-->
				<option value="O" selected><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
		<%
				}else {
		%>
				<option value="I" selected><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
				<option value="O" ><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option><!-- add this for  ML-BRU-SCF-0097[31836]-->
		<%
				}
			
		%>
		</select>
		<img src="../../eCommon/images/mandatory.gif" align="center"></img>
	</td>
</tr>
<tr>
	<td align="right" class="label"><fmt:message key="ePH.DispenseStage.label" bundle="${ph_labels}"/></td>
	<td align="left"class="label" >&nbsp;&nbsp;
		<b> <%=param_legends.get("V")%> </b>
	</td> 	
</tr>
<tr><td colspan="2">&nbsp;</tr>
<tr>
	<td align="right" colspan="2" class="white">
		<input type="button" class="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="getApplicableDispStage(disp_locn_category); showQueryCriteria();">	 <!-- called getApplicableDispStage(disp_locn_category) for  ML-BRU-SCF-0097[31836] reopen-->
		<input type="button" class="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick="goHome()">&nbsp;&nbsp;&nbsp;
	</td>	
</tr>
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
</form>
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
	putObjectInBean(bean_id,bean,request);
%>	
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</html>

