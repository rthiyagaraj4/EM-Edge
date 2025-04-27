
<!--
Sr No       Version             Incident              SCF/CRF                        Developer Name
1 			V201022             IN73702            NMC-JD-CRF-0042.1         			Shikha Seth
2 			 V221227			33882				TH-KW-CRF-0084					Mohanapriya
3			V230814								NMC-JD-CRF-0102.2					Mohanapriya
-----------------------------------------------------------------------------------------------
-->

<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<HTML>
<HEAD>
</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		String calledForm = (String) request.getParameter("calledForm");//Added By Aravindh/11-04-2018/MMS-DM-CRF-0125
		if(calledForm == null) {
			calledForm = "";
		}
		System.err.println("calledForm "+calledForm);
		//V221227
		String params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
		System.err.println(params);
		//V221227
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

<%
	if(calledForm.equals("serviceApprStatus")) {
%>
	<iframe name='recordApprovalSearch' id='recordApprovalSearch'	src='BillingRecordApprovalSearch.jsp?calledForm=<%=calledForm %>'  frameborder=0 scrolling='no' noresize style='height:21vh;width:100vw'></iframe>
		<iframe name='recordApprovalPatientDataDetails' id='recordApprovalPatientDataDetails' 	src='../../eCommon/html/blank.html' frameborder=0  noresize style='height:40vh;width:100vw'></iframe>
		<iframe name='recordApprovalPatientDataBtn' id='recordApprovalPatientDataBtn' 	src='../../eCommon/html/blank.html' frameborder=0  noresize style='height:0vh;width:100vw'></iframe>
		<iframe name='recordPreApprovalRecordDetails' id='recordPreApprovalRecordDetails' 	src='../../eCommon/html/blank.html' frameborder=0  noresize style='height:15vh;width:100vw'></iframe>
		<iframe name='recordPreApprovalRecordBtn' id='recordPreApprovalRecordBtn' 	src='../../eCommon/html/blank.html' frameborder=0  noresize style='height:5vh;width:100vw'></iframe>
	
<%
	//V201022 start
	} else if(calledForm.equals("serviceApprStatusReport")) {
%>
	<iframe name='recordApprovalSearch' id='recordApprovalSearch'	src='BillingRecordApprovalSearch.jsp?calledForm=<%=calledForm %>'  frameborder=0 scrolling='no' noresize style='height:21vh;width:100vw'></iframe>
		<iframe name='recordApprovalPatientDataDetails' id='recordApprovalPatientDataDetails' 	src='../../eCommon/html/blank.html' frameborder=0  noresize style='height:40vh;width:100vw'></iframe>
		<iframe name='recordApprovalPatientDataBtn' id='recordApprovalPatientDataBtn' 	src='../../eCommon/html/blank.html' frameborder=0  noresize style='height:0vh;width:100vw'></iframe>
		<iframe name='recordPreApprovalRecordDetails' id='recordPreApprovalRecordDetails' 	src='../../eCommon/html/blank.html' frameborder=0  noresize style='height:30vh;width:100vw'></iframe>
		<iframe name='recordPreApprovalRecordBtn' id='recordPreApprovalRecordBtn' 	src='../../eCommon/html/blank.html' frameborder=0  noresize style='height:5vh;width:100vw'></iframe>
			
<%
	//V201022 end
	}
	else if(calledForm.equals("ApprStsTrack") || calledForm.equals("preAuthStsTrack")) {//V230814
%>
	<iframe name='recordApprovalSearch' id='recordApprovalSearch'	src='BillingRecordApprovalSearch.jsp?<%=params %>'  frameborder=0 scrolling='no' noresize style='height:21vh;width:100vw'></iframe>
		<iframe name='recordApprovalPatientDataDetails' id='recordApprovalPatientDataDetails' 	src='../../eCommon/html/blank.html' frameborder=0  noresize style='height:37vh;width:100vw'></iframe>
		<iframe name='recordApprovalPatientDataBtn' id='recordApprovalPatientDataBtn' 	src='../../eCommon/html/blank.html' frameborder=0  noresize style='height:5vh;width:100vw'></iframe>
		<iframe name='recordPreApprovalRecordDetails' id='recordPreApprovalRecordDetails' 	src='../../eCommon/html/blank.html' frameborder=0  noresize style='height:30vh;width:100vw'></iframe>
		<iframe name='recordPreApprovalRecordBtn' id='recordPreApprovalRecordBtn' 	src='../../eCommon/html/blank.html' frameborder=0  noresize style='height:5vh;width:100vw'></iframe>
			
<%
	//V221227 end
	} else {
%>
	<iframe name='recordApprovalSearch' id='recordApprovalSearch'				src='BillingRecordApprovalSearch.jsp'  frameborder=0 scrolling='no' noresize style='height:21vh;width:100vw'></iframe>
		<iframe name='recordApprovalPatientDataDetails' id='recordApprovalPatientDataDetails' 	src='../../eCommon/html/blank.html' frameborder=0  noresize style='height:37vh;width:100vw'></iframe>
		<iframe name='recordApprovalPatientDataBtn' id='recordApprovalPatientDataBtn' 	src='../../eCommon/html/blank.html' frameborder=0  noresize style='height:5vh;width:100vw'></iframe>
		<iframe name='recordPreApprovalRecordDetails' id='recordPreApprovalRecordDetails' 	src='../../eCommon/html/blank.html' frameborder=0  noresize style='height:30vh;width:100vw'></iframe>
		<iframe name='recordPreApprovalRecordBtn' id='recordPreApprovalRecordBtn' 	src='../../eCommon/html/blank.html' frameborder=0  noresize style='height:5vh;width:100vw'></iframe>
	
<%
	}
%>
</HTML>

