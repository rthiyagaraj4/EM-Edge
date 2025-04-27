<!DOCTYPE html>
<!--
-----------------------------------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------------------------------
09/01/13      100         Bmohankumar  created
-----------------------------------------------------------------------------------------------
-->
<!--
Sr No       Version             Incident              SCF/CRF                        Developer Name
1 			 V221227			33882				TH-KW-CRF-0084					Mohanapriya
2			V230814								NMC-JD-CRF-0102.2					Mohanapriya
-----------------------------------------------------------------------------------------------
-->

<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*, eBL.* ,eBL.Common.*,eCommon.Common.*" %>

<HTML>   

 
<HEAD>  
</HEAD>    
<!--
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link> 
-->
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
		<script language="javascript" src='../../eBL/js/BillingRecordApprovalScript.js'></script>		  
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
<%
			String params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
			String function_id=request.getParameter("function_id");
			if(function_id==null || function_id.equals("")) function_id="";
			System.err.println("function_id "+function_id);
			System.err.println("params "+params);
			//Added V221227
			String calledForm = (String) request.getParameter("calledForm");
			if(calledForm == null) {
				calledForm = "";
			}
			System.err.println("calledForm,BillingRecordapproval.jsp "+calledForm);
			String url ="";
			String title="";
			if(calledForm.equals("ApprStsTrack") || calledForm.equals("preAuthStsTrack")){//V230814
				url = "../../eCommon/jsp/MstCodeToolbar.jsp?home_required_yn=N&" ;
				title=request.getParameter("title");
			}else{
				url = "../../eCommon/jsp/MstCodeToolbar.jsp?home_required_yn=Y&" ;
			}
			//Added V221227
			String source = url + params ;

if(calledForm.equals("ApprStsTrack") || calledForm.equals("preAuthStsTrack")){
%>
<title><%=title%></title>
<% } %>

			 <iFRAME name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:7vh;width:100vw'></iFRAME>
			 <iFRAME name='BillingRecordApproval' id='BillingRecordApproval' 	src='../../eBL/jsp/BillingRecordApprovalMainFrames.jsp?<%=params%>' frameborder=0 scrolling='no' noresize style='height:83vh;width:100vw'></iFRAME>
			<!--<FRAME name='BillingRecordApproval' id='BillingRecordApproval' 	src='BillingAgeLimitSetUp.jsp' frameborder=0 scrolling='auto' noresize>--> 
			<!-- <FRAME name='BillingRecordApproval' id='BillingRecordApproval' 	src='BillingReportCriteria.jsp' frameborder=0 scrolling='auto' noresize>-->  
			<iFRAME name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:8vh;width:100vw'></iFRAME>




</HTML>  

