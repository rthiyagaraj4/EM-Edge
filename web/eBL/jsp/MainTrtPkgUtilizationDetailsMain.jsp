<!DOCTYPE html>
<!-- 
Sr No        Version           Incident             SCF/CRF             Developer Name
--------------------------------------------------------------------------------------
1           		          		      PMG2021-COMN-CRF-0076      PalaniNarayanan
 -->

<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>


 <title>Utilization Report</title>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>	<script language='javascript' src='../../eBL/js/PkgUtilization.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%		   			
	String params = request.getQueryString() ;
	if(params==null || params.equals("")) params="";
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String source = url + params ;

%>		
	<iframe name='PkgUtilizationPatientHdr' id='PkgUtilizationPatientHdr' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:6vh;width:100vw'></iframe>
		<iframe name='MainTrtPkgUtilizationServDtlsForPatient.jsp' id='MainTrtPkgUtilizationServDtlsForPatient.jsp' src='MainTrtPkgUtilizationServDtlsForPatient.jsp?<%=params%>' frameborder=0 scrolling='auto' noresize style='height:90vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:4vh;width:100vw'></iframe>
	
</HTML>

