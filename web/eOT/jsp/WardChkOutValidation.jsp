<!DOCTYPE html>
<%
//"java.sql.*, java.util.*, java.io.*, eOT.Common.*, eOT.*"
%>
<%@page   import="java.util.ArrayList,java.util.Hashtable,eOT.Common.*, eOT.*" %>
<%@page  contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%

	try {
		String func_mode	= request.getParameter("func_mode");
		Hashtable hash		= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash				= (Hashtable)hash.get( "SEARCH" ) ;
		String bean_id		= "@WardChkOutBean";
		String bean_name	= "eOT.WardChkOutBean";
		WardChkOutBean bean= (WardChkOutBean)mh.getBeanObject( bean_id, request, bean_name );

		if(func_mode!= null && func_mode.equals("clearBean")){
			bean.clear();
		}else if(func_mode!= null && func_mode.equals("updateStatusAndCommit")){
			String booking_num		= (String) hash.get("booking_num");
			String bookings_type	= (String) hash.get("bookings_type");
			String check_out_time	= (String) hash.get("check_out_time");	
			String error_text = "";
			ArrayList result_arr = new ArrayList();
			if(bookings_type.equals("S"))
				error_text = bean.updateStatusAndCommit(booking_num,check_out_time);
			else if(bookings_type.equals("R")){ // RD Exams Check-out from ward.
				result_arr = bean.updateRDExamsStatusAndCommit(booking_num);
				error_text = (String)result_arr.get(0);
			}
			if(error_text==null) error_text="";
			if(error_text!=null && error_text.equals("null")) error_text="";
			if(error_text!=null && error_text.equals("")) error_text="";
			if(bookings_type.equals("S")){
				if(!error_text.equals("") && !error_text.equals("RECORD_INSERTED"))
					out.println(error_text);
				else
					out.println("NO_ERROR_FOUND");
			}else if(bookings_type.equals("R")){
				if(error_text.equals("E")){
					out.println(error_text);
				}else
					out.println("NO_ERROR_FOUND");
			}
		}else if(func_mode!= null && func_mode.equals("getCheckListsDetails")){
			String appt_ref_num	    =	(String) hash.get("appt_ref_num");
			String order_id     	=	(String) hash.get("order_id");
			String speciality_code  =	(String) hash.get("speciality_code");
			String verify_checklist_codes="";
			String no_of_verifications = "1";
			String role_id_1 = "";
			String role_id_2 = "";
			String role_id_3 = "";
			String role_id_4 = "";
			String retVal = "";
			ArrayList verify_checklist_arr = new ArrayList();
            
			verify_checklist_arr = bean.getOperChecklists(appt_ref_num,"",speciality_code,order_id); 
    
			if(verify_checklist_arr.size()>0){
			verify_checklist_codes=checkForNull((String)verify_checklist_arr.get(0));
			no_of_verifications = checkForNull((String)verify_checklist_arr.get(1));
			role_id_1 = checkForNull((String)verify_checklist_arr.get(2));
			role_id_2 = checkForNull((String)verify_checklist_arr.get(3));
			role_id_3 = checkForNull((String)verify_checklist_arr.get(4));
			role_id_4 = checkForNull((String)verify_checklist_arr.get(5));
			}else{
			verify_checklist_codes="";
			no_of_verifications = "";
			role_id_1 = "";
			role_id_2 = "";
			role_id_3 = "";
			role_id_4 = "";
			}
			 
			retVal=verify_checklist_codes+"$$"+no_of_verifications+"$$"+role_id_1+"$$"+role_id_2+"$$"+role_id_3+"$$"+role_id_4;
			out.println(retVal);
		}else if(func_mode!= null && func_mode.equals("getUserInfo")){
			String appt_ref_num	    =	(String) hash.get("appt_ref_num");
			String order_id     	=	(String) hash.get("order_id");
			String appt_yn          =	(String) hash.get("appt_yn");
			String old_checklist_user_id = "";
	        String checklist_completed_yn = "N";
			String retVal = "";
			ArrayList user_info_arr = new ArrayList();
            
			user_info_arr = (ArrayList)bean.getUserInfo(appt_ref_num,"","1",order_id,appt_yn);
			if(user_info_arr.size()>0){
				old_checklist_user_id	= (String)user_info_arr.get(0);
				checklist_completed_yn	= (String)user_info_arr.get(1);
			}else{
				old_checklist_user_id = "";
				checklist_completed_yn = "N";
			}
            
			retVal=old_checklist_user_id+"$$"+checklist_completed_yn;
			out.println(retVal);
		}					
	}catch (Exception e) {
		out.println("alert(\"" + e + "\");") ;
		e.printStackTrace();
	}
%>
