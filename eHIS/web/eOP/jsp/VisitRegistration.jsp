<!DOCTYPE html>
<!--    Function Name VisitRegistration
    Created by M.Sathis Kumar on 13/12/2000 
    resident_stay_yn
for that put oper_stn_yn in ('O', 'B')
    
    -->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<html>
<head>
<title><fmt:message key="Common.RegisterVisit.label" bundle="${common_labels}"/></title>
	<%
	request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script><!--  Added for JD-CRF-0183 [IN:041353] By Dharma on 25th Nov 2013-->

	<!--Added by Ashwini on 23-Sep-2022 for TH-KW-CRF-0020.1-->
	<script src='../../eXH/js/ExternalApplication.js' language='Javascript'></script>
	<script language='javascript' src='../../eOP/js/VisitRegistration.js'></script>
	<script language='javascript' src='../../eOP/js/VisitRegistrationQuery.js'></script>
	<script language='javascript' src='../../eOP/js/VisitRegistration1.js'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src="../../eCommon/js/DateUtils.js" language="javascript"></script>
	    <script language="javascript" src="../../eOP/js/Checkblockscheduleforpract.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!--  Added for JD-CRF-0183 [IN:041353] By Dharma on 27th Nov 2013-->
	

	
<%
	
	String function_id=request.getParameter("function_id");
	String call_from     =(request.getParameter("call_from") == null)?"":request.getParameter("call_from");

    String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
    String params = request.getQueryString() ;
	int start_index = params.indexOf("&patient");
	if(start_index!=-1)
		params = params.substring(0,start_index);
	else
		params = params;	
		
    String source = url + params ; 
	
	//String queryStr	= params;	

	if(call_from.equals("CA"))
	{
		source = source+"&home_required_yn=N";
		//queryStr = queryStr+"&home_required_yn=N";		
	}	
	

	//session.putValue("queryString",queryStr);

	
	String patient     =(request.getParameter("patient") == null)?"":request.getParameter("patient");
	String q_appt_ref_no     =(request.getParameter("q_appt_ref_no") == null)?"":request.getParameter("q_appt_ref_no");
	String referral_id     =(request.getParameter("referral_id") == null)?"":request.getParameter("referral_id");
	String q_clinic_code     =(request.getParameter("q_clinic_code") == null)?"":request.getParameter("q_clinic_code");
	String q_visit_adm_type     =(request.getParameter("q_visit_adm_type") == null)?"":request.getParameter("q_visit_adm_type");
	String q_practitioner_id     =(request.getParameter("q_practitioner_id") == null)?"":request.getParameter("q_practitioner_id");
	String contact_reason_code =(request.getParameter("contact_reason_code") == null)?"":request.getParameter("contact_reason_code");
	String reason     =(request.getParameter("reason") == null)?"":request.getParameter("reason");	
	String service_code     =(request.getParameter("service_code") == null)?"":request.getParameter("service_code");	
	String q_locn_type     =(request.getParameter("q_locn_type") == null)?"":request.getParameter("q_locn_type");	
	String q_Appt_time     =(request.getParameter("q_Appt_time") == null)?"":request.getParameter("q_Appt_time");	
	String resource_class     =(request.getParameter("resource_class") == null)?"":request.getParameter("resource_class");


	%>	
    </head>

	<form name='visit_form' id='visit_form'>
		<input type='hidden' name='call_from' id='call_from' value='<%=call_from%>'>
	</form>


    <frameset rows='42,*,55' >
    <frame name='commontoolbarFrame' id='commontoolbarFrame' src='<%= source %>'  frameborder=0 scrolling='no' noresize>
    
	<%
		if(call_from.equals("CA"))
		{		 
	%>       
           <frame name='f_query_add_mod' id='f_query_add_mod' id='visit1' src='../../eOP/jsp/VisitRegistrationMain.jsp?function_id=<%=function_id%>&func_source=<%=params%>&query_string=<%=java.net.URLEncoder.encode(params,"UTF-8")%>&patient=<%=patient%>&q_appt_ref_no=<%=q_appt_ref_no%>&referral_id=<%=referral_id%>&q_clinic_code=<%=q_clinic_code%>&q_locn_type=<%=q_locn_type%>&q_Appt_time=<%=q_Appt_time%>&q_visit_adm_type=<%=q_visit_adm_type%>&q_practitioner_id=<%=q_practitioner_id%>&contact_reason_code=<%=contact_reason_code%>&reason=<%=reason%>&service_code=<%=service_code%>&resource_class=<%=resource_class%>&call_from=CA' frameborder=0 noresize scrolling='auto'>

	<%
		}
		else
		{
	%>

		 <frame name='f_query_add_mod' id='f_query_add_mod' id='visit1' src='../../eOP/jsp/VisitRegistrationMain.jsp?function_id=<%=function_id%>&func_source=<%=params%>&query_string=<%=java.net.URLEncoder.encode(params,"UTF-8")%>' frameborder=0 noresize scrolling='no'>
	<%
		}
	%>
	
    <frame name='messageFrame' id='messageFrame'  src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='no'>
   </frameset>	
   	
</html>

