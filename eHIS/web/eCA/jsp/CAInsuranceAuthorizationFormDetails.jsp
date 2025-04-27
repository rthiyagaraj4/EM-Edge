<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
12/11/2018  IN059704        PRATHYUSHA   12/11/2018          Ramesh G      AAKH-CRF-0079.2	
05/12/2018  IN069192        PRATHYUSHA   26/11/2018          Ramesh G      AAKH-CRF-0079.2										
23/12/2019  IN071639        SIVABAGYAM M 23/12/2019          Ramesh G      AAKH-CRF-0079.10
28/01/2020  IN072296       SIVABAGYAM M  28/01/2020          Ramesh G      CA-AAKH-CRF-0079.10/02-Saved Approval Number doesn't display.
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>

<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eCA.*, eCA.Common.*, eCommon.Common.*,java.text.DecimalFormat,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<title><fmt:message key="eCA.InsuranceAuthorizationForm.label" bundle="${ca_labels}"/></title>
	<head>
	<%
        request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	    String locale			= (String)session.getAttribute("LOCALE");
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCA/js/CAInsuranceAuthorizationForm.js"></script>
		<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>		
	<%
	String patientid = request.getParameter("patientid")==null?"": request.getParameter("patientid");
	String encounterid = request.getParameter("encounterid") == null ? "": request.getParameter("encounterid");
	String facility_id = (String) session.getAttribute("facility_id");
	String user_name			= (String) session.getValue( "appl_user_name" ) ;
	String login_user_id		=	(String)session.getValue("login_user");
	String bean_id="CAInsurenceAuthorizationFormsBean";
	String bean_name="eCA.CAInsurenceAuthorizationFormsBean";
	ArrayList PatientInsurenceAuthorizationDetails= new ArrayList();		
	String savedisabled=request.getParameter("savedisabled")==null?"disabled":request.getParameter("savedisabled"); //IN071639
	String printdisabled=request.getParameter("printdisabled")==null?"disabled":request.getParameter("printdisabled"); //IN071639
	CAInsurenceAuthorizationFormsBean bean = (CAInsurenceAuthorizationFormsBean)getBeanObject( bean_id,bean_name,request);
	try{	
	System.err.println("locale"+locale);
		PatientInsurenceAuthorizationDetails=bean.getPatientInsurenceAuthorizationDetails(patientid,encounterid,locale);		
		//IN071639 STARTS
		String report_id="";
		int index=0,indexSec=0;
		String approval_number= "";
		String[] primaryInsurnceList=null;  
	%>
	<BODY> 		
		<form name="formClaimFormsResult" id="formClaimFormsResult" >
			<table cellpadding="0" cellspacing="0" width="100%" height="100%" align="center" border="0">
				<tr style="height:50px;"><td>&nbsp;</td></tr>
				<tr>
					<td align="center" valign="top">
						<table cellpadding="0" cellspacing="0" width="60%" align="center" border="0">			
							
							<tr>
								<th  class='columnheader'  ><fmt:message key="eCA.InsuranceName.label" bundle="${ca_labels}"/></th>
								<th  class='columnheader'  ><fmt:message key="eCA.ApprovalNumber.label" bundle="${ca_labels}"/></th>
								<th  class='columnheader'  >&nbsp;</th>	
								<th  class='columnheader'  >&nbsp;</th>	
							</tr>
							<%for(int i=0;i<PatientInsurenceAuthorizationDetails.size();i++){
									primaryInsurnceList  = (String[])PatientInsurenceAuthorizationDetails.get(i); 
									approval_number=primaryInsurnceList[2];
									%>
								<tr>
									<td width="50%" align="left"  style=padding-left:10px valign="center"class="label"> <%=primaryInsurnceList[0]%>&nbsp; <img src='../../eCA/images/DOCUL.gif' onClick='UploadDocument()' height='20' title='View Insurance Document' > </td>					
									<td width="30%" align="left"  style=padding-left:10px valign="center"class="fields"><input type="text" name="approvalNum<%=primaryInsurnceList[1]%>" id="approvalNum<%=primaryInsurnceList[1]%>" id="approvalNum<%=primaryInsurnceList[1]%>"   size="30" maxlength="30" value="<%=approval_number%>" onFocus="enableSave('<%=i%>');" onkeypress="return CheckForSpeclChar(event);" onblur="disableSave(this,'<%=primaryInsurnceList[1]%>','<%=i%>');" onpaste="return CheckForSpecCharsWithCopyPaste(event)" ></td>
									<td width="10%" align="left" style=padding-left:10px valign="center"class="label"><input type="button" id="savedisabled<%=i%>" disabled name="savedisabled<%=i%>"  value="Save"   onclick="saveDetails('<%=primaryInsurnceList[1]%>',<%=i%>)" /></td>
									<td width="10%" align="left" style=padding-left:10px valign="center"class="label"><input type="button" id="printdisabled<%=i%>" name="printdisabled<%=i%>" value="Print"  onclick="printDetails('<%=primaryInsurnceList[1]%>')"/></td>
									 <input type="hidden" id="approval_number<%=primaryInsurnceList[1]%>" name="approval_number<%=primaryInsurnceList[1]%>" value="<%=approval_number%>" />
								</tr>
							<%}
							%>
							<tr>
								<td colspan="4">&nbsp;</td>
								<input type="hidden"  id="cnt_reports" name="cnt_reports" id="cnt_reports" value="<%=PatientInsurenceAuthorizationDetails.size()%>"/>
							</tr>							
						</table>
					</td>
				</tr>
			</table>	<!-- IN071639ends --> 		
			<input type="hidden" value="<%=patientid%>"  id="patient_id" name="patient_id" >
			<input type="hidden" value="<%=encounterid%>"  id="encounterid" name="encounterid" >	
			<input type="hidden" name="facility_id" id="facility_id"		value="<%=facility_id%>" >				
			 <input type="hidden" name="user_name" id="user_name"		value="<%=user_name%>" >
			 <input type="hidden" name="login_user_id" id="login_user_id"		value="<%=login_user_id%>" >
			  <input type="hidden" name="language_id" id="language_id"		value="<%=locale%>" >
			  <input type="hidden"  id="report_id" name=report_id" value=""/>
			  
		 
		</form>
		<!-- IN071639 STARTS  -->
		<script>
		
		</script>	
		<!-- IN071639 ENDS  -->
	</BODY>
	<%
	}catch ( Exception e ) {
		e.printStackTrace() ;
	}
	putObjectInBean(bean_id,bean,request);
	%>
</html>

