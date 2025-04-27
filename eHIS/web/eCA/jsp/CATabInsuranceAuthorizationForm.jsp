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

<%@ page import="java.sql.*,webbeans.eCommon.*,eCA.*,eCA.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<title><fmt:message key="eCA.InsuranceAuthorizationForm.label" bundle="${ca_labels}"/></title>
	
	<%
        
	    String locale			= (String)session.getAttribute("LOCALE");
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";		
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String bean_id="CAInsurenceAuthorizationFormsBean";
		String bean_name="eCA.CAInsurenceAuthorizationFormsBean";
		String encounterid = request.getParameter("encounterid")==null?"":request.getParameter("encounterid");
		String patientid = request.getParameter("patientid")==null?"":request.getParameter("patientid");
		CAInsurenceAuthorizationFormsBean bean = (CAInsurenceAuthorizationFormsBean)getBeanObject( bean_id,bean_name,request);
		try{
			String count= bean.getInsurenceFormsCount(patientid,encounterid);
			String facility_id = bean.getFacility_id(patientid,encounterid);
			if(!count.equals("0")){
			%>
				<iframe name="f_query_result" id="f_query_result" frameborder="0" scrolling="no" noresize src="../../eCA/jsp/CATabInsuranceAuthorizationFormDetails.jsp?patientid=<%=patientid%>&encounterid=<%=encounterid%>&facility_id=<%=facility_id%>" style="height:100vh;width:100vw"></iframe><iframe name="f_query_print" id="f_query_print" SCROLLING="NO" FRAMEBORDER="0" NORESIZE SRC="../../eCA/jsp/CAInsuranceAuthorizationFormPrint.jsp" style="height:0%;width:100vw"></iframe>
			<%}else{ %>
				<TABLE width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
					<TR>
						<TD align="center" valign="middle" class="label" style="text-align:center"><fmt:message key="eCA.notInsurencePatient.label" bundle="${ca_labels}"/></TD>
					</TR>
				</TABLE>		
			<%}				
		}catch ( Exception e ) {
			e.printStackTrace() ;
		}
		%>
</html>

