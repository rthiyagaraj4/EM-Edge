<!DOCTYPE html>
<!--
Sr No        Version           Incident             SCF/CRF             Developer Name
--------------------------------------------------------------------------------------
1	   		 V211118            23078	      PMG2021-COMN-CRF-0076.1      Mohana Priya
-->
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" %>



<HTML>
<HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>	
		<title><fmt:message key="eBL.PKGADHOCDISC.label" bundle="${bl_labels}" /></title>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>	
		<script language='javascript' src='../../eBL/js/PkgAdhocDiscount.js'></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language="JavaScript" src="../../eBL/js/MaintainTreamentPackage.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<%		   			
		String params = request.getQueryString() ;
		if(params==null || params.equals("")) params="";
		//String url = "../../eCommon/jsp/MstCodeToolbar.jsp?home_required_yn=Y";
		//String source = url + params ;

%>	
		<!-- <iframe name="test" id="test" id="test" src='../../eBL/jsp/MainTreatAdhocDisc.jsp'  frameborder=0 scrolling='no' noresize></iframe> -->
			<iframe name='PkgAdhocDiscountPatientHdr' id='PkgAdhocDiscountPatientHdr' id="PkgAdhocDiscountPatientHdr" src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:6vh;width:100vw'></iframe>
			<iframe name='PkgAdhocDiscountDetails' id='PkgAdhocDiscountDetails' src=' ManiTrtPkgPkgAdhocDiscountDetails.jsp?<%=params%>' frameborder=0 scrolling='no' noresize style='height:85vh;width:100vw'></iframe>
			<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:9vh;width:100vw'></iframe>
		
			
		<input type='hidden' name='params' id='params' id='params' value='<%=params%>' />
</HTML>

