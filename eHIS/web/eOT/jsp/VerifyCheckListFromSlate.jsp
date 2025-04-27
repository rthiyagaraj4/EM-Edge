<!DOCTYPE html>
<%@page  import ="java.util.ArrayList,eCommon.XSSRequestWrapper,eCommon.Common.*,eOT.*" contentType="text/html;charset=UTF-8" %>

<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>

<%-- Mandatory declarations end --%>

<html>
<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
	<script language='javascript' src='../../eOT/js/OTCommon.js'></script>
	<script language="javascript" src="../../eOT/js/VerifyCheckList.js"></script>

<script language='javascript'>
function funsubmitCheckInDtls_1(checklists){
	var formObj = document.VerifyCheckListFromSlateForm;	
	var chk_params = formObj.params.value;
	var no_of_verifications = formObj.no_of_verifications.value;

	var checklist_stage = "";
	var post_oper_user1_completed_yn = formObj.post_oper_user1_completed_yn.value;
	var post_oper_user2_completed_yn = formObj.post_oper_user2_completed_yn.value;
	var post_oper_user3_completed_yn = formObj.post_oper_user3_completed_yn.value;
	var post_oper_user4_completed_yn = formObj.post_oper_user4_completed_yn.value;

	if(no_of_verifications > 0 && post_oper_user1_completed_yn=="N")
		checklist_stage="C50";		
	else if(no_of_verifications > 1 && post_oper_user2_completed_yn=="N")
		checklist_stage="C60";		
	else if(no_of_verifications > 2 && post_oper_user3_completed_yn=="N")
		checklist_stage="C70";		
	else if(no_of_verifications > 3 && post_oper_user4_completed_yn=="N")
		checklist_stage="C80";		

	var order_id = formObj.order_id.value;
	var checklist_arr = checklists.split("##");
	var verify_checklist_codes = "&verify_checklist_code_1="+checklist_arr[0];
	var count=1;
	for(i=1;i<checklist_arr.length;i++){
		count++;				
		//verify_checklist_codes+=verify_checklist_codes+"&verify_checklist_code_"+count+"="+checklist_arr[i];
		verify_checklist_codes=verify_checklist_codes+"&verify_checklist_code_"+count+"="+checklist_arr[i]; //Modified Against AAKH-SCF-0478
	}
	var booking_or_oper_flag = "B";
	if(order_id!=null && order_id!="null" && order_id!="")
			booking_or_oper_flag = "ORD";

	var old_post_oper_user1_id = (formObj.old_post_oper_user1_id.value).toUpperCase();
	var old_post_oper_user2_id = (formObj.old_post_oper_user2_id.value).toUpperCase();
	var old_post_oper_user3_id = (formObj.old_post_oper_user3_id.value).toUpperCase();
	var old_post_oper_user4_id = (formObj.old_post_oper_user4_id.value).toUpperCase();

	var slate_user_id = (formObj.slate_user_id.value).toUpperCase();
	var disable_checklist_fields = "N";
	var access="NYNNY";
	if(checklist_stage=="C50"){
		if(old_post_oper_user1_id!=null && old_post_oper_user1_id!="" && old_post_oper_user1_id!="null" && old_post_oper_user1_id!="NULL"){
			if(slate_user_id.toUpperCase()!=old_post_oper_user1_id.toUpperCase()){
				disable_checklist_fields = "disabled"
				access="NNNNY";
			}
		}
	}else if(checklist_stage=="C60"){
		if(old_post_oper_user2_id!=null && old_post_oper_user2_id!="" && old_post_oper_user2_id!="null" && old_post_oper_user2_id!="NULL"){
			if(slate_user_id.toUpperCase()!=old_post_oper_user2_id.toUpperCase()){
				disable_checklist_fields = "disabled"
				access="NNNNY";
			}
		}
	}
	if(checklist_stage=="C70"){
		if(old_post_oper_user3_id!=null && old_post_oper_user3_id!="" && old_post_oper_user3_id!="null" && old_post_oper_user3_id!="NULL"){
			if(slate_user_id.toUpperCase()!=old_post_oper_user3_id.toUpperCase()){
				disable_checklist_fields = "disabled"
				access="NNNNY";
			}
		}
	}
	if(checklist_stage=="C80"){
		if(old_post_oper_user4_id!=null && old_post_oper_user4_id!="" && old_post_oper_user4_id!="null" && old_post_oper_user4_id!="null"){
			if(slate_user_id.toUpperCase()!=old_post_oper_user4_id.toUpperCase()){
				disable_checklist_fields = "disabled"
				access="NNNNY";
			}
		}
	}

	var checklist_completed_yn = formObj.checklist_completed_yn.value;
	if(checklist_completed_yn=="Y"){
		disable_checklist_fields = "disabled"
		access="NNNNY";
	}
	var db_param_1="module_id=OT&function_type=F&menu_id=OT_JAVA_DFLT&access="+access+"&home_required_yn=N";
	var verifychecklist = getLabel("eOT.VerifyCheckList.Label","OT");
	var function_string = "&function_id=OT_CHECK_LIST&function_name="+verifychecklist
	var db_param = db_param_1 + function_string;
	var url_desc = "VerifyCheckListMain.jsp";
	//Maheshwaran k added 'apply_flag' for the CRF CHL-CRF-0043 [IN:035927] as on 19/03/2013
	var url = url_desc+"?"+db_param+"&called_from=OT_SLATE&patient_id="+formObj.patient_id.value+"&slate_user_id="+slate_user_id+verify_checklist_codes+"&checklist_codes_count="+count+"&checklist_stage="+checklist_stage+"&apply_flag=Y&pre_or_post=O&booking_or_oper_flag="+booking_or_oper_flag+"&no_of_verifications="+no_of_verifications+"&user_id="+slate_user_id+"&role_id_1="+formObj.role_id_1.value+"&role_id_2="+formObj.role_id_2.value+"&role_id_3="+formObj.role_id_3.value+"&role_id_4="+formObj.role_id_4.value+"&order_id="+order_id+"&booking_num="+formObj.booking_num.value+"&oper_num="+formObj.oper_num.value+"&disable_checklist_fields="+disable_checklist_fields;
//	alert(url);
	var dialogHeight = "94" ;
	var dialogWidth  = "445" ;
	var dialogTop    = "790";
	var dialogLeft   = "100";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:"+dialogTop+ "; status=no" ;
	var arguments    = "" ;
	//	var retVal 	   = window.showModalDialog(url, arguments, features);
	window.name = "test";
	formObj.action = "../../eOT/jsp/"+url;
	formObj.method="POST";
	formObj.target="test";
	formObj.submit();
}

</script>
</head>
<%
	String recovery_in_out_flag =CommonBean.checkForNull(request.getParameter("recovery_in_out_flag"));
%>
<body>
<form name="VerifyCheckListFromSlateForm" id="VerifyCheckListFromSlateForm">
<%
	String params = request.getQueryString();
	String called_from = CommonBean.checkForNull(request.getParameter("called_from"));
	String slate_user_id = CommonBean.checkForNull(request.getParameter("slate_user_id"));
	String booking_num		= CommonBean.checkForNull(request.getParameter("booking_num"));
	String order_id			= CommonBean.checkForNull(request.getParameter("order_id"),"");
	String oper_num = CommonBean.checkForNull(request.getParameter("oper_num"));
	String speciality_code	= CommonBean.checkForNull(request.getParameter("speciality_code"),"");
	String cur_date="";
	String cur_time="";	

	String bean_id = "ChkInOutRecoveryBean";
	String bean_name = "eOT.ChkInOutRecoveryBean";
	ChkInOutRecoveryBean bean = (ChkInOutRecoveryBean) mh.getBeanObject( bean_id, request, bean_name );
	//bean.clear();
	String check_for_check_list_compl = "N";
	ArrayList timeList = bean.getSysDateTime();
	cur_date= (String) timeList.get(1);
	cur_time = (String) timeList.get(2);
	bean.loadDisposalDtls(oper_num);
	check_for_check_list_compl = bean.getCheckListReqdYNFlag("27");	
	
// Start of Verify CheckList logic

	String no_of_verifications = "1";
	int no_of_verifications_int = 1;
	String role_id_1		= "";
	String role_id_2		= "";
	String role_id_3		= "";
	String role_id_4		= "";
	ArrayList verify_checklist_arr = null;
	ArrayList user_info_arr = null;
	String old_checklist_user_id = "";
	String checklist_completed_yn = "N";
	String appt_ref_num = "";
	String verify_checklist_codes="";
	String appt_yn = "";
	String post_oper_user1_completed_yn = "N";
	String post_oper_user2_completed_yn = "N";
	String post_oper_user3_completed_yn = "N";
	String post_oper_user4_completed_yn = "N";

	String old_post_oper_user1_id	= "";
	String old_post_oper_user2_id	= "";
	String old_post_oper_user3_id	= "";
	String old_post_oper_user4_id	= "";

	// to compare the user who already entered the data with the current user
	verify_checklist_arr	= new ArrayList();
	user_info_arr			= new ArrayList();

	verify_checklist_arr = bean.getOperChecklists(booking_num,oper_num,speciality_code,order_id); 
	if(verify_checklist_arr.size()>0){
		verify_checklist_codes=(String)verify_checklist_arr.get(0);
		no_of_verifications = (String)verify_checklist_arr.get(1);
		no_of_verifications=no_of_verifications==null?"1":no_of_verifications;
		no_of_verifications=no_of_verifications.equalsIgnoreCase("null")?"1":no_of_verifications;
		no_of_verifications=no_of_verifications.equals("null")?"1":no_of_verifications;
		no_of_verifications_int = Integer.parseInt(no_of_verifications);
		role_id_1 = (String)verify_checklist_arr.get(2);
		role_id_2 = (String)verify_checklist_arr.get(3);
		role_id_3 = (String)verify_checklist_arr.get(4);
		role_id_4 = (String)verify_checklist_arr.get(5);
	}else{
		verify_checklist_codes="";
		no_of_verifications = "";
		no_of_verifications_int = 1;
		role_id_1 = "";
		role_id_2 = "";
		role_id_3 = "";
		role_id_4 = "";
	}
	user_info_arr = (ArrayList)bean.getUserInfo(booking_num,oper_num,"1",order_id);
	if(user_info_arr.size()>0){

		post_oper_user1_completed_yn = (String)user_info_arr.get(9);
		post_oper_user2_completed_yn = (String)user_info_arr.get(11);
		post_oper_user3_completed_yn = (String)user_info_arr.get(13);
		post_oper_user4_completed_yn = (String)user_info_arr.get(15);

		old_post_oper_user1_id		 = (String)user_info_arr.get(8);
		old_post_oper_user2_id		 = (String)user_info_arr.get(10);
		old_post_oper_user3_id		 = (String)user_info_arr.get(12);
		old_post_oper_user4_id		 = (String)user_info_arr.get(14);

		if(no_of_verifications_int==1){
			if(post_oper_user1_completed_yn.equals("Y"))
				checklist_completed_yn		 = "Y";
			else
				checklist_completed_yn		 = "N";
		}else if(no_of_verifications_int==2){ 
			if(post_oper_user1_completed_yn.equals("Y") && post_oper_user2_completed_yn.equals("Y"))
				checklist_completed_yn		 = "Y";
			else
				checklist_completed_yn		 = "N";
		}else if(no_of_verifications_int==3){ 
			if(post_oper_user1_completed_yn.equals("Y") && post_oper_user2_completed_yn.equals("Y") && post_oper_user3_completed_yn.equals("Y"))
				checklist_completed_yn		 = "Y";
			else
				checklist_completed_yn		 = "N";
		}else if(no_of_verifications_int==4){ 
			if(post_oper_user1_completed_yn.equals("Y") && post_oper_user2_completed_yn.equals("Y") && post_oper_user3_completed_yn.equals("Y") && post_oper_user4_completed_yn.equals("Y"))
			checklist_completed_yn		 = "Y";
		}else
			checklist_completed_yn		 = "N";
	}else{
		old_post_oper_user1_id		 = "";
		old_post_oper_user2_id		 = "";
		old_post_oper_user3_id		 = "";
		checklist_completed_yn		 = "N";
	}
// till here

// End of Verify CheckList Logic
%>
	<input type='hidden' name='bean_id' id='bean_id' value='<%=bean_id%>' >
	<input type='hidden' name='bean_name' id='bean_name' value='<%=bean_name%>' >
	<input type='hidden' name='params' id='params' value='<%=request.getQueryString()%>' >	
	<input type='hidden' name='check_out_flag' id='check_out_flag' value='N' >	
	<input type='hidden' name='called_from' id='called_from' value='<%=called_from%>' >
	<input type='hidden' name='facility_id' id='facility_id' value="<%=CommonBean.checkForNull(request.getParameter("facility_id"))%>">
	<input type='hidden' name='slate_user_id' id='slate_user_id' value="<%=slate_user_id%>">
	<input type='hidden' name='oper_num' id='oper_num' value='<%=oper_num%>' >
	<input type='hidden' name="size" id="size" value='0' >
	<input type='hidden' name="size1" id="size1" value='0' >
	<input type='hidden' name="recovery_in_out_flag" id="recovery_in_out_flag" value='<%=recovery_in_out_flag%>' >
	<input type='hidden' name="patient_id" id="patient_id" value="<%=request.getParameter("patient_id")%>" >	

	<input type='hidden' name="user_id" id="user_id" value="<%=slate_user_id%>" >
	<input type='hidden' name="no_of_verifications" id="no_of_verifications" value="<%=no_of_verifications%>">
	<input type='hidden' name="role_id_1" id="role_id_1" value="<%=role_id_1%>">
	<input type='hidden' name="role_id_2" id="role_id_2" value="<%=role_id_2%>">
	<input type='hidden' name="role_id_3" id="role_id_3" value="<%=role_id_3%>">
	<input type='hidden' name="role_id_4" id="role_id_4" value="<%=role_id_4%>">
	<input type='hidden' name="checklist_completed_yn" id="checklist_completed_yn" value="<%=checklist_completed_yn%>">
	<input type='hidden' name="order_id" id="order_id" value="<%=order_id%>">
	<input type='hidden' name='booking_num' id='booking_num' value="<%=booking_num%>">

	<input type='hidden' name='post_oper_user1_completed_yn' id='post_oper_user1_completed_yn' value="<%=post_oper_user1_completed_yn%>">
	<input type='hidden' name='post_oper_user2_completed_yn' id='post_oper_user2_completed_yn' value="<%=post_oper_user2_completed_yn%>">
	<input type='hidden' name='post_oper_user3_completed_yn' id='post_oper_user3_completed_yn' value="<%=post_oper_user3_completed_yn%>">
	<input type='hidden' name='post_oper_user4_completed_yn' id='post_oper_user4_completed_yn' value="<%=post_oper_user4_completed_yn%>">

	<input type='hidden' name="old_post_oper_user1_id" id="old_post_oper_user1_id" value="<%=old_post_oper_user1_id%>">
	<input type='hidden' name="old_post_oper_user2_id" id="old_post_oper_user2_id" value="<%=old_post_oper_user2_id%>">
	<input type='hidden' name="old_post_oper_user3_id" id="old_post_oper_user3_id" value="<%=old_post_oper_user3_id%>">
	<input type='hidden' name="old_post_oper_user4_id" id="old_post_oper_user4_id" value="<%=old_post_oper_user4_id%>">

	<input type='hidden' name="check_for_check_list_compl" id="check_for_check_list_compl" value="<%=check_for_check_list_compl%>">

</form>
<script language="javascript">
	funsubmitCheckInDtls_1("<%=verify_checklist_codes%>");
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</body>
</html>

