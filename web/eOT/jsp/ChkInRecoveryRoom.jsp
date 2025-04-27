<!DOCTYPE html>
<%@page  import ="java.sql.Connection,java.sql.ResultSet,java.sql.Statement,java.util.HashMap,eCommon.XSSRequestWrapper,eCommon.Common.*,webbeans.eCommon.ConnectionManager,java.net.URLDecoder" %>
<%@page  import ="java.util.ArrayList,eCommon.Common.*,eOT.*" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/CommonMasterObjectCollect.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 
%>
<html>
<head>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/dchk.js'></script>
<script language='javascript' src='../../eOT/js/CheckInOutRecoveryRoom.js'></script>
<script language='javascript' src='../../eOT/js/OTCommon.js'></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script language='javascript' src='../../eOT/js/Hashtable.js'></script>
<script language='javascript'>

function funDisposableDtls()
{
	var formObj=document.CheckInToRecoveryRoomForm;
	var params = formObj.params.value;
	parent.parent.frames[0].location.href="../../eCommon/jsp/commonToolbar.jsp?"+params;
	var oper_num = formObj.oper_num.value;
	var slate_user_id = formObj.slate_user_id.value;	
	var params = formObj.params.value;
	params = params+"&oper_num="+oper_num+"&slate_user_id="+slate_user_id;	
	parent.parent.result_frame.location.href="../../eOT/jsp/DisposalDetailsFrame.jsp?"+params;
	parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";	
}

function funUntowardEvents()
{
    var formObj=document.CheckInToRecoveryRoomForm;
	var oper_num = formObj.oper_num.value;
	var slate_user_id = formObj.slate_user_id.value;
	var params = formObj.params.value;
	params = params+"&oper_num="+oper_num+"&slate_user_id="+slate_user_id;
	parent.parent.result_frame.location.href='../../eOT/jsp/UntowardEventFrames.jsp?'+params
	parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";//?err_num='
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String recovery_in_out_flag =CommonBean.checkForNull(request.getParameter("recovery_in_out_flag"));
	String facility_id = CommonBean.checkForNull(request.getParameter("facility_id"));
    String oper_num = CommonBean.checkForNull(request.getParameter("oper_num"));
	String surgeon_doc_comp_yn = CommonBean.checkForNull(request.getParameter("surgeon_doc_comp_yn"));
	String nursing_doc_comp_yn = CommonBean.checkForNull(request.getParameter("nursing_doc_comp_yn"));
	String anaesthesia_doc_comp_yn = CommonBean.checkForNull(request.getParameter("anaesthesia_doc_comp_yn"));
	String called_from = CommonBean.checkForNull(request.getParameter("called_from"));
	String slate_user_id = CommonBean.checkForNull(request.getParameter("slate_user_id"));
	String order_id = CommonBean.checkForNull(request.getParameter("order_id"));
    String oper_code = CommonBean.checkForNull(request.getParameter("oper_code"));
	String surgeon_code = CommonBean.checkForNull(request.getParameter("surgeon_code"));
	String speciality_code	= CommonBean.checkForNull(request.getParameter("speciality_code"),"");
	String module_id = CommonBean.checkForNull(request.getParameter("module_id"));
	String mode	= CommonBean.checkForNull(request.getParameter("mode"));
	String booking_num		= CommonBean.checkForNull(request.getParameter("booking_num"));
	mode = CommonRepository.getCommonKeyValue("MODE_INSERT");
	String check_in_recovery_time = "",cur_date="",cur_time="",doc_comp_yn="",role_id_1		= "",role_id_2		= "",role_id_3		= "",role_id_4		= "",verify_checklist_codes="",old_post_oper_user1_id	= "",old_post_oper_user2_id	= "",old_post_oper_user3_id	= "",old_post_oper_user4_id	= "",current_date="",current_time="";
	String no_of_verifications = "1";
	int no_of_verifications_int = 1;
	ArrayList verify_checklist_arr = null;
	ArrayList user_info_arr = null;
	String checklist_completed_yn = "N";
	String post_oper_user1_completed_yn = "N";
	String post_oper_user2_completed_yn = "N";
	String post_oper_user3_completed_yn = "N";
	String post_oper_user4_completed_yn = "N";
	String check_for_check_list_compl = "N";
	String bean_id = "ChkInOutRecoveryBean";
	String bean_name = "eOT.ChkInOutRecoveryBean";
	String charge_recovery_room_yn="",chargable_amt="",encounter_id="",episode_id="",episode_type="",patient_class="",bl_episode_type="",visit_id="",nature_type="",nature_code="",bl_interface_flag="",recy_room_finalization_stage="",check_into_or_time="",check_out_time="";
	Connection con = null;
	Statement pstmt  = null;
	Statement pstmt1  = null;
	Statement pstmt2  = null;
	Statement stmt = null ;
	ResultSet rst = null;
	ResultSet rst1 = null;
	ResultSet rst2 = null;
	ResultSet resultSet	= null ; 
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.createStatement();
		pstmt2 = con.createStatement();
		pstmt1 = con.createStatement();
		stmt = con.createStatement() ;
		
		String sql="SELECT BL_INTERFACE_FLAG,CHARGE_RECOVERY_ROOM_YN,RECY_ROOM_FINALIZATION_STAGE FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID='"+facility_id+"'";
		rst=pstmt.executeQuery(sql);
		if(rst !=null && rst.next())
		{
			bl_interface_flag=CommonBean.checkForNull(rst.getString(1));
			charge_recovery_room_yn=CommonBean.checkForNull(rst.getString(2));
			recy_room_finalization_stage=CommonBean.checkForNull(rst.getString(3));
			if(("N").equals(bl_interface_flag))
			{
				charge_recovery_room_yn="N";
			}
		}
	
		String SQL_or_time ="SELECT TO_CHAR(CHECK_INTO_OR_TIME,'DD/MM/YYYY HH24:MI') CHECK_INTO_OR_TIME, TO_CHAR(CHECK_OUT_TIME,'DD/MM/YYYY HH24:MI') CHECK_OUT_TIME  FROM OT_POST_OPER_HDR WHERE  OPERATING_FACILITY_ID='"+facility_id+"' AND  OPER_NUM='"+oper_num+"'";
		rst2=pstmt2.executeQuery(SQL_or_time);
		if(rst2 !=null && rst2.next())
		{		
			check_into_or_time=rst2.getString("CHECK_INTO_OR_TIME");
			if(check_into_or_time ==null) check_into_or_time="";
			check_out_time=rst2.getString("CHECK_OUT_TIME");
			if(check_out_time ==null) check_out_time="";
		}	

	/*   String sql1="SELECT  ENCOUNTER_ID,EPISODE_ID,EPISODE_TYPE,VISIT_ID,NATURE_TYPE,NATURE_CODE,PATIENT_CLASS FROM OT_POST_OPER_HDR WHERE OPER_NUM='"+oper_num+"'";
	*/

	//Modified by DhanasekarV on 29/03/2011  
	String sql1="SELECT  ENCOUNTER_ID,EPISODE_ID,EPISODE_TYPE,VISIT_ID,NATURE_TYPE,NATURE_CODE,PATIENT_CLASS FROM OT_POST_OPER_HDR WHERE OPER_NUM='"+oper_num+"' AND OPERATING_FACILITY_ID='"+facility_id+"'";

	rst1=pstmt1.executeQuery(sql1);
	if(rst1 !=null && rst1.next())
	{
		encounter_id=CommonBean.checkForNull(rst1.getString(1));
		episode_id=CommonBean.checkForNull(rst1.getString(2));
		episode_type=CommonBean.checkForNull(rst1.getString(3));
		visit_id=CommonBean.checkForNull(rst1.getString(4));
		nature_type=CommonBean.checkForNull(rst1.getString(5));
		nature_code=CommonBean.checkForNull(rst1.getString(6));
		patient_class=CommonBean.checkForNull(rst1.getString(7));
	}
		
	String sql_bl_epi_type="SELECT BL_EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS = '"+patient_class+"' AND EPISODE_TYPE ='"+episode_type+"' ";
	rst1=pstmt1.executeQuery(sql_bl_epi_type);
	if(rst1 !=null && rst1.next())
	{
		bl_episode_type=CommonBean.checkForNull(rst1.getString(1));
	}

	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;

	ChkInOutRecoveryBean bean = (ChkInOutRecoveryBean) mh.getBeanObject( bean_id, request, bean_name );
	String list[] =  bean.getAllDocumentionReqdYN(facility_id);
	surgeon_doc_comp_yn=("N"==list[0].intern() )?"Y":surgeon_doc_comp_yn;
	nursing_doc_comp_yn=("N"==list[1].intern() )?"Y":nursing_doc_comp_yn;
	anaesthesia_doc_comp_yn=("N"==list[2].intern() )?"Y":anaesthesia_doc_comp_yn;	
	
	String anaesthesia_eval_reqd_yn = bean.getAnaesthesiaApplicableYN(order_id);
	if("N".equals(anaesthesia_eval_reqd_yn)){
		doc_comp_yn=( surgeon_doc_comp_yn.equals("Y") && nursing_doc_comp_yn.equals("Y") )?"Y":"N";
	}else{
		doc_comp_yn=( surgeon_doc_comp_yn.equals("Y") && nursing_doc_comp_yn.equals("Y") &&  "Y".equals(anaesthesia_doc_comp_yn) )?"Y":"N";
	}
	check_in_recovery_time=bean.getRecoveryCheckInTime(oper_num);
	
	//Added Against SKR-SCF-1287 Starts
	String sql_curr_date="SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') CUR_DATE,TO_CHAR(SYSDATE,'HH24:MI') CUR_TIME,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI')  CURRENT_DATE_TIME FROM DUAL";
	resultSet			= stmt.executeQuery(sql_curr_date);

	if(resultSet!=null && resultSet.next()){
		current_date=resultSet.getString("CUR_DATE");
		current_time = resultSet.getString("CUR_TIME");
	}
	//Added Against SKR-SCF-1287 Ends
	
	ArrayList timeList = bean.getSysDateTime();
	cur_date= (String) timeList.get(1);
	cur_time = (String) timeList.get(2); 
	
	if(recovery_in_out_flag.equalsIgnoreCase("CHECK_OUT_RECO")){
		bean.loadDisposalDtls(oper_num);
		check_for_check_list_compl = bean.getCheckListReqdYNFlag("27");	
	}
	
	//order_id			= CommonBean.checkForNull(request.getParameter("order_id"),"");
	// to compare the user who already entered the data with the current user
	if(recovery_in_out_flag.equalsIgnoreCase("CHECK_OUT_RECO")){
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
	}
	}catch(Exception e){
			e.printStackTrace();
			System.err.println("Err Msg from CommonValidation.jsp :"+e);
		}
		finally{
			if(rst!=null) rst.close();
			if(pstmt!=null)pstmt.close();
			if(rst1!=null) rst1.close();
			if(rst2!=null) rst2.close();
			if(pstmt1!=null)pstmt1.close();
			if(pstmt2!=null)pstmt2.close();
			if(con!=null) con.close();
		}
	if(recovery_in_out_flag.equals("CHECK_IN_RECO")){
%>
<body onload="loadChkInRecTime();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='CheckInToRecoveryRoomForm' id='CheckInToRecoveryRoomForm'>
<input type='hidden' name='params' id='params' value='<%=request.getQueryString()%>' >	
<table border='0' cellpadding='3' cellspacing='0' width='100%'>
<tr>
	<td colspan='4' class='CAGROUPHEADING'>
		<fmt:message key="eOT.CheckInToRecoveryRoom.Label" bundle="${ot_labels}"/>
	</td> 
</tr>
<tr>
	<td class='Label' width="25%" >
	<fmt:message key="eOT.RecoveryStartTime.Label" bundle="${ot_labels}"/>
	</td> 
	<td class='Label' width="25%" >
	    <input type='text' name='start_date' id='start_date' size='8'  value='<%=cur_date%>' readonly>
		<img src='../../eCommon/images/CommonCalendar.gif'  onClick="return showCalendar('start_date');">
		<input type='text' name='start_time' id='start_time' size='2'  maxlength='5' value='' onBlur='checkTimeFormat(this);' > <img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	<td class='Label' width="25%"  >
		<fmt:message key="eOT.RecoveryEndTime.Label" bundle="${ot_labels}"/> 
	</td> 
	<td class='Label' width="25%">
		<input type='text' name='end_date' id='end_date' size='8'  value='' readonly>
		<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('end_date');">
		<input type='text' name='end_time' id='end_time' size='2'  maxlength='5' value="" onBlur='checkTimeValidity(this);' onFocus="assingTime(this);" > 
   </td>
 </tr>
 <tr>
    <td class='Label' width="25%">
		<fmt:message key="eOT.RecoveryRoom.Label" bundle="${ot_labels}"/>
	</td>
    <td class='Label' width="25%" >		
		<input type='hidden' name='recovery_room_code' id='recovery_room_code'>
		<input type='text' name='recovery_room_desc' id='recovery_room_desc' size='15'   onblur="if(this.value!='')searchRecoveryRoomforCheckIn(recovery_room_code,recovery_room_desc);" >
		<input type='button' class='button' value='?' name='recoveryLookUp' id='recoveryLookUp' onClick='searchRecoveryRoomforCheckIn(recovery_room_code,recovery_room_desc);' > <img src='../../eCommon/images/mandatory.gif'></img>		
	</td>
 </tr>
</table>
<%}else if(recovery_in_out_flag.equalsIgnoreCase("CHECK_OUT_RECO")){%>
<body onLoad="loadRecTime1();">
<form name='CheckInToRecoveryRoomForm' id='CheckInToRecoveryRoomForm'>
<input type='hidden' name='params' id='params' value='<%=request.getQueryString()%>' >	
<table border='0' cellpadding='3' cellspacing='0' width='100%'>
<tr>
	<td colspan="4" class='CAGROUPHEADING'>
	<fmt:message key="eOT.CheckOutFromRecoveryRoom.Label" bundle="${ot_labels}"/>
	</td> 
</tr>
<tr>
    <td class='Label' width="25%"  >
			<fmt:message key="eOT.RecoveryRoom.Label" bundle="${ot_labels}"/>
	</td> 
    <td class='Label' width="25%" >		
		<input type='hidden' name='recovery_room_code' id='recovery_room_code'>
		<input type='text' name='recovery_room_desc' id='recovery_room_desc' size='15'  value=''  disabled>		
	</td>
	<td class='Label' width="25%" >
	<fmt:message key="eOT.RecoveryStartTime.Label" bundle="${ot_labels}"/>
	</td> 
	<td class='Label' width="25%" >
	    <input type='text' name='start_date' id='start_date' size='8'  value="" disabled>
		<input type='text' name='start_time' id='start_time' size='2'  maxlength='5' value="" disabled> 
	</td>
<tr>
	<td  class='Label' width="25%">
	<fmt:message key="eOT.RecoveryEndTime.Label" bundle="${ot_labels}"/> 
	</td> 
	<!-- Modified by DhanasekarV against issue IN026657 -->
	<td class='Label' width="25%" >
		<!--input type='text' name='end_date' size='8'  value='<%=cur_date%>' readonly onblur="if((validateDate()==true) && (document.forms[0].end_time.value != ''))  validateDtTime(document.forms[0].end_time);"-->
		<input type='text' name='end_date' id='end_date' size='8'  value='<%=cur_date%>' readonly onblur="if((isValidDate(end_date)==true) && (document.forms[0].end_time.value != ''))  validateDtTime(document.forms[0].end_time);"><!--Modified Against SKR-SCF-1287-->
		<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar_local('end_date');" > 
		<input type='text' name='end_time' id='end_time' size='2'  maxlength='5' value='<%=cur_time%>' 
		onBlur="if (document.forms[0].end_date.value !='') validateDtTime(this);" onFocus="assingTime(this);" onkeypress="return checkForSpecCharsforIDTime(event);"> 
		<img name='imgflag'src='../../eCommon/images/mandatory.gif'></img>
   </td>
 
	<%if(bl_interface_flag.equals("Y") && charge_recovery_room_yn.equals("Y")){%>
	<td class='label' width="25%" id='chrg_unit_show_yn' style='visible:inline;'>
		<fmt:message key="eOT.ChargableUnits.Label" bundle="${ot_labels}"/> 
	</td> 
	 <td class='fields' width="25%" id='pyble_unit_show_yn' style='visible:inline;'>
			<input type='text' class='fields' name='charge_units' id='charge_units' size='3' onblur="getServPanelDtls(this,serv_code);" maxlength='3' value='' tabindex=-1>
	</td> 
	<%}else{%>
	<td class='label' width="25%" id='chrg_unit_show_yn'></td>
	 <td class='fields' width="25%" id='pyble_unit_show_yn'></td>
	<%}%>
<tr>
	<td  class='Label' width="25%">
		<fmt:message key="eOT.CheckOut.Label" bundle="${ot_labels}"/>	
	</td>
	<td  class='Label' width="25%">
		<input type='checkbox'  class='label' name='check_out' id='check_out' onClick='validateCheckBox();'>
	</td>
	 
<%if(bl_interface_flag.equals("Y") && charge_recovery_room_yn.equals("Y")){%>
<td class='label' ></td>
	<td class="gridData" colspan ='4' >
		<div id="charge_details_1" style='visible:hidden;display:none'>
		</div>
		<input type="hidden" name="bl_panel_str" id="bl_panel_str" value="">
	</td>
<% } %>
	<input type='hidden' name='check_out_time' id='check_out_time' value='12:20'>
</tr>
<tr>		
	<td class='Label' width="25%" >
		<fmt:message key="Common.TransferTo.label" bundle="${common_labels}"/>  
	</td>
	<td class='Label' width="25%" >
		<select name="transfer" id="transfer" onchange="disableWardAndStatus()" >
		<option value='W'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
		<option value='C'><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
		<option value='M'><fmt:message key="eOT.Mortuary.Label" bundle="${ot_labels}"/></option>	
		</select>		
		<img name='imgflag'src='../../eCommon/images/mandatory.gif'></img>
	</td>
	<td class='Label' width="25%">
		<fmt:message key="Common.Nursing.label" bundle="${common_labels}"/>/
		<fmt:message key="Common.clinic.label"      bundle="${common_labels}"/>
	</td>
	
	<td class='Label' width="25%" >
		<input type='hidden' name='ward_code' id='ward_code' value='' >
		<!-- ML-MMOH-CRF-0752.3-US001 -->
		<input type='text' name='ward_desc' id='ward_desc' size='36'  value='' onblur="if(this.value!='')searchWardclinic(this);else ward_code.value='' "  disabled>
		<input type='button' class='button' name='WardLookUp' id='WardLookUp' disabled size='15' value="?" OnClick="searchWardclinic(ward_desc);" ><img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>
<tr>	
	<td class='Label' width="25%" >
	<fmt:message key="eOT.TransferTime.Label" bundle="${ot_labels}"/>
	</td> 
	<td class='Label' width="25%" >
	    <input type='text' name='transfer_date' id='transfer_date' size='8'  value='<%=cur_date%>' readonly>
		<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('transfer_date');">
		<input type='text' name='transfer_time' id='transfer_time' size='2'  maxlength='5' value='<%=cur_time%>' onBlur='checkTimeValidity(this);checkTimeValidation();' onkeypress="return checkForSpecCharsforIDTime(event);"> <img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	<td class='Label' width="25%" >
	<fmt:message key="Common.status.label" bundle="${common_labels}"/>
	</td>
	<td class='Label' width="25%" >
		<select name="status" id="status"  >
			<option value="">
			<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
			</option>
			<option value='I'>
			<fmt:message key="eOT.Intubated.Label" bundle="${ot_labels}"/>
			</option>
			<option value='E'>
			<fmt:message key="eOT.Extubated.Label" bundle="${ot_labels}"/>
			</option>
		</select>
	</td>
</tr>
<tr>
	<td class='Label' width="25%" colspan="2">
	</td>
</tr>
</table>
<%}%>
	<input type='hidden' name='cur_date' id='cur_date' value='<%=cur_date%>'>
	<input type='hidden' name='cur_time' id='cur_time' value='<%=cur_time%>'>
	<input type='hidden' name='module_id' id='module_id' value='<%=module_id%>'>
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type='hidden' name='bean_id' id='bean_id' value='<%=bean_id%>' >
	<input type='hidden' name='bean_name' id='bean_name' value='<%=bean_name%>' >
	<input type='hidden' name='doc_comp_yn' id='doc_comp_yn' value='<%=doc_comp_yn%>' >	
	<input type='hidden' name='check_out_flag' id='check_out_flag' value='N' >	
	<input type='hidden' name='called_from' id='called_from' value='<%=called_from%>' >
	<input type='hidden' name='facility_id' id='facility_id' value="<%=CommonBean.checkForNull(request.getParameter("facility_id"))%>">
	<input type='hidden' name='slate_user_id' id='slate_user_id' value="<%=slate_user_id%>">
	<input type='hidden' name='oper_num' id='oper_num' value='<%=oper_num%>' >
	<input type='hidden' name='check_in_recovery_time' id='check_in_recovery_time' value='<%=check_in_recovery_time%>' >
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
	<input type='hidden' name="verify_checklist_codes" id="verify_checklist_codes" value="<%=verify_checklist_codes%>">
	<input type='hidden' name="locale" id="locale" value="<%=locale%>">
	<input type='hidden' name='speciality_code' id='speciality_code' value='<%=speciality_code%>'>
	<input type='hidden' name='oper_code' id='oper_code' value='<%=oper_code%>'>
	<input type='hidden' name='surgeon_code' id='surgeon_code' value='<%=surgeon_code%>'>
	<input type='hidden' name='chargable_amt' id='chargable_amt' value='<%=chargable_amt%>'>
	<input type='hidden' name='calc_chrge_units' id='calc_chrge_units' value=''>
	<input type='hidden' name='accession_num' id='accession_num' value=''>
	<input type='hidden' name='service_code' id='service_code' value=''>
	<input type='hidden' name='rec_room_chrging_stg' id='rec_room_chrging_stg' value='<%=recy_room_finalization_stage%>'>
	<input type='hidden' name='encounter_id' id='encounter_id' value='<%=encounter_id %>'>
	<input type='hidden' name='episode_id' id='episode_id' value='<%=episode_id %>'>
	<input type='hidden' name='episode_type' id='episode_type' value='<%=bl_episode_type %>'>
	<input type='hidden' name='visit_id' id='visit_id' value='<%=visit_id %>'>
	<input type='hidden' name='nature_type' id='nature_type' value='<%=nature_type %>'>
	<input type='hidden' name='nature_code' id='nature_code' value='<%=nature_code %>'>
	<input type='hidden' name='current_time' id='current_time' value='<%=current_time %>'>
	<input type='hidden' name='current_date' id='current_date' value='<%=current_date %>'>
	<input type='hidden' name='accession_num_chrg_unit' id='accession_num_chrg_unit' value=''>
	<input type='hidden' name='rec_room_code' id='rec_room_code' value=''>
	<input type='hidden' name='rec_room_desc' id='rec_room_desc' value=''>
	<input type='hidden' name='modified_charge_units' id='modified_charge_units' value=''>
	<input type='hidden' name='check_into_or_time' id='check_into_or_time' value='<%=check_into_or_time%>'>
	<input type='hidden' name='bl_interface_flag' id='bl_interface_flag' value='<%=bl_interface_flag%>'><!-- Setup for parameter for facility billing flag -->
	<input type='hidden' name='charge_recovery_room_yn' id='charge_recovery_room_yn' value='<%=charge_recovery_room_yn%>'><!-- Setup for parameter for facility flag -->
	<input type='hidden' name='recy_room_finalization_stage' id='recy_room_finalization_stage' value='<%=recy_room_finalization_stage%>'><!-- Setup for parameter for facility flag -->
	<input type='hidden' name='rec_room_chrge_yn' id='rec_room_chrge_yn' value=''><!-- Recovery Room Master flag -->
	<input type='hidden' name='include_exclude' id='include_exclude' value=''>
	<input type='hidden' name='appr_reqd_val' id='appr_reqd_val' value=''>
	<input type='hidden' name='reason_inc_exe' id='reason_inc_exe' value=''>
	<input type='hidden' name='inc_exe_blng_wdw' id='inc_exe_blng_wdw' value=''>
</form>
</html>

