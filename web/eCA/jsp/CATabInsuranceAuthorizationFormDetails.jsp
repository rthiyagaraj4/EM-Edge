<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      		Name        		Rev.Date				Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------------------------------
25/01/2019		IN057997			Kamalakannan G	  		25/01/2019				Ramesh G.		AAKH-CRF-0079
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>

<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eCA.*, eCA.Common.*, eCommon.Common.*,java.text.DecimalFormat,java.sql.*,webbeans.eCommon.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<title><fmt:message key="eCA.InsuranceAuthorizationForm.label" bundle="${ca_labels}"/></title>
	<head>
	<%
        request.setCharacterEncoding("UTF-8");
	    String locale			= (String)session.getAttribute("LOCALE");
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCA/js/CAInsuranceAuthorizationForm.js"></script>
		<script LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="JavaScript" src="../../eCA/js/CATabInsuranceAuthorizationForm.js"></script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>		
	<%
	String patientid = request.getParameter("patientid")==null?"": request.getParameter("patientid");
	String encounterid = request.getParameter("encounterid") == null ? "": request.getParameter("encounterid");
	String facilityid = request.getParameter("facility_id") == null ? "": request.getParameter("facility_id");
	String user_name			= (String) session.getValue( "appl_user_name" ) ;
	String login_user_id		=	(String)session.getValue("login_user");
	String bean_id="CAInsurenceAuthorizationFormsBean";
	String bean_name="eCA.CAInsurenceAuthorizationFormsBean";
	ArrayList primaryInsurnceList				= new ArrayList();	
	ArrayList seconderyInsurnceList				= new ArrayList();
	HashMap PatientInsurenceAuthorizationDetails			= new HashMap();	
	CAInsurenceAuthorizationFormsBean bean = (CAInsurenceAuthorizationFormsBean)getBeanObject( bean_id,bean_name,request);
	try{	
		PatientInsurenceAuthorizationDetails=bean.getPatientInsurenceAuthorizationDetails(patientid,encounterid,locale);	
		primaryInsurnceList=(ArrayList)PatientInsurenceAuthorizationDetails.get("primaryInsurnceList");
		seconderyInsurnceList=(ArrayList)PatientInsurenceAuthorizationDetails.get("seconderyInsurnceList");	
	%>
	<BODY> 		
		<form name="formClaimFormsResult" id="formClaimFormsResult" >
			<table cellpadding="0" cellspacing="0" width="100%" height="100%" align="center" border="0">
				<tr style="height:50px;"><td>&nbsp;</td></tr>
				<tr>
					<td align="center" valign="top">
						<table cellpadding="0" cellspacing="0" width="50%" align="center" border="0">			
								<tr>
									<th  class='columnheader'  colspan='2'><fmt:message key="eCA.BillingGroupPriorityWise.label" bundle="${ca_labels}"/></th>	
								</tr>
						<%if(primaryInsurnceList.size()>0){%>
								
								<% for(int i=0;i<primaryInsurnceList.size();i+=4){ %>
								<tr>
									<td width="50%" align="left" valign="top"class="label"><%=primaryInsurnceList.get(i+2)%></td>					
									<td width="50%" align="left" valign="top"class="label"><input type="radio" name="preority" id="preority" id="<%=primaryInsurnceList.get(i+0)%>"   value="<%=primaryInsurnceList.get(i+3)%>" onclick="myTabFunction(this.value)"  ></td>					
								</tr>
							<%	}
							}
							if(seconderyInsurnceList.size()>0){
							%>
							<% for(int i=0;i<seconderyInsurnceList.size();i+=4){ %>
							<tr>
								<td width="50%" align="left" valign="top"class="label"><%=seconderyInsurnceList.get(i+2)%></td>
								<td width="50%" align="left" valign="top"class="label"><input type="radio" name="preority" id="preority" id="<%=seconderyInsurnceList.get(i+0)%>"   value="<%=seconderyInsurnceList.get(i+3)%>" onclick="myTabFunction(this.value)"  ></td>
							</tr>
							<%	}
							}%>
							<tr>
								<td colspan="2">&nbsp;<input type="hidden" name="p_report_id" id="p_report_id" value="" >	</td>
							</tr>
							<tr> 
								<td colspan='2' align='center'>
									<input type="button" class='button' value="View"  name="View" id="View" onclick="viewDetailsInTab('<%=patientid%>','<%=encounterid%>','<%=facilityid%>')" disabled />
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>			
			<input type="hidden" value="<%=patientid%>"  name="patient_id" >
			<input type="hidden" value="<%=encounterid%>"  name="encounterid" >
        		<input type="hidden" name="facility_id" id="facility_id"		value="<%=facilityid%>" >				
			<input type="hidden" name="user_name" id="user_name"		value="<%=user_name%>" >
			<input type="hidden" name="login_user_id" id="login_user_id"		value="<%=login_user_id%>" >
			<input type="hidden" name="language_id" id="language_id"		value="<%=locale%>" >
		</form>	
	</BODY>
	<%
	}catch ( Exception e ) {
		e.printStackTrace() ;
	}
	putObjectInBean(bean_id,bean,request);
	%>
</html>

