<!DOCTYPE html>
<!-- 
Sr No        Version           Incident             SCF/CRF             Developer Name
--------------------------------------------------------------------------------------
1			V230106				36652			TH-KW-CRF-0145.1			Mohanapriya
 -->
<%@ page import="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE></TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
<%
	request.setCharacterEncoding("UTF-8");
	String limit_function_id = request.getParameter("limit_function_id") == null ? "" : request.getParameter("limit_function_id");

	//String queryString = request.getQueryString()== null?"":request.getQueryString();
	String login_id = request.getParameter("p_login_user") == null ? "" : request.getParameter("p_login_user");
	String login_pwd = request.getParameter("p_user_password") == null ? "" : request.getParameter("p_user_password");
	String mode = request.getParameter("mode") == null ? "V" : request.getParameter("mode");
	
	String facility_id = request.getParameter("p_facility_id") == null ? "" : request.getParameter("p_facility_id");
	String resp_id = request.getParameter("p_resp_id") == null ? "" : request.getParameter("p_resp_id");
	String patient_id = request.getParameter("p_patient_id") == null ? "" : request.getParameter("p_patient_id");

	String encounter_id = request.getParameter("p_encounter_id") == null ? "" : request.getParameter("p_encounter_id");

	String locale = request.getParameter("locale") == null ? "" : request.getParameter("locale");


	//String function_id = request.getParameter("function_id") == null ? "" : request.getParameter("function_id");
	String function_id = request.getParameter("limit_function_id") == null ? "" : request.getParameter("limit_function_id");
System.out.println("login_id "+login_id+" login_pwd "+login_pwd+" mode "+mode +" facility_id "+facility_id+" patient_id "+patient_id +"encounter_id"+encounter_id);
System.out.println("function_id "+function_id);
	if(locale.equals(""))
	{
		System.out.println("locale value is comming as empty in InvokePatientHistoryWrapper.jsp");
	}

	session.putValue("LOCALE",locale);
	
	
%>
<script>
	function openMPP(){
		 var ie7 = (document.all && !window.opera && window.XMLHttpRequest) ? true : false;  
	     if (ie7) 
		 {
			   //This method is required to close a window without any prompt for IE7/IE8
			   window.open('','_parent','');
			   window.close();
           }
		   else 
           {
			   //This method is required to close a window without any prompt for IE6
			   this.focus();
			   self.opener = this;
			   self.close();
           }

		var  screenHeight=screen.height;
		var  screenWidth=screen.width;
		var features ="location=0,height="+screenHeight+",width="+screenWidth+",top=0,left=0,resizable=yes";
		window.open('../../eBL/jsp/InvokeManagePatientPackage.jsp?patient_id=<%=patient_id%>&mode=<%=mode%>&facility_id=<%=facility_id%>&responsibility_id=<%=resp_id%>&login_user=<%=login_id%>&login_pwd=<%=login_pwd%>&episode_id=<%=encounter_id%>&encounter_id=<%=encounter_id%>&locale=<%=locale%>&function_id=<%=function_id%>&calledFrom=managePatientPopup','eHIS',features);	
	
	//window.open('../../eBL/jsp/InvokeManagePatientPackage.jsp?patient_id=<%=patient_id%>&mode=<%=mode%>&facility_id=<%=facility_id%>&responsibility_id=<%=resp_id%>&login_user=<%=login_id%>&login_pwd=<%=login_pwd%>&episode_id=<%=encounter_id%>&encounter_id=<%=encounter_id%>&locale=<%=locale%>&function_id=<%=function_id%>','eHIS',features);	
	}

</script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>
</HEAD>
<BODY onload='openMPP();' onKeyDown='lockKey()'>
</BODY>
</HTML>

