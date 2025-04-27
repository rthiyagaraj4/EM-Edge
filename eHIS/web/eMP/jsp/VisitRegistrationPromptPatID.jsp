<!DOCTYPE html>
<!--    Function Name VisitRegistration
    Created by M.Sathis Kumar on 13/12/2000 -->

<%@ page import ="java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
    <head>
        <meta http-equiv="Expires" content="0">
        <title><fmt:message key="eMP.EnterPatientID.label" bundle="${mp_labels}"/></title>
		<%
            String sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		  	request.setCharacterEncoding("UTF-8");

%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
        
       
		<%
            String gen_file_yn      = request.getParameter("gen_file_yn")==null?"":request.getParameter("gen_file_yn");
            String q_clinic_code    = request.getParameter("q_clinic_code")==null?"":request.getParameter("q_clinic_code");
            String q_appt_ref_no    = request.getParameter("q_appt_ref_no")==null?"":request.getParameter("q_appt_ref_no");
            String q_from_funct = request.getParameter("q_from_funct")==null?"":request.getParameter("q_from_funct"); 
            String q_booking_ref_no = request.getParameter("q_booking_ref_no")==null?"":request.getParameter("q_booking_ref_no");
			String q_booking_type = request.getParameter("q_booking_type")==null?"":request.getParameter("q_booking_type");
			
            String p_referral_id    = request.getParameter("p_referral_id")==null?"":request.getParameter("p_referral_id");

            String func_act = request.getParameter("func_act")==null?"":request.getParameter("func_act");
            String fromVR = request.getParameter("from_VR");
            
            if(fromVR == null)  fromVR= "" ;
			String calledFrom         = request.getParameter("calledFrom");
			if(calledFrom==null) calledFrom =""; 
			String Unregpatbkgyn         = request.getParameter("Unregpatbkgyn");
			if(Unregpatbkgyn==null) Unregpatbkgyn ="N"; 

			String function_id=(request.getParameter("function_id") == null)?"":request.getParameter("function_id");
       %>
    </head>
    <iframe name='prompt_patidf1' id='prompt_patidf1' src='../../eMP/jsp/VisitRegistrationPromptPatIDF1.jsp?q_booking_ref_no=<%=q_booking_ref_no%>&q_from_funct=<%=q_from_funct%>&gen_file_yn=<%=gen_file_yn%>&calledFrom=<%=calledFrom%>&Unregpatbkgyn=<%=Unregpatbkgyn%>&q_clinic_code=<%=q_clinic_code%>&q_appt_ref_no=<%=q_appt_ref_no%>&p_referral_id=<%=p_referral_id%>&func_act=<%=func_act%>&fromVR=<%=fromVR%>&q_booking_type=<%=q_booking_type%>&function_id=<%=function_id%>' frameborder=0 scrolling='no' noresize style='height:80vh;width:100vw'></iframe>
        <iframe name='prompt_patidf2' id='prompt_patidf2' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:10vh;width:100vw'></iframe>
    <body onKeyDown ='lockKey()'>
        <form name="promptpatid1" id="promptpatid1">

			<input type="hidden" name="gen_file_yn" id="gen_file_yn" value="<%=gen_file_yn%>">
            <input type="hidden" name="q_clinic_code" id="q_clinic_code" value="<%=q_clinic_code%>">
            <input type="hidden" name="q_appt_ref_no" id="q_appt_ref_no" value="<%=q_appt_ref_no%>">
            <input type="hidden" name="q_from_funct" id="q_from_funct" value="<%=q_from_funct%>">
            <input type="hidden" name="q_booking_ref_no" id="q_booking_ref_no" value="<%=q_booking_ref_no%>">
			<input type="hidden" name="q_booking_type" id="q_booking_type" value="<%=q_booking_type%>">

        </form>
    </body>
</html>

