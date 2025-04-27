<!DOCTYPE html>
<html>
<%@page  contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@page  import ="java.sql.Connection,java.sql.ResultSet,java.sql.Statement,java.util.HashMap,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,java.net.URLDecoder,eCommon.Common.CommonBean,java.util.ArrayList,eOT.*,eOT.Common.*" %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<html>
<head>
<%  
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends

	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>

<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<script type='text/javascript' src='../../eCommon/js/dchk.js'></script>
<script type='text/javascript' src='../../eOT/js/CheckInToOR.js'></script>
<script type='text/javascript' src='../../eOT/js/OTCommon.js'></script>
<script type='text/javascript' src='../../eCommon/js/DateUtils.js'></script>
<script language='javascript'>
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String bean_id = "HoldingAreaBean";
	String bean_name = "eOT.HoldingAreaBean";
	HoldingAreaBean bean = (HoldingAreaBean) mh.getBeanObject(bean_id, request, bean_name );
	//Maheshwaran k added for the CRF CHL-CRF-0043 [IN:035927] as on 19/03/2013
	//Start
	//This Bean is used to get only the PostOperative Checklist code
	String bean_id1 = "ChkInOutRecoveryBean";
	String bean_name1 = "eOT.ChkInOutRecoveryBean";
	ChkInOutRecoveryBean bean1 = (ChkInOutRecoveryBean) mh.getBeanObject( bean_id1, request, bean_name1 );
	ArrayList verify_checklist_arr1 = new ArrayList();
	String verify_checklist_codes1="";
	//End
	String check_for_check_list_compl = bean.getCheckListReqdYNFlag("05");
	String oper_num = CommonBean.checkForNull(request.getParameter("oper_num"));
	String facility_id = CommonBean.checkForNull(request.getParameter("facility_id"));
	String slate_user_id = CommonBean.checkForNull(request.getParameter("slate_user_id"));	
	String getSpecialityCode = CommonBean.checkForNull(request.getParameter("speciality_code")); //Added Against ARYU-SCF-0087[IN:067241]
	String hold_area_check_in_time = "",speciality_code = "",cur_date="",cur_time="",role_id_1 = "",role_id_2 = "",role_id_3 = "",role_id_4 = "",old_checklist_user_id = "",verify_checklist_codes="";
	ArrayList hold_area_list = null;	
	ArrayList date_list = bean.getSysDateTime(); // date_time, date, time
    cur_date = (String)date_list.get(1);
	cur_time = (String)date_list.get(2);

	bean.loadHoldingAreaDtls(oper_num);
	hold_area_list = bean.getHoldingAreaDtls();
    if(hold_area_list.size()>0){
		//format of time dd/mm/yyyy HH24:MI
		hold_area_check_in_time = (String) hold_area_list.get(0);
		speciality_code = (String) hold_area_list.get(5);
	}
    // Start of Verify CheckList logic
	String booking_num	= CommonBean.checkForNull(request.getParameter("booking_num"));
	String order_id		= CommonBean.checkForNull(request.getParameter("order_id"),"");

	String no_of_verifications = "1";
	ArrayList verify_checklist_arr = new ArrayList();
	ArrayList user_info_arr = new ArrayList();
	String checklist_completed_yn = "N";

	//to compare the user who already entered the data with the current user
	//Added Against ARYU-SCF-0087[IN:067241]
	if(speciality_code.equals("") && speciality_code.length()==0){
		speciality_code = getSpecialityCode;
	}
	//Added End ARYU-SCF-0087[IN:067241]
	verify_checklist_arr = bean.getOperChecklists(booking_num,oper_num,speciality_code,order_id); 
	if(verify_checklist_arr.size()>0){
			verify_checklist_codes=(String)verify_checklist_arr.get(0);
			no_of_verifications = (String)verify_checklist_arr.get(1);
			role_id_1 = (String)verify_checklist_arr.get(2);
			role_id_2 = (String)verify_checklist_arr.get(3);
			role_id_3 = (String)verify_checklist_arr.get(4);
			role_id_4 = (String)verify_checklist_arr.get(5);
	}else{
			verify_checklist_codes="";
			no_of_verifications = "";
			role_id_1 = "";
			role_id_2 = "";
			role_id_3 = "";
			role_id_4 = "";
	}
	
	user_info_arr = (ArrayList)bean.getUserInfo(booking_num,oper_num,"1",order_id);
	if(user_info_arr.size()>0){
		old_checklist_user_id	= (String)user_info_arr.get(0);
		checklist_completed_yn	= (String)user_info_arr.get(1);
	}else{
		old_checklist_user_id = "";
		checklist_completed_yn = "N";
	}
	//till here
	//Maheshwaran k added for the CRF CHL-CRF-0043 [IN:035927] as on 19/03/2013
	//Start
	verify_checklist_arr1 = bean1.getOperChecklists(booking_num,oper_num,speciality_code,order_id); 
	if(verify_checklist_arr1.size()>0){
		verify_checklist_codes1=(String)verify_checklist_arr1.get(0);
	}else{
		verify_checklist_codes1="";
	}
		
	verify_checklist_codes=verify_checklist_codes+"##"+verify_checklist_codes1;	
	System.err.println("verify_checklist_codes in CheckInToOR.jsp===>"+verify_checklist_codes);
	//Added against AAKH-SCF-0418 [IN:071802] Starts Here
	String[] arrSplit = verify_checklist_codes.split("##");
	String checklist=arrSplit[0];
	System.err.println("checklist in CheckInToOR.jsp===>"+checklist);
	for (int i=0; i < arrSplit.length; i++)
	{
		if(!checklist.equals(arrSplit[i]))
		{
			checklist=checklist+"##"+arrSplit[i];
			System.err.println("checklist++ in CheckInToOR.jsp===>"+checklist);
		}
	}
		verify_checklist_codes=checklist; 
		System.err.println("verify_checklist_codes Final in CheckInToOR.jsp===>"+verify_checklist_codes);
	//AAKH-SCF-0418 [IN:071802] Ends Here
	// End of Verify CheckList Logic
	//PMG2016-KDAH-CRF-0001 starts
	String setup_bean_id = "SetUpParamForFacilityBean";
	String setup_bean_name = "eOT.SetUpParamForFacilityBean";
	SetUpParamForFacilityBean setup_bean = (SetUpParamForFacilityBean) mh.getBeanObject( setup_bean_id, request, setup_bean_name );
	HashMap map=new HashMap();
	String tab_id="OtherDetails";
	map = setup_bean.getQueryDtls(tab_id, facility_id);
	String multi_check_in_yn=(String)map.get("multiCheckInAllowed_YN");
	//PMG2016-KDAH-CRF-0001 ends
	String check_in_time="";
	String check_out_holding_area_time="";
	Connection con = null;
	Statement pstmt2  = null;
	ResultSet rst2 = null;
	//End
	try 
	{
		con = ConnectionManager.getConnection(request);
		
		String SQL_checkin_time ="SELECT TO_CHAR(CHECK_OUT_HOLDING_AREA_TIME,'DD/MM/YYYY HH24:MI') CHECK_OUT_HOLDING_AREA_TIME,		TO_CHAR(CHECK_IN_TIME,'DD/MM/YYYY HH24:MI') CHECK_IN_TIME 	FROM OT_POST_OPER_HDR WHERE  OPERATING_FACILITY_ID='"+facility_id+"' AND  OPER_NUM='"+oper_num+"'";
		pstmt2 = con.createStatement();
		rst2=pstmt2.executeQuery(SQL_checkin_time);
		if(rst2 !=null && rst2.next())
		{			
			check_out_holding_area_time=rst2.getString("CHECK_OUT_HOLDING_AREA_TIME");
			if(check_out_holding_area_time ==null) check_out_holding_area_time="";
			check_in_time=rst2.getString("CHECK_IN_TIME");
			if(check_in_time ==null) check_in_time="";
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
			if(rst2!=null) rst2.close();
			if(pstmt2!=null)pstmt2.close();
			if(con!=null) con.close();
	}
%>

<body onLoad="validatePatientConsent();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='CheckInToORForm' id='CheckInToORForm'>
<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
	<tr>
		<td class='CAGROUPHEADING' colspan='6'><fmt:message key="eOT.CheckIntoOR.Label" bundle="${ot_labels}"/></td>	
	</tr>

	<tr>
		<td class='label' width='25%'><fmt:message key="eOT.CheckedInDateTime.Label" bundle="${ot_labels}"/> </td>
		<td class='fields' width='25%'>
			 <input type='text' class='fields' name='checked_in_date' id='checked_in_date' size='8'  value='<%=cur_date%>' readonly>
			 <img class='fields' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('checked_in_date');"> 
			<input type='text' class='fields' name='checked_in_time' id='checked_in_time' size='5'  maxlength='5' value='<%=cur_time%>' onBlur='checkTimeFormat(this)'><img src='../../eCommon/images/mandatory.gif'></img>
		</td>
	</tr>
	</table>

	<input type='hidden' name='hold_area_check_in_time' id='hold_area_check_in_time' value='<%=hold_area_check_in_time%>' >
	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
	<input type='hidden' name='cur_date' id='cur_date' value='<%=cur_date%>'>
	<input type='hidden' name='slate_user_id' id='slate_user_id' value='<%=slate_user_id%>'>
	<input type='hidden' name='user_id' id='user_id' value='<%=slate_user_id%>'>
	<input type='hidden' name='patient_id' id='patient_id' value="<%=request.getParameter("patient_id")%>">
	<input type='hidden' name='oper_num' id='oper_num' value='<%=oper_num%>'>
	<input type='hidden' name='booking_num' id='booking_num' value='<%=booking_num%>'>
	<input type='hidden' name='order_id' id='order_id' value='<%=order_id%>'>
	<input type='hidden' name="no_of_verifications" id="no_of_verifications" value="<%=no_of_verifications%>">
	<input type='hidden' name="role_id_1" id="role_id_1" value="<%=role_id_1%>">
	<input type='hidden' name="role_id_2" id="role_id_2" value="<%=role_id_2%>">
	<input type='hidden' name="role_id_3" id="role_id_3" value="<%=role_id_3%>">
	<input type='hidden' name="role_id_4" id="role_id_4" value="<%=role_id_4%>">
	<input type='hidden' name="old_checklist_user_id" id="old_checklist_user_id" value="<%=old_checklist_user_id%>">
	<input type='hidden' name="checklist_completed_yn" id="checklist_completed_yn" value="<%=checklist_completed_yn%>">
	<input type='hidden' name="check_for_check_list_compl" id="check_for_check_list_compl" value="<%=check_for_check_list_compl%>">
	<input type='hidden' name="verify_checklist_codes" id="verify_checklist_codes" value="<%=verify_checklist_codes%>">
	<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
	<input type='hidden' name='check_in_time' id='check_in_time' value='<%=check_in_time%>'>
	<input type='hidden' name='check_out_holding_area_time' id='check_out_holding_area_time' value='<%=check_out_holding_area_time%>'>
	<input type="hidden" name="multi_check_in_yn" id="multi_check_in_yn" id="multi_check_in_yn" value="<%=multi_check_in_yn %>">
</form>
</body>
</html>

