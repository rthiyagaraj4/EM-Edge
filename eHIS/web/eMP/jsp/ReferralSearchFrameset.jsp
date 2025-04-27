<!DOCTYPE html>
<!--
   		 Developed By  :- M.F.Mohamed Ali Suhail
   		 Function      :-  Referral Search (To search a referral id)
--> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.Common.*," contentType="text/html;charset=UTF-8"%>

<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/ecis.css'></link> -->
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<HEAD>
<%
	request.setCharacterEncoding("UTF-8");
	String p_calling_function	 = checkForNull(request.getParameter("p_calling_function"),"INDEPENDENT");
	
	//String function_id	 = checkForNull(request.getParameter("function_id"));
	String function_id=request.getParameter("function_id")==null?"":request.getParameter("function_id");


	if(function_id.equals("IP_PENDING_REFERRAL_BOOKING") || function_id.equals("OA_PENDING_REFERRAL_BOOKING"))
		p_calling_function = function_id;

/*
	if(p_calling_function.equals("") && function_id.equals("PENDING_REFERRAL_BOOKING"))
		p_calling_function = function_id;
	else		
		p_calling_function = "INDEPENDENT";
*/
	String ass_func_id	 = checkForNull(request.getParameter("ass_func_id"));
	String ca_patient_id=checkForNull(request.getParameter("ca_patient_id"));

	String p_patient_id	="";
	if(ca_patient_id.equals(""))
	{
		p_patient_id = 	request.getParameter("p_patient_id");
		p_patient_id = (p_patient_id==null)?"":p_patient_id;
	}
	else
	{
		p_patient_id = 	request.getParameter("ca_patient_id");
		p_patient_id = (p_patient_id==null)?"":p_patient_id;
	}

	String p_referral_id	     = 	request.getParameter("p_referral_id");
	p_referral_id			     = (p_referral_id==null)?"":p_referral_id;

	String p_from_date		     = 	request.getParameter("p_from_date");
	p_from_date				     = (p_from_date==null)?"":p_from_date;

	String p_to_date		     = 	request.getParameter("p_to_date");
	p_to_date				     = (p_to_date==null)?"":p_to_date;

	String p_from_ref_type	     = 	request.getParameter("p_from_ref_type");
	p_from_ref_type			     = (p_from_ref_type==null)?"":p_from_ref_type;

	String p_from_ref_code	     = 	request.getParameter("p_from_ref_code");
	p_from_ref_code			     = (p_from_ref_code==null)?"":p_from_ref_code;

	String p_from_locn_type	     = 	request.getParameter("p_from_locn_type");
	p_from_locn_type		     = (p_from_locn_type==null)?"":p_from_locn_type;

	String p_from_locn_code	     = 	request.getParameter("p_from_locn_code");
	p_from_locn_code		     = (p_from_locn_code==null)?"":p_from_locn_code;

	String p_from_pract_id	     = 	request.getParameter("p_from_pract_id");
	p_from_pract_id			     = (p_from_pract_id==null)?"":p_from_pract_id;

	String p_to_ref_type	     = 	request.getParameter("p_to_ref_type");
	p_to_ref_type			     = (p_to_ref_type==null)?"":p_to_ref_type;

	String p_to_ref_code	     = 	request.getParameter("p_to_ref_code");
	p_to_ref_code			     = (p_to_ref_code==null)?"":p_to_ref_code;

	String calledFrom         = request.getParameter("calledFrom");
	if(calledFrom==null) calledFrom =""; 

	String p_to_locn_type	     = 	request.getParameter("p_to_locn_type");
	p_to_locn_type			     = (p_to_locn_type==null)?"":p_to_locn_type;

	String p_to_locn_code	     = 	request.getParameter("p_to_locn_code");
	p_to_locn_code			     = (p_to_locn_code==null)?"":p_to_locn_code;

	String p_to_pract_id	     = 	request.getParameter("p_to_pract_id");
	p_to_pract_id			     = (p_to_pract_id==null)?"":p_to_pract_id;
	String p_to_pract_name=request.getParameter("p_to_pract_name");
	p_to_pract_name 			     = (p_to_pract_name==null)?"":p_to_pract_name ;
	String p_select			     = 	request.getParameter("p_select");
	p_select				     = (p_select==null)?"":p_select;
	String p_reg_patient	     = 	request.getParameter("p_reg_patient");
	p_reg_patient			     = (p_reg_patient==null)?"":p_reg_patient;
    String p_speciality_code     =  request.getParameter("p_speciality_code");
     p_speciality_code            = (p_speciality_code==null)?"":p_speciality_code;
    String p_service_code     =  request.getParameter("p_service_code");
     p_service_code            = (p_service_code==null)?"":p_service_code;
	 
	 //Added by Santhosh for MMS-DM-CRF-0209.4-US005
	 String p_service_desc = "";
	 if(ass_func_id.equals("REFERAL_REQUIRED")){
		 
		Connection con = null;
		con = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs    = null; 
				
		pstmt  = con.prepareStatement("SELECT SHORT_DESC FROM AM_SERVICE WHERE SERVICE_CODE='"+p_service_code+"'");
		rs = pstmt.executeQuery() ;
		if( rs != null ) {
			if( rs.next() ) {
				p_service_desc = checkForNull(rs.getString(1));
			}
		}
	 }
	//END
	
	 String res_class=(request.getParameter("resorce_type") == null)?"":request.getParameter("resorce_type");
	 String waitListNo=(request.getParameter("waitListNo") == null)?"":request.getParameter("waitListNo");
	  String callingMode=(request.getParameter("callingMode") == null)?"":request.getParameter("callingMode");
	if(!waitListNo.equals(""))
	{
		ca_patient_id=p_patient_id;
	}
%>
  <TITLE><fmt:message key="Common.referral.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.search.label" bundle="${common_labels}"/></TITLE>
    <%
    if((p_calling_function!=null && p_calling_function.equalsIgnoreCase("INDEPENDENT"))||(p_calling_function!=null && p_calling_function.equalsIgnoreCase("REPRINT_REF_LETTER"))) { %>
	  <iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eMP/jsp/ReferralSearchCriteria.jsp?p_calling_function=<%=p_calling_function%>&function_id=<%=function_id%>&p_patient_id=<%=p_patient_id%>&p_referral_id=<%=p_referral_id%>&p_from_date=<%=p_from_date%>&p_to_date=<%=p_to_date%>&p_from_ref_type=<%=p_from_ref_type%>&p_from_ref_code=<%=p_from_ref_code%>&p_from_locn_type=<%=p_from_locn_type%>&p_from_locn_code=<%=p_from_locn_code%>&p_from_pract_id=<%=p_from_pract_id%>&p_to_ref_type=<%=p_to_ref_type%>&calledFrom=<%=calledFrom%>&p_to_ref_code=<%=p_to_ref_code%>&p_to_locn_type=<%=p_to_locn_type%>&p_to_locn_code=<%=p_to_locn_code%>&p_speciality_code=<%=p_speciality_code%>&p_service_code=<%=p_service_code%>&p_to_pract_id=<%=p_to_pract_id%>&p_to_pract_name=<%=p_to_pract_name%>&p_select=<%=p_select%>&p_reg_patient=<%=p_reg_patient%>&res_class=<%=res_class%>&ass_func_id=<%=ass_func_id%>&ca_patient_id=<%=ca_patient_id%>&callingMode=<%=callingMode%>&p_service_desc=<%=p_service_desc%>' frameborder=0 scrolling='auto' noresize  style='height:68vh;width:99vw'></iframe>
	  <iframe name='f_query_add_mod_result' id='f_query_add_mod_result' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:32vh;width:99vw'></iframe>
	  <iframe name='validation_frame' id='validation_frame' src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:0vh;width:99vw' scrolling='no'></iframe>
       
    <% } else { %>
	  <iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eMP/jsp/ReferralSearchCriteria.jsp?p_calling_function=<%=p_calling_function%>&function_id=<%=function_id%>&p_patient_id=<%=p_patient_id%>&p_referral_id=<%=p_referral_id%>&p_from_date=<%=p_from_date%>&p_to_date=<%=p_to_date%>&p_from_ref_type=<%=p_from_ref_type%>&p_from_ref_code=<%=p_from_ref_code%>&p_from_locn_type=<%=p_from_locn_type%>&p_from_locn_code=<%=p_from_locn_code%>&p_from_pract_id=<%=p_from_pract_id%>&p_to_ref_type=<%=p_to_ref_type%>&calledFrom=<%=calledFrom%>&p_to_ref_code=<%=p_to_ref_code%>&p_to_locn_type=<%=p_to_locn_type%>&p_to_locn_code=<%=p_to_locn_code%>&p_speciality_code=<%=p_speciality_code%>&p_service_code=<%=p_service_code%>&p_to_pract_id=<%=p_to_pract_id%>&p_to_pract_name=<%=p_to_pract_name%>&p_select=<%=p_select%>&p_reg_patient=<%=p_reg_patient%>&res_class=<%=res_class%>&ass_func_id=<%=ass_func_id%>&ca_patient_id=<%=ca_patient_id%>&callingMode=<%=callingMode%>&p_service_desc=<%=p_service_desc%>' frameborder=0 scrolling='auto' style='height:68vh;width:99vw' noresize></iframe>
	  <iframe name='f_query_add_mod_result' id='f_query_add_mod_result' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:5vh;width:99vw'></iframe>
	  <iframe name='validation_frame' id='validation_frame' src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:0vh;width:99vw' scrolling='no'></iframe>
     
	<% } %>

</html>

<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
